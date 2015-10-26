package Bldriver;

import java.rmi.RemoteException;

import businesslogic.managerbl.Statistics_Stub;
import businesslogicservice.managerblservice.Statistics;

public class Statistics_Driver {
	public void driver(Statistics statistics){
		try{
			if(statistics.getStatistics(1, 1)!=null){
				System.out.println("statistics get");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Statistics statistics=new Statistics_Stub();
		Statistics_Driver driver=new Statistics_Driver();
		driver.driver(statistics);
	}
}
