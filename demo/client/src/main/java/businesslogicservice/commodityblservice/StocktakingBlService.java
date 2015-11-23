package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.StocktakingVO;

public interface StocktakingBlService {
	public StocktakingVO Stocktaking()throws RemoteException;
}
