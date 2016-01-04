package businesslogic.balancebl.DebitnotePack;

import vo.DebitnoteVO;
import vo.RecordcollectVO;

import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class DebitExam {
    public double exam(DebitnoteVO vo){
        List<RecordcollectVO> list=vo.getList();
        double sum=0;
        for(int i=0;i<=list.size()-1;i++){
            RecordcollectVO avo=list.get(i);
            sum=sum+avo.getCollectionsum();
        }

        return sum;
    }

}
