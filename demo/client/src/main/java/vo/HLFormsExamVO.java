package vo;

import java.util.List;

import po.Formstate;

public class HLFormsExamVO {
	long loadtime;
	String Stringcode;
	String motorcode;
	String destination;		
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	double fee;
	Formstate documentstate;	
	
	public HLFormsExamVO(long loadtime,String Stringcode,String motorcode,String destination,String vehiclecode,String supervisor,
			String supercargo,List<String> allbarcode,double fee){
		this.loadtime=loadtime;
		this.Stringcode=Stringcode;
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

	public void setStringcode(String Stringcode) {
		this.Stringcode = Stringcode;
	}

	public void setMotorcode(String motorcode) {
		this.motorcode = motorcode;
	}

	public void setDestination(String destination) {
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
	public double getFee(){
		return this.fee;
	}
}
