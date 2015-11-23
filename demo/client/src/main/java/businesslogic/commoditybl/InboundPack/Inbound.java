package businesslogic.commoditybl.InboundPack;

import java.rmi.RemoteException;

import po.City;
import po.CommodityLocation;
import vo.ResultMessage;
import vo.StockinVO;

public class Inbound {
		InboundFormMock form;
		IdInfoMock idgetter;
	public Inbound(InboundFormMock form,IdInfoMock idgetter) {
		// TODO Auto-generated constructor stub
		this.form=form;
		this.idgetter=idgetter;
	
	}
	
	public ResultMessage InboundForm(StockinVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String ordercode=vo.getOrdercode();
		long intime=vo.getIntime();
		CommodityLocation location=vo.getLocation();
		City destination=vo.getDestination();
		long id=this.idgetter.getid();
		
		
		this.form.setInboundForm(ordercode, intime, location, destination, id);
		ResultMessage result=this.form.passform();
		
		return result;
	}

}
