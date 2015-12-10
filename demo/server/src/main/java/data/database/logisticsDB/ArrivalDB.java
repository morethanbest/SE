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

public class ArrivalDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table ArrivalPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table ArrivalPO(id text,centercode text,arrivaltime bigint,whefromhall boolean,"
					+ "transcode text,departure text,arrivalstate blob,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(ArrivalPO po) {
		try {
			byte[] statebytes = Serialize.Object2Bytes(po.getArrivalstate());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "insert into ArrivalPO values(?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setString(2, po.getCentercode());
			pst.setBoolean(3, po.isWhefromhall());
			pst.setLong(4, po.getArrivaltime());
			pst.setString(5, po.getTranscode());
			pst.setString(6, po.getDeparture());
			pst.setBytes(7, statebytes);
			pst.setBytes(8, formstate);
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

	public static ResultMessage update(ArrivalPO po) {

		try {
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			byte[] arrivalstate =Serialize.Object2Bytes(po.getArrivalstate());
			dbh = new DBHelper();
			sql = "update ArrivalPO set centercode=?,arrivaltime=?,whefromhall=?,transcode=?,departure=?,arrivalstate=?,documentstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getCentercode());
			pst.setLong(2, po.getArrivaltime());
			pst.setBoolean(3, po.isWhefromhall());
			pst.setString(4, po.getTranscode());
			pst.setString(5, po.getDeparture());
			pst.setBytes(6, arrivalstate);
			pst.setBytes(7, formstate);
			pst.setString(8,po.getId());
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
			sql = "select id,centercode,arrivaltime,whefromhall,transcode,departure,arrivalstate from ArrivalPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				Arrivalstate arrivalstate=(Arrivalstate)Serialize.Bytes2Object(ret.getBytes(7)) ;
				po = new ArrivalPO(ret.getString(1), ret.getString(2), ret.getLong(3), ret.getBoolean(4),ret.getString(5), ret.getString(6),
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
	
	public static List<ArrivalPO> fuzzySearch(Formstate documentstate,String orgcode){
		List<ArrivalPO> list=new ArrayList<ArrivalPO>();
		ArrivalPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,centercode,arrivaltime,transcode,departure,arrivalstate from ArrivalPO where documentstate = ? and id like ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				Arrivalstate arrivalstate=(Arrivalstate)Serialize.Bytes2Object(ret.getBytes(7)) ;
				po = new ArrivalPO(ret.getString(1), ret.getString(2), ret.getLong(3), ret.getBoolean(4),ret.getString(5), ret.getString(6),
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
		long lastId=0;
		dbh=new DBHelper();
		sql="select id from ArrivalPO where id like ?";
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
		ArrivalPO po=new ArrivalPO("0250001","a",1,true,"b","c",Arrivalstate.lost,Formstate.waiting);
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting).size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId("025"));
					
	}
}
