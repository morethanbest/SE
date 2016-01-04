package businesslogic.balancebl.RecordpayPack;

import dataservice.balancedataservice.RecordpayFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordpayList;
import po.RecordpayPO;
import po.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/12/3.
 */
public class UpdateRecord {

    String id;
    long paytime;
    double paysum;
    String payman;
    String payaccount;
    RecordpayList entry;
    String remark;
    Formstate formstate;

    public void set(String id,long paytime,double paysum,String payman,String payaccount,RecordpayList entry,String remark
            ,Formstate formstate){
        this.id=id;
        this.paytime=paytime;
        this.paysum=paysum;
        this.payman=payman;
        this.payaccount=payaccount;
        this.entry=entry;
        this.remark=remark;
        this.formstate=formstate;
    }


    public ResultMessage passupdate(){
        RecordpayFormDataService data= RMIHelper.getRecordpay();
        if(this.formstate==Formstate.checked){
            this.formstate=Formstate.checked;
            try {
                data.removeTheCost(payaccount,paysum);
            } catch (RemoteException e) {
                System.out.println("record pay update remove cost failed!!!!");
                e.printStackTrace();
            }


        }
        RecordpayPO po=new RecordpayPO(id,paytime,paysum,payman,payaccount,entry,remark,formstate);
        ResultMessage result=null;
        try {
            result=data.updateRecordpayForm(po);
        } catch (RemoteException e) {
            System.out.println("record pay update failedQ!!!");
            e.printStackTrace();
        }
        return result;

    }
}
