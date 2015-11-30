package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.CenterloadVO;
import vo.RecordtransVO;

public interface RecordtransBlService {
	public ResultMessage Recordtrans (RecordtransVO vo)throws RemoteException;
	public ResultMessage update(RecordtransVO vo)throws RemoteException;
	public List<RecordtransVO> find(Formstate state,String orgcode)  throws RemoteException;



	public String getid(String orgcode,String data) throws  RemoteException;
	public double getfee(RecordtransVO vo ,String city1,String city2, String transporttype);//为vo装车队呢  现在所在城市 和目的地城市，  运输类型
}
