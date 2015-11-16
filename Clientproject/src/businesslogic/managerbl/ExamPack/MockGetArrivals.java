package businesslogic.managerbl.ExamPack;

import java.util.ArrayList;
import java.util.List;

import po.ArrivalPO;
import vo.ArrivalExamVO;

public class MockGetArrivals extends GetArrivals {
	
	public List<ArrivalExamVO> getArrivals(){
		
		List<ArrivalPO> lp=new ArrayList<ArrivalPO>();		//以后为从数据层得到审批状态为waiting的
		
		List<ArrivalExamVO> lv=new ArrayList<ArrivalExamVO>();
		for(int i=0;i<lp.size();i++){
			ArrivalPO po=lp.get(i);
			ArrivalExamVO vo=new ArrivalExamVO(po.getCentercode(),po.getArrivaltime(),po.getTranscode(),po.getDeparture(),po.getArrivalstate());
			lv.add(vo);
			
		}
		return lv;
	}
}
