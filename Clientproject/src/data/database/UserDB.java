package data.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.UserPO;
import vo.ResultMessage;  
public class UserDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;

	public static ResultMessage write(byte[] b,String username,String password){

		dbh=new DBHelper();
		sql="insert into UserPO values(?,?,?)";
		pst=dbh.prepare(sql);
		try{

			pst.setBytes(1, b);
			pst.setString(2, username);
			pst.setString(3, password);
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
	
	public static ResultMessage check(String username,String password){
		dbh=new DBHelper();
		sql="select username,password from UserPO where username=? and password=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, username);
			pst.setString(2, password);
			ret=pst.executeQuery();
			if(ret.next()){
				ret.close();
				dbh.close();// 关闭连接
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();// 关闭连接
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.failure;
		
	}
//	public static void main(String[] args) {
//		UserPO po=new UserPO(1,"sunchao","123","member");
//		UserPO po=new UserPO(2,"sunkang","1234","member");
//		UserPO po=new UserPO(3,"wangxinyu","12345","member");
//		UserPO po=new UserPO(4,"songziwei","123456","member");
//		Serialize ser = new Serialize();
//		try{
//			byte[] b=ser.Object2Bytes(po);
//			ResultMessage result;
//			result=write(b,po.getUsername(),po.getPassword());
//			if(result==ResultMessage.success){
//				System.out.println("add Successfully");
//			}
//			result=check("sunchao","1234");
//			if(result==ResultMessage.success){
//				System.out.println("login Successfully");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		
//	}
	
	
}
