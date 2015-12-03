package businesslogic.balancebl.RecordcollectPack;

import dataservice.balancedataservice.RecordcollectFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class Addcollect {

    String id;
    long collectiontime;
    String accountcode;
    double collectionsum;
    String collectionman;
    List<String> allordercode;
    Formstate documentstate;

    public void set(String id,long collectiontime,String accountcode, double collectionsum,String collectionman,List<String> allordercode,Formstate documentstate){
        this.id=id;
        this.collectionman=collectionman;
        this.accountcode=accountcode;
        this.collectionsum=collectionsum;
        this.collectiontime=collectiontime;
        this.allordercode=allordercode;
        this.documentstate=documentstate;
    }


    public ResultMessage passadd(){
        RecordcollectFormDataService data= RMIHelper.getRecordcollect();

        RecordcollectPO po=new RecordcollectPO(id,collectiontime,accountcode,collectionsum,collectionman,allordercode,documentstate);

        ResultMessage result=null;
        try {
            result=data.addRecordcollectForm(po);
        } catch (RemoteException e) {
            System.out.println("record collect add form failed!!!");
            e.printStackTrace();
        }
        return result;


    }
}
