package businesslogic.balancebl.DebitnotePack;

import dataservice.balancedataservice.DebitnoteFormDataService;
import init.RMIHelper;
import po.CityPO;
import vo.CityVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class CityGet {
    public List<CityVO> getcity(){
        DebitnoteFormDataService data= RMIHelper.getDebitnote();
        List<CityPO> citys=null;

        List<CityVO> list=null;
        try {
            citys=data.getALLCity();

            list=new ArrayList<CityVO>();
            for(int i=0;i<=citys.size()-1;i++){
                CityPO po=citys.get(i);
                String name=po.getName();
                String zone=po.getZone();

                CityVO vo=new CityVO(name,zone);
                list.add(vo);



            }


        } catch (RemoteException e) {
            System.out.println("debitnote get all citys failed!!!");
            e.printStackTrace();
        }



        return list;
    }
}
