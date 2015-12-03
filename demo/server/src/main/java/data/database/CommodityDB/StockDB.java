package data.database.commodityDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import po.ResultMessage;
import po.StockPO;

public class StockDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table StockPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table StockPO(orgcode text,name text,blocknum bigint,linenum bigint,shelfnum bigint,locationnum bigint,"
					+ "totalnum bigint,warningvalue double)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			write(new StockPO("0250","航运区",1,200,50,200,200000,0.9));
			write(new StockPO("0250","铁运区",2,400,50,200,400000,0.9));
			write(new StockPO("0250","汽运区",3,300,50,200,300000,0.9));
			write(new StockPO("0250","机动区",4,100,50,200,100000,0.9));
			
			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(StockPO po) {
		try {
			dbh = new DBHelper();
			sql = "insert into StockPO values(?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getOrgcode());
			pst.setString(2, po.getName());
			pst.setLong(3, po.getBlocknum());
			pst.setLong(4, po.getLinenum());
			pst.setLong(5, po.getShelfnum());
			pst.setLong(6, po.getLocationnum());
			pst.setLong(7, po.getTotalnum());
			pst.setDouble(8, po.getWarningvalue());
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

	public static ResultMessage update(StockPO po) {

		try {
			dbh = new DBHelper();
			sql = "update StockPO set name=?,blocknum=?,linenum=?,shelfnum=?,locationnum=?,totalnum=?,warningvalue=? where orgcode=?,";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getName());
			pst.setLong(2, po.getBlocknum());
			pst.setLong(3, po.getLinenum());
			pst.setLong(4, po.getShelfnum());
			pst.setLong(5, po.getLocationnum());
			pst.setLong(6, po.getTotalnum());
			pst.setDouble(7, po.getWarningvalue());
			pst.setString(8, po.getOrgcode());
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
	
	//获取某个区达到警戒值的库存数量
	public static double getwarningNumInblock(String orgcode,long blocknum){
		double num=0;
		try {
			dbh = new DBHelper();
			sql = "select totalnum,warningvalue from StockPO where orgcode =? and blocknum=?";
			pst = dbh.prepare(sql);
			pst.setString(1, orgcode);
			pst.setLong(2, blocknum);
			ret = pst.executeQuery();
			if(ret.next()){
				num=ret.getLong(1)*ret.getDouble(2);
			}
			ret.close();
			dbh.close();// 关闭连接


		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	//获取所有的区号
	public static List<Long> getAllblock(String orgcode) {
		List<Long> list=new ArrayList<Long>();
		try {
			dbh = new DBHelper();
			sql = "select blocknum from StockPO where orgcode =?";
			pst = dbh.prepare(sql);
			pst.setString(1, orgcode);
			ret = pst.executeQuery();
			while(ret.next()){
				list.add(ret.getLong(1));
			}
			ret.close();
			dbh.close();// 关闭连接


		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public static void main(String[] args) {
		initialize();
		

	}
}
