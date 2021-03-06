package data.database.logisticsDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;

public class CenterloadDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table CenterloadPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table CenterloadPO(loadtime bigint,motorcode text,destination text,"
					+ "vehiclecode text,supervisor text,supercargo text,allbarcode blob,fee double,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(CenterloadPO po) {
		try {
			byte[] listbytes = Serialize.Object2Bytes(po.getAllbarcode());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "insert into CenterloadPO values(?,?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setLong(1, po.getLoadtime());
			pst.setString(2, po.getMotorcode());
			pst.setString(3, po.getDestination());
			pst.setString(4, po.getVehiclecode());
			pst.setString(5, po.getSupervisor());
			pst.setString(6, po.getSupercargo());
			pst.setBytes(7, listbytes);
			pst.setDouble(8, po.getFee());
			pst.setBytes(9, formstate);
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

	public static ResultMessage update(CenterloadPO po) {

		try {
			byte[] listbytes=Serialize.Object2Bytes(po.getAllbarcode());
			byte[] formstate =Serialize.Object2Bytes(po.getDocumentstate());
			dbh = new DBHelper();
			sql = "update CenterloadPO set loadtime=?,destination=?,vehiclecode=?,supervisor=?,"
					+ "supercargo=?,allbarcode=?,fee=?,documentstate=? where motorcode=?";
			pst = dbh.prepare(sql);
			pst.setLong(1, po.getLoadtime());
			pst.setString(2, po.getDestination());
			pst.setString(3, po.getVehiclecode());
			pst.setString(4, po.getSupervisor());
			pst.setString(5, po.getSupercargo());
			pst.setBytes(6, listbytes);
			pst.setDouble(7, po.getFee());
			pst.setBytes(8, formstate);
			pst.setString(9, po.getMotorcode());

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
	
	public static List<CenterloadPO> fuzzySearch(Formstate documentstate){
		List<CenterloadPO> list=new ArrayList<CenterloadPO>();
		CenterloadPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select loadtime,motorcode,destination,vehiclecode,supervisor,"
					+ "supercargo,allbarcode,fee from CenterloadPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allbarcode=(List<String>)Serialize.Bytes2Object(ret.getBytes(7)) ;
				po = new CenterloadPO(ret.getLong(1), ret.getString(2), ret.getString(3), ret.getString(4),
						ret.getString(5),ret.getString(6),allbarcode,ret.getDouble(8),documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<CenterloadPO> fuzzySearch(Formstate documentstate,String orgcode){
		List<CenterloadPO> list=new ArrayList<CenterloadPO>();
		CenterloadPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			sql = "select loadtime,motorcode,destination,vehiclecode,supervisor,"
					+ "supercargo,allbarcode,fee from CenterloadPO where documentstate = ? and motorcode like ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, "%"+orgcode+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(2).startsWith(orgcode))
					continue;
				List<String> allbarcode=(List<String>)Serialize.Bytes2Object(ret.getBytes(7)) ;
				po = new CenterloadPO(ret.getLong(1), ret.getString(2), ret.getString(3), ret.getString(4),
						ret.getString(5),ret.getString(6),allbarcode,ret.getDouble(8),documentstate);
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
		sql="select motorcode from CenterloadPO where motorcode like ?";
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
	
	public static CenterloadPO getpoBymotorcode(String motorcode){
		CenterloadPO po=null;
		dbh=new DBHelper();
		try {
//			byte[] statebytes=Serialize.Object2Bytes(Formstate.checked);
			sql = "select loadtime,destination,vehiclecode,supervisor,"
					+ "supercargo,allbarcode,fee,documentstate from CenterloadPO where motorcode = ?";
			pst = dbh.prepare(sql);
			pst.setString(1, motorcode);
//			pst.setBytes(2, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				List<String> allbarcode=(List<String>)Serialize.Bytes2Object(ret.getBytes(6)) ;
				Formstate state=(Formstate)Serialize.Bytes2Object(ret.getBytes(8)) ;
				po = new CenterloadPO(ret.getLong(1), motorcode, ret.getString(2), ret.getString(3),
						ret.getString(4),ret.getString(5),allbarcode,ret.getDouble(7),state);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args) {
//		System.out.println(getLastId("0250"));
//		initialize();
//		List<String> list=new ArrayList<String>();
//		list.add("001");
//		CenterloadPO po=new CenterloadPO(1,"0250002","1","b","c","d",list,10,Formstate.waiting);
//		if(write(po)==ResultMessage.success)
//			System.out.println("write success");
//		if(update(po)==ResultMessage.success)
//			System.out.println("update success");
//		if(fuzzySearch(Formstate.waiting).size()>0)
//			System.out.println("fuzzysearch success");
//		System.out.println(getLastId("0250"));
					
	}
}
