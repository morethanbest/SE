package businesslogic.managerbl.BalancePack;

import dataservice.managerdataservice.ManagerBalanceDataService;
import init.RMIHelper;
import vo.BalanceviewVO;

import java.rmi.RemoteException;

public class Balanceview {
    public BalanceviewVO view(){
        ManagerBalanceDataService data= RMIHelper.getManagerbalance();
        double in=0;
        try {
            in=data.allin();
        } catch (RemoteException e) {
            System.out.println("manager balance view get allin failed!!!");
            e.printStackTrace();
        }

        double out=0;
        try {
            out=data.allout();
        } catch (RemoteException e) {
            System.out.println("manager balance view get allout failed!!!");
            e.printStackTrace();
        }

        double interest=in-out;
        BalanceviewVO vo=new BalanceviewVO(in,out,interest);
        return vo;

    }

}
