package businesslogic.managerbl.ExamPack;

import java.util.List;

import po.ArrivalPO;
import vo.ArrivalExamVO;
import vo.ResultMessage;

public class MockSetArrivals extends SetArrivals {
	public ResultMessage exam(List<ArrivalExamVO> volist){
		for(int i=0;i<volist.size();i++){
			ArrivalExamVO vo=volist.get(i);
			ArrivalPO po=new ArrivalPO(vo.getId(),vo.getCentercode(),vo.getArrivaltime(),vo.getTranscode(),vo.getDeparture(),vo.getArrivalstate());
			po.setDocumentstate(vo.getDocumentstate());
			//传入数据层
		}
		return ResultMessage.success;
	}
}
