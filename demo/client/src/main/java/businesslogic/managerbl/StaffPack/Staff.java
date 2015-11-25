package businesslogic.managerbl.StaffPack;

import java.util.List;

import po.City;
import po.Job;
import po.Organizationtype;
import po.ResultMessage;
import vo.StaffVO;

public class Staff {
	AddStaff adds;
	DelStaff dels;
	FindStaff finds;
	RevStaff revs;
	
	public Staff(AddStaff adds){
		this.adds=adds;
	}
	
	public Staff(DelStaff dels){
		this.dels=dels;
	}
	
	public Staff(FindStaff finds){
		this.finds=finds;
	}
	
	public Staff(RevStaff revs){
		this.revs=revs;
	}
	
	public ResultMessage addStaff(StaffVO vo){
		long id=vo.getId();
		String name=vo.getName();
		Job job=vo.getJob();
		String organizationname=vo.getOrganizationname();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype organizationtype=vo.getOrganizationtype();
		City city=vo.getCity();
		adds.setAddInfo(id, name, job, organizationname, organizationcode, organizationtype, city);
		ResultMessage result=adds.addStaff();
		return result;
		
	}
	
	public ResultMessage delStaff(StaffVO vo){
		long id=vo.getId();
		dels.setDelInfo(id);
		ResultMessage result=dels.delete();
		return result;
	}
	
	public List<StaffVO> findStaffbyOrganization(String organizationcode){
		finds.setFindInfo(organizationcode);
		List<StaffVO> listvo=finds.fuzzyfindbyorganization();
		return listvo;
	}
	
	public List<StaffVO> findStaffbyJob(Job job){
		finds.setFindInfo(job);
		List<StaffVO> listvo=finds.fuzzyfindStaffbyJob();
		return listvo;
	}
	
	public List<StaffVO> findStaffbyBoth(String organizationcode,Job job){
		finds.setFindInfo(organizationcode,job);
		List<StaffVO> listvo=finds.fuzzyfindStaffbyboth();
		return listvo;
	}
	
	public ResultMessage revStaff(StaffVO vo){
		long id=vo.getId();
		String name=vo.getName();
		Job job=vo.getJob();
		String organizationname=vo.getOrganizationname();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype organizationtype=vo.getOrganizationtype();
		City city=vo.getCity();
		revs.setRevInfo(id, name, job, organizationname, organizationcode, organizationtype, city);
		ResultMessage result=revs.rev();
		return result;
	}
}
