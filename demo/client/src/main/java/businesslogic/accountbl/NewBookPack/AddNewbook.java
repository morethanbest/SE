package businesslogic.accountbl.NewBookPack;

import businesslogic.managerbl.OrganizationPack.Organization;
import dataservice.accountdataservice.NewBookDataService;
import init.RMIHelper;
import po.*;
import vo.*;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class AddNewbook {
    public ResultMessage addNew(long id){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String date=Integer.toString(year)+Integer.toString(month)+Integer.toString(day);
        long time=Long.valueOf(date);

        NewBookDataService data= RMIHelper.getNewbook();

        List<AccountPO> apo=null;
        List<CommodityPO> cpo=null;
        List<OrganizationPO> opo=null;
        List<StaffPO> spo=null;
        List<VehiclesPO> vpo=null;
        if(id!=1) {
            NewbookPO anotherpo = null;
            try {
                anotherpo = data.getLastBook();
            } catch (RemoteException e) {
                System.out.println("add new book get last book failed!!!");
                e.printStackTrace();
            }

            apo=anotherpo.getAccount();
            cpo=anotherpo.getCommodity();
            opo=anotherpo.getOrganization();
            spo=anotherpo.getStaff();
            vpo=anotherpo.getVehicles();

        }








        NewbookPO po=new NewbookPO(id,time,apo,cpo,opo,spo,vpo);



        ResultMessage result=null;
        try {
            result=data.addNewBook(po);
        } catch (RemoteException e) {
            System.out.println("add new book failed!!!");
            e.printStackTrace();
        }
        return result;

    }
}
