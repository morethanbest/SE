package businesslogic.managerbl.OrganizationPack;

import java.nio.file.attribute.PosixFilePermission;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.managerdata.OrganizationData;
import dataservice.managerdataservice.OrganizationDataService;
import po.OrganizationPO;
import po.Organizationtype;
import vo.OrganizationVO;

public class FindOrganization {
	long id;
    String name;
    Organizationtype type;
	
	public void setFindInfo(String name){
		this.name=name;
	}
	public void setFindInfo(long id){
		this.id=id;
	}
	public void setFindInfo(Organizationtype type){
		this.type=type;
	}
	public void setFindInfo(String name,Organizationtype type){
		this.name=name;
		this.type=type;
	}
	
	public OrganizationVO findOrganization() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		OrganizationPO po=organization.findOrganization(id);
		if(po==null){
			return null;
		}
		long id=po.getId();
		Organizationtype type=po.getType();
		String name=po.getName();
		OrganizationVO vo=new OrganizationVO(id,name,type);
		return vo;
	}
	public List<OrganizationVO> findOrganizationbyName() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		List<OrganizationPO> listpo=organization.fuzzyfind(name);
		List<OrganizationVO> listvo=new ArrayList<OrganizationVO>();
		for(int i=0;i<listpo.size();i++){
			OrganizationPO po=listpo.get(i);
			long id=po.getId();
			String name=po.getName();
			Organizationtype type=po.getType();
			OrganizationVO vo=new OrganizationVO(id, name, type);
			listvo.add(vo);
		}
		return listvo;
	}
	public List<OrganizationVO> findOrganizationbyType() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		List<OrganizationPO> listpo=organization.fuzzyfindbytype(type);
		List<OrganizationVO> listvo=new ArrayList<OrganizationVO>();
		for(int i=0;i<listpo.size();i++){
			OrganizationPO po=listpo.get(i);
			long id=po.getId();
			String name=po.getName();
			Organizationtype type=po.getType();
			OrganizationVO vo=new OrganizationVO(id, name, type);
			listvo.add(vo);
		}
		return listvo;
	}
	public List<OrganizationVO> findOrganizationbyBoth() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		List<OrganizationPO> listpo=organization.fuzzyfindbyboth(name, type);
		List<OrganizationVO> listvo=new ArrayList<OrganizationVO>();
		for(int i=0;i<listpo.size();i++){
			OrganizationPO po=listpo.get(i);
			long id=po.getId();
			String name=po.getName();
			Organizationtype type=po.getType();
			OrganizationVO vo=new OrganizationVO(id, name, type);
			listvo.add(vo);
		}
		return listvo;
	}
}
