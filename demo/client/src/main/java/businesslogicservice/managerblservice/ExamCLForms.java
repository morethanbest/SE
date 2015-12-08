package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;
import vo.CLFormsExamVO;
import vo.CenterloadVO;

public interface ExamCLForms {
	public List<CenterloadVO> getCenterLoadForm (Formstate state);

	public ResultMessage updateCenterLoadForm (CenterloadVO vo);

}
