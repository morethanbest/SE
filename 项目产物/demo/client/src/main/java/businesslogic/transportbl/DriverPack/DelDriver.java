package businesslogic.transportbl.DriverPack;

import dataservice.transportdataservice.DriversDataService;
import init.RMIHelper;
import po.DriversPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class DelDriver {
	String drivercode;
	String drivername;
	long birthtime;
	String identifiercode;
	String cellphone;
	String drivergender;
	long timelimit;
	public void  setDelDriver(String drivercode,String drivername,long birthtime,String identifiercode,String cellphone,String drivergender,long timelimit) {
		// TODO Auto-generated constructor stub
		this.drivercode=drivercode;
		this.drivername=drivername;
		this.birthtime=birthtime;
		this.identifiercode=identifiercode;
		this.cellphone=cellphone;
		this.drivergender=drivergender;
		this.timelimit=timelimit;
	}
	
	public ResultMessage passdel(){
		DriversPO po=new DriversPO(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
		ResultMessage result=ResultMessage.success;
		DriversDataService dataserv= RMIHelper.getDriverdata();

		try {
			result=dataserv.deleteDriver(po);
		} catch (Exception e) {
			System.out.println("Delete Driver Failed!!!");
			result=ResultMessage.failure;
			e.printStackTrace();
		}
		return result;
	}

}
