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
	
	public List<StaffVO> fuzzyfindStaff() throws RemoteException{
		StaffDataService staff=new StaffData();
		List<StaffPO> listpo=staff.fuzzyfindStaff(name);
		List<StaffVO> listvo=new ArrayList<StaffVO>();
		for(int i=0;i<listpo.size();i++){
			StaffPO po=listpo.get(i);
			long id=po.getId();
			String name=po.getName();
			Job job=po.getJob();
			StaffVO vo=new StaffVO(id, name, job);
			listvo.add(vo);
		}
		return listvo;
	}
	public StaffVO findStaff() throws RemoteException{
		StaffDataService staff=new StaffData();
		StaffPO po=staff.findStaff(id);
		if(po==null){
			return null;
		}
		String name=po.getName();
		Job job=po.getJob();
		StaffVO vo=new StaffVO(id, name, job);
		return vo;
	}
	public List<StaffVO> fuzzyfindStaffbyJob() throws RemoteException{
		StaffDataService staff=new StaffData();
		List<StaffPO> listpo=staff.fuzzyfindbyjob(job);
		List<StaffVO> listvo=new ArrayList<StaffVO>();
		for(int i=0;i<listpo.size();i++){
			StaffPO po=listpo.get(i);
			long id=po.getId();
			String name=po.getName();
			Job job=po.getJob();
			StaffVO vo=new StaffVO(id, name, job);
			listvo.add(vo);
		}
		return listvo;
	}
	public List<StaffVO> fuzzyfindStaffbyboth() throws RemoteException{
		StaffDataService staff=new StaffData();
		List<StaffPO> listpo=staff.fuzzyfindbyboth(name, job);
		List<StaffVO> listvo=new ArrayList<StaffVO>();
		for(int i=0;i<listpo.size();i++){
			StaffPO po=listpo.get(i);
			long id=po.getId();
			String name=po.getName();
			Job job=po.getJob();
			StaffVO vo=new StaffVO(id, name, job);
			listvo.add(vo);
		}
		return listvo;
	}
}
