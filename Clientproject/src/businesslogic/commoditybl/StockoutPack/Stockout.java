package businesslogic.commoditybl.StockoutPack;

import java.rmi.RemoteException;

import po.Hall;
import po.Loadform;
import vo.ResultMessage;
import vo.StockoutVO;

public class Stockout {
	StockoutFormMock form;
	IdInfoMock idgetter;
	public Stockout(StockoutFormMock form,IdInfoMock idgetter) {
		// TODO Auto-generated constructor stub
		this.form=form;
		this.idgetter=idgetter;
	}
	
	
	
	
	
	public ResultMessage StockoutOP(StockoutVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String ordercode=vo.getOrdercode();
		long outtime=vo.getOuttime();
		Hall destination=vo.getDestination();
		Loadform loadform=vo.getLoadform();
		String transcode=vo.getTranscode();
		String motorcode=vo.getMotorcode();
		
		long id=idgetter.getid();
		form.setStockoutForm(ordercode, outtime, destination, loadform, transcode, motorcode, id);
		ResultMessage result=form.passform();
		return result;
		
	}
	
	

}
