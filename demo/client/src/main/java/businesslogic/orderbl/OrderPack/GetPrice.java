package businesslogic.orderbl.OrderPack;

import java.text.DecimalFormat;
import java.util.List;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import po.Ordertype;
import vo.ConstantsVO;

public class GetPrice {
	String senderaddress;
	String receiveraddress;
	double numbers;
	double weight;
	double volume;
	String packagetype;
	Ordertype ordertype;
	public void setPriceInfo(String senderaddress,String receiveraddress,double numbers,double weight,
			double volume,String packagetype,Ordertype ordertype){
		this.senderaddress=senderaddress;
		this.receiveraddress=receiveraddress;
		this.numbers=numbers;
		this.weight=weight;
		this.volume=volume;
		this.packagetype=packagetype;
		this.ordertype=ordertype;
	}
	public double getPrice(){
		String[] splits1=senderaddress.split("-");
		String[] splits2=receiveraddress.split("-");
		ConstantsController constants=new ConstantsController();
		List<ConstantsVO> listvo=constants.getConstants("距离-"+splits1[0]+"-"+splits2[0]);
		ConstantsVO vo=listvo.get(0);
		double distance=vo.getValue();
		List<ConstantsVO> listvo1=constants.getConstants("包装类型-"+packagetype);
		ConstantsVO vo1=listvo1.get(0);
		double packagefee=vo1.getValue();
		double w=weight;
		if(volume/5000>w){
			w=volume/5000;
		}
		String name="快递类型-";
		switch(ordertype){
			case economical:
				name+="经济快递";
				break;
			case normal:
				name+="标准快递";
				break;
			case fast:
				name+="特快";
				break;
		}
		List<ConstantsVO> listvo2=constants.getConstants(name);
		ConstantsVO vo2=listvo2.get(0);
		double ot=vo2.getValue();
		double price=distance/1000*ot*w+packagefee;
		DecimalFormat df=new DecimalFormat("0.00");  
		price=new Double(df.format(price).toString());
		return price;
	}


}
