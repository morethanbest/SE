package businesslogic.transportbl.DriverPack;

import java.rmi.RemoteException;
import java.util.List;

import vo.DriverVO;
import po.ResultMessage;

public class Driver {
	AddDriver addd;
	DelDriver deld;
	RevDriver revd;
	FindDriver findd;


	public Driver(AddDriver addd) {
		// TODO Auto-generated constructor stub
		this.addd=addd;

	}
	public Driver(DelDriver deld){
		this.deld=deld;
	}
	public Driver(RevDriver revd){
		this.revd=revd;
	}
	public Driver(FindDriver findd){
		this.findd=findd;
	}


	
	
	
	
	
	
	public ResultMessage addDriver(DriverVO vo)  {
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

	
	public ResultMessage delDriver(DriverVO vo)  {
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

	
	public ResultMessage revDriver(DriverVO vo) {
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

	
	public DriverVO getDriverbyDN(String driverNumber,String orgcode)  {
		// TODO Auto-generated method stub
		DriverVO vo=findd.getdriverbynum(driverNumber,orgcode);
		return vo;
	}

	
	public List<DriverVO> getDriverbyName(String name,String orgcode)  {
		// TODO Auto-generated method stub
		List<DriverVO> list=findd.getdriverbyname(name,orgcode);
		return list;
	}

}
