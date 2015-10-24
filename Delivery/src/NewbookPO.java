import java.io.Serializable;

public class NewbookPO  implements Serializable{
	long id;
	OrignalAccountPO[] account;
	OrignalCommodityPO[] commodity;
	OrignalOrganizationPO organization;
	OrignalStaffPO staff;
	OrignalVehiclesPO vehicles;
	public NewbookPO(long id, OrignalAccountPO[] account, OrignalCommodityPO[] commodity,
			OrignalOrganizationPO organization, OrignalStaffPO staff, OrignalVehiclesPO vehicles) {
		this.id = id;
		this.account = account;
		this.commodity = commodity;
		this.organization = organization;
		this.staff = staff;
		this.vehicles = vehicles;
	}
	public long getId() {
		return id;
	}
	public OrignalAccountPO[] getAccount() {
		return account;
	}
	public OrignalCommodityPO[] getCommodity() {
		return commodity;
	}
	public OrignalOrganizationPO getOrganization() {
		return organization;
	}
	public OrignalStaffPO getStaff() {
		return staff;
	}
	public OrignalVehiclesPO getVehicles() {
		return vehicles;
	}
	
	
}
