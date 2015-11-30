package businesslogic.commoditybl.InboundPack;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.commoditybl.StockoutPack.IdInfoMock;
import po.Formstate;
import po.ResultMessage;
import vo.StockinVO;

public class InboundController implements businesslogicservice.commodityblservice.InboundBlService{

	

	@Override
	public ResultMessage Inbound(StockinVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		AddInbound newform=new AddInbound();
		
		IdInfoMock idgetter=new IdInfoMock(5);
		Inbound newinbound=new Inbound(newform,idgetter);
		
		ResultMessage result=newinbound.InboundForm(vo);
		
		
		return result;
	}

	@Override
	public ResultMessage update(StockinVO vo) throws RemoteException {
		return null;
	}

	@Override
	public List<StockinVO> findInboundForm(Formstate state) throws RemoteException {

	}

	@Override
		 public String getid(String orgcode) throws RemoteException {
		StockinId idgetter=new StockinId();
		String id=idgetter.getid(orgcode);
		return id;
	}

}










