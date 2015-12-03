package data.database.balanceDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.CommodityLocation;
import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;
import po.StockinPO;

public class RecordcollectDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
//		sql = "drop table RecordcollectPO";
//		pst = dbh.prepare(sql);
		try {
//			pst.executeUpdate();
			sql = "create table RecordcollectPO(id text,collectiontime bigint,collectionsum double,"
					+ "collectionman text,allordercode blob,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(RecordcollectPO po) {
		try {
			byte[] listbytes=Serialize.Object2Bytes(po.getAllordercode());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "insert into RecordcollectPO values(?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setLong(2,po.getCollectiontime() );
			pst.setDouble(3, po.getCollectionsum());
			pst.setString(4, po.getCollectionman());
			pst.setBytes(5, listbytes);
			pst.setBytes(6, formstate);
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

	public static ResultMessage update(RecordcollectPO po) {

		try {
			byte[] location=Serialize.Object2Bytes(po.getAllordercode());
			byte[] formstate =Serialize.Object2Bytes(po.getFormstate());
			dbh = new DBHelper();
			sql = "update RecordcollectPO set collectiontime=?,collectionsum=?,Location=?,destination=?,formstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getOrdercode());
			pst.setLong(2, po.getIntime());
			pst.setBytes(3, location);
			pst.setString(4, po.getDestination());
			pst.setBytes(5, formstate);
			pst.setString(6, po.getId());
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
	
	public static List<StockinPO> fuzzySearch(Formstate documentstate){
		List<StockinPO> list=new ArrayList<StockinPO>();
		StockinPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,ordercode,intime,Location,destination from StockinPO where formstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				CommodityLocation location=(CommodityLocation)Serialize.Bytes2Object(ret.getBytes(4)) ;
				po = new StockinPO(ret.getString(1), ret.getString(2), ret.getLong(3), location, ret.getString(5),documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<StockinPO> fuzzySearch(Formstate documentstate,String orgcode){
		List<StockinPO> list=new ArrayList<StockinPO>();
		StockinPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,ordercode,intime,Location,destination from StockinPO where formstate = ? and id like ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				CommodityLocation location=(CommodityLocation)Serialize.Bytes2Object(ret.getBytes(4)) ;
				po = new StockinPO(ret.getString(1), ret.getString(2), ret.getLong(3), location, ret.getString(5),documentstate);
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
		sql="select id from StockinPO where id like ?";
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
		StockinPO po=new StockinPO("0250001","a",1,new CommodityLocation(1,1,1,1),"c",Formstate.waiting);
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting,"025").size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId("025"));
					
	}
}
