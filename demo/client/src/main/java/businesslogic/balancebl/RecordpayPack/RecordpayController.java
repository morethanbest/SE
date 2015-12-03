package businesslogic.balancebl.RecordpayPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.RecordpayVO;
import po.ResultMessage;
import businesslogicservice.balanceblservice.RecordpayBlService;

public class RecordpayController implements RecordpayBlService{



	@Override
	public ResultMessage AddRecordpay(RecordpayVO vo) throws RemoteException {
		AddRecord add=new AddRecord();
		Recordpay record=new Recordpay(add);
		ResultMessage result=record.add(vo);
		return  result;
	}

	@Override
	public ResultMessage updateRecordpay(RecordpayVO vo) throws RemoteException {
		UpdateRecord update=new UpdateRecord();
		Recordpay record=new Recordpay(update);
		ResultMessage result=record.update(vo);
		return result;
	}

	@Override
	public List<RecordpayVO> findforms(Formstate formstate) throws RemoteException {
		FindRecord find=new FindRecord();
		Recordpay record=new Recordpay(find);
		List<RecordpayVO> list=record.find(formstate);
		return list;
	}

	@Override
	public String getid() throws RemoteException {
		IdInfo idgetter=new IdInfo();
		String id=idgetter.getid();
		return id;
	}
}
