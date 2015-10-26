package Bldriver;

import java.rmi.RemoteException;

import businesslogic.commoditybl.StocktakingBlService_Stub;
import businesslogicservice.commodityblservice.StocktakingBlService;

public class Stocktaking_Driver {
	public void driver(StocktakingBlService stocktaking){
		try{
			if(stocktaking.Stocktaking()!=null){
				System.out.println("stocktaking get");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		StocktakingBlService stocktaking=new StocktakingBlService_Stub();
		Stocktaking_Driver driver=new Stocktaking_Driver();
		driver.driver(stocktaking);
	}
}
