package presentation.enums;

public enum StaffType {
	Courior("快递员"), HallStaff("营业厅业务员"), CenterStaff("中转中心业务员"), CenterDepot("中转中心库存管理人员"), Financial("财务人员"), Manager("总经理");
	private String name;

	private StaffType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
