package businesslogic.balancebl.DebitnotePack;

import vo.DebitnoteExamVO;
import vo.DebitnoteVO;
import vo.RecordcollectVO;

import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class Debitnote {
    private HallCollect hall;
    private DateCollect day;
    private DebitExam exam;
    public Debitnote(HallCollect hall){this.hall=hall;}
    public Debitnote(DateCollect day){this.day=day;}
    public Debitnote(DebitExam exam){this.exam=exam;}

    public DebitnoteVO gethall(String orgcode){
        List<RecordcollectVO> list=hall.getbyhall(orgcode);
        DebitnoteVO vo=new DebitnoteVO(list);
        return vo;
    }

    public DebitnoteVO getdate(long date){
        List<RecordcollectVO> list=day.getbydate(date);
        DebitnoteVO vo=new DebitnoteVO(list);
        return vo;
    }

    public DebitnoteExamVO debitexam(DebitnoteVO det){
        double sum=exam.exam(det);
        DebitnoteExamVO vo=new DebitnoteExamVO(sum);
        return vo;
    }

}
