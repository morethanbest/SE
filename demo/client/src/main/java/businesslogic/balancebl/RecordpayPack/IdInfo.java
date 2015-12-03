package businesslogic.balancebl.RecordpayPack;

import dataservice.balancedataservice.RecordpayFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

public class IdInfo {
    public String getid(){
        RecordpayFormDataService data= RMIHelper.getRecordpay();
        long id=0;
        try {
            id=data.getlastid()+1;
        } catch (RemoteException e) {
            System.out.println("Record pay getlast id failed!!!");
            e.printStackTrace();
        }

        String result=Long.toString(id);
        int len=result.length();
        if(len>7){
            System.out.println("Record pay get id overflow!!!");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        for(int i=0;i<=7-len-1;i++){
            result="0"+result;
        }
        return result;


    }

}
