package businesslogic.balancebl.RecordpayPack;

import po.Formstate;
import po.RecordpayList;
import po.RecordpayPO;
import po.ResultMessage;
import vo.RecordpayVO;
import po.ResultMessage;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class Recordpay {
	AddRecord addRecord;
	UpdateRecord update;
	FindRecord find;
	public Recordpay(AddRecord add){this.addRecord=add;}

	public Recordpay(UpdateRecord update){this.update=update;}

	public Recordpay(FindRecord find){this.find=find;}

	public ResultMessage add(RecordpayVO vo){
		String id=vo.getId();
		long paytime=vo.getPaytime();
		double paysum=vo.getPaysum();
		String payman=vo.getPayman();
		String payaccount=vo.getPayaccount();
		RecordpayList entry=vo.getEntry();
		String remark=vo.getRemark();
		Formstate formstate=vo.getFormstate();

		addRecord.set(id,paytime,paysum,payman,payaccount,entry,remark,formstate);
		ResultMessage result=addRecord.passadd();
		return result;
	}

	public ResultMessage update(RecordpayVO vo){
		String id=vo.getId();
		long paytime=vo.getPaytime();
		double paysum=vo.getPaysum();
		String payman=vo.getPayman();
		String payaccount=vo.getPayaccount();
		RecordpayList entry=vo.getEntry();
		String remark=vo.getRemark();
		Formstate formstate=vo.getFormstate();

		update.set(id, paytime, paysum, payman, payaccount, entry, remark, formstate);
		ResultMessage result=update.passupdate();
		return result;
	}

	public List<RecordpayVO> find(Formstate formstate){
		List<RecordpayPO> pos=find.findforms(formstate);
		List<RecordpayVO> list=new ArrayList<RecordpayVO>();
		for(int i=0;i<=pos.size()-1;i++){
			RecordpayPO po=pos.get(i);
			String id=po.getId();
			long paytime=po.getPaytime();
			double paysum=po.getPaysum();
			String payman=po.getPayman();
			String payaccount=po.getPayaccount();
			RecordpayList entry=po.getEntry();
			String remark=po.getRemark();
			Formstate state=po.getFormstate();

			RecordpayVO vo=new RecordpayVO(id,paytime,paysum,payman,payaccount,entry,remark,state);
			list.add(vo);




		}
		return list;



	}
}
