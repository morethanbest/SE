package businesslogic.managerbl.ExamPack;

import java.util.ArrayList;
import java.util.List;

import po.ArrivalPO;
import po.Arrivalstate;
import vo.ArrivalExamVO;

public class MockGetArrivals extends GetArrivals {
	
	public List<ArrivalExamVO> getArrivals(){
		
		List<ArrivalPO> lp=new ArrayList<ArrivalPO>();		//以后为从数据层得到审批状态为waiting的
		lp.add(new ArrivalPO(1,"1",1,"1",Hall.Nanjing1,Arrivalstate.broken));
		List<ArrivalExamVO> lv=new ArrayList<ArrivalExamVO>();
		for(int i=0;i<lp.size();i++){
			ArrivalPO po=lp.get(i);
			ArrivalExamVO vo=new ArrivalExamVO(po.getId(),po.getCentercode(),po.getArrivaltime(),po.getTranscode(),po.getDeparture()
					,po.getArrivalstate(),po.getDocumentstate());
			lv.add(vo);
			
		}
		return lv;
	}
}
