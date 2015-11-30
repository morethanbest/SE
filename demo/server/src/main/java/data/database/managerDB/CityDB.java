package data.database.managerDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.userDB.UserDB;
import po.CityPO;
import po.ResultMessage;

public class CityDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table CityPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table CityPO(name text,zone text)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			CityPO po=new CityPO("上海","021");
			write(new CityPO("北京","010"));
			write(new CityPO("广州","020"));
			write(new CityPO("南京","025"));
			write(po);
			dbh.close();// 关闭连接
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ResultMessage write(CityPO po){
		if(search(po.getName())!=null){
			return ResultMessage.failure;
		}
		dbh=new DBHelper();
		sql="insert into CityPO values(?,?)";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,po.getName());
			pst.setString(2, po.getZone());
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
		dbh.close();// 关闭连接
		return ResultMessage.success;
		
	}
	
	public static ResultMessage delete(CityPO po){
		if(search(po.getName())!=null){
			OrganizationDB.deletebycity(po.getName());
			StaffDB.deletebycity(po.getName());
			UserDB.deletebyCity(po.getName());
			ConstantsDB.deletebycity(po.getName());
		}
		dbh=new DBHelper();
		sql="delete from CityPO where name=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1, po.getName());
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
	
	public static ResultMessage update(CityPO po){
		dbh=new DBHelper();
		sql="update CityPO set zone=? where name=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,po.getZone());
			pst.setString(2, po.getName());
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
	
	public static List<CityPO> getAll(){
		List<CityPO> list=new ArrayList<CityPO>();
		CityPO po;
		dbh=new DBHelper();
		sql="select name,zone from CityPO";
		pst = dbh.prepare(sql);
		try {
			ret=pst.executeQuery();
			while(ret.next()){
				po=new CityPO(ret.getString(1),ret.getString(2));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static CityPO search(String name){
		CityPO po=null;
		dbh=new DBHelper();
		sql="select zone from CityPO where name = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,name);	
			ret=pst.executeQuery();
			if(ret.next()){
				po=new CityPO(name,ret.getString(1));
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;		//查不到时返回null
	}
	
	public static void main(String args[]){
		initialize();

//		if(search("上海")!=null)
//		System.out.println("search success");
//		if(write(new CityPO("上海","021"))==ResultMessage.failure)
//			System.out.println("write success");
//		if(getAll().size()>0)
//			System.out.println("getAll success");
//		if(update(new CityPO("上海","022"))==ResultMessage.success)
//			System.out.println("update success");
//		if(delete(new CityPO("上海","021"))==ResultMessage.success)
//		System.out.println("delete success");
	}
}
