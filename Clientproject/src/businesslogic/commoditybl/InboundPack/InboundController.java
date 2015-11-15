package businesslogic.commoditybl.InboundPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockinVO;

public class InboundController implements businesslogicservice.commodityblservice.InboundBlService{

	

	@Override
	public ResultMessage Inbound(StockinVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		InboundForm newform=new InboundForm();
		
		IdInfo idgetter=new IdInfo(5);
		Inbound newinbound=new Inbound(newform,idgetter);
		
		ResultMessage result=newinbound.InboundForm(vo);
		
		
		return result;
	}

}










