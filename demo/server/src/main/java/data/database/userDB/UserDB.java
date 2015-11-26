package data.database.userDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.database.DBHelper;
import data.database.Serialize;
import po.City;
import po.Job;
import po.Organizationtype;
import po.ResultMessage;
import po.UserPO;

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
			sql = "create table UserPO(id bigint auto_increment primary key,username text,password text,job blob,organizationname text,organizationcode text,organizationtype blob,city blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			UserPO po = new UserPO(1, "sunchao","123",Job.manager,null,null,null,null); // 此处的id没用，以后应该设个初始值如10000

			ResultMessage result;
			result = write(po);
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}

			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(UserPO user) {
		try {
			byte[] jobbytes = Serialize.Object2Bytes(user.getJob());
			byte[] typebytes= Serialize.Object2Bytes(user.getOrganizationtype());
			byte[] citybytes=Serialize.Object2Bytes(user.getCity());
			dbh = new DBHelper();
			sql = "insert into UserPO values(null,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setBytes(3, jobbytes);
			pst.setString(4, user.getOrganizationname());
			pst.setString(5, user.getOrganizationcode());
			pst.setBytes(6, typebytes);
			pst.setBytes(7, citybytes);
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
	
	public static ResultMessage deletebyStaff(String organizationcode){
		dbh=new DBHelper();
		sql="delete from UserPO where organizationcode=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1, organizationcode);
			int result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static ResultMessage deletebyid(UserPO po){
		dbh=new DBHelper();
		sql="delete from UserPO where ide=?";
		pst=dbh.prepare(sql);
		try{
			pst.setLong(1, po.getId());
			int result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static UserPO find(long id) {
		UserPO po=null;
		dbh = new DBHelper();
		sql = "select username,password,job,organizationname,organizationcode,organizationtype,city from UserPO where id=?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1, id);
			ret = pst.executeQuery();
			if (ret.next()) {
				String username = ret.getString(1);
				byte[] jobbytes = ret.getBytes(3);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(6);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				byte[] citybytes=ret.getBytes(7);
				City city=(City)Serialize.Bytes2Object(citybytes);
				po = new UserPO(id,username,ret.getString(2),job,ret.getString(4),ret.getString(5),type,city);
				ret.close();
				dbh.close();// 关闭连接
				return po;
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}

		return po;

	}
	
	public static ResultMessage update(UserPO po){
		dbh=new DBHelper();
		sql="update UserPO set username=?,password=?,job=?,organizationname=?,organizationcode=?"
				+ ",organizationtype=?,city=? where id=?";
		pst=dbh.prepare(sql);
		try{
			byte[] jobbytes=Serialize.Object2Bytes(po.getJob());
			byte[] typebytes=Serialize.Object2Bytes(po.getOrganizationtype());
			byte[] citybytes=Serialize.Object2Bytes(po.getCity());
			pst.setString(1, po.getUsername());
			pst.setString(2, po.getPassword());
			pst.setBytes(3, jobbytes);
			pst.setString(4, po.getOrganizationname());
			pst.setString(5, po.getOrganizationcode());
			pst.setBytes(6, typebytes);
			pst.setBytes(7, citybytes);
			pst.setLong(8, po.getId());
			int result;
			result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;		
	}
	
	public static UserPO check(String username, String password) {
		UserPO po=null;
		dbh = new DBHelper();
		sql = "select id,job,organizationname,organizationcode,organizationtype,city from UserPO where username=? and password=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, username);
			pst.setString(2, password);
			ret = pst.executeQuery();
			if (ret.next()) {
				byte[] jobbytes = ret.getBytes(2);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(5);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				byte[] citybytes=ret.getBytes(6);
				City city=(City)Serialize.Bytes2Object(citybytes);
				po = new UserPO(ret.getLong(1),username,password,job,ret.getString(3),ret.getString(4),type,city);
				ret.close();
				dbh.close();// 关闭连接
				return po;
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}

		return po;

	}

	public static void main(String[] args) {
		initialize();
//		update(new UserPO(1,"sunchao","234",Job.transfercentersalesman,"上海中转中心","025000",Organizationtype.transfercenter,City.Shanghai));
		if(check("sunchao","123")!=null){
			System.out.println("login");
		}
	}

}
