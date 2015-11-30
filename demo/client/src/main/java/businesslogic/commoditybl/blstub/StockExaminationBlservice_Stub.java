package businesslogic.commoditybl.blstub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.commodityblservice.StockExaminationBlService;
import po.City;
import po.CommodityLocation;
import vo.CommodityTakingVO;
import vo.StockExaminationVO;

public class StockExaminationBlservice_Stub implements StockExaminationBlService {

	@Override
	public StockExaminationVO StockExamination(long startTime, long endTime) throws RemoteException {
		// TODO Auto-generated method stub
		List<CommodityTakingVO> l=new ArrayList<CommodityTakingVO>();
		l.add(new CommodityTakingVO("1",1,1,new CommodityLocation(1,1,1,1), City.Beijing));
		return new StockExaminationVO(1,1,l,0,0,0,0,0);
	}

}
