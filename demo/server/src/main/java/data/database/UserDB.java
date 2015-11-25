package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import po.City;
import po.Job;
import po.LoginPO;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;
import po.StaffPO;
import po.UserPO;

public class UserDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst = null;

	public static void initialize() {
		dbh = new DBHelper();
		sql = "drop table UserPO";
		pst = dbh.prepare(sql);
		try {
			pst.executeUpdate();
			sql = "create table UserPO(id bigint auto_increment primary key,username text,password text,staff blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			UserPO po = new UserPO(1, "sunchao", "123", new StaffPO(2,"sunchao",Job.manager,null) ); // 此处的id没用，以后应该设个初始值如10000

			ResultMessage result;
			result = write(po.getUsername(), po.getPassword(),po.getStaff());
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}

			dbh.close();// 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultMessage write(String username, String password, StaffPO staff) {
		try {
			byte[] staffbytes = Serialize.Object2Bytes(staff);
			dbh = new DBHelper();
			sql = "insert into UserPO values(null,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, username);
			pst.setString(2, password);
			pst.setBytes(3, staffbytes);
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
	
	public static ResultMessage deletebyStaff(List<StaffPO> stafflist){
		dbh=new DBHelper();
		sql="delete from UserPO where staff=?";
		pst=dbh.prepare(sql);
		try{
			int result=0;
			for(int i=0;i<stafflist.size();i++){
				byte[] staffbytes=Serialize.Object2Bytes(stafflist.get(i));
				pst.setBytes(1,staffbytes);
				if(pst.executeUpdate()>0)
				result=1;
			}
			if(result!=0){
				return ResultMessage.success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	public static LoginPO check(long id, String password) {
		LoginPO po=null;
		dbh = new DBHelper();
		sql = "select username,staff from UserPO where id=? and password=?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1, id);
			pst.setString(2, password);
			ret = pst.executeQuery();
			if (ret.next()) {
				String username = ret.getString(1);
				byte[] staffbytes = ret.getBytes(2);
				StaffPO staff = (StaffPO) Serialize.Bytes2Object(staffbytes);
				po = new LoginPO(username, staff);
				ret.close();
				dbh.close();// 关闭连接
				return po;
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static void main(String[] args) {
		initialize();
		write("a","1234",new StaffPO(1,"sunchao",Job.transfercentersalesman,new OrganizationPO("上海中转中心","025000",Organizationtype.transfercenter,City.Shanghai)));
	}

}
