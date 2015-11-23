package vo;

import java.util.List;

import po.Formstate;
import po.Hall;

public class HLFormsExamVO {
	long loadtime;
	String hallcode;
	String motorcode;
	Hall destination;		
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	double fee;
	Formstate documentstate;	
	
	public HLFormsExamVO(long loadtime,String hallcode,String motorcode,Hall destination,String vehiclecode,String supervisor,
			String supercargo,List<String> allbarcode,double fee){
		this.loadtime=loadtime;
		this.hallcode=hallcode;
		this.motorcode=motorcode;
		this.destination=destination;
		this.vehiclecode=vehiclecode;
		this.supervisor=supervisor;
		this.supercargo=supercargo;
		this.allbarcode=allbarcode;
		this.fee=fee;
		this.documentstate=Formstate.waiting;
	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}

	public void setLoadtime(long loadtime) {
		this.loadtime = loadtime;
	}

	public void setHallcode(String hallcode) {
		this.hallcode = hallcode;
	}

	public void setMotorcode(String motorcode) {
		this.motorcode = motorcode;
	}

	public void setDestination(Hall destination) {
		this.destination = destination;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public void setSupercargo(String supercargo) {
		this.supercargo = supercargo;
	}

	public void setAllbarcode(List<String> allbarcode) {
		this.allbarcode = allbarcode;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
	}
	
	public Formstate getDocumentstate(){
		return this.documentstate;
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
	public double getFee(){
		return this.fee;
	}
}
