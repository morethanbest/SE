package businesslogic.balancebl.RecordcollectPack;

import po.Formstate;
import po.ResultMessage;

import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class Addcollect {

    String id;
    long collectiontime;
    double collectionsum;
    String collectionman;
    List<String> allordercode;
    Formstate documentstate;

    public void set(String id,long collectiontime, double collectionsum,String collectionman,List<String> allordercode,Formstate documentstate){
        this.id=id;
        this.collectionman=collectionman;
        this.collectionsum=collectionsum;
        this.collectiontime=collectiontime;
        this.allordercode=allordercode;
        this.documentstate=documentstate;
    }


    public ResultMessage passadd(){


    }
}
