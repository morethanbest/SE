package data.database.logisticsDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;

public class RecordtransDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table RecordtransPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table RecordtransPO(loadtime bigint,transcode text,transport text,transportcode text,"
					+ "departrue text,destination text,countercode text,supervisor text,allcode blob,fee double,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(RecordtransPO po) {
		try {
			byte[] listbytes = Serialize.Object2Bytes(po.getAllcode());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "insert into RecordtransPO values(?,?,?,?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setLong(1, po.getLoadtime());
			pst.setString(2, po.getTranscode());
			pst.setString(3, po.getTransportType());
			pst.setString(4, po.getTransportCode());
			pst.setString(5, po.getDepartrue());
			pst.setString(6, po.getDestination());
			pst.setString(7, po.getCountercode());
			pst.setString(8, po.getSupervisor());
			pst.setBytes(9, listbytes);
			pst.setDouble(10, po.getFee());
			pst.setBytes(11, formstate);
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

	public static ResultMessage update(RecordtransPO po) {

		try {
			byte[] listbytes=Serialize.Object2Bytes(po.getAllcode());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "update RecordtransPO set loadtime=?,transport=?,transportcode=?,"
					+ "departrue=?,destination=?,countercode=?,supervisor=?,allcode=?,fee=?,documentstate=? where transcode=?";
			pst = dbh.prepare(sql);
			pst.setLong(1, po.getLoadtime());
			pst.setString(2, po.getTransportType());
			pst.setString(3, po.getTransportCode());
			pst.setString(4, po.getDepartrue());
			pst.setString(5, po.getDestination());
			pst.setString(6, po.getCountercode());
			pst.setString(7, po.getSupervisor());
			pst.setBytes(8, listbytes);
			pst.setDouble(9, po.getFee());
			pst.setBytes(10, formstate);
			pst.setString(11, po.getTranscode());
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
	
	public static List<RecordtransPO> fuzzySearch(Formstate documentstate){
		List<RecordtransPO> list=new ArrayList<RecordtransPO>();
		RecordtransPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select loadtime,transcode,transport,transportcode,"
					+ "departrue,destination,countercode,supervisor,allcode,fee from RecordtransPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allbarcode=(List<String>)Serialize.Bytes2Object(ret.getBytes(9));
				po = new RecordtransPO(ret.getLong(1), ret.getString(2), ret.getString(3), ret.getString(4),
						ret.getString(5),ret.getString(6),ret.getString(7),ret.getString(8),allbarcode,ret.getDouble(10),documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<RecordtransPO> fuzzySearch(Formstate documentstate,String orgcode){
		List<RecordtransPO> list=new ArrayList<RecordtransPO>();
		RecordtransPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select loadtime,transcode,transport,transportcode,departrue,destination,"
					+ "countercode,supervisor,allcode,fee from RecordtransPO where documentstate = ? and transcode like ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(3).startsWith(orgcode))
					continue;
				List<String> allbarcode=(List<String>)Serialize.Bytes2Object(ret.getBytes(9));
				po = new RecordtransPO(ret.getLong(1), ret.getString(2), ret.getString(3), ret.getString(4),
						ret.getString(5),ret.getString(6),ret.getString(7),ret.getString(8),allbarcode,ret.getDouble(10),documentstate);
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
		sql="select transcode from RecordtransPO where transcode like ?";
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
	
	public static RecordtransPO getpoBytranscode(String transcode){
		RecordtransPO po=null;
		dbh=new DBHelper();
		try {
//			byte[] statebytes=Serialize.Object2Bytes(Formstate.checked);
			sql = "select loadtime,transport,transportcode,departrue,destination,countercode,"
					+ "supervisor,allcode,fee,documentstate from RecordtransPO where transcode = ?";
			pst = dbh.prepare(sql);
			pst.setString(1, transcode);
//			pst.setBytes(2, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allbarcode=(List<String>)Serialize.Bytes2Object(ret.getBytes(8)) ;
				Formstate state=(Formstate)Serialize.Bytes2Object(ret.getBytes(10)) ;
				po = new RecordtransPO(ret.getLong(1), transcode,ret.getString(2), ret.getString(3), ret.getString(4),
						ret.getString(5),ret.getString(6),ret.getString(7),allbarcode,ret.getDouble(9),state);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args) {
		initialize();
//		List<String> list=new ArrayList<String>();
//		list.add("001");
//		RecordtransPO po=new RecordtransPO(1,"025000","02500000","1","b","c","d","e",list,10,Formstate.waiting);
//		if(write(po)==ResultMessage.success)
//			System.out.println("write success");
//		if(update(po)==ResultMessage.success)
//			System.out.println("update success");
//		if(fuzzySearch(Formstate.waiting).size()>0)
//			System.out.println("fuzzysearch success");
//		System.out.println(getLastId("0250"));
					
	}
}
