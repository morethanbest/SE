package businesslogic.balancebl.BalancePack;

import dataservice.balancedataservice.BalanceDataService;
import init.RMIHelper;
import vo.BalanceviewVO;

import java.rmi.RemoteException;

public class Balanceview {

    public BalanceviewVO viewbalance(){
        BalanceDataService data= RMIHelper.getBalancedata();
        double allin=0;
        try {
            allin=data.allin();
        } catch (RemoteException e) {
            System.out.println("balance view get all in failed!!!");
            e.printStackTrace();
        }
        double allout=0;
        try {
            allout=data.allout();
        } catch (RemoteException e) {
            System.out.println("balance view get all out failed!!!");
            e.printStackTrace();
        }

        double interest=allin-allout;
        BalanceviewVO vo=new BalanceviewVO(allin,allout,interest);
        return vo;
    }

}
