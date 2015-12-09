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
        NewbookPO po=null;
        try {
            po=data.findNewBook(time);
        } catch (RemoteException e) {
            System.out.println(" find new book fialed!!!");
            e.printStackTrace();
        }
        TransAccount ta=new TransAccount();
        TransCommodity tc=new TransCommodity();
        TransOrg to=new TransOrg();
        TransStaff ts=new TransStaff();
        TransVehicle tv=new TransVehicle();


        List<AccountVO> avo=ta.trans2(po.getAccount());
        List<CommodityVO> cvo=tc.trans2(po.getCommodity());
        List<OrganizationVO> ovo=to.trans2(po.getOrganization());
        List<StaffVO> svo=ts.trans(po.getStaff());
        List<VehicleVO> vvo=tv.trans(po.getVehicles());

        NewbookVO vo=new NewbookVO(po.getId(),avo,cvo,ovo,svo,vvo);

        return vo;

    }
}
