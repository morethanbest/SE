package presentation.enums;

import po.Ordertype;

public enum OrderTypes {
	EMS("经济快递", Ordertype.economical), Standard("标准快递", Ordertype.normal), Express("特快", Ordertype.fast);

	private String name;
	private Ordertype ordertype;
	
	private OrderTypes(String name, Ordertype ordertype) {
		this.name = name;
		this.ordertype = ordertype;
	}

	public String getName() {
		return name;
	}

	public Ordertype getOrdertype() {
		return ordertype;
	}
	
}
