package data.database.accountDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.AccountPO;
import po.CommodityPO;
import po.NewbookPO;
import po.OrganizationPO;
import po.ResultMessage;
import po.StaffPO;
import po.VehiclesPO;

public class NewBookDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table NewbookPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table NewbookPO(id bigint ,time bigint,account blob,commodity blob,organization blob,"
					+ "staff blob,vehicles blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ResultMessage write(NewbookPO po){
		dbh=new DBHelper();
		sql="insert into NewbookPO values(?,?,?,?,?,?,?)";
		pst=dbh.prepare(sql);
		try{
			pst.setLong(1,po.getId());
			pst.setLong(2, po.getTime());
			byte[] accountbytes=Serialize.Object2Bytes(po.getAccount());
			byte[] commoditybytes=Serialize.Object2Bytes(po.getCommodity());
			byte[] organizationbytes=Serialize.Object2Bytes(po.getOrganization());
			byte[] staffbytes=Serialize.Object2Bytes(po.getStaff());
			byte[] vehiclesbytes=Serialize.Object2Bytes(po.getVehicles());
			pst.setBytes(3, accountbytes);
			pst.setBytes(4, commoditybytes);
			pst.setBytes(5, organizationbytes);
			pst.setBytes(6, staffbytes);
			pst.setBytes(7, vehiclesbytes);
			int result=pst.executeUpdate();
			if(result==-1){
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();
			return ResultMessage.success;
		}catch(Exception e){
			e.printStackTrace();
		}
		dbh.close();
		return ResultMessage.failure;
		
	}
	
	
	public static NewbookPO search(long time){
		NewbookPO po=null;
		dbh=new DBHelper();
		sql="select id,time,account,commodity,organization,staff,vehicles from NewbookPO where  time<= ?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1,time);	
			ret=pst.executeQuery();
			long lasttime=0;
			while(ret.next()){
				if(ret.getLong(2)>lasttime){				//如果查到的比之前的更新
					lasttime=ret.getLong(2);
					List<AccountPO> account=(List<AccountPO>)Serialize.Bytes2Object(ret.getBytes(3));
					List<CommodityPO> commodity=(List<CommodityPO>)Serialize.Bytes2Object(ret.getBytes(4));
					List<OrganizationPO> organization=(List<OrganizationPO>)Serialize.Bytes2Object(ret.getBytes(5));
					List<StaffPO> staff=(List<StaffPO>)Serialize.Bytes2Object(ret.getBytes(6));
					List<VehiclesPO> vehicles=(List<VehiclesPO>)Serialize.Bytes2Object(ret.getBytes(7));
					po=new NewbookPO(ret.getLong(1),ret.getLong(2),account,commodity,organization,staff,vehicles);
				}

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
		sql="select id from NewbookPO";
		pst = dbh.prepare(sql);
		try {
			ret=pst.executeQuery();
			while(ret.next()){
				if(ret.getLong(1)>lastId){
					lastId=ret.getLong(1);
				}
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
		
	}

}
