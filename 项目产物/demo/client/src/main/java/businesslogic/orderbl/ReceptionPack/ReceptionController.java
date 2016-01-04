package businesslogic.orderbl.ReceptionPack;

import businesslogicservice.orderblservice.ReceptionBlService;
import po.ResultMessage;
import vo.ReceptionVO;

public class ReceptionController implements ReceptionBlService{
    @Override
	public ResultMessage addReception(ReceptionVO vo){
		// TODO Auto-generated method stub
    	RecordReception recordReception =new RecordReception();
    	Reception reception=new Reception(recordReception);
    	ResultMessage result=reception.record(vo);
		return result;
	}

}
