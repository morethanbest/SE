package data.database.transportDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import po.DriversPO;
import po.ResultMessage;

public class DriverDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table DriversPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table DriversPO(drivercode text,drivername text,birthtime bigint,identifiercode text,cellphone text,drivergender text,timelimit bigint)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			DriversPO po = new DriversPO("025000000", "大梦", 19930430, "31022819930430689", "13123456789", "男",
					20180530);
			ResultMessage result;
			result = write(po);
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			dbh.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(DriversPO po) {
		// if(search(job)!=null){
		// return ResultMessage.failure;
		// }
		dbh = new DBHelper();
		try {
			sql = "insert into DriversPO values(?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getDrivercode());
			pst.setString(2, po.getDrivername());
			pst.setLong(3, po.getBirthtime());
			pst.setString(4, po.getIdentifiercode());
			pst.setString(5, po.getCellphone());
			pst.setString(6, po.getDrivergender());
			pst.setLong(7, po.getTimelimit());

			int result = pst.executeUpdate();
			if (result == -1) {
				dbh.close();
				return ResultMessage.failure;
			}
			dbh.close();
			return ResultMessage.success;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResultMessage.failure;

	}

	public static ResultMessage delete(DriversPO po) {
		dbh = new DBHelper();
		sql = "delete from DriversPO where drivercode=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, po.getDrivercode());
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	public static ResultMessage update(DriversPO po) {
		dbh = new DBHelper();
		sql = "update DriversPO set drivername=?,birthtime=?,identifiercode=?,cellphone=?,drivergender=?,timelimit=? where drivercode=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, po.getDrivername());
			pst.setLong(2, po.getBirthtime());
			pst.setString(3, po.getIdentifiercode());
			pst.setString(4, po.getCellphone());
			pst.setString(5, po.getDrivergender());
			pst.setLong(6, po.getTimelimit());
			pst.setString(7, po.getDrivercode());
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	public static DriversPO search(String drivercode) {
		DriversPO po = null;
		dbh = new DBHelper();
		try {
			sql = "select drivername,birthtime,identifiercode,cellphone,drivergender,timelimit from DriversPO where drivercode = ?";
			pst = dbh.prepare(sql);
			pst.setString(1, drivercode);
			ret = pst.executeQuery();
			if (ret.next()) {
				po = new DriversPO(drivercode, ret.getString(1), ret.getLong(2), ret.getString(3), ret.getString(4),
						ret.getString(5), ret.getLong(6));
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public static List<DriversPO> fuzzysearch(String name){
		List<DriversPO> list=new ArrayList<DriversPO>();
		dbh = new DBHelper();
		try {
			sql = "select drivercode,birthtime,identifiercode,cellphone,drivergender,timelimit from DriversPO where drivername like ?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+name+"%");
			ret = pst.executeQuery();
			if (ret.next()) {
				DriversPO po = new DriversPO( ret.getString(1),name, ret.getLong(2), ret.getString(3), ret.getString(4),
						ret.getString(5), ret.getLong(6));
				list.add(po);
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getlastcode(String codeget){
		String code=null;
		dbh = new DBHelper();
		try {
			sql = "select drivercode from DriversPO where drivercode like ?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+codeget+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(ret.getString(1).startsWith(codeget))
					code=ret.getString(1);
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	public static void main(String[] args) {
		initialize();
		if(search("025000000")!=null){
			System.out.println("search success");
		}
		if(fuzzysearch("大").size()>0){
			System.out.println("fuzzysearch success");
		}
		System.out.println(getlastcode("025000"));
	}
}
