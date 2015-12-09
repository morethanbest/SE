package data.database.commodityDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.database.DBHelper;
import po.ResultMessage;

//用于返回库存盘点的截止点
public class StopPointDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table StopPoint";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table StopPoint(id text)";		//id为机构号+日期+若干位
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ResultMessage write(String id) {			//id为机构号+日期+若干位
		try {
			dbh = new DBHelper();
			sql = "insert into StopPoint values(?)";
			pst = dbh.prepare(sql);
			pst.setString(1, id);
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
	
	public static long getlastStoppoint(String orgcodeanddate) {			//根据机构号和时间得到最新的stoppoint
		long number=Long.parseLong(orgcodeanddate+"0000");
		try {
			dbh = new DBHelper();
			sql = "select id from StopPoint where id like ?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+orgcodeanddate+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(ret.getString(1).startsWith(orgcodeanddate))
					number++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		write(Long.toString(number+1));
		return number;

	}

}
