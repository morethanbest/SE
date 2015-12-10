package po;

import java.io.Serializable;

public enum Job implements Serializable {
	Courier("快递员"), hallsalesman("营业厅业务员"), transfercentersalesman("中转中心业务员"), CenterDepot("中转中心库存管理人员"),
	Financial("财务人员"), drivers("司机"), manager("总经理") ,administrator("管理员"),advanceFinancial("高级财务人员");
	
	private String name;
	
	private Job(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
}
