package businesslogic.logisticsbl;

import businesslogicservice.logisticsblservice.CheckForExistBlService;
import dataservice.logisticsdataservice.CenterLoadFormDataService;
import dataservice.logisticsdataservice.HallLoadFormDataService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import po.ResultMessage;

public class CheckForExistBl implements CheckForExistBlService {

	@Override
	public boolean checkCenterLoad(String motorcode) {
		// TODO Auto-generated method stub
		try{
			CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
			return dataserv.checkCenterLoad(motorcode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkTrans(String transcode) {
		// TODO Auto-generated method stub
		try{
			RecordtransFormDataService dataserv= RMIHelper.getRecordtrans();
			return dataserv.checkTrans(transcode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkHallLoad(String motorcode) {
		// TODO Auto-generated method stub
		try{
			HallLoadFormDataService dataserv= RMIHelper.getHallloadform();
			return dataserv.checkHallLoad(motorcode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
