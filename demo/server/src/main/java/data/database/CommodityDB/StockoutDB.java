package data.database.commodityDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;

public class StockoutDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table StockoutPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table StockoutPO(id text,ordercode text,outtime bigint,"
					+ "destination text,transporttype text,transcode text,formstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(StockoutPO po) {
		try {
			byte[] formstate =Serialize.Object2Bytes(po.getFormstate());
			dbh = new DBHelper();
			sql = "insert into StockoutPO values(?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setString(2, po.getOrdercode());
			pst.setLong(3, po.getOuttime());
			pst.setString(4, po.getDestination());
			pst.setString(5, po.getTransporttype());
			pst.setString(6, po.getTranscode());
			pst.setBytes(7, formstate);
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

	public static ResultMessage update(StockoutPO po) {

		try {
			byte[] formstate =Serialize.Object2Bytes(po.getFormstate());
			dbh = new DBHelper();
			sql = "update StockoutPO set ordercode=?,outtime=?,destination=?,transporttype=?,transcode=?,formstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getOrdercode());
			pst.setLong(2, po.getOuttime());
			pst.setString(3, po.getDestination());
			pst.setString(4, po.getTransporttype());
			pst.setString(5, po.getTranscode());
			pst.setBytes(6, formstate);
			pst.setString(7, po.getId());
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
	
	public static List<StockoutPO> fuzzySearch(Formstate documentstate){
		List<StockoutPO> list=new ArrayList<StockoutPO>();
		StockoutPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,ordercode,outtime,destination,transporttype,transcode from StockoutPO where formstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				po = new StockoutPO(ret.getString(1), ret.getString(2), ret.getLong(3), ret.getString(4), ret.getString(5),
						ret.getString(6),documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<StockoutPO> fuzzySearch(Formstate documentstate,String orgcode){
		List<StockoutPO> list=new ArrayList<StockoutPO>();
		StockoutPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,ordercode,outtime,destination,transporttype,transcode from StockoutPO where formstate = ? and id like ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				po = new StockoutPO(ret.getString(1), ret.getString(2), ret.getLong(3), ret.getString(4), ret.getString(5),
						ret.getString(6),documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static long getLastId(String orgcode){
		long lastId=0;
		dbh=new DBHelper();
		sql="select id from StockoutPO where id like ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, "%"+orgcode+"%");
			ret=pst.executeQuery();
			if(ret.next()){
				if(ret.getString(1).startsWith(orgcode))
					lastId++;
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
		StockoutPO po=new StockoutPO("0250001","a",1,"b","c","d",Formstate.waiting);
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting,"025").size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId("025"));
					
	}
}
