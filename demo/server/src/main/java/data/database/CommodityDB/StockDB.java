package data.database.commodityDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.database.DBHelper;
import data.database.Serialize;
import po.ResultMessage;
import po.StockPO;

public class StockDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
//		sql = "drop table StockPO";
//		pst = dbh.prepare(sql);
		try {
//			pst.executeUpdate();
			sql = "create table StockPO(name text,blocknum bigint,linenum bigint,shelfnum bigint,locationnum bigint,totalnum bigint,warningvalue double)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(StockPO po) {
		try {
			byte[] location = Serialize.Object2Bytes(po.getLocation());
			dbh = new DBHelper();
			sql = "insert into StockPO values(?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getId());
			pst.setString(2, po.getOrdercode());
			pst.setLong(3, po.getIntime());
			pst.setLong(4, po.getOuttime());
			pst.setString(5, po.getDestination());
			pst.setBytes(6, location);
			pst.setLong(7, po.getLocation().getBlocknum());
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
//
//		return ResultMessage.failure;
//
//	}
//
//	public static ResultMessage update(CommodityPO po) {
//
//		try {
//			byte[] location = Serialize.Object2Bytes(po.getLocation());
//			dbh = new DBHelper();
//			sql = "update CommodityPO set ordercode=?,intime=?,outtime=?,destination=?,Location=?,blocknum=? where id=?";
//			pst = dbh.prepare(sql);
//			pst.setString(1, po.getOrdercode());
//			pst.setLong(2, po.getIntime());
//			pst.setLong(3, po.getOuttime());
//			pst.setString(4, po.getDestination());
//			pst.setBytes(5, location);
//			pst.setString(6, po.getId());
//			pst.setLong(7, po.getLocation().getBlocknum());
//			int result = pst.executeUpdate();
//			if (result == -1) {
//				dbh.close();// 关闭连接
//				return ResultMessage.failure;
//			}
//			dbh.close();// 关闭连接
//			return ResultMessage.success;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ResultMessage.failure;
//	}

	public static void main(String[] args) {
		initialize();

	}
}
