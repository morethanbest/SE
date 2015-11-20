package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.ConstantsPO;
import po.Job;
import vo.ResultMessage;

public class ConstantsDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table ConstantsPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table ConstantsPO(id bigint auto_increment primary key,name text,value double)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			ConstantsPO po=new ConstantsPO(1,"distance;Shanghai;Nanjing",5);
			ResultMessage result;
			result = write(po.getName(), po.getValue());
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			List<ConstantsPO> list = fuzzySearch("distance");
			if (list.size()>0) {
				System.out.println("get it");
			}
			ret.close();
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ResultMessage write(String name,double value){

		dbh=new DBHelper();
		sql="insert into ConstantsPO values(null,?,?)";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,name);
			pst.setDouble(2, value);
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
	
	public static List<ConstantsPO> fuzzySearch(String name){
		List<ConstantsPO> list=new ArrayList<ConstantsPO>();
		ConstantsPO po;
		dbh=new DBHelper();
		sql="select id,name,value from ConstantsPO where name like ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,"%"+name+"%");	//模糊查找时两边加%
			ret=pst.executeQuery();
			while(ret.next()){
				po=new ConstantsPO(ret.getLong(1),ret.getString(2),ret.getDouble(3));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ConstantsPO search(String name){
		ConstantsPO po=null;
		dbh=new DBHelper();
		sql="select id,name,value from ConstantsPO where name like ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,name);	
			ret=pst.executeQuery();
			if(ret.next()){
				po=new ConstantsPO(ret.getLong(1),ret.getString(2),ret.getDouble(3));
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
		sql="select max(id) from ConstantsPO";
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
		System.out.println(getLastId());
	}

	
}
