package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage addArrivalFromHall(ArrivalVO vo,String orgname)throws RemoteException;//填写到达单 如果这个到达是从营业厅中来的
	//orgname意思为 hall的organization的中文名字  不是编号
	
	public ResultMessage addArrivalFromCenter(ArrivalVO vo,String orgname)throws  RemoteException;//填写到达单， 如果这个到达是从中转中心来的
	//orgname的意思为 center 的organization的名字


	public ResultMessage update(ArrivalVO vo)throws RemoteException;// 更新单据  就是修改

	public List<ArrivalVO> search(Formstate state) throws  RemoteException;

	public String  getid(String organizationcode) throws  RemoteException;//传入中转中心的组织编号 得到id（为组织编号+7位数组）   返回的string已经包含了组织编号

}
