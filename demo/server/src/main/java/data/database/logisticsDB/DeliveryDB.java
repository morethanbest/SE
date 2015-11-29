package data.database.logisticsDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;

public class DeliveryDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table DeliveryPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table DeliveryPO(id text,arrivaltime bigint,"
					+ "barcode text,delivorinfo text,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(DeliveryPO po) {
		try {
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "insert into DeliveryPO values(?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setLong(2, po.getArrivaltime());
			pst.setString(3, po.getBarcode());
			pst.setString(4, po.getDelivorinfo());
			pst.setBytes(5, formstate);
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

	public static ResultMessage update(DeliveryPO po) {

		try {
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "update DeliveryPO set arrivaltime=?,barcode=?,delivorinfo=?,documentstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setLong(1, po.getArrivaltime());
			pst.setString(2, po.getBarcode());
			pst.setString(3, po.getDelivorinfo());
			pst.setBytes(4, formstate);
			pst.setString(5,po.getId());
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
	
	public static List<DeliveryPO> fuzzySearch(Formstate documentstate){
		List<DeliveryPO> list=new ArrayList<DeliveryPO>();
		DeliveryPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,arrivaltime,barcode,delivorinfo from DeliveryPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				po = new DeliveryPO(ret.getString(1), ret.getLong(2), ret.getString(3), ret.getString(4),documentstate);
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
		sql="select id from DeliveryPO where id like ?";
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
		DeliveryPO po=new DeliveryPO("0250001",1,"b","c",Formstate.waiting);
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting).size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId("025"));
					
	}
}
