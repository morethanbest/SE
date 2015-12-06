package businesslogic.logisticsbl.RecordtransPack;

import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;
import vo.RecordtransVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class Recordtrans {
    AddTrans add;
    UpdateTrans update;
    FindTrans find;
    public Recordtrans(AddTrans add){
        this.add=add;
    }
    public Recordtrans(UpdateTrans update){
        this.update=update;
    }
    public Recordtrans(FindTrans find){
        this.find=find;
    }

    public ResultMessage addform(RecordtransVO vo){
        long loadtime=vo.getLoadtime();

        String transcode=vo.getTranscode();
        String transport=vo.getTransportType();//交通方式
        String transportcode=vo.getTransportCode();//班次号
        String departrue=vo.getDepartrue();
        String destination=vo.getDestination();
        String countercode=vo.getCountercode();
        String supervisor=vo.getSupervisor();
        List<String> allcode=vo.getAllcode();
        double fee=vo.getfee();
        Formstate documentstate=vo.getFormstate();

        add.set(loadtime,transcode,transport,transportcode,departrue,destination,countercode,supervisor,allcode,fee,documentstate);
        ResultMessage result=add.passadd();
        return result;
    }

    public ResultMessage updateform(RecordtransVO vo){
        long loadtime=vo.getLoadtime();

        String transcode=vo.getTranscode();
        String transport=vo.getTransportType();//交通方式
        String transportcode=vo.getTransportCode();//班次号
        String departrue=vo.getDepartrue();
        String destination=vo.getDestination();
        String countercode=vo.getCountercode();
        String supervisor=vo.getSupervisor();
        List<String> allcode=vo.getAllcode();
        double fee=vo.getfee();
        Formstate documentstate=vo.getFormstate();

        update.set(loadtime,  transcode, transport, transportcode, departrue, destination, countercode, supervisor, allcode, fee, documentstate);
        ResultMessage result=update.passupdate();
        return result;
    }

    public List<RecordtransVO> findforms(Formstate state,String orgcode){
        List<RecordtransVO> list=new ArrayList<RecordtransVO>();
        List<RecordtransPO> pos=find.findforms(state,orgcode);
        int len=pos.size();
        for(int i=0;i<=len-1;i++){
            RecordtransPO newpo=pos.get(i);
            long loadtime=newpo.getLoadtime();

            String transcode=newpo.getTranscode();
            String transport=newpo.getTransportType();//交通方式
            String transportcode=newpo.getTransportCode();//班次号
            String departrue=newpo.getDepartrue();
            String destination=newpo.getDestination();
            String countercode=newpo.getCountercode();
            String supervisor=newpo.getSupervisor();
            List<String> allcode=newpo.getAllcode();
            double fee=newpo.getFee();
            Formstate documentstate=newpo.getDocumentstate();

            RecordtransVO vo=new RecordtransVO(loadtime,transcode,transport,transportcode,departrue,destination,countercode,supervisor,allcode,fee,documentstate);
            list.add(vo);


        }
        return list;
    }

}
