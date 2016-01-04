package businesslogic.balancebl.RecordcollectPack;

import dataservice.balancedataservice.RecordcollectFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

public class IdInfo {

    public String getid(String orgcode){
        RecordcollectFormDataService data= RMIHelper.getRecordcollect();
        long id=0;
        try {
            id=data.getlastid(orgcode)+1;
        } catch (RemoteException e) {
            System.out.println("record collect get last id failed!@!!");
            e.printStackTrace();
        }

        String temp=Long.toString(id);
        int len=temp.length();
        if(len>7){
            System.out.println("record collect id overflow!!!");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<=7-len-1;i++){
            temp="0"+temp;
        }
        String result=orgcode+temp;
        return result;
    }


}
