package data.database.logisticsDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.ArrivalPO;
import po.Arrivalstate;
import po.Formstate;
import po.ResultMessage;

public class CenterloadDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
//		sql = "drop table CenterloadPO";
//		pst = dbh.prepare(sql);
		try {
//			pst.executeUpdate();
			sql = "create table CenterloadPO(id bigint auto_increment primary key,loadtime bigint,motorcode text,destination text,"
					+ "vehiclecode text,supervisor text,supercargo text,allbarcode blob,fee double,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//
//	public static ResultMessage write(CenterloadPO po) {
//		try {
//			byte[] statebytes = Serialize.Object2Bytes(po.getArrivalstate());
//			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
//			dbh = new DBHelper();
//			sql = "insert into ArrivalPO values(null,?,?,?,?,?,?)";
//			pst = dbh.prepare(sql);
//
//			pst.setString(1, po.getCentercode());
//			pst.setLong(2, po.getArrivaltime());
//			pst.setString(3, po.getTranscode());
//			pst.setString(4, po.getDeparture());
//			pst.setBytes(5, statebytes);
//			pst.setBytes(6, formstate);
//			int result = pst.executeUpdate();
//			if (result == -1) {
//				dbh.close();// 关闭连接
//				return ResultMessage.failure;
//			}
//			dbh.close();// 关闭连接
//			return ResultMessage.success;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return ResultMessage.failure;
//
//	}

	public static ResultMessage update(ArrivalPO po) {

		try {
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "update ArrivalPO set documentstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, formstate);
			pst.setLong(2,po.getId());
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
	
	public static List<ArrivalPO> fuzzySearch(Formstate documentstate){
		List<ArrivalPO> list=new ArrayList<ArrivalPO>();
		ArrivalPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,centercode,arrivaltime,transcode,departure,arrivalstate from ArrivalPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				Arrivalstate arrivalstate=(Arrivalstate)Serialize.Bytes2Object(ret.getBytes(6)) ;
				po = new ArrivalPO(ret.getLong(1), ret.getString(2), ret.getLong(3), ret.getString(4), ret.getString(5),
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

	public static long getLastId(){
		long lastId=0;
		dbh=new DBHelper();
		sql="select max(id) from ArrivalPO";
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
		ArrivalPO po=new ArrivalPO(1,"a",1,"b","c",Arrivalstate.lost,Formstate.waiting);
//		if(write(po)==ResultMessage.success)
//			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting).size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId());
					
	}
}
