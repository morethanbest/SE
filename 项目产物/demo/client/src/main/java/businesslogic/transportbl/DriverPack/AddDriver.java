package businesslogic.transportbl.DriverPack;

import dataservice.transportdataservice.DriversDataService;
import init.RMIHelper;
import po.DriversPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class AddDriver {
	String drivercode;
	String drivername;
	long birthtime;
	String identifiercode;
	String cellphone;
	String drivergender;
	long timelimit;
	public void setAddDriver(String drivercode,String drivername,long birthtime,String identifiercode,String cellphone,String drivergender,long timelimit) {
		// TODO Auto-generated constructor stub
		this.drivercode=drivercode;
		this.drivername=drivername;
		this.birthtime=birthtime;
		this.identifiercode=identifiercode;
		this.cellphone=cellphone;
		this.drivergender=drivergender;
		this.timelimit=timelimit;
	}
	
	
	public ResultMessage passadd(){
		DriversPO po=new DriversPO(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
		DriversDataService dataserv= RMIHelper.getDriverdata();

		ResultMessage result= null;
		try {
			result = dataserv.insertDriver(po);
		} catch (Exception e) {
			System.out.println("Add driver failed!!!");
			result=ResultMessage.failure;
			e.printStackTrace();
		}
		return result;
	}
	
	
}
