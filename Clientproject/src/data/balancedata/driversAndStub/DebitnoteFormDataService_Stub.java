//package data.balancedata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//
//import po.DebitnotePO;
//import po.Formstate;
//import dataservice.balancedataservice.DebitnoteFormDataService;
//
//public class DebitnoteFormDataService_Stub implements DebitnoteFormDataService{
//
//	@Override
//	public List<DebitnotePO> getDebitnoteForm(Formstate state)
//			throws RemoteException {
//		// TODO Auto-generated method stub
//		List<DebitnotePO> list=new ArrayList<DebitnotePO>();
//		DebitnotePO newpo=new DebitnotePO(122345, 20140312,"�Ͼ���ѧҽԺ","���", "�Ͼ���ѧ", 200000, "�Ͼ�����·");
//		list.add(newpo);
//		return list;
//	}
//
//	@Override
//	public void updateDebitnoteForm(DebitnotePO po) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Update Succeed!\n");
//		
//	}
//
//	@Override
//	public void addDebitnoteForm(DebitnotePO po) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Add Succeed!\n");
//		
//	}
//
//	
//
//}
