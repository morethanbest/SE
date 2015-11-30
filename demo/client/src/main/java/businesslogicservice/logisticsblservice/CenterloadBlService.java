package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.TransportType;
import presentation.enums.TransportTypes;
import vo.CLFareVO;
import vo.CenterloadVO;

public interface CenterloadBlService {
	public ResultMessage addCenterLoadForm(CenterloadVO vo)throws RemoteException;




	public List<CenterloadVO>  findCenterloadForm(Formstate state,String orgcode) throws  RemoteException;

	public ResultMessage update(CenterloadVO vo)throws RemoteException;

	//传入两个参数 一个是组织编号 一个是当前日期  由此得到string类型的汽运编号
	public String getid(String orgcode,String date) throws  RemoteException;


	//得到运费的方法
	public double getfee(CenterloadVO vo ,String city1,String city2, String transporttype);//为vo装车队呢  现在所在城市 和目的地城市，  运输类型
}
