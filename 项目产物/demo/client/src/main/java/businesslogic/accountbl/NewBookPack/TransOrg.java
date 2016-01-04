package businesslogic.accountbl.NewBookPack;

import businesslogic.managerbl.OrganizationPack.Organization;
import po.OrganizationPO;
import po.Organizationtype;
import vo.OrganizationVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TransOrg {
    public List<OrganizationPO> trans(List<OrganizationVO> vo){
        List<OrganizationPO> list=new ArrayList<OrganizationPO>();
        for(int i=0;i<=vo.size()-1;i++){
            OrganizationVO newvo=vo.get(i);
            String name=newvo.getName();
            String organizationcode=newvo.getOrganizationcode();
            Organizationtype type=newvo.getType();
            String city=newvo.getCity();

            OrganizationPO po=new OrganizationPO(name,organizationcode,type,city);
            list.add(po);
        }
        return list;
    }

    public List<OrganizationVO> trans2(List<OrganizationPO> po){
        List<OrganizationVO> list=new ArrayList<OrganizationVO>();
        for(int i=0;i<=po.size()-1;i++){
            OrganizationPO newpo=po.get(i);
            String name=newpo.getName();
            String organizationcode=newpo.getOrganizationcode();
            Organizationtype type=newpo.getType();
            String city=newpo.getCity();

            OrganizationVO vo=new OrganizationVO(name,organizationcode,type,city);
            list.add(vo);
        }
        return list;
    }
}
