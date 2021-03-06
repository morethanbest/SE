package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import po.Job;
import po.ResultMessage;
import po.StaffPO;

public class StaffDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table StaffPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table StaffPO(id bigint auto_increment primary key,name text,job blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			StaffPO po=new StaffPO(1,"sunchao",Job.manager);
			ResultMessage result;
			result = write(po.getName(), po.getJob());
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			StaffPO po1 = search("sunchao");
			if (po1!=null) {
				System.out.println("get it");
			}
			ret.close();
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultMessage write(String name, Job job) {
		try {
			byte[] jobbytes = Serialize.Object2Bytes(job);
			dbh = new DBHelper();
			sql = "insert into StaffPO values(null,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, name);
			pst.setBytes(2, jobbytes);
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
	
	public static ResultMessage delete(long id){
		dbh=new DBHelper();
		sql="delete from StaffPO where id=?";
		pst=dbh.prepare(sql);
		try{
			pst.setLong(1, id);
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
	
	public static ResultMessage update(String originalname,String newname,Job job){
		try{
			byte[] jobbytes = Serialize.Object2Bytes(job);
			dbh = new DBHelper();
			sql = "update StaffPO set name=?,job=? where name=?";
			pst = dbh.prepare(sql);
			pst.setString(1, newname);
			pst.setBytes(2, jobbytes);
			pst.setString(3, originalname);
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
//	public static List<ConstantsPO> fuzzySearch(String name){
//		List<ConstantsPO> list=new ArrayList<ConstantsPO>();
//		ConstantsPO po;
//		dbh=new DBHelper();
//		sql="select id,name,value from ConstantsPO where name like ?";
//		pst = dbh.prepare(sql);
//		try {
//			pst.setString(1,"%"+name+"%");	//模糊查找时两边加%
//			ret=pst.executeQuery();
//			while(ret.next()){
//				po=new ConstantsPO(ret.getLong(1),ret.getString(2),ret.getDouble(3));
//				list.add(po);
//			}
//			ret.close();
//			dbh.close();// 关闭连接
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	
	public static StaffPO search(String name){
		StaffPO po=null;
		dbh=new DBHelper();
		sql="select id,name,job from StaffPO where name = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,name);	
			ret=pst.executeQuery();
			if(ret.next()){
				byte[] jobbytes=ret.getBytes(3);
				Job job=(Job) Serialize.Bytes2Object(jobbytes);
				po=new StaffPO(ret.getLong(1),ret.getString(2),job);
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
		sql="select max(id) from StaffPO";
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
