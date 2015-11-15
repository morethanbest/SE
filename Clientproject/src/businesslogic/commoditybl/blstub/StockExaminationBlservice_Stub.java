package businesslogic.commoditybl.blstub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.commodityblservice.StockExaminationBlService;
import po.CommodityLocation;
import vo.CommodityOutVO;
import vo.StockExaminationVO;

public class StockExaminationBlservice_Stub implements StockExaminationBlService {

	@Override
	public StockExaminationVO StockExamination(long startTime, long endTime) throws RemoteException {
		// TODO Auto-generated method stub
		List<CommodityOutVO> l=new ArrayList<CommodityOutVO>();
		l.add(new CommodityOutVO("1",1,1,new CommodityLocation(1,1,1,1)));
		return new StockExaminationVO(1,1,l);
	}

}
