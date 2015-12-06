package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.CenterloadVO;
import vo.RecordtransVO;

public interface RecordtransBlService {
	public ResultMessage Recordtrans (RecordtransVO vo);
	public ResultMessage update(RecordtransVO vo);
	public List<RecordtransVO> find(Formstate state,String orgcode)  ;



	public String getid(String orgcode,long data) throws  RemoteException;
	public double getfee(List<String> allbarcode,String city1,String city2,String transporttype);//为vo装车队呢  现在所在城市 和目的地城市，  运输类型
}
