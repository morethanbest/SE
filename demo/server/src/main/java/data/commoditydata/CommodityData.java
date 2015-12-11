package data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import data.database.commodityDB.CommodityDB;
import data.database.commodityDB.StockDB;
import data.database.commodityDB.StopPointDB;
import dataservice.commoditydataservice.CommodityDataService;
import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

public class CommodityData extends UnicastRemoteObject implements CommodityDataService{

	public CommodityData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<CommodityPO> getallCommodity(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getAll(orgcode);
	}

	@Override
	public ResultMessage addnew(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return CommodityDB.write(po);
		else 
			return ResultMessage.failure;
	}

	@Override
	public boolean wheOverLoad(String orgcode, long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		//如果该区库存加1后的数值比这个区的警戒值大
		return CommodityDB.getNum(orgcode, blocknum)+1>StockDB.getwarningNumInblock(orgcode, blocknum);	
	}

	@Override
	public CommodityPO getCommodityByLocation(String orgcode, CommodityLocation location) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbyLocation(orgcode, location);
	}

	@Override
	public ResultMessage updateCommodtiy(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return CommodityDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public CommodityPO getCommodityByCode(String orgcode, String ordercode) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbyCode(orgcode, ordercode);
	}

	@Override
	public ResultMessage setOuttime(CommodityPO po, long outtime) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null){
			po.setOuttime(outtime);
			return CommodityDB.update(po);
		}else 
			return ResultMessage.failure;
		
	}

	@Override
	public long getStopPoint(String orgcode, long date) throws RemoteException {
		// TODO Auto-generated method stub
		return StopPointDB.getlastStoppoint(orgcode+date);
	}

	@Override
	public List<CommodityPO> stockTaking(String orgcode, long date, long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbyblock(orgcode, blocknum);
	}

	@Override
	public List<CommodityPO> getCommodtiyByBlock(String orgcode, long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbyblock(orgcode, blocknum);
	}

	@Override
	public List<Long> getAllBlock(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return StockDB.getAllblock(orgcode);
	}

	@Override
	public List<Long> getCommodityNumber(String orgcode, long begin, long end) throws RemoteException {
		// TODO Auto-generated method stub
		List<Long> list=new ArrayList<Long>();
		list.add(CommodityDB.getinnumber(orgcode, begin, end));
		list.add(CommodityDB.getoutnumber(orgcode, begin, end));
		list.add(CommodityDB.getAllNum(orgcode));
		return list;
	}

	@Override
	public List<CommodityPO> getCommodityBetween(String orgcode, long starttime, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbetween(orgcode, starttime, endtime);
	}

	@Override
	public List<Long> getStockNumbyblocknum(long blocknum, String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return StockDB.getStockNumbyblocknum(blocknum, orgcode);
	}

	@Override
	public boolean isEmpty(String orgcode,CommodityLocation location) throws RemoteException {
		// TODO Auto-generated method stub
		if(CommodityDB.getbyLocation(orgcode, location)==null){
			return true;
		}else{
			return false;
		}
		
	}


	
}
