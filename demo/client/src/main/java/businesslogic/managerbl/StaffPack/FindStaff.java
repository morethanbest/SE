package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;
import po.City;
import po.Job;
import po.Organizationtype;
import po.StaffPO;
import vo.StaffVO;

public class FindStaff {
	long id;
	String organizationcode;
    Job job;
    
	public void setFindInfo(String organizationcode){
		this.organizationcode=organizationcode;
	}
	public void setFindInfo(long id){
		this.id=id;
	}
	public void setFindInfo(Job job){
		this.job=job;
	}
	public void setFindInfo(String organizationcode, Job job){
		this.organizationcode=organizationcode;
		this.job=job;
	}
	
	public List<StaffVO> fuzzyfindbyorganization(){
		StaffDataService staff=RMIHelper.getStaffdata();
		List<StaffPO> listpo;
		List<StaffVO> listvo;
		try {
			listpo = staff.fuzzyfindbyorganization(organizationcode);
			listvo=new ArrayList<StaffVO>();
			for(int i=0;i<listpo.size();i++){
				StaffPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Job job=po.getJob();
				String organizationname=po.getOrganizationname();
				String organizationcode=po.getOrganizationcode();
				Organizationtype organizationtype=po.getType();
				City city=po.getCity();
				StaffVO vo=new StaffVO(id, name, job, organizationname, organizationcode, organizationtype, city);
				listvo.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("fuzzyfindStaff fail");
		}
		
		return listvo;
	}
	public StaffVO findStaff(){
		StaffDataService staff=RMIHelper.getStaffdata();
		StaffPO po;
		StaffVO vo;
		try {
			po = staff.findStaff(id);
			if(po==null){
				return null;
			}
			String name=po.getName();
			Job job=po.getJob();
			String organizationname=po.getOrganizationname();
			String organizationcode=po.getOrganizationcode();
			Organizationtype organizationtype=po.getType();
			City city=po.getCity();
			vo=new StaffVO(id, name, job, organizationname, organizationcode, organizationtype, city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			vo=null;
			System.out.println("findstaff fail");
		}
		
		return vo;
	}
	public List<StaffVO> fuzzyfindStaffbyJob(){
		StaffDataService staff=RMIHelper.getStaffdata();
		List<StaffPO> listpo;
		List<StaffVO> listvo;
		try {
			listpo = staff.fuzzyfindbyjob(job);
			listvo=new ArrayList<StaffVO>();
			for(int i=0;i<listpo.size();i++){
				StaffPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Job job=po.getJob();
				String organizationname=po.getOrganizationname();
				String organizationcode=po.getOrganizationcode();
				Organizationtype organizationtype=po.getType();
				City city=po.getCity();
				StaffVO vo=new StaffVO(id, name, job, organizationname, organizationcode, organizationtype, city);
				listvo.add(vo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("fuzzyfindbyjob fail");
		}
		
		return listvo;
	}
	public List<StaffVO> fuzzyfindStaffbyboth(){
		StaffDataService staff=RMIHelper.getStaffdata();
		List<StaffPO> listpo;
		List<StaffVO> listvo;
		try {
			listpo = staff.fuzzyfindbyboth(organizationcode, job);
			listvo=new ArrayList<StaffVO>();
			for(int i=0;i<listpo.size();i++){
				StaffPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Job job=po.getJob();
				String organizationname=po.getOrganizationname();
				String organizationcode=po.getOrganizationcode();
				Organizationtype organizationtype=po.getType();
				City city=po.getCity();
				StaffVO vo=new StaffVO(id, name, job, organizationname, organizationcode, organizationtype, city);
				listvo.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("fuzzyfindbyboth fail");
		}
		
		return listvo;
	}
}
