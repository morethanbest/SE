package vo;

import java.util.List;

public class HallLoadVO {
	long loadtime;
	String Stringcode;
	String motorcode;
	String destination;
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	
	public HallLoadVO(long loadtime,String Stringcode,String motorcode,String destination,String vehiclecode,String supervisor,
			String supercargo,List<String> allbarcode){
		this.loadtime=loadtime;
		this.Stringcode=Stringcode;
		this.motorcode=motorcode;
		this.destination=destination;
		this.vehiclecode=vehiclecode;
		this.supervisor=supervisor;
		this.supercargo=supercargo;
		this.allbarcode=allbarcode;
	}

	public long getLoadtime(){
		return this.loadtime;
	}
	public String getStringcode(){
		return this.Stringcode;
	}
	public String getMotorcode(){
		return this.motorcode;
	}
	public String getDestination(){
		return this.destination;
	}
	public String getVehicldecode(){
		return this.vehiclecode;
	}
	public String getSupervisor(){
		return this.supervisor;
	}
	public String getSupercargo(){
		return this.supercargo;
	}
	public List<String> getAllbarcode(){
		return this.allbarcode;
	}
}