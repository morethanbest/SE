package businesslogicservice.managerblservice;

import java.util.List;

import po.ResultMessage;
import vo.ConstantsVO;

public interface ConstantsBlService {
	public ResultMessage addConstants (ConstantsVO vo);
	
	public ResultMessage delConstants(ConstantsVO vo);
	
	public List<ConstantsVO> getConstants(String name);
	//鏇存柊鏁版嵁锛岄�氳繃鍘熷悕鏌ユ壘锛屽啀灏唙o瑕嗙洊涓�
	public ResultMessage revConstants (ConstantsVO vo);


}