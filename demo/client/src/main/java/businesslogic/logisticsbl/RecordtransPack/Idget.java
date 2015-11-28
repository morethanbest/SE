package businesslogic.logisticsbl.RecordtransPack;

import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/28.
 */
public class Idget {
    public String getid(String orgcode,String date){
        RecordtransFormDataService data= RMIHelper.getRecordtrans();
        long id=0;
        String result=null;
        try {
            id=data.findLasttranscode(orgcode,date);
        } catch (RemoteException e) {
            System.out.println("recordtrans get id failed!!!");
            e.printStackTrace();
        }
        result=Long.toString(id);
        int len=result.length();
        if(len>7){
            System.out.println("id overflow");
            try {
                throw new Exception();
            } catch (Exception e) {

                e.printStackTrace();
            }


        }

        for(int i=0;i<=len-1;i++)
            result="0"+result;
        result=orgcode=date+result;
        return result;

    }

}
