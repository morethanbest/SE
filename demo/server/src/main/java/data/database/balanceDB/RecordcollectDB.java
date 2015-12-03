package data.database.balanceDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;

public class RecordcollectDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table RecordcollectPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table RecordcollectPO(id text,collectiontime bigint,accountcode text,collectionsum double,"
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
			sql = "insert into RecordcollectPO values(?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setLong(2,po.getCollectiontime() );
			pst.setString(3, po.getAccountcode());
			pst.setDouble(4, po.getCollectionsum());
			pst.setString(5, po.getCollectionman());
			pst.setBytes(6, listbytes);
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

	public static ResultMessage update(RecordcollectPO po) {

		try {
			byte[] listbytes=Serialize.Object2Bytes(po.getAllordercode());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "update RecordcollectPO set collectiontime=?,accountcode=?,collectionsum=?,collectionman=?,allordercode=?,documentstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setLong(1, po.getCollectiontime());
			pst.setString(2, po.getAccountcode());
			pst.setDouble(3, po.getCollectionsum());
			pst.setString(4, po.getCollectionman());
			pst.setBytes(5, listbytes);
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
	
	public static List<RecordcollectPO> fuzzySearch(Formstate documentstate){
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		RecordcollectPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,collectiontime,accountcode,collectionsum,collectionman,allordercode from RecordcollectPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allordercode=(List<String>)Serialize.Bytes2Object(ret.getBytes(6));
				po = new RecordcollectPO(ret.getString(1), ret.getLong(2), ret.getString(3),ret.getDouble(4), 
						ret.getString(5),allordercode,documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//获得在一段时间中完成的收款单
	public static List<RecordcollectPO> getbetween(Formstate documentstate,long starttime,long endtime){
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		RecordcollectPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,collectiontime,accountcode,collectionsum,collectionman,allordercode from RecordcollectPO where documentstate = ?"
					+ "and ?<=collect<=?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setLong(2, starttime);
			pst.setLong(3, endtime);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allordercode=(List<String>)Serialize.Bytes2Object(ret.getBytes(6));
				po = new RecordcollectPO(ret.getString(1), ret.getLong(2), ret.getString(3),ret.getDouble(4),
						ret.getString(5),allordercode,documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<RecordcollectPO> fuzzySearch(Formstate documentstate,String orgcode){
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		RecordcollectPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,collectiontime,accountcode,collectionsum,collectionman,allordercode from RecordcollectPO where documentstate = ? and id like ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				List<String> allordercode=(List<String>)Serialize.Bytes2Object(ret.getBytes(6));
				po = new RecordcollectPO(ret.getString(1), ret.getLong(2), ret.getString(3),ret.getDouble(4), 
						ret.getString(5),allordercode,documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//按营业厅获取收款单
	public static List<RecordcollectPO> getbyhall(String orgcode){
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		RecordcollectPO po;
		dbh=new DBHelper();
		try {
			sql = "select id,collectiontime,accountcode,collectionsum,collectionman,allordercode,documentstate from RecordcollectPO where id like ?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(1).startsWith(orgcode))
					continue;
				List<String> allordercode=(List<String>)Serialize.Bytes2Object(ret.getBytes(6));
				Formstate documentstate=(Formstate)Serialize.Bytes2Object(ret.getBytes(7));
				po = new RecordcollectPO(ret.getString(1), ret.getLong(2), ret.getString(3),ret.getDouble(4), 
						ret.getString(5),allordercode,documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//按天换取收款单
	public static List<RecordcollectPO> getbydate(long date){
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		RecordcollectPO po;
		dbh=new DBHelper();
		try {
			sql = "select id,collectiontime,accountcode,collectionsum,collectionman,allordercode,documentstate from RecordcollectPO where collectiontime = ?";
			pst = dbh.prepare(sql);
			pst.setLong(1,date);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allordercode=(List<String>)Serialize.Bytes2Object(ret.getBytes(6));
				Formstate documentstate=(Formstate)Serialize.Bytes2Object(ret.getBytes(7));
				po = new RecordcollectPO(ret.getString(1), ret.getLong(2), ret.getString(3),ret.getDouble(4), 
						ret.getString(5),allordercode,documentstate);
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
		sql="select id from RecordcollectPO where id like ?";
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
		RecordcollectPO po=new RecordcollectPO("0250001",1,"123",2,"sunchao",new ArrayList<String>(),Formstate.waiting);
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting,"025").size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId("025"));
					
	}
}
