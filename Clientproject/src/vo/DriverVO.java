package vo;


public class DriverVO {
	String drivercode;
	String drivername;
	long birthtime;
	String identifiercode;
	String cellphone;
	String drivergender;
	long timelimit;
	public DriverVO(String drivercode, String drivername, long birthtime, String identifiercode, String cellphone,
			String drivergender, long timelimit) {
		this.drivercode = drivercode;
		this.drivername = drivername;
		this.birthtime = birthtime;
		this.identifiercode = identifiercode;
		this.cellphone = cellphone;
		this.drivergender = drivergender;
		this.timelimit = timelimit;
	}
	public String getDrivercode() {
		return drivercode;
	}
	public String getDrivername() {
		return drivername;
	}
	public long getBirthtime() {
		return birthtime;
	}
	public String getIdentifiercode() {
		return identifiercode;
	}
	public String getCellphone() {
		return cellphone;
	}
	public String getDrivergender() {
		return drivergender;
	}
	public long getTimelimit() {
		return timelimit;
	}
	
}
