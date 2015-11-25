package businesslogic.transportbl.DriverPack;

import dataservice.transportdataservice.DriversDataService;
import init.RMIHelper;
import po.DriversPO;
import vo.DriverVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class FindDriver {

	
	
	public DriverVO getdriverbynum(String driverNumber){
		DriversDataService dataserv= RMIHelper.getDriverdata();
		DriverVO vo=null;
		DriversPO po=null;
		try {
			po=dataserv.findDriverBynum(driverNumber);
			String drivercode=po.getDrivercode();
			String drivername=po.getDrivername();
			long birthtime=po.getBirthtime();
			String identifiercode=po.getIdentifiercode();
			String cellphone=po.getCellphone();
			String drivergender=po.getDrivergender();
			long timelimit=po.getTimelimit();
			vo=new DriverVO(drivercode,drivername,birthtime,identifiercode,cellphone,drivergender,timelimit);
		} catch (RemoteException e) {
			System.out.println("Find Drvier Failed!!!");
			e.printStackTrace();
		}

		return vo;
	}
	
	public List<DriverVO> getdriverbyname(String name){
		List<DriverVO> list=new ArrayList<DriverVO>();
		DriversDataService dataserv=RMIHelper.getDriverdata();
		List<DriversPO> polist=new ArrayList<DriversPO>();
		try {
			polist=dataserv.findDriverByname(name);
			for(int i=0;i<=polist.size()-1;i++){
				String drivercode=polist.get(i).getDrivercode();
				String drivername=polist.get(i).getDrivername();
				long birthtime=polist.get(i).getBirthtime();
				String identifiercode=polist.get(i).getIdentifiercode();
				String cellphone=polist.get(i).getCellphone();
				String drivergender=polist.get(i).getDrivergender();
				long timelimit=polist.get(i).getTimelimit();

				DriverVO newvo=new DriverVO(drivercode,drivername,birthtime,identifiercode,cellphone,drivergender,timelimit);
				list.add(newvo);
			}
		} catch (RemoteException e) {
			System.out.println("Find Driver By Name Failed!!!");

			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	

}
