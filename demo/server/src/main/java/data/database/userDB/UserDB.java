package data.database.userDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.database.DBHelper;
import data.database.Serialize;
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
			sql = "create table UserPO(username text,password text,job blob,organizationname text,organizationcode text,organizationtype blob,city text)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			UserPO po = new UserPO("1","123",Job.manager,"总部","025",Organizationtype.headquarters,"南京"); 
			ResultMessage result;
			result = write(po);
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			write(new UserPO("admin","admin",Job.administrator,"总部","025",Organizationtype.headquarters,"南京"));
			write(new UserPO("3","123",Job.hallsalesman,"南京鼓楼营业厅","025000",Organizationtype.hall,"南京"));
			write(new UserPO("2","123",Job.Courier,"南京鼓楼营业厅","025000",Organizationtype.hall,"南京"));
			write(new UserPO("3","123",Job.hallsalesman,"南京鼓楼营业厅","025000",Organizationtype.hall,"南京"));
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(UserPO user) {
		try {
			if(find(user.getUsername())!=null){
				return ResultMessage.failure;
			}
			byte[] jobbytes = Serialize.Object2Bytes(user.getJob());
			byte[] typebytes= Serialize.Object2Bytes(user.getOrganizationtype());
			dbh = new DBHelper();
			sql = "insert into UserPO values(?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setBytes(3, jobbytes);
			pst.setString(4, user.getOrganizationname());
			pst.setString(5, user.getOrganizationcode());
			pst.setBytes(6, typebytes);
			pst.setString(7, user.getCity());
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
	
//	public static ResultMessage deletebyStaff(String organizationcode){
//		dbh=new DBHelper();
//		sql="delete from UserPO where organizationcode=?";
//		pst=dbh.prepare(sql);
//		try{
//			pst.setString(1, organizationcode);
//			int result=pst.executeUpdate();
//			if(result!=0){
//				return ResultMessage.success;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return ResultMessage.failure;
//	}
	public static ResultMessage deletebyCity(String city){
		dbh=new DBHelper();
		sql="delete from UserPO where city=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1, city);
			int result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static ResultMessage deletebyusername(UserPO po){
		dbh=new DBHelper();
		sql="delete from UserPO where username=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1, po.getUsername());
			int result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static UserPO find(String username) {
		UserPO po=null;
		dbh = new DBHelper();
		sql = "select password,job,organizationname,organizationcode,organizationtype,city from UserPO where username=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, username);
			ret = pst.executeQuery();
			if (ret.next()) {
				byte[] jobbytes = ret.getBytes(2);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(5);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po = new UserPO(username,ret.getString(1),job,ret.getString(3),ret.getString(4),type,ret.getString(6));
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
		sql="update UserPO set password=?,job=?,organizationname=?,organizationcode=?"
				+ ",organizationtype=?,city=? where username=?";
		pst=dbh.prepare(sql);
		try{
			byte[] jobbytes=Serialize.Object2Bytes(po.getJob());
			byte[] typebytes=Serialize.Object2Bytes(po.getOrganizationtype());
			pst.setString(1, po.getPassword());
			pst.setBytes(2, jobbytes);
			pst.setString(3, po.getOrganizationname());
			pst.setString(4, po.getOrganizationcode());
			pst.setBytes(5, typebytes);
			pst.setString(6, po.getCity());
			pst.setString(7, po.getUsername());
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
		sql = "select job,organizationname,organizationcode,organizationtype,city from UserPO where username=? and password=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, username);
			pst.setString(2, password);
			ret = pst.executeQuery();
			if (ret.next()) {
				byte[] jobbytes = ret.getBytes(1);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(4);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po = new UserPO(username,password,job,ret.getString(2),ret.getString(3),type,ret.getString(5));
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
//		update(new UserPO("sunchao","234",Job.transfercentersalesman,"上海中转中心","025000",Organizationtype.transfercenter,"上海"));
		if(check("1","123")!=null){
			System.out.println("login");
		}
	}

}
