package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
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
	
	public OrganizationVO findOrganization(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO po;
		OrganizationVO vo;
		try {
			po = organization.findOrganization(id);
			long id=po.getId();
			Organizationtype type=po.getType();
			String name=po.getName();
			vo=new OrganizationVO(id,name,type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo=null;
			System.out.println("findOrganization fail");
		}
		return vo;
	}
	public List<OrganizationVO> findOrganizationbyName(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		List<OrganizationPO> listpo;
		List<OrganizationVO> listvo;
		try {
			listpo = organization.fuzzyfind(name);
			listvo=new ArrayList<OrganizationVO>();
			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Organizationtype type=po.getType();
				OrganizationVO vo=new OrganizationVO(id, name, type);
				listvo.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("findOrganizationbyName fail");
		}
		
		return listvo;
	}
	public List<OrganizationVO> findOrganizationbyType(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		List<OrganizationPO> listpo;
		List<OrganizationVO> listvo;
		try {
			listpo = organization.fuzzyfindbytype(type);
			listvo=new ArrayList<OrganizationVO>();
			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Organizationtype type=po.getType();
				OrganizationVO vo=new OrganizationVO(id, name, type);
				listvo.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("fuzzyfindbytype fail");
			listvo=null;
		}
		
		return listvo;
	}
	public List<OrganizationVO> findOrganizationbyBoth(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		List<OrganizationPO> listpo;
		List<OrganizationVO> listvo;
		try {
			listpo = organization.fuzzyfindbyboth(name, type);
			listvo=new ArrayList<OrganizationVO>();
			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				long id=po.getId();
				String name=po.getName();
				Organizationtype type=po.getType();
				OrganizationVO vo=new OrganizationVO(id, name, type);
				listvo.add(vo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("fuzzyfindbyboth fail");
		}
		
		return listvo;
	}
}
