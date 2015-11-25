package data.database.managerDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.database.DBHelper;
import data.database.Serialize;
import po.Job;
import po.ResultMessage;
import po.SalaryMode;
import po.SalaryPO;

public class SalaryDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table SalaryPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table SalaryPO(job blob,salarymode blob,base double,bonus double)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();
			SalaryPO po=new SalaryPO(Job.Courier,SalaryMode.deduct,2000,10);
			ResultMessage result;
			result = write(po.getJob(), po.getSalarymode(),po.getBase(),po.getBonus());
			if (result == ResultMessage.success) {
				System.out.println("add Successfully");
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ResultMessage write(Job job,SalaryMode salarymode,double base,double bonus){
		if(search(job)!=null){
			return ResultMessage.failure;
		}
		dbh=new DBHelper();
		try{
		byte[] jobbytes=Serialize.Object2Bytes(job);
		byte[] salarybytes=Serialize.Object2Bytes(salarymode);
		sql="insert into SalaryPO values(?,?,?,?)";
		pst=dbh.prepare(sql);
			pst.setBytes(1,jobbytes);
			pst.setBytes(2, salarybytes);
			pst.setDouble(3, base);
			pst.setDouble(4, bonus);
			int result=pst.executeUpdate();
			if(result==-1){
				dbh.close();
				return ResultMessage.failure;
			}
			dbh.close();
			return ResultMessage.success;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ResultMessage.failure;
		
	}
	
	public static ResultMessage delete(Job job){
		dbh=new DBHelper();
		sql="delete from SalaryPO where job=?";
		pst=dbh.prepare(sql);
		try{
			byte[] jobbytes=Serialize.Object2Bytes(job);
			pst.setBytes(1, jobbytes);
			int result;
			result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static ResultMessage update(Job job,SalaryMode salarymode,double base,double bonus){
		dbh=new DBHelper();
		sql="update SalaryPO set salarymode=?,base=?,bonus=? where job=?";
		pst=dbh.prepare(sql);
		try{
			byte[] jobbytes=Serialize.Object2Bytes(job);
			byte[] salarybytes=Serialize.Object2Bytes(salarymode);
			pst.setBytes(1,salarybytes);
			pst.setDouble(2, base);
			pst.setDouble(3, bonus);
			pst.setBytes(4, jobbytes);
			int result;
			result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	
	
	
	public static SalaryPO search(Job job){
		SalaryPO po=null;
		dbh=new DBHelper();
		try {
		byte[] jobbytes=Serialize.Object2Bytes(job);
		sql="select job,salarymode,base,bonus from SalaryPO where job = ?";
		pst = dbh.prepare(sql);
			pst.setBytes(1,jobbytes);	
			ret=pst.executeQuery();
			if(ret.next()){
				Job jobget=(Job)Serialize.Bytes2Object(ret.getBytes(1));
				SalaryMode salarymode=(SalaryMode)Serialize.Bytes2Object(ret.getBytes(2));
				po=new SalaryPO(jobget,salarymode,ret.getDouble(3),ret.getDouble(4));
			}
			ret.close();
			dbh.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;		
	}
	
	public static void main(String[] args) {
		initialize();
		if(search(Job.Courier)!=null){
			System.out.println("search success");
		}
		if(update(Job.Courier,SalaryMode.deduct,2000,50)==ResultMessage.success){
			System.out.println("update success");
		}
//		if(delete(Job.Courier)==ResultMessage.success){
//			System.out.println("delete success");
//		}
	}
}
