package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.OrdersPO;
import po.Ordertype;
import dataservice.orderdataservice.OrderFormDataService;

public class OrderFormDataService_Stub implements OrderFormDataService{

	@Override
	public void addOrderForm(OrdersPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public OrdersPO getOrderForm(long ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		OrdersPO po=new OrdersPO(2, "����","�Ͼ�����ϼ�����ִ��163��", "�Ͼ���ѧ���ѧԺ", "18362925841", "18362925841", "�ſ�", "�Ͼ��к���·21��", "�Ͼ���ѧ���ѧԺ", "12250612301", "12250612301", 2, 30, 200, "head first java", 200, 10, 50, "1205661001", Ordertype.fast);
		return po;
		
	}

	@Override
	public List<OrdersPO> getOrderForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrdersPO> list=new ArrayList<OrdersPO>();
		OrdersPO po=new OrdersPO(2, "����","�Ͼ�����ϼ�����ִ��163��", "�Ͼ���ѧ���ѧԺ", "18362925841", "18362925841", "�ſ�", "�Ͼ��к���·21��", "�Ͼ���ѧ���ѧԺ", "12250612301", "12250612301", 2, 30, 200, "head first java", 200, 10, 50, "1205661001", Ordertype.fast);
		list.add(po);
		return list;
	}

	@Override
	public void updateOrderForm(OrdersPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public long findLastID() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
