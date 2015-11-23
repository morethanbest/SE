package businesslogic.transportbl.DriverPack;

import po.DriversPO;
import vo.DriverVO;

public class FindDriverMock {
	DriverVO vo;
	public FindDriverMock(DriverVO vo) {
		// TODO Auto-generated constructor stub
		this.vo=vo;
	}
	
	
	public DriverVO getdriverbynum(String driverNumber){
		return vo;
	}
	
	public DriverVO getdriverbyname(String name){
		return vo;
	}
	
	
	
	
	
	

}
