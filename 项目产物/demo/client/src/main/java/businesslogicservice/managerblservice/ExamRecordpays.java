package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordpayPO;
import po.ResultMessage;
import vo.RecordpayExamVO;
import vo.RecordpayVO;

public interface ExamRecordpays {
	public List<RecordpayVO> getRecordpayForm (Formstate state);

	public ResultMessage updateRecordpayForm (RecordpayVO vo);
}
