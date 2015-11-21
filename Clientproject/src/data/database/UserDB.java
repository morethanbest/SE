package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import po.Hall;
import po.Job;
import po.LoginPO;
import po.UserPO;
import vo.ResultMessage;

public class UserDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table UserPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table UserPO(id bigint auto_increment primary key,username text,password text,job blob,hall blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			UserPO po = new UserPO(1, "sunchao", "123", Job.manager, null); // 此处的id没用，以后应该设个初始值如10000

			ResultMessage result;
			result = write(po.getUsername(), po.getPassword(), po.getJob(), po.getHall());
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			Job job = check(1, "1234").getJob();
			if (job != Job.visitor) {
				System.out.println("login Successfully");
			}
			ret.close();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(String username, String password, Job job, Hall hall) {
		try {
			byte[] jobbytes = Serialize.Object2Bytes(job);
			byte[] hallbytes = Serialize.Object2Bytes(hall);
			dbh = new DBHelper();
			sql = "insert into UserPO values(null,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, username);
			pst.setString(2, password);
			pst.setBytes(3, jobbytes);
			pst.setBytes(4, hallbytes);
			int result = pst.executeUpdate();
			if (result == -1) {
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResultMessage.success;

	}

	public static LoginPO check(long id, String password) {
		LoginPO po;
		dbh = new DBHelper();
		sql = "select job,username,hall from UserPO where id=? and password=?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1, id);
			pst.setString(2, password);
			ret = pst.executeQuery();
			if (ret.next()) {
				byte[] jobbytes = ret.getBytes(1);
				String username = ret.getString(2);
				byte[] hallbytes = ret.getBytes(3);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				Hall hall = (Hall) Serialize.Bytes2Object(hallbytes);
				po = new LoginPO(username, hall, job);
				ret.close();
				dbh.close();// 关闭连接
				return po;
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LoginPO(null, null, Job.visitor);

	}

	public static void main(String[] args) {
		initialize();
	}

}
