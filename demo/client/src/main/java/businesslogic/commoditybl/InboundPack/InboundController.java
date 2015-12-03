package businesslogic.commoditybl.InboundPack;

import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import vo.StockinVO;

public class InboundController implements businesslogicservice.commodityblservice.InboundBlService{


	@Override
	public boolean wheOverLoad(StockinVO vo) throws RemoteException {
		Alarm ring=new Alarm();
		boolean result=ring.getwhe(vo);
		return result;
	}

	@Override
	public ResultMessage Inbound(StockinVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		AddInbound add=new AddInbound();
		Inbound inbound=new Inbound(add);
		ResultMessage result=inbound.InboundForm(vo);

		
		
		return result;
	}

	@Override
	public ResultMessage update(StockinVO vo) throws RemoteException {
		UpdateInbound update=new UpdateInbound();
		Inbound inbound=new Inbound(update);
		ResultMessage result=inbound.updateForm(vo);
		return result;
	}

	@Override
	public List<StockinVO> findInboundForm(Formstate state,String orgcode) throws RemoteException {
		FindInbound find=new FindInbound();
		Inbound inbound=new Inbound(find);
		List<StockinVO> list=inbound.findforms(state,orgcode);
		return list;

	}

	@Override
		 public String getid(String orgcode) throws RemoteException {
		StockinId idgetter=new StockinId();
		String id=idgetter.getid(orgcode);
		return id;
	}

	@Override
	public CommodityLocation getAvailLoc(String orgcode,long blocknum) throws RemoteException {
		LocationGet get=new LocationGet();
		CommodityLocation location=get.getLoc(orgcode,blocknum);
		return location;
	}

}










