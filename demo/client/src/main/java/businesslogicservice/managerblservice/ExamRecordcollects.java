package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;
import vo.RecordcollectExamVO;
import vo.RecordcollectVO;

public interface ExamRecordcollects {
	public List<RecordcollectVO> getRecordcollectForm (Formstate statee);

	public ResultMessage updateRecordcollectForm (RecordcollectVO vo);
}
