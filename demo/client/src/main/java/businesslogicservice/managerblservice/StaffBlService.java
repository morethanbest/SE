package businesslogicservice.managerblservice;

import java.util.List;

import po.Job;
import po.ResultMessage;
import vo.StaffVO;

public interface StaffBlService {
	public ResultMessage addStaff(StaffVO vo);
	
	public ResultMessage delStaff(StaffVO vo);
	
	public ResultMessage revStaff(StaffVO vo);
	
	public List<StaffVO> getStaffbyName(String name);
	
	public List<StaffVO> getStaffbyJob(Job job);
	
	public List<StaffVO> getStaffbyBoth(String name, Job job);

}
