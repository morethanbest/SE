package businesslogic.balancebl.RecordpayPack;

import dataservice.balancedataservice.RecordpayFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordpayList;
import po.RecordpayPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2015/12/3.
 */
public class AddRecord {
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

    public ResultMessage passadd(){
        RecordpayFormDataService data= RMIHelper.getRecordpay();
        RecordpayPO po=new RecordpayPO(id,paytime,paysum,payman,payaccount,entry,remark,formstate);
        ResultMessage result=null;
        try {
            result=data.addRecordpayForm(po);
        } catch (RemoteException e) {
            System.out.println("record pay add form failed!!1");
            e.printStackTrace();
        }
        return result;

    }
}
