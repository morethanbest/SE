package data.database.accountDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import po.AccountPO;
import po.ResultMessage;

public class AccountDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table AccountPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table AccountPO(id bigint auto_increment primary key,accountname text,accountsum double)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			AccountPO po=new AccountPO(1,"abcde",10000);
			ResultMessage result;
			result = write(po);
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ResultMessage write(AccountPO po){
		if(search(po.getAccountname())!=null){
			return ResultMessage.failure;
		}
		dbh=new DBHelper();
		sql="insert into AccountPO values(null,?,?)";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,po.getAccountname());
			pst.setDouble(2, po.getAccountsum());
			int result=pst.executeUpdate();
			if(result==-1){
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();
			return ResultMessage.success;
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbh.close();
		return ResultMessage.failure;
		
	}
	
	public static ResultMessage delete(AccountPO po){
		dbh=new DBHelper();
		sql="delete from AccountPO where id=?";
		pst=dbh.prepare(sql);
		try{
			pst.setLong(1,po.getId());
			int result;
			result=pst.executeUpdate();
			if(result!=0){
				dbh.close();
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dbh.close();
		return ResultMessage.failure;
	}
	
	public static ResultMessage update(AccountPO po){
		dbh=new DBHelper();
		sql="update AccountPO set accountname=?,accountsum=? where id=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1, po.getAccountname());
			pst.setDouble(2,po.getAccountsum());
			pst.setLong(3, po.getId());
			int result;
			result=pst.executeUpdate();
			if(result!=0){
				dbh.close();
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dbh.close();
		return ResultMessage.failure;
	}
	
	
	public static List<AccountPO> getAll(){
		List<AccountPO> list=new ArrayList<>();
		dbh=new DBHelper();
		sql="select id,accountname,accountsum from AccountPO ";
		pst = dbh.prepare(sql);
		try{
			ret=pst.executeQuery();
			while(ret.next()){
				list.add(new AccountPO(ret.getLong(1), ret.getString(2), ret.getDouble(3)));
			}
			ret.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		dbh.close();
		return list;
	}
	
	public static AccountPO search(String accountname){
		AccountPO po=null;
		dbh=new DBHelper();
		sql="select id,accountsum from AccountPO where  accountname= ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,accountname);	
			ret=pst.executeQuery();
			if(ret.next()){
				po=new AccountPO(ret.getLong(1),accountname,ret.getDouble(2));
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;		//查不到时返回null
	}
	
	public static long getLastId(){
		long lastId=0;
		dbh=new DBHelper();
		sql="select max(id) from AccountPO";
		pst = dbh.prepare(sql);
		try {
			ret=pst.executeQuery();
			if(ret.next()){
				lastId=ret.getLong(1);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastId;
	}
	public static void main(String[] args) {
		initialize();
		if(update(new AccountPO(1,"cde",50))==ResultMessage.success){
			System.out.println("success");
		}
		System.out.println(search("cde").getAccountsum());
		System.out.println(getLastId());
	}

}
