package po;

import java.io.Serializable;
import java.util.List;

public class NewbookPO  implements Serializable{
	long id;
	long time;
	List<OrignalAccountPO> account;
	List<OrignalCommodityPO> commodity;
	List<OrignalOrganizationPO> organization;
	List<OrignalStaffPO> staff;
	List<OrignalVehiclesPO> vehicles;
	public NewbookPO(long id, List<OrignalAccountPO> account,
			List<OrignalCommodityPO> commodity,
			List<OrignalOrganizationPO> organization,
			List<OrignalStaffPO> staff, List<OrignalVehiclesPO> vehicles) {
		super();
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
	public List<OrignalAccountPO> getAccount() {
		return account;
	}
	public List<OrignalCommodityPO> getCommodity() {
		return commodity;
	}
	public List<OrignalOrganizationPO> getOrganization() {
		return organization;
	}
	public List<OrignalStaffPO> getStaff() {
		return staff;
	}
	public List<OrignalVehiclesPO> getVehicles() {
		return vehicles;
	}

}
