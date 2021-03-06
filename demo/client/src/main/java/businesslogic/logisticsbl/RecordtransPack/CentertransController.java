package businesslogic.logisticsbl.RecordtransPack;

import businesslogicservice.logisticsblservice.RecordtransBlService;
import po.Formstate;
import po.ResultMessage;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class CentertransController implements RecordtransBlService{
    @Override
    public ResultMessage Recordtrans(RecordtransVO vo)  {
        AddTrans add=new AddTrans();
        Recordtrans trans=new Recordtrans(add);
        ResultMessage result=trans.addform(vo);


        return result;
    }

    @Override
    public ResultMessage update(RecordtransVO vo)  {
        RecordtransUpdateLogistics updatehistory=new RecordtransUpdateLogistics();
        updatehistory.updatehistory(vo);

        UpdateTrans update=new UpdateTrans();
        Recordtrans trans=new Recordtrans(update);
        ResultMessage result=trans.updateform(vo);
        return result;
    }

    @Override
    public List<RecordtransVO> find(Formstate state,String orgcode)  {
        FindTrans find=new FindTrans();
        Recordtrans trans=new Recordtrans(find);
        List<RecordtransVO> list=trans.findforms(state,orgcode);
        return list;
    }

    @Override
    public String getid(String orgcode, long date)  {
        Idget idgetter=new Idget();
        String id=idgetter.getid(orgcode,date);

        return id;
    }

    @Override
    public double getfee(List<String> allbarcode, String city1, String city2,String transporttype) {
        FeeCount counter=new FeeCount();
        double fee=counter.getfee(allbarcode,city1,city2,transporttype);
        return fee;


    }
}
