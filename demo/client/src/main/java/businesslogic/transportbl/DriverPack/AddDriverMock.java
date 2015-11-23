package businesslogic.transportbl.DriverPack;

import po.DriversPO;
import vo.ResultMessage;

public class AddDriverMock {
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
		ResultMessage result=ResultMessage.success;
		return result;
	}
	
	
}
