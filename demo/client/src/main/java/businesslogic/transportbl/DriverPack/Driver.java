package businesslogic.transportbl.DriverPack;

import java.rmi.RemoteException;

import vo.DriverVO;
import vo.ResultMessage;

public class Driver {
	AddDriverMock addd;
	DelDriverMock deld;
	RevDriverMock revd;
	FindDriverMock findd;
	public Driver(AddDriverMock addd) {
		// TODO Auto-generated constructor stub
		this.addd=addd;
	}
	public Driver(DelDriverMock deld){
		this.deld=deld;
	}
	public Driver(RevDriverMock revd){
		this.revd=revd;
	}
	public Driver(FindDriverMock findd){
		this.findd=findd;
	}
	

	
	
	
	
	
	
	public ResultMessage addDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String drivercode=vo.getDrivercode();
		String drivername=vo.getDrivername();
		long birthtime=vo.getBirthtime();
		String identifiercode=vo.getIdentifiercode();
		String cellphone=vo.getCellphone();
		String drivergender=vo.getDrivergender();
		long timelimit=vo.getTimelimit();
		
		addd.setAddDriver(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
		ResultMessage result=addd.passadd();
		return result;
	}

	
	public ResultMessage delDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String drivercode=vo.getDrivercode();
		String drivername=vo.getDrivername();
		long birthtime=vo.getBirthtime();
		String identifiercode=vo.getIdentifiercode();
		String cellphone=vo.getCellphone();
		String drivergender=vo.getDrivergender();
		long timelimit=vo.getTimelimit();
		
		deld.setDelDriver(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
		ResultMessage result=deld.passdel();
		
		
		return result;
	}

	
	public ResultMessage revDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String drivercode=vo.getDrivercode();
		String drivername=vo.getDrivername();
		long birthtime=vo.getBirthtime();
		String identifiercode=vo.getIdentifiercode();
		String cellphone=vo.getCellphone();
		String drivergender=vo.getDrivergender();
		long timelimit=vo.getTimelimit();
		
		revd.setRevDriver(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
		ResultMessage result=revd.passrev();
		return result;
	}

	
	public DriverVO getDriverbyDN(String driverNumber) throws RemoteException {
		// TODO Auto-generated method stub
		DriverVO vo=findd.getdriverbynum(driverNumber);
		return vo;
	}

	
	public DriverVO getDriverbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		DriverVO vo=findd.getdriverbyname(name);
		return vo;
	}

}
