package businesslogic.accountbl.NewBookPack;

import businesslogic.managerbl.OrganizationPack.Organization;
import dataservice.accountdataservice.NewBookDataService;
import init.RMIHelper;
import po.NewbookPO;
import vo.*;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class FindNewbook {
    public NewbookVO find(long time){
        NewBookDataService data= RMIHelper.getNewbook();

        TransAccount ta=new TransAccount();
        TransCommodity tc=new TransCommodity();
        TransOrg to=new TransOrg();
        TransStaff ts=new TransStaff();
        TransVehicle tv=new TransVehicle();

        List<AccountVO> avo=null;
        List<CommodityVO> cvo=null;
        List<OrganizationVO> ovo=null;
        List<StaffVO> svo=null;
        List<VehicleVO> vvo=null;

        NewbookVO vo=null;
        
        NewbookPO po=null;
        try {
            po=data.findNewBook(time);

            avo=ta.trans2(po.getAccount());
            cvo=tc.trans2(po.getCommodity());
            ovo=to.trans2(po.getOrganization());
            svo=ts.trans(po.getStaff());
            vvo=tv.trans(po.getVehicles());

            vo=new NewbookVO(po.getId(),avo,cvo,ovo,svo,vvo);

        } catch (Exception e) {
            System.out.println(" find new book fialed!!!");
            e.printStackTrace();
        }







        return vo;

    }
}
