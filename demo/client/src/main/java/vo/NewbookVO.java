package vo;

import java.util.List;

public class NewbookVO {
	long id;
	List<AccountVO> account;
	List<CommodityGetRegionVO> commodity;
	List<OrganizationVO> organization;
	List<StaffVO> staff;
	List<VehicleVO> vehicles;
	public NewbookVO(long id, List<AccountVO> account,
			List<CommodityGetRegionVO> commodity,
			List<OrganizationVO> organization,
			List<StaffVO> staff, List<VehicleVO> vehicles) {
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
	public List<AccountVO> getAccount() {
		return account;
	}
	public List<CommodityGetRegionVO> getCommodity() {
		return commodity;
	}
	public List<OrganizationVO> getOrganization() {
		return organization;
	}
	public List<StaffVO> getStaff() {
		return staff;
	}
	public List<VehicleVO> getVehicles() {
		return vehicles;
	}

}
