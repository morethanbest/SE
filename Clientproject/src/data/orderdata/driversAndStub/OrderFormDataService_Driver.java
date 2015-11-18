package data.orderdata.driversAndStub;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.OrdersPO;
import po.Ordertype;

import dataservice.orderdataservice.OrderFormDataService;

public class OrderFormDataService_Driver {
	public void drive(OrderFormDataService orderFormDataService) throws RemoteException{
		orderFormDataService.addOrderForm(new OrdersPO(2, "李旺","南京市栖霞区仙林大道163号", "南京大学软件学院", "18362925841", "18362925841", "张凯", "南京市汉中路21号", "南京大学软件学院", "12250612301", "12250612301", 2, 30, 200, "head first java", 200, 10, 50, "1205661001", Ordertype.fast));
		orderFormDataService.updateOrderForm(new OrdersPO(2, "李旺","南京市栖霞区仙林大道163号", "南京大学软件学院", "18362925841", "18362925841", "张凯", "南京市汉中路21号", "南京大学软件学院", "12250612301", "12250612301", 2, 30, 200, "head first java", 200, 10, 50, "1205661001", Ordertype.fast));
		OrdersPO po = orderFormDataService.getOrderForm(1);
		System.out.println("Got it!");
		System.out.println("Sender's name is " + po.getSendername());
		List<OrdersPO> list = orderFormDataService.getOrderForm(Formstate.waiting);
		System.out.println("Got it!");
		System.out.println("It has " + list.size() + " Commodity");
	}
	public static void main(String[] args) throws RemoteException {
		OrderFormDataService orderFormDataService = new OrderFormDataService_Stub();
		OrderFormDataService_Driver driver = new OrderFormDataService_Driver();
		driver.drive(orderFormDataService);
	}
}
