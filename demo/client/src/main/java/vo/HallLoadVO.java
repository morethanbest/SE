package vo;

import po.Formstate;

import java.util.List;

public class HallLoadVO {
	long loadtime;
	String hallcode;
	String motorcode;
	String destination;
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	double fee;
	Formstate documentstate;
	
	public HallLoadVO(long loadtime,String Stringcode,String motorcode,String destination,String vehiclecode,String supervisor,
			String supercargo,List<String> allbarcode,double fee,Formstate state){
		this.loadtime=loadtime;
		this.hallcode=Stringcode;
		this.motorcode=motorcode;
		this.destination=destination;
		this.vehiclecode=vehiclecode;
		this.supervisor=supervisor;
		this.supercargo=supercargo;
		this.allbarcode=allbarcode;
		this.fee=fee;
		this.documentstate=state;
	}

	public long getLoadtime(){
		return this.loadtime;
	}
	public String getStringcode(){
		return this.hallcode;
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
	public double getfee(){return this.fee;}
	public Formstate getstate(){return this.documentstate;}
}