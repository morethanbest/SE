package data.database.managerDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class OrganizationDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table OrganizationPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table OrganizationPO(name text,organizationcode text,type blob,city text)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			OrganizationPO po=new OrganizationPO("南京鼓楼营业厅","025000",Organizationtype.hall,"南京");
			write(po);
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultMessage write(OrganizationPO po) {
		try {
			byte[] typebytes = Serialize.Object2Bytes(po.getType());
			dbh = new DBHelper();
			sql = "insert into OrganizationPO values(?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getName());
			pst.setString(2, po.getOrganizationcode());
			pst.setBytes(3, typebytes);
			pst.setString(4, po.getCity());
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
	public static ResultMessage deletebycity(String city){
		dbh=new DBHelper();
		sql="delete from OrganizationPO where city=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,city);
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
	
	public static ResultMessage delete(OrganizationPO po){
		String organizationcode=po.getOrganizationcode();
		OrganizationPO organization=search(organizationcode);
		if(organization!=null)
			StaffDB.deletebyorganization(organizationcode);
		dbh=new DBHelper();
		sql="delete from OrganizationPO where organizationcode=?";
		pst=dbh.prepare(sql);
		try{
			pst.setString(1,organizationcode);
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
	
	public static ResultMessage update(OrganizationPO po){
		try{
			byte[] typebytes = Serialize.Object2Bytes(po.getType());
			dbh = new DBHelper();
			sql = "update OrganizationPO set name=?,type=?,city=? where organizationcode=?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getName());
			pst.setBytes(2, typebytes);
			pst.setString(3, po.getCity());
			pst.setString(4, po.getOrganizationcode());
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				return ResultMessage.success;
			}
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static List<OrganizationPO> getAll(){
		List<OrganizationPO> list=new ArrayList<OrganizationPO>();
		OrganizationPO po;
		dbh=new DBHelper();
		sql="select name,organizationcode,type,city from OrganizationPO";
		pst = dbh.prepare(sql);
		try {
			ret=pst.executeQuery();
			while(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getString(1),ret.getString(2),type,ret.getString(4));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<OrganizationPO> fuzzySearchbycity(String city){
		List<OrganizationPO> list=new ArrayList<OrganizationPO>();
		OrganizationPO po;
		dbh=new DBHelper();
		sql="select name,organizationcode,type from OrganizationPO where city = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, city);
			ret=pst.executeQuery();
			while(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getString(1),ret.getString(2),type,city);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<OrganizationPO> fuzzySearchbytype(Organizationtype type) {
		List<OrganizationPO> list = new ArrayList<OrganizationPO>();
		try {
			byte[] typebyte = Serialize.Object2Bytes(type);

			OrganizationPO po;
			dbh = new DBHelper();
			sql="select name,organizationcode,city from OrganizationPO where type=?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, typebyte);
			ret = pst.executeQuery();
			while (ret.next()) {
				po=new OrganizationPO(ret.getString(1),ret.getString(2),type,ret.getString(3));
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<OrganizationPO> fuzzySearchbyboth(String city, Organizationtype type) {
		List<OrganizationPO> list = new ArrayList<OrganizationPO>();
		try {
			byte[] typebyte = Serialize.Object2Bytes(type);
			OrganizationPO po;
			dbh = new DBHelper();
			sql="select name,organizationcode from OrganizationPO where type=? and city= ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, typebyte);
			pst.setString(2, city);
			ret = pst.executeQuery();
			while (ret.next()) {
				po=new OrganizationPO(ret.getString(1),ret.getString(2),type,city);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static OrganizationPO search(String organizationcode){
		OrganizationPO po=null;
		dbh=new DBHelper();
		sql="select name,organizationcode,type,city from OrganizationPO where organizationcode = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,organizationcode);
			ret=pst.executeQuery();
			if(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getString(1),ret.getString(2),type,ret.getString(4));
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;		//查不到时返回null
	}
	
	public static String gethallcode(String city){
		String lastcode=null;
		dbh=new DBHelper();
		sql="select organizationcode from OrganizationPO where city=? and type=?";
		pst = dbh.prepare(sql);
		try {
			byte[] typebytes=Serialize.Object2Bytes(Organizationtype.hall);
			pst.setString(1, city);
			pst.setBytes(2, typebytes);
			ret=pst.executeQuery();
			while(ret.next()){
				lastcode=ret.getString(1);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastcode;
	}
	public static void main(String[] args) {
		initialize();
		System.out.println("test");
//		if(getAll().size()>0){
//			System.out.println("getall success");
//		}
//		if(update(new OrganizationPO("上海中转中心","025000",Organizationtype.transfercenter,"上海"))==ResultMessage.success){
//			System.out.println("update success");
//		}
//		if(search("025000")!=null){
//			System.out.println("search success");
//		}
//		if(fuzzySearchbycity("上海").size()>0){
//			System.out.println("fuzzysearch success");
//		}
//		if(fuzzySearchbytype(Organizationtype.transfercenter).size()>0){
//			System.out.println("fuzzySearchbyypte success");
//		}
//		if(fuzzySearchbyboth("上海",Organizationtype.transfercenter).size()>0){
//			System.out.println("fuzzySearchbyboth success");
//		}
//		if("025000".equals(gethallcode("南京"))){
//			System.out.println("gethallcode success");
//		}
//		if(delete(new OrganizationPO("南京鼓楼营业厅","025000",Organizationtype.hall,"南京"))==ResultMessage.success){
//			System.out.println("delete success");
//		}
	}
}
