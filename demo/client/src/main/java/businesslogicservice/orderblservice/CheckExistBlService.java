package businesslogicservice.orderblservice;

import java.rmi.RemoteException;

import po.ResultMessage;

public interface CheckExistBlService {
	public boolean checkExist(String ordercode);
}
