package data.database.CommodityDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

public class CommodityDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table CommodityPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table CommodityPO(id text,ordercode text,intime bigint,outtime bigint,destination text,location blob,blocknum bigint)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(CommodityPO po) {
		try {
			byte[] location=Serialize.Object2Bytes(po.getLocation());
			dbh = new DBHelper();
			sql = "insert into CommodityPO values(?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setString(2, po.getOrdercode());
			pst.setLong(3, po.getIntime());
			pst.setLong(4, po.getOuttime());
			pst.setString(5, po.getDestination());
			pst.setBytes(6, location);
			pst.setLong(7, po.getLocation().getBlocknum());
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

	public static ResultMessage update(CommodityPO po) {

		try {
			byte[] location=Serialize.Object2Bytes(po.getLocation());
			dbh = new DBHelper();
			sql = "update CommodityPO set ordercode=?,intime=?,outtime=?,destination=?,Location=?,blocknum=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getOrdercode());
			pst.setLong(2, po.getIntime());
			pst.setLong(3,po.getOuttime());
			pst.setString(4, po.getDestination());
			pst.setBytes(5, location);
			pst.setString(6, po.getId());
			pst.setLong(7, po.getLocation().getBlocknum());
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
	
	
	public static List<CommodityPO> getAll(){
		List<CommodityPO> list=new ArrayList<CommodityPO>();
		CommodityPO po;
		dbh=new DBHelper();
		try {
			sql = "select id,ordercode,intime,outtime,destination,Location from CommodityPO and outtime < 0";
			pst = dbh.prepare(sql);
			ret = pst.executeQuery();
			while (ret.next()) {
				CommodityLocation location=(CommodityLocation)Serialize.Bytes2Object(ret.getBytes(6)) ;
				po = new CommodityPO(ret.getString(1), ret.getString(2), ret.getLong(3),ret.getLong(4),  ret.getString(5),location);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//获取某个仓库所有的库存
	public static List<CommodityPO> getAll(String orgcode){
		List<CommodityPO> list=new ArrayList<CommodityPO>();
		CommodityPO po;
		dbh=new DBHelper();
		try {
			sql = "select id,ordercode,intime,outtime,destination,Location from CommodityPO where id like ? and outtime < 0";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				CommodityLocation location=(CommodityLocation)Serialize.Bytes2Object(ret.getBytes(6)) ;
				po = new CommodityPO(ret.getString(1), ret.getString(2), ret.getLong(3),ret.getLong(4),  ret.getString(5),location);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//获取某个区所有没出库的库存
	public static List<CommodityPO> getbyblock(String orgcode,long blocknum){
		List<CommodityPO> list=new ArrayList<CommodityPO>();
		CommodityPO po;
		dbh=new DBHelper();
		try {
			sql = "select id,ordercode,intime,outtime,destination,Location from CommodityPO "
					+ "where id like ? and outtime < 0 and blocknum=?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+orgcode+"%");
			pst.setLong(2, blocknum);
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				CommodityLocation location=(CommodityLocation)Serialize.Bytes2Object(ret.getBytes(6)) ;
				po = new CommodityPO(ret.getString(1), ret.getString(2), ret.getLong(3),ret.getLong(4),  ret.getString(5),location);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//获取在一段时间内入库的数量
	public static long getinnumber(String orgcode,long starttime,long endtime){
		long number=0;
		dbh=new DBHelper();
		try {
			sql = "select id from CommodityPO where id like ? and ?<intime<?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+orgcode+"%");
			pst.setLong(2, starttime);
			pst.setLong(3, endtime);
			ret = pst.executeQuery();
			while (ret.next()) {
				if(ret.getString(1).startsWith(orgcode))
					number++;
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	//获取在一段时间内出库的数量
		public static long getoutnumber(String orgcode,long starttime,long endtime){
			long number=0;
			dbh=new DBHelper();
			try {
				sql = "select id from CommodityPO where id like ? and ?<outtime<?";
				pst = dbh.prepare(sql);
				pst.setString(1, "%"+orgcode+"%");
				pst.setLong(2, starttime);
				pst.setLong(3, endtime);
				ret = pst.executeQuery();
				while (ret.next()) {
					if(ret.getString(1).startsWith(orgcode))
						number++;
				}
				ret.close();
				dbh.close();// 关闭连接
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return number;
		}
	
	//获取在一个时间段内出入库的所有库存信息	
	public static List<CommodityPO> getbetween(String orgcode,long starttime,long endtime){
		List<CommodityPO> list=new ArrayList<CommodityPO>();
		CommodityPO po;
		dbh=new DBHelper();
		try {
			sql = "select id,ordercode,intime,outtime,destination,Location from CommodityPO where id like ? and outtime < 0 and "
					+ "?<= intime <=?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+orgcode+"%");
			pst.setLong(2, starttime);
			pst.setLong(3,endtime);
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				CommodityLocation location=(CommodityLocation)Serialize.Bytes2Object(ret.getBytes(6)) ;
				po = new CommodityPO(ret.getString(1), ret.getString(2), ret.getLong(3),ret.getLong(4),  ret.getString(5),location);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//获取在某个位置上的库存信息
	public static CommodityPO getbyLocation(String orgcode,CommodityLocation location){
		CommodityPO po=null;
		dbh=new DBHelper();
		try {
			byte[] locationbytes = Serialize.Object2Bytes(location);
			sql = "select id,ordercode,intime,outtime,destination from CommodityPO where Location = ? and id like ? and outtime<0";
			pst = dbh.prepare(sql);
			pst.setBytes(1, locationbytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				po = new CommodityPO(ret.getString(1), ret.getString(2), ret.getLong(3), ret.getLong(4),ret.getString(5),location);
				break;
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}
	
	
	//获取某个订单的库存信息
	public static CommodityPO getbyCode(String orgcode,String ordercode){
		CommodityPO po=null;
		dbh=new DBHelper();
		try {
			sql = "select id,intime,outtime,destination,location from CommodityPO where ordercode = ? and id like ? and outtime<0";
			pst = dbh.prepare(sql);
			pst.setString(1, ordercode);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				CommodityLocation location = (CommodityLocation)Serialize.Bytes2Object(ret.getBytes(5));
				po = new CommodityPO(ret.getString(1), ordercode, ret.getLong(2), ret.getLong(3),ret.getString(4),location);
				break;
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}
	//获取某个区的库存数量
	public static long getNum(String orgcode,long blocknum){
		long number=0;
		dbh=new DBHelper();
		sql="select id from CommodityPO where id like ? and blocknum=? and outtime<0";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, "%"+orgcode+"%");
			pst.setLong(2, blocknum);
			ret=pst.executeQuery();
			if(ret.next()){
				if(ret.getString(1).startsWith(orgcode))
					number++;
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	//获取该仓库的总数量
	public static long getAllNum(String orgcode){
		long number=0;
		dbh=new DBHelper();
		sql="select id from CommodityPO where id like ? and outtime<0";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, "%"+orgcode+"%");
			ret=pst.executeQuery();
			if(ret.next()){
				if(ret.getString(1).startsWith(orgcode))
					number++;
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}

	public static void main(String[] args) {
		initialize();
		CommodityPO po=new CommodityPO("0250001","a",20150422,-1,"b",new CommodityLocation(1,1,1,1));
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(getAll("025").size()>0)
			System.out.println("getall success");
		if(getbetween("025",20150422,20150422).size()>0){
			System.out.println("getbetween success");
		}
		if(getbyblock("025",1).size()>0){
			System.out.println("getbyblock success");
		}
					
	}
}
