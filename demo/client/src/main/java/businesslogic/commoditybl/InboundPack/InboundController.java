package businesslogic.commoditybl.InboundPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockinVO;

public class InboundController implements businesslogicservice.commodityblservice.InboundBlService{

	

	@Override
	public ResultMessage Inbound(StockinVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		InboundFormMock newform=new InboundFormMock();
		
		IdInfoMock idgetter=new IdInfoMock(5);
		Inbound newinbound=new Inbound(newform,idgetter);
		
		ResultMessage result=newinbound.InboundForm(vo);
		
		
		return result;
	}

}










