package businesslogic.managerbl.StaffPack;

import java.nio.file.attribute.PosixFilePermission;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.managerdata.StaffData;
import dataservice.managerdataservice.StaffDataService;
import po.Job;
import po.StaffPO;
import vo.StaffVO;

public class FindStaff {
	long id;
    String name;
    Job job;
    
	public void setFindInfo(String name){
		this.name=name;
	}
	public void setFindInfo(long id){
		this.id=id;
	}
	public void setFindInfo(Job job){
		this.job=job;
	}
	public void setFindInfo(String name,Job job){
		this.name=name;
		this.job=job;
	}
	
	public List<StaffVO> fuzzyfindStaff(){
		StaffDataService staff=new StaffData();
		List<StaffPO> listpo;
		List<StaffVO> listvo;
		try {
			listpo = staff.fuzzyfindStaff(name);
			listvo=new ArrayList<StaffVO>();
			for(int i=0;i<listpo.size();i++){
				StaffPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Job job=po.getJob();
				StaffVO vo=new StaffVO(id, name, job);
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
		StaffDataService staff=new StaffData();
		StaffPO po;
		StaffVO vo;
		try {
			po = staff.findStaff(id);
			if(po==null){
				return null;
			}
			String name=po.getName();
			Job job=po.getJob();
			vo=new StaffVO(id, name, job);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			vo=null;
			System.out.println("findstaff fail");
		}
		
		return vo;
	}
	public List<StaffVO> fuzzyfindStaffbyJob(){
		StaffDataService staff=new StaffData();
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
				StaffVO vo=new StaffVO(id, name, job);
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
		StaffDataService staff=new StaffData();
		List<StaffPO> listpo;
		List<StaffVO> listvo;
		try {
			listpo = staff.fuzzyfindbyboth(name, job);
			listvo=new ArrayList<StaffVO>();
			for(int i=0;i<listpo.size();i++){
				StaffPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Job job=po.getJob();
				StaffVO vo=new StaffVO(id, name, job);
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
