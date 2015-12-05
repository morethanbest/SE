package businesslogicservice.transportblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.VehicleVO;

public interface VehicleBlService {
	public ResultMessage addVehicle (VehicleVO vo);
	
	public ResultMessage delVehicle (VehicleVO vo);
	
	public ResultMessage revVehicle (VehicleVO vo);
	
	public VehicleVO getVehiclebyVN (String vehicleNumber,String orgcode);
	
	public VehicleVO getVehiclebyPN (String plateNumber,String orgcode);

	//得到 车辆的编号  形式为  6位的营业厅编号 加上了三位的数字
	public String getid(String orgcode);


	
	
}
