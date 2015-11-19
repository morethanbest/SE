//package data.commoditydata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//
//import po.CommodityLocation;
//import po.CommodityPO;
//import dataservice.commoditydataservice.CommodityDataService;
//
//public class CommodityDataService_Stub implements CommodityDataService{
//
//	@Override
//	public List<CommodityPO> getallCommodity() throws RemoteException {
//		// TODO Auto-generated method stub
//		List<CommodityPO> list=new ArrayList<CommodityPO>();
//		CommodityPO po=new CommodityPO(102335, "1201836287", 20120722, new CommodityLocation(15, 78, 22, 100),0 );
//		list.add(po);
//		return list;
//	}
//
//	@Override
//	public List<CommodityPO> getCommodityBetween(long starttime, long endtime)
//			throws RemoteException {
//		// TODO Auto-generated method stub
//		List<CommodityPO> list=new ArrayList<CommodityPO>();
//		CommodityPO po=new CommodityPO(102335, "1201836287", 20120722, new CommodityLocation(15, 78, 22, 100),0 );
//		list.add(po);
//		return list;
//	}
//
//	@Override
//	public void addnew(CommodityPO po) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Add Succeed!");
//		
//	}
//
//	@Override
//	public void setOuttime(CommodityPO po, long endtime) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Set Succeed!");
//		
//	}
//
//	@Override
//	public void changeLocation(CommodityPO po, CommodityLocation location)
//			throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Change Succeed!");
//		
//	}
//
//	
//
//}
