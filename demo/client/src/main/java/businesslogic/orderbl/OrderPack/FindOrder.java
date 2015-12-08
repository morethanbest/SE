package businesslogic.orderbl.OrderPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.OrderPO;
import po.Ordertype;
import vo.OrderVO;

public class FindOrder {
	Formstate documentstate;
	String orgcode;
	public void setstate(Formstate documentstate,String orgcode){
		this.documentstate=documentstate;
		this.orgcode=orgcode;
	}
	public List<OrderVO> findOrderbyState(){
		OrderFormDataService orderFormDataService=RMIHelper.getOrderformdata();
		List<OrderVO> listvo=new ArrayList<OrderVO>();
		try {
			List<OrderPO> listpo=orderFormDataService.getOrderForm(documentstate,orgcode);
			for(int i=0;i<listpo.size();i++){
				OrderPO po=listpo.get(i);
				String sendername=po.getSendername();
				String senderaddress=po.getSenderaddress();
				String senderunit=po.getSenderunit();
				String senderphone=po.getSenderphone();
				String sendercellphone=po.getSendercellphone();
				String receivername=po.getReceivername();
				String receiveraddress=po.getReceiveraddress();
				String receiverunit=po.getReceiverunit();
				String receiverphone=po.getReceiverphone();
				String receivercellphone=po.getReceivercellphone();
				double numbers=po.getNumbers();
				double weight=po.getWeight();
				double volume=po.getVolume();
				String productname=po.getProductname();
				String packagetype=po.getPackagetype();
				String ordercode=po.getOrdercode();
				Ordertype ordertype=po.getOrdertype();
				double totalfee=po.getTotalfee();
				Formstate documentstate=po.getDocumentstate();
				OrderVO vo=new OrderVO(sendername, senderaddress, senderunit, senderphone, sendercellphone, receivername, 
						receiveraddress, receiverunit, receiverphone, receivercellphone, numbers, weight, volume, productname, 
						packagetype, ordercode, ordertype, totalfee, documentstate);
				listvo.add(vo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listvo;
	}
}
