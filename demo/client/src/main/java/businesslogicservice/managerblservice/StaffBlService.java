package businesslogicservice.managerblservice;

import java.util.List;

import po.Job;
import po.ResultMessage;
import vo.StaffVO;

public interface StaffBlService {
	public ResultMessage addStaff(StaffVO vo);
	
	public ResultMessage delStaff(StaffVO vo);
	
	public ResultMessage revStaff(StaffVO vo);
	
	public List<StaffVO> getStaffbyOrganization(String organization);
	
	public List<StaffVO> getStaffbyJob(Job job);
	
	public List<StaffVO> getStaffbyBoth(String organization, Job job);

}
