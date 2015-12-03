package data.database.balanceDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.Formstate;
import po.RecordpayList;
import po.RecordpayPO;
import po.ResultMessage;

public class RecordpayDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table RecordpayPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table RecordpayPO(id text,paytime bigint,paysum double,payman text,"
					+ "payaccount text,entry blob,remark text,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(RecordpayPO po) {
		try {
			byte[] listbytes=Serialize.Object2Bytes(po.getEntry());
			byte[] formstate =Serialize.Object2Bytes(po.getFormstate());
			dbh = new DBHelper();
			sql = "insert into RecordpayPO values(?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setLong(2,po.getPaytime() );
			pst.setDouble(3, po.getPaysum());
			pst.setString(4, po.getPayman());
			pst.setString(5, po.getPayaccount());
			pst.setBytes(6, listbytes);
			pst.setString(7, po.getRemark());
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

	public static ResultMessage update(RecordpayPO po) {

		try {

			byte[] listbytes=Serialize.Object2Bytes(po.getEntry());
			byte[] formstate =Serialize.Object2Bytes(po.getFormstate());
			dbh = new DBHelper();
			sql = "update RecordpayPO set paytime=?,paysum=?,payman=?,payaccount=?,entry=?,remark=?,documentstate=? where id=?";
			pst = dbh.prepare(sql);
			pst.setLong(1,po.getPaytime() );
			pst.setDouble(2, po.getPaysum());
			pst.setString(3, po.getPayman());
			pst.setString(4, po.getPayaccount());
			pst.setBytes(5, listbytes);
			pst.setString(6, po.getRemark());
			pst.setBytes(7, formstate);
			pst.setString(8, po.getId());
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
	
	public static List<RecordpayPO> fuzzySearch(Formstate documentstate){
		List<RecordpayPO> list=new ArrayList<RecordpayPO>();
		RecordpayPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,paytime,paysum,payman,payaccount,entry,remark from RecordpayPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				RecordpayList entry=(RecordpayList)Serialize.Bytes2Object(ret.getBytes(6));
				po = new RecordpayPO(ret.getString(1), ret.getLong(2), ret.getDouble(3), ret.getString(4),
						ret.getString(5),entry,ret.getString(7),documentstate);
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
	public static List<RecordpayPO> getbetween(Formstate documentstate,long starttime,long endtime){
		List<RecordpayPO> list=new ArrayList<RecordpayPO>();
		RecordpayPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select id,paytime,paysum,payman,payaccount,entry,remark from RecordpayPO where documentstate = ?"
					+ "and ?<=paytime<=?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setLong(2, starttime);
			pst.setLong(3, endtime);
			ret = pst.executeQuery();
			while (ret.next()) {
				RecordpayList entry=(RecordpayList)Serialize.Bytes2Object(ret.getBytes(6));
				po = new RecordpayPO(ret.getString(1), ret.getLong(2), ret.getDouble(3), ret.getString(4),
						ret.getString(5),entry,ret.getString(7),documentstate);
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
		long lastId=-1;
		dbh=new DBHelper();
		sql="select count(*) from RecordpayPO";
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
		lastId--;
		return lastId;
	}

	public static void main(String[] args) {
		initialize();
		RecordpayPO po=new RecordpayPO("0000001",1,2,"sunchao","123",RecordpayList.bonus,"a",Formstate.waiting);
		if(write(po)==ResultMessage.success)
			System.out.println("write success");
		if(update(po)==ResultMessage.success)
			System.out.println("update success");
		if(fuzzySearch(Formstate.waiting).size()>0)
			System.out.println("fuzzysearch success");
		System.out.println(getLastId());
					
	}
}
