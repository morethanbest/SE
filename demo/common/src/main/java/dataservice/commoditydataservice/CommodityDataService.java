package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

public interface CommodityDataService extends Remote {
	public List<CommodityPO> getallCommodity(String orgcode)throws RemoteException;
	


	public ResultMessage addnew(CommodityPO po) throws RemoteException;
	









	////入库
	//是否超出警戒值(在入库时确定）  就就是说  此时 货物数量未被加入分区  所以这个计算时 要将货物的数量加1之后再判断是否 会报警
	public boolean wheOverLoad(String orgcode,long blocknum) throws  RemoteException;

	////库存分区调整

	//通过地址得到commoditypo
	public CommodityPO getCommodityByLocation(String orgcode,CommodityLocation location) throws  RemoteException;

	public ResultMessage updateCommodtiy(CommodityPO po)throws  RemoteException;


	////出库管理

	//出库更新出库时间
	//通过快件编号得到 commoditypo
	public CommodityPO getCommodityByCode(String orgcode,String ordercode) throws  RemoteException;

	public ResultMessage setOuttime(CommodityPO po,long endtime) throws RemoteException;







	////库存盘点
	//库存盘点得到截止点
	public long getStopPoint(String orgcode,String date) throws  RemoteException;
	//得到此区所有的commoditypo  (存在着的，已经出库的不算）

	public List<CommodityPO> stockTaking(String orgcode,String date,long blocknum) throws RemoteException;

	public List<CommodityPO> getCommodtiyByBlock(String orgcode,long blocknum) throws  RemoteException;

	public List<Long> getAllBlock(String orgcode) throws  RemoteException;




	////库存查看
	//出入库数量 库存数量  list中三个数据 分别为 出库数量 入库数量  总数量
	public List<Long> getCommodityNumber(String orgcode,long begin,long end) throws  RemoteException;

	public List<CommodityPO>  getCommodityBetween(String orgcode,long starttime,long endtime)throws RemoteException;


}
