//package data.logisticsdata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//
//import po.CenterloadPO;
//import po.Formstate;
//import po.Hall;
//import dataservice.logisticsdataservice.CenterLoadFormDataService;
//
//public class CenterLoadFormDataService_Stub  implements CenterLoadFormDataService{
//
//	@Override
//	public List<CenterloadPO> getCenterLoadForm(Formstate state)
//			throws RemoteException {
//		// TODO Auto-generated method stub
//		List<CenterloadPO> list=new ArrayList<CenterloadPO>();
//		List<String> allbarcode=new ArrayList<String>();
//		allbarcode.add("2014940328");
//
//
//		CenterloadPO po=new CenterloadPO(156646, 20131201, "0251201304120000001", Hall.Shanghai, "0250000001", "����", "�ſ�", allbarcode, 200);
//		list.add(po);
//		return list;
//	}
//
//	@Override
//	public void updateCenterLoadForm(CenterloadPO po) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Update Succeed!\n");
//		
//	}
//
//	@Override
//	public void addCenterLoadForm(CenterloadPO po) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Add Succeed!\n");
//		
//	}
//
//	@Override
//	public long findLastID() throws RemoteException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//}
