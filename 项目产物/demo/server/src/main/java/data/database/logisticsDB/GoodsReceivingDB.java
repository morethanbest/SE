package data.database.logisticsDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.ResultMessage;

public class GoodsReceivingDB {static String sql = null;
static DBHelper dbh = null;
static ResultSet ret = null;
static PreparedStatement pst = null;

public static void initialize() {
	dbh = new DBHelper();
	sql = "drop table GoodsReceivingPO";
	pst = dbh.prepare(sql);
	try {
		pst.executeUpdate();
		sql = "create table GoodsReceivingPO(id text,arrivaltime bigint,whefromhall boolean,"
				+ "transcode text,departure text,arrivalstate blob,documentstate blob)";
		pst = dbh.prepare(sql);
		pst.executeUpdate();
		dbh.close();// 关闭连接
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static ResultMessage write(GoodsReceivingPO po) {
	try {
		byte[] statebytes = Serialize.Object2Bytes(po.getArrivalstate());
		byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
		dbh = new DBHelper();
		sql = "insert into GoodsReceivingPO values(?,?,?,?,?,?,?)";
		pst = dbh.prepare(sql);
		pst.setString(1, po.getId());
		pst.setLong(2, po.getArrivaltime());
		pst.setBoolean(3, po.isWhefromhall());
		pst.setString(4, po.getTranscode());
		pst.setString(5, po.getDeparture());
		pst.setBytes(6, statebytes);
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

public static ResultMessage update(GoodsReceivingPO po) {

	try {
		byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
		byte[] arrivalstate =Serialize.Object2Bytes(po.getArrivalstate());
		dbh = new DBHelper();
		sql = "update GoodsReceivingPO set arrivaltime=?,whefromhall=?,transcode=?,departure=?,arrivalstate=?,documentstate=? where id=?";
		pst = dbh.prepare(sql);
		pst.setLong(1, po.getArrivaltime());
		pst.setBoolean(2, po.isWhefromhall());
		pst.setString(3, po.getTranscode());
		pst.setString(4, po.getDeparture());
		pst.setBytes(5, arrivalstate);
		pst.setBytes(6, formstate);
		pst.setString(7,po.getId());
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

public static List<GoodsReceivingPO> fuzzySearch(Formstate documentstate){
	List<GoodsReceivingPO> list=new ArrayList<GoodsReceivingPO>();
	GoodsReceivingPO po;
	dbh=new DBHelper();
	try {
		byte[] statebytes = Serialize.Object2Bytes(documentstate);
		sql = "select id,arrivaltime,whefromhall,transcode,departure,arrivalstate from GoodsReceivingPO where documentstate = ?";
		pst = dbh.prepare(sql);
		pst.setBytes(1, statebytes);
		ret = pst.executeQuery();
		while (ret.next()) {
			Arrivalstate arrivalstate=(Arrivalstate)Serialize.Bytes2Object(ret.getBytes(6)) ;
			po = new GoodsReceivingPO(ret.getString(1), ret.getLong(2), ret.getBoolean(3),ret.getString(4), ret.getString(5),
					arrivalstate,documentstate);
			list.add(po);
		}
		ret.close();
		dbh.close();// 关闭连接
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public static List<GoodsReceivingPO> fuzzySearch(Formstate documentstate,String orgcode){
	List<GoodsReceivingPO> list=new ArrayList<GoodsReceivingPO>();
	GoodsReceivingPO po;
	dbh=new DBHelper();
	try {
		byte[] statebytes = Serialize.Object2Bytes(documentstate);
		sql = "select id,arrivaltime,whefromhall,transcode,departure,arrivalstate from GoodsReceivingPO where documentstate = ? and id like ?";
		pst = dbh.prepare(sql);
		pst.setBytes(1, statebytes);
		pst.setString(2, "%"+orgcode+"%");
		ret = pst.executeQuery();
		while (ret.next()) {
			if(!ret.getString(1).startsWith(orgcode))
				continue;
			Arrivalstate arrivalstate=(Arrivalstate)Serialize.Bytes2Object(ret.getBytes(6)) ;
			po = new GoodsReceivingPO(ret.getString(1), ret.getLong(2), ret.getBoolean(3),ret.getString(4), ret.getString(5),
					arrivalstate,documentstate);
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
	long lastId=-1;
	dbh=new DBHelper();
	sql="select id from GoodsReceivingPO where id like ?";
	pst = dbh.prepare(sql);
	try {
		pst.setString(1, "%"+orgcode+"%");
		ret=pst.executeQuery();
		while(ret.next()){
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
//	GoodsReceivingPO po=new GoodsReceivingPO("0250001",1,true,"b","c",Arrivalstate.lost,Formstate.waiting);
//	if(write(po)==ResultMessage.success)
//		System.out.println("write success");
//	if(update(po)==ResultMessage.success)
//		System.out.println("update success");
//	if(fuzzySearch(Formstate.waiting).size()>0)
//		System.out.println("fuzzysearch success");
//	System.out.println(getLastId("025"));
				
}
}
