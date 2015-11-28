package businesslogic.logisticsbl.RecordtransPack;

import businesslogic.balancebl.DebitnotePack.Record;
import businesslogicservice.logisticsblservice.RecordtransBlService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;
import vo.CenterloadVO;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class CentertransController implements RecordtransBlService{
    @Override
    public ResultMessage Recordtrans(RecordtransVO vo) throws RemoteException {
        AddTrans add=new AddTrans();
        Recordtrans trans=new Recordtrans(add);
        ResultMessage result=trans.addform(vo);

        RecordtransUpdateLogistics updatehistory=new RecordtransUpdateLogistics();
        updatehistory.updatehistory(vo);
        return result;
    }

    @Override
    public ResultMessage update(RecordtransVO vo) throws RemoteException {
        UpdateTrans update=new UpdateTrans();
        Recordtrans trans=new Recordtrans(update);
        ResultMessage result=trans.updateform(vo);
        return result;
    }

    @Override
    public List<RecordtransVO> find(Formstate state) throws RemoteException {
        FindTrans find=new FindTrans();
        Recordtrans trans=new Recordtrans(find);
        List<RecordtransVO> list=trans.findforms(state);
        return list;
    }

    @Override
    public String getid(String orgcode, String date) throws RemoteException {
        Idget idgetter=new Idget();
        String id=idgetter.getid(orgcode,date);

        return id;
    }

    @Override
    public double getfee(RecordtransVO vo, String city1, String city2, String transporttype) {
        FeeCount counter=new FeeCount();
        double fee=counter.getfee(vo,city1,city2,transporttype);
        return fee;


    }
}
