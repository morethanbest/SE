package po;

import java.io.Serializable;
import java.util.List;

public class NewbookPO  implements Serializable{
	long id;
	long time;
	List<AccountPO> account;
	List<CommodityPO> commodity;
	List<OrganizationPO> organization;
	List<StaffPO> staff;
	List<VehiclesPO> vehicles;

	public NewbookPO(long id, long time,List<AccountPO> account, List<CommodityPO> commodity,
			List<OrganizationPO> organization,
			List<StaffPO> staff, List<VehiclesPO> vehicles) {
		super();
		this.id = id;
		this.time=time;
		this.account = account;
		this.commodity = commodity;
		this.organization = organization;
		this.staff = staff;
		this.vehicles = vehicles;
	}
	public long getId() {
		return id;
	}
	public long getTime(){return time;}
	public List<AccountPO> getAccount() {
		return account;
	}
	public List<CommodityPO> getCommodity() {
		return commodity;
	}
	public List<OrganizationPO> getOrganization() {
		return organization;
	}
	public List<StaffPO> getStaff() {
		return staff;
	}
	public List<VehiclesPO> getVehicles() {
		return vehicles;
	}

}
