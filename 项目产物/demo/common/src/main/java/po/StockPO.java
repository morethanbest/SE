package po;
//用于记录仓库的容量和警戒值
public class StockPO {
	String orgcode;
	String name;
	long blocknum;
	long linenum;
	long shelfnum;
	long locationnum;
	long totalnum;
	double warningvalue;
	
	public StockPO(String orgcode, String name, long blocknum, long linenum, long shelfnum, long locationnum,
			long totalnum, double warningvalue) {
		this.orgcode = orgcode;
		this.name = name;
		this.blocknum = blocknum;
		this.linenum = linenum;
		this.shelfnum = shelfnum;
		this.locationnum = locationnum;
		this.totalnum = totalnum;
		this.warningvalue = warningvalue;
	}
	
	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBlocknum() {
		return blocknum;
	}
	public void setBlocknum(long blocknum) {
		this.blocknum = blocknum;
	}
	public long getLinenum() {
		return linenum;
	}
	public void setLinenum(long linenum) {
		this.linenum = linenum;
	}
	public long getShelfnum() {
		return shelfnum;
	}
	public void setShelfnum(long shelfnum) {
		this.shelfnum = shelfnum;
	}
	public long getLocationnum() {
		return locationnum;
	}
	public void setLocationnum(long locationnum) {
		this.locationnum = locationnum;
	}
	public long getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(long totalnum) {
		this.totalnum = totalnum;
	}
	public double getWarningvalue() {
		return warningvalue;
	}
	public void setWarningvalue(double warningvalue) {
		this.warningvalue = warningvalue;
	}
	
}
