package businesslogic.accountbl.NewBookPack;

import po.Job;
import po.Organizationtype;
import po.StaffPO;
import vo.StaffVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TransStaff {
    public List<StaffVO> trans(List<StaffPO> po){
        List<StaffVO> list=new ArrayList<StaffVO>();
        for(int i=0;i<=po.size()-1;i++){
            StaffPO newpo=po.get(i);
            long id=newpo.getId();
            String name=newpo.getName();
            Job job=newpo.getJob();
            String organizationname=newpo.getOrganizationname();
            String organizationcode=newpo.getOrganizationcode();
            Organizationtype organizationtype=newpo.getOrganizationtype();
            String city=newpo.getCity();

            StaffVO vo=new StaffVO(id,name,job,organizationname,organizationcode,organizationtype,city);
            list.add(vo);
        }
        return list;
    }
    public List<StaffPO> trans2(List<StaffVO> vo){
        List<StaffPO> list=new ArrayList<StaffPO>();
        for(int i=0;i<=vo.size()-1;i++){
            StaffVO newvo=vo.get(i);
            long id=newvo.getId();
            String name=newvo.getName();
            Job job=newvo.getJob();
            String organizationname=newvo.getOrganizationname();
            String organizationcode=newvo.getOrganizationcode();
            Organizationtype organizationtype=newvo.getOrganizationtype();
            String city=newvo.getCity();

            StaffPO po=new StaffPO(id,name,job,organizationname,organizationcode,organizationtype,city);
            list.add(po);
        }
        return list;
    }
}
