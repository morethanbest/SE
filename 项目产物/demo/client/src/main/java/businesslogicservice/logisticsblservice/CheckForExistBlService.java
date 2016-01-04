package businesslogicservice.logisticsblservice;

public interface CheckForExistBlService {
	public boolean checkCenterLoad(String motorcode);
	
	public boolean checkTrans(String transcode);
	
	public boolean checkHallLoad(String motorcode);
}
