package vo;

import java.util.List;

import po.Hall;

public class HallLoadVO {
	long loadtime;
	String hallcode;
	String motorcode;
	Hall destination;
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	
	public HallLoadVO(long loadtime,String hallcode,String motorcode,Hall destination,String vehiclecode,String supervisor,
			String supercargo,List<String> allbarcode){
		this.loadtime=loadtime;
		this.hallcode=hallcode;
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
	public String getHallcode(){
		return this.hallcode;
	}
	public String getMotorcode(){
		return this.motorcode;
	}
	public Hall getDestination(){
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