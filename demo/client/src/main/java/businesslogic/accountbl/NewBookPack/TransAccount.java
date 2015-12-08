package businesslogic.accountbl.NewBookPack;

import po.AccountPO;
import vo.AccountVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TransAccount {
    public List<AccountPO> trans(List<AccountVO> vo){
        List<AccountPO> list=new ArrayList<AccountPO>();
        for(int i=0;i<=vo.size()-1;i++){
            AccountVO newvo=vo.get(i);
            long id=newvo.getId();
            String accountname=newvo.getAccountname();
            double accountsum=newvo.getAccountsum();

            AccountPO po=new AccountPO(id,accountname,accountsum);
            list.add(po);
        }
        return list;
    }

    public List<AccountVO> trans2(List<AccountPO> po){
        List<AccountVO> list=new ArrayList<AccountVO>();
        for(int i=0;i<=po.size()-1;i++){
            AccountPO newpo=po.get(i);
            long id=newpo.getId();
            String accountname=newpo.getAccountname();
            double accountsum=newpo.getAccountsum();

            AccountVO vo=new AccountVO(id,accountname,accountsum);
            list.add(vo);
        }
        return list;
    }
}
