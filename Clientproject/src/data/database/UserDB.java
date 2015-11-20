package data.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Job;
import po.UserPO;
import vo.ResultMessage;  
public class UserDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table UserPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table UserPO(id bigint auto_increment primary key,username text,password text,job blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			UserPO po = new UserPO(1, "sunchao", "123", Job.manager);			//此处的id没用，以后应该设个初始值如10000
			byte[] jobbytes = Serialize.Object2Bytes(po.getJob());
			ResultMessage result;
			result = write(po.getUsername(), po.getPassword(), jobbytes);
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			Job job = checkforjob(1, "123");
			if (job != Job.visitor) {
				System.out.println("login Successfully");

			}
			ret.close();
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ResultMessage write(String username,String password,byte[] job){

		dbh=new DBHelper();
		sql="insert into UserPO values(null,?,?,?)";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,username);
			pst.setString(2, password);
			pst.setBytes(3, job);
			int result=pst.executeUpdate();
			if(result==-1){
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();// 关闭连接
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ResultMessage.success;
		
	}
	
	public static Job checkforjob(long id,String password){
		dbh=new DBHelper();
		sql="select job from UserPO where id=? and password=?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1, id);
			pst.setString(2, password);
			ret=pst.executeQuery();
			if(ret.next()){
				byte[] jobbytes=ret.getBytes(1);
				Job job=(Job)Serialize.Bytes2Object(jobbytes);
				ret.close();
				dbh.close();// 关闭连接
				return job;
			}
			ret.close();
			dbh.close();// 关闭连接
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Job.visitor;
		
	}
	public static void main(String[] args) {
		initialize();
	}

	
	
}
