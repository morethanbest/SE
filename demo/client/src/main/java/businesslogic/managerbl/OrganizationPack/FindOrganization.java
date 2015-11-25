package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.City;
import po.OrganizationPO;
import po.Organizationtype;
import vo.OrganizationVO;

public class FindOrganization {
	City city;
    Organizationtype type;
	
	public void setFindInfo(City city){
		this.city=city;
	}
	public void setFindInfo(Organizationtype type){
		this.type=type;
	}
	public void setFindInfo(City city, Organizationtype type){
		this.city=city;
		this.type=type;
	}

	public List<OrganizationVO> findOrganizationbyCity(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		List<OrganizationPO> listpo;
		List<OrganizationVO> listvo=new ArrayList<OrganizationVO>();
		try {
			listpo = organization.fuzzyfind(city);

			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				String poname=po.getName();
				String poorganizationcode=po.getOrganizationcode();
				Organizationtype potype=po.getType();
				City pocity=po.getCity();
				OrganizationVO vo=new OrganizationVO(poname, poorganizationcode, potype, pocity);
				listvo.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("findOrganizationbyCity fail");
		}
		
		return listvo;
	}
	public List<OrganizationVO> findOrganizationbyType(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		List<OrganizationPO> listpo;
		List<OrganizationVO> listvo=new ArrayList<OrganizationVO>();
		try {
			listpo = organization.fuzzyfindbytype(type);
			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				String poname=po.getName();
				String poorganizationcode=po.getOrganizationcode();
				Organizationtype potype=po.getType();
				City pocity=po.getCity();
				OrganizationVO vo=new OrganizationVO(poname, poorganizationcode, potype, pocity);
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
			listpo = organization.fuzzyfindbyboth(city, type);
			listvo=new ArrayList<OrganizationVO>();
			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				String poname=po.getName();
				String poorganizationcode=po.getOrganizationcode();
				Organizationtype potype=po.getType();
				City pocity=po.getCity();
				OrganizationVO vo=new OrganizationVO(poname, poorganizationcode, potype, pocity);
				listvo.add(vo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("fuzzyfindbyboth fail");
		}
		
		return listvo;
	}
	public List<OrganizationVO> findOrganizationall(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		List<OrganizationPO> listpo;
		List<OrganizationVO> listvo;
		try {
			listpo = organization.getAll();
			listvo=new ArrayList<OrganizationVO>();
			for(int i=0;i<listpo.size();i++){
				OrganizationPO po=listpo.get(i);
				String poname=po.getName();
				String poorganizationcode=po.getOrganizationcode();
				Organizationtype potype=po.getType();
				City pocity=po.getCity();
				OrganizationVO vo=new OrganizationVO(poname, poorganizationcode, potype, pocity);
				listvo.add(vo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("getall fail");
		}

		return listvo;
	}
}
