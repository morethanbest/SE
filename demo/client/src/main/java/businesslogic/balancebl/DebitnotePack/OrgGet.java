package businesslogic.balancebl.DebitnotePack;

import businesslogic.managerbl.OrganizationPack.Organization;
import dataservice.balancedataservice.DebitnoteFormDataService;
import init.RMIHelper;
import po.OrganizationPO;
import po.Organizationtype;
import vo.OrganizationVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class OrgGet {
    public List<OrganizationVO> getorg(String city){
        List<OrganizationVO> list=new ArrayList<OrganizationVO>();
        DebitnoteFormDataService data= RMIHelper.getDebitnote();
        List<OrganizationPO> pos=null;
        try {
            pos=data.getAllOrganization(city);
        } catch (RemoteException e) {
            System.out.println("debitnote get all organization failed!!!");
            e.printStackTrace();
        }

        for(int i=0;i<=pos.size()-1;i++){
            OrganizationPO po=pos.get(i);
            String name=po.getName();
            String organizationcode=po.getOrganizationcode();
            Organizationtype type=po.getType();
            String city2=po.getCity();

            OrganizationVO vo=new OrganizationVO(name,organizationcode,type,city2);
            list.add(vo);




        }
        return list;


    }
}
