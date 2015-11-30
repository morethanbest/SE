package businesslogic.commoditybl.InboundPack;

import java.rmi.RemoteException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import po.StockinPO;
import vo.StockinVO;

public class Inbound {
		AddInbound add;
		UpdateInbound update;
	FindInbound find;

	public Inbound(AddInbound add) {
		// TODO Auto-generated constructor stub
		this.add=add;

	
	}

	public Inbound(UpdateInbound update){this.update=update;}
	public Inbound(FindInbound find){this.find=find;}
	
	public ResultMessage InboundForm(StockinVO vo) {
		// TODO Auto-generated method stub
		String id=vo.getId();
		String ordercode=vo.getOrdercode();
		long intime=vo.getIntime();
		CommodityLocation location=vo.getLocation();
		String destination=vo.getDestination();
		Formstate formstate=vo.getFormstate();

		add.set(id,ordercode,intime,location,destination,formstate);
		ResultMessage result=add.passform();

		
		


		
		return result;
	}


	public ResultMessage updateForm(StockinVO vo) {
		String id=vo.getId();
		String ordercode=vo.getOrdercode();
		long intime=vo.getIntime();
		CommodityLocation location=vo.getLocation();
		String destination=vo.getDestination();
		Formstate formstate=vo.getFormstate();

		update.set(id, ordercode, intime, location, destination, formstate);
		ResultMessage result=update.passupdate();
		return result;

	}

	public List<StockinVO> findforms(Formstate state,String orgcode){
		List<StockinVO> list=new ArrayList<StockinVO>();
		List<StockinPO> pos=find.findInboundForma(state,orgcode);
		for(int i=0;i<=pos.size()-1;i++){
			StockinPO po=pos.get(i);

			String id=po.getId();
			String ordercode=po.getOrdercode();
			long intime=po.getIntime();
			CommodityLocation location=po.getLocation();
			String destination=po.getDestination();
			Formstate formstate=po.getFormstate();





			StockinVO newvo=new StockinVO(id,ordercode,intime,location,destination,formstate);
			list.add(newvo);
		}
		return list;
	}
}
