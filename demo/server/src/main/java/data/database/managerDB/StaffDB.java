package data.database.managerDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import data.database.userDB.UserDB;
import po.Job;
import po.Organizationtype;
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
			sql = "create table StaffPO(id bigint auto_increment primary key,name text,job blob,organizationname text,organizationcode text,organizationtype blob,city text)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			StaffPO po=new StaffPO(1,"孙超",Job.transfercentersalesman,"上海中转中心","0250",Organizationtype.transfercenter,"上海");
			ResultMessage result;
			result = write(po);
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			StaffPO po1 = search(1);
			if (po1!=null) {
				System.out.println("get it");
			}
			ret.close();
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultMessage write(StaffPO staff) {
		try {
			
			byte[] jobbytes = Serialize.Object2Bytes(staff.getJob());
			byte[] typebytes=Serialize.Object2Bytes(staff.getOrganizationtype());
			dbh = new DBHelper();
			sql = "insert into StaffPO values(null,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, staff.getName());
			pst.setBytes(2, jobbytes);
			pst.setString(3, staff.getOrganizationname());
			pst.setString(4, staff.getOrganizationcode());
			pst.setBytes(5, typebytes);
			pst.setString(6, staff.getCity());
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
		dbh.close();
		return ResultMessage.failure;
		
	}
	
	public static ResultMessage delete(long id){
//		StaffPO po=search(id);
//		UserDB.deletebyStaff(po.getOrganizationcode());
		dbh=new DBHelper();
		sql="delete from StaffPO where id=?";
		pst=dbh.prepare(sql);
		try{
			pst.setLong(1, id);
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
	public static ResultMessage deletebycity(String city){
		dbh=new DBHelper();
		sql="delete from StaffPO where city=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1, city);
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
	
	public static ResultMessage deletebyorganization(String organizationcode){
		dbh=new DBHelper();
		sql="delete from StaffPO where organizationcode=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,organizationcode);
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
	
	public static ResultMessage update(StaffPO staff){
		try{
			byte[] jobbytes = Serialize.Object2Bytes(staff.getJob());
			byte[] typebytes=Serialize.Object2Bytes(staff.getOrganizationtype());
			dbh = new DBHelper();
			sql = "update StaffPO set name=?,job=?,organizationname=?,organizationcode=?,organizationtype=?,city=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, staff.getName());
			pst.setBytes(2, jobbytes);
			pst.setString(3, staff.getOrganizationname());
			pst.setString(4, staff.getOrganizationcode());
			pst.setBytes(5, typebytes);
			pst.setString(6, staff.getCity());
			pst.setLong(7,staff.getId());
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				dbh.close();
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dbh.close();
		return ResultMessage.failure;
	}
	
	public static ResultMessage updatebyOrg(String organizationcode,String organizationname){
		try{
			dbh = new DBHelper();
			sql = "update StaffPO set organizationname=? where organizationcode=?";
			pst = dbh.prepare(sql);
			pst.setString(1, organizationname);
			pst.setString(2, organizationcode);
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				dbh.close();
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dbh.close();
		return ResultMessage.failure;
	}
//	public static List<StaffPO> fuzzySearch(String name){
//		List<StaffPO> list=new ArrayList<StaffPO>();
//		StaffPO po;
//		dbh=new DBHelper();
//		sql="select id,name,job,organization from StaffPO where name like ?";
//		pst = dbh.prepare(sql);
//		try {
//			pst.setString(1,"%"+name+"%");	//模糊查找时两边加%
//			ret=pst.executeQuery();
//			while(ret.next()){
//				byte[] jobbytes=ret.getBytes(3);
//				Job job=(Job) Serialize.Bytes2Object(jobbytes);
//				byte[] organizationbytes=ret.getBytes(4);
//				OrganizationPO organization=(OrganizationPO)Serialize.Bytes2Object(organizationbytes);
//				po=new StaffPO(ret.getLong(1),ret.getString(2),job,organization);
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
	
	public static List<StaffPO> getAll() {
		List<StaffPO> list=new ArrayList<StaffPO>();
		try {
			StaffPO po;
			dbh = new DBHelper();
			sql = "select id,name,job,organizationname,organizationcode,organizationtype,city from StaffPO";
			pst = dbh.prepare(sql);

			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] jobbytes=ret.getBytes(3);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(6);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new StaffPO(ret.getLong(1),ret.getString(2),job,ret.getString(4),ret.getString(5),type,ret.getString(7));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<StaffPO> fuzzySearchbyjob(Job job) {
		List<StaffPO> list = new ArrayList<StaffPO>();
		try {
			byte[] jobbyte = Serialize.Object2Bytes(job);

			StaffPO po;
			dbh = new DBHelper();
			sql = "select id,name,job,organizationname,organizationcode,organizationtype,city from StaffPO where job=?";
			pst = dbh.prepare(sql);

			pst.setBytes(1, jobbyte);
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] typebytes=ret.getBytes(6);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new StaffPO(ret.getLong(1),ret.getString(2),job,ret.getString(4),ret.getString(5),type,ret.getString(7));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<StaffPO> fuzzySearchbyboth(String organizationname, Job job) {
		List<StaffPO> list = new ArrayList<StaffPO>();
		try {
			byte[] jobbyte = Serialize.Object2Bytes(job);

			StaffPO po;
			dbh = new DBHelper();
			sql = "select id,name,job,organizationname,organizationcode,organizationtype,city from StaffPO where organizationname=? and job=?";
			pst = dbh.prepare(sql);

			pst.setString(1, organizationname);
			pst.setBytes(2, jobbyte);
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] typebytes=ret.getBytes(6);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new StaffPO(ret.getLong(1),ret.getString(2),job,ret.getString(4),ret.getString(5),type,ret.getString(7));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<StaffPO> fuzzySearchbyorganizationname(String organizationname) {
		List<StaffPO> list = new ArrayList<StaffPO>();
		try {

			StaffPO po;
			dbh = new DBHelper();
			sql = "select id,name,job,organizationname,organizationcode,organizationtype,city from StaffPO where organizationname=?";
			pst = dbh.prepare(sql);

			pst.setString(1, organizationname);
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] jobbytes = ret.getBytes(3);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(6);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new StaffPO(ret.getLong(1),ret.getString(2),job,ret.getString(4),ret.getString(5),type,ret.getString(7));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static StaffPO search(long id){
		StaffPO po=null;
		dbh=new DBHelper();
		sql = "select id,name,job,organizationname,organizationcode,organizationtype,city from StaffPO where id=?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1,id);	
			ret=pst.executeQuery();
			if(ret.next()){
				byte[] jobbytes = ret.getBytes(3);
				Job job = (Job) Serialize.Bytes2Object(jobbytes);
				byte[] typebytes=ret.getBytes(6);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new StaffPO(ret.getLong(1),ret.getString(2),job,ret.getString(4),ret.getString(5),type,ret.getString(7));
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
//	public static void main(String[] args) {
//		initialize();
//		if((fuzzySearchbyorganizationname("上海中转中心").size()>0))
//		System.out.println(getLastId());
//		if(search(1)!=null){
//			System.out.println("search success");
//		}
//	}
}
