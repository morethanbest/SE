package po;

import java.io.Serializable;

public class DriversPO  implements Serializable{
	String drivercode;
	String drivername;
	long birthtime;
	String identifiercode;
	String cellphone;
	String drivergender;
	long timelimit;
	public DriversPO(String drivercode, String drivername, long birthtime, String identifiercode, String cellphone,
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
	public void setDrivercode(String drivercode) {
		this.drivercode = drivercode;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public void setBirthtime(long birthtime) {
		this.birthtime = birthtime;
	}
	public void setIdentifiercode(String identifiercode) {
		this.identifiercode = identifiercode;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public void setDrivergender(String drivergender) {
		this.drivergender = drivergender;
	}
	public void setTimelimit(long timelimit) {
		this.timelimit = timelimit;
	}
	
}
