package businesslogicservice.transportblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.DriverVO;


public interface DriverBlService {
	public ResultMessage addDriver (DriverVO vo);
	
	public ResultMessage delDriver (DriverVO vo);
	
	public ResultMessage revDriver (DriverVO vo);
	
	public DriverVO getDriverbyDN (String driverNumber,String orgcode);
	
	public List<DriverVO> getDriverbyName (String name,String orgcode);
	//得到 司机的编号  形式为  6位的营业厅编号 加上了三位的数字
	public String getid(String orgcode) ;



	
	
}
