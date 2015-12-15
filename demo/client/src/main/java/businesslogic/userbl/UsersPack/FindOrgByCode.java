package businesslogic.userbl.UsersPack;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import init.RMIHelper;
import po.OrganizationPO;
import vo.OrganizationVO;

public class FindOrgByCode {
	public OrganizationVO findOrgByCode(String orgcode){
		UserDataService userDataService=RMIHelper.getUserdata();
		OrganizationVO vo=null;
		try {
			OrganizationPO po=userDataService.getOrganization(orgcode);
			vo=new OrganizationVO(po.getName(), po.getOrganizationcode(), po.getType(), po.getCity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
