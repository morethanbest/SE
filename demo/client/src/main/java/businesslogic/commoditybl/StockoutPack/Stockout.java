package businesslogic.commoditybl.StockoutPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.commoditybl.InboundPack.FindInbound;
import po.Formstate;
import po.Loadform;
import po.ResultMessage;
import po.StockoutPO;
import presentation.enums.PackageTypes;
import po.ResultMessage;
import vo.StockoutVO;

public class Stockout {
	AddStockout add;
	UpdateStockout update;
	FindStockout find;
	public Stockout(AddStockout add){this.add=add;}
	public Stockout(UpdateStockout update){this.update=update;}
	public Stockout(FindStockout find){this.find=find;}
	
	
	public ResultMessage addform(StockoutVO vo){
		String id=vo.getId();
		String ordercode=vo.getOrdercode();
		long outtime=vo.getOuttime();
		String destination=vo.getDestination();
		String transporttype=vo.getTransportType();
		String transcode=vo.getTranscode();

		Formstate formstate=vo.getFormstate();

		add.set(id,ordercode,outtime,destination,transporttype,transcode,formstate);
		ResultMessage result=add.passadd();
		return result;
	}

	public ResultMessage updateform(StockoutVO vo){
		String id=vo.getId();
		String ordercode=vo.getOrdercode();
		long outtime=vo.getOuttime();
		String destination=vo.getDestination();
		String transporttype=vo.getTransportType();
		String transcode=vo.getTranscode();

		Formstate formstate=vo.getFormstate();

		update.set(id, ordercode, outtime, destination, transporttype, transcode, formstate);
		ResultMessage result=update.passupdate();
		return result;

	}

	public List<StockoutVO> findforms(Formstate state,String orgcode){
		List<StockoutVO> list=new ArrayList<StockoutVO>();
		List<StockoutPO> pos=find.findforms(state,orgcode);
		for(int i=0;i<=pos.size()-1;i++) {
			StockoutPO po=pos.get(i);
			String id=po.getId();
			String ordercode=po.getOrdercode();
			long outtime=po.getOuttime();
			String destination=po.getDestination();
			String transporttype=po.getTransporttype();
			String transcode=po.getTranscode();

			Formstate formstate=po.getFormstate();
			StockoutVO vo=new StockoutVO(id,ordercode,outtime,destination,transporttype,transcode,formstate);
			list.add(vo);
		}

		return list;
	}

	

	
	

}
