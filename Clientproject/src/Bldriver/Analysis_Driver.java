package Bldriver;

import java.rmi.RemoteException;

import businesslogic.managerbl.stub.BalanceviewBlService_Stub;
import businesslogic.managerbl.stub.SearchAccount_Stub;
import businesslogic.managerbl.stub.Statistics_Stub;
import businesslogicservice.managerblservice.BalanceviewBlService;
import businesslogicservice.managerblservice.SearchAccount;
import businesslogicservice.managerblservice.Statistics;

public class Analysis_Driver {
	public void driver(Statistics statistics,BalanceviewBlService balance,SearchAccount account){
		try{
			if(account.searchAccount(1)!=null){
				System.out.println("account get");
			}
			if(balance.Balanceview()!=null){
				System.out.println("balance get");
			}
			if(statistics.getStatistics(1, 1)!=null){
				System.out.println("statistics get");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		BalanceviewBlService balancebl=new BalanceviewBlService_Stub();
		SearchAccount accountbl=new SearchAccount_Stub();
		Statistics statistics=new Statistics_Stub();
		Analysis_Driver driver=new Analysis_Driver();
		driver.driver(statistics,balancebl,accountbl);
	}
}
