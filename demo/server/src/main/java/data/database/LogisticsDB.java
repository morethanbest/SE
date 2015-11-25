package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import po.LogisticsPO;
import po.ResultMessage;

public class LogisticsDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table LogisticsPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table LogisticsPO(id bigint auto_increment primary key,state text,ordernum text,history blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(LogisticsPO po) {
		try {
			String state = po.getState();
			String ordernum = po.getOrdernum();
			List<String> history = po.getHistory();
			byte[] historybytes = Serialize.Object2Bytes(history);
			dbh = new DBHelper();
			sql = "insert into LogisticsPO values(null,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, state);
			pst.setString(2, ordernum);
			pst.setBytes(3, historybytes);
			int result = pst.executeUpdate();
			if (result == -1) {
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();// 关闭连接
			return ResultMessage.success;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResultMessage.failure;

	}

	public static ResultMessage update(LogisticsPO po) {

		try {
			byte[] historybytes = Serialize.Object2Bytes(po.getHistory());
			String ordernum = po.getOrdernum();
			String state = po.getState();
			dbh = new DBHelper();
			sql = "update LogisticsPO set history=?,state=? where ordernum=?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, historybytes);
			pst.setString(2, state);
			pst.setString(3, ordernum);
			int result = pst.executeUpdate();
			if (result == -1) {
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();// 关闭连接
			return ResultMessage.success;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	public static LogisticsPO find(String ordernum) {
		LogisticsPO po = null;
		dbh = new DBHelper();
		sql = "select id,state,history,ordernum from LogisticsPO where ordernum = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, ordernum);
			ret = pst.executeQuery();
			if (ret.next()) {
				byte[] historybytes = ret.getBytes(3);
				List<String> history = (List<String>) Serialize.Bytes2Object(historybytes);
				po = new LogisticsPO(ret.getLong(1), ret.getString(2), history, ret.getString(4));
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return po; // 查不到时返回null
	}

	public static void main(String[] args) {
		initialize();
		if (write(new LogisticsPO(1, "a", new ArrayList<String>(), "123")) == ResultMessage.success) {
			System.out.println("write success");
		}
		if (find("123") != null) {
			System.out.println("find success");
		}
		if (update(new LogisticsPO(1, "b", new ArrayList<String>(), "123")) == ResultMessage.success) {
			System.out.println("update success");
		}
	}
}
