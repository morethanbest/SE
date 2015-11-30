package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage addArrival(ArrivalVO vo)throws RemoteException;//填写到达单 如果这个到达是从营业厅中来的
	//orgname意思为 hall的organization的中文名字  不是编号
	



	public ResultMessage updateFromHall(ArrivalVO vo,String orgname)throws RemoteException;// 更新单据  就是修改

	public ResultMessage updateFromCenter(ArrivalVO vo,String orgname) throws  RemoteException;

	//本营业厅按单据状态查询
	public List<ArrivalVO> search(String orgcode,Formstate state) throws  RemoteException;

	public String  getid(String organizationcode) throws  RemoteException;//传入中转中心的组织编号 得到id（为组织编号+7位数组）   返回的string已经包含了组织编号

}
