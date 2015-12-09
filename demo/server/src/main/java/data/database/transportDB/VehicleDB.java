package data.database.transportDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import po.ResultMessage;
import po.VehiclesPO;

public class VehicleDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table VehiclesPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table VehiclesPO(vehiclecode text,vehiclenum text,extendtime bigint)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			VehiclesPO po = new VehiclesPO("025000000", "苏A00000", 19930430);
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

	public static ResultMessage write(VehiclesPO po) {
		// if(search(job)!=null){
		// return ResultMessage.failure;
		// }
		dbh = new DBHelper();
		try {
			sql = "insert into VehiclesPO values(?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getVehiclecode());
			pst.setString(2, po.getVehiclenum());
			pst.setLong(3, po.getExtendtime());

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

	public static ResultMessage delete(VehiclesPO po) {
		dbh = new DBHelper();
		sql = "delete from VehiclesPO where vehiclecode=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, po.getVehiclecode());
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

	public static ResultMessage update(VehiclesPO po) {
		dbh = new DBHelper();
		sql = "update VehiclesPO set vehiclenum=?,extendtime=? where vehiclecode=?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1, po.getVehiclenum());
			pst.setLong(2, po.getExtendtime());
			pst.setString(3, po.getVehiclecode());

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

	public static List<VehiclesPO> getAll(){
		List<VehiclesPO> list=new ArrayList<VehiclesPO>();
		dbh = new DBHelper();
		try {
			sql = "select vehiclecode,vehiclenum,extendtime from VehiclesPO";
			pst = dbh.prepare(sql);
			ret = pst.executeQuery();
			while(ret.next()) {
				list.add(new VehiclesPO(ret.getString(1), ret.getString(2), ret.getLong(3)));
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static VehiclesPO searchbycode(String vehiclecode) {
		VehiclesPO po = null;
		dbh = new DBHelper();
		try {
			sql = "select vehiclenum,extendtime from VehiclesPO where vehiclecode = ?";
			pst = dbh.prepare(sql);
			pst.setString(1, vehiclecode);
			ret = pst.executeQuery();
			if (ret.next()) {
				po = new VehiclesPO(vehiclecode, ret.getString(1), ret.getLong(2));
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public static VehiclesPO searchbynum(String vehiclenum) {
		VehiclesPO po = null;
		dbh = new DBHelper();
		try {
			sql = "select vehiclecode,extendtime from VehiclesPO where vehiclenum = ?";
			pst = dbh.prepare(sql);
			pst.setString(1, vehiclenum);
			ret = pst.executeQuery();
			if (ret.next()) {
				po = new VehiclesPO(ret.getString(1),vehiclenum, ret.getLong(2));
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public static long getlastcode(String codeget){
		long lastid=-1;
		dbh = new DBHelper();
		try {
			sql = "select vehiclecode from VehiclesPO where vehiclecode like ?";
			pst = dbh.prepare(sql);
			pst.setString(1, "%"+codeget+"%");
			ret = pst.executeQuery();
			while (ret.next()) {
				if(ret.getString(1).startsWith(codeget));
					lastid++;
			}
			ret.close();
			dbh.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastid;
	}
	public static void main(String[] args) {
		initialize();
		if(searchbycode("025000000")!=null){
			System.out.println("search success");
		}
		if(searchbynum("苏A00000")!=null){
			System.out.println("fuzzysearch success");
		}
		System.out.println(getlastcode("025000"));
	}
}
