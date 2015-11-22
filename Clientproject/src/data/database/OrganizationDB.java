package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

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
			sql = "create table OrganizationPO(id bigint auto_increment primary key,name text,type blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			OrganizationPO po=new OrganizationPO(1,"上海",Organizationtype.hall);
			write(po.getName(), po.getType());
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultMessage write(String name, Organizationtype type) {
		try {
			byte[] typebytes = Serialize.Object2Bytes(type);
			dbh = new DBHelper();
			sql = "insert into OrganizationPO values(null,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, name);
			pst.setBytes(2, typebytes);
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
		sql="delete from OrganizationPO where id=?";
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
	
	public static ResultMessage update(long id,String name,Organizationtype type){
		try{
			byte[] typebytes = Serialize.Object2Bytes(type);
			dbh = new DBHelper();
			sql = "update OrganizationPO set name=?,type=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, name);
			pst.setBytes(2, typebytes);
			pst.setLong(3,id);
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
	
	public static List<OrganizationPO> fuzzySearch(String name){
		List<OrganizationPO> list=new ArrayList<OrganizationPO>();
		OrganizationPO po;
		dbh=new DBHelper();
		sql="select id,name,type from OrganizationPO where name like ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,"%"+name+"%");	//模糊查找时两边加%
			ret=pst.executeQuery();
			while(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getLong(1),ret.getString(2),type);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<OrganizationPO> fuzzySearchbytype(Organizationtype typeget) {
		List<OrganizationPO> list = new ArrayList<OrganizationPO>();
		try {
			byte[] typebyte = Serialize.Object2Bytes(typeget);

			OrganizationPO po;
			dbh = new DBHelper();
			sql = "select id,name,type from OrganizationPO where type=?";
			pst = dbh.prepare(sql);

			pst.setBytes(1, typebyte);
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] typebytes = ret.getBytes(3);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po = new OrganizationPO(ret.getLong(1), ret.getString(2), type);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<OrganizationPO> fuzzySearchbyboth(String name, Organizationtype typeget) {
		List<OrganizationPO> list = new ArrayList<OrganizationPO>();
		try {
			byte[] typebyte = Serialize.Object2Bytes(typeget);

			OrganizationPO po;
			dbh = new DBHelper();
			sql = "select id,name,type from OrganizationPO where type=? and name like ?";
			pst = dbh.prepare(sql);

			pst.setBytes(1, typebyte);
			pst.setString(2, "%" + name + "%"); // 模糊查找时两边加%
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] typebytes = ret.getBytes(3);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po = new OrganizationPO(ret.getLong(1), ret.getString(2), type);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static OrganizationPO search(long id){
		OrganizationPO po=null;
		dbh=new DBHelper();
		sql="select id,name,type from OrganizationPO where id = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1,id);	
			ret=pst.executeQuery();
			if(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getLong(1),ret.getString(2),type);
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
		sql="select max(id) from OrganizationPO";
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
		System.out.println("test");
		if(write("南京",Organizationtype.hall)==ResultMessage.success){
			System.out.println("write success");
		}
		if(getLastId()==2){
			System.out.println("getLastId success");
		}
		if(delete(2)==ResultMessage.success){
			System.out.println("delete success");
		}
		if(update(1,"上海",Organizationtype.transfercenter)==ResultMessage.success){
			System.out.println("update success");
		}
		if(search(1)!=null){
			System.out.println("seach success");
		}
		if(fuzzySearch("上海").size()>0){
			System.out.println("fuzzysearch success");
		}
		if(fuzzySearchbytype(Organizationtype.transfercenter).size()>0){
			System.out.println("fuzzySearchbyypte success");
		}
		if(fuzzySearchbyboth("上海",Organizationtype.transfercenter).size()>0){
			System.out.println("fuzzySearchbyboth success");
		}
	}
}
