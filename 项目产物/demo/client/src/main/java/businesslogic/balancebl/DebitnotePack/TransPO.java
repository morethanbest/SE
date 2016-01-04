package businesslogic.balancebl.DebitnotePack;

import po.Formstate;
import po.RecordcollectPO;
import vo.RecordcollectVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class TransPO {
    public List<RecordcollectVO> trans(List<RecordcollectPO> pos){
        List<RecordcollectVO> list=new ArrayList<RecordcollectVO>();

        for(int i=0;i<=pos.size()-1;i++){
            RecordcollectPO po=pos.get(i);
            String id=po.getId();
            long collectiontime=po.getCollectiontime();
            String accountcode=po.getAccountcode();
            double collectionsum=po.getCollectionsum();
            String collectionman=po.getCollectionman();
            List<String> allordercode=po.getAllordercode();
            Formstate formstate=po.getDocumentstate();

            RecordcollectVO vo=new RecordcollectVO(id,collectiontime,accountcode,collectionsum,collectionman,allordercode,formstate);
            list.add(vo);




        }
        return list;
    }
}
