
package po;
import java.io.Serializable;

public class LoadPO  implements Serializable{
	long id;
	long loadtime;
	long hallcode;
	long motorcode;
	Hall destination;		
	long vehiclecode;
	String supervisor;
	String supercargo;
	long[] allbarcode;
	double fee;
	Formstate documentstate;	
	
	public LoadPO(long id,long loadtime,long hallcode,long motorcode,Hall destination,long vehiclecode,String supervisor,
			String supercargo,long[] allbarcode,double fee){
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
	public long getId() {
		return id;
	}
	public long getVehiclecode() {
		return vehiclecode;
	}

	public void setVehiclecode(long vehiclecode) {
		this.vehiclecode = vehiclecode;
	}

	public void setLoadtime(long loadtime) {
		this.loadtime = loadtime;
	}

	public void setHallcode(long hallcode) {
		this.hallcode = hallcode;
	}

	public void setMotorcode(long motorcode) {
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

	public void setAllbarcode(long[] allbarcode) {
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
	public long getHallcode(){
		return this.hallcode;
	}
	public long getMotorcode(){
		return this.motorcode;
	}
	public Hall getDestination(){
		return this.destination;
	}
	public long getVehicldecode(){
		return this.vehiclecode;
	}
	public String getSupervisor(){
		return this.supervisor;
	}
	public String getSupercargo(){
		return this.supercargo;
	}
	public long[] getAllbarcode(){
		return this.allbarcode;
	}
	public double getFee(){
		return this.fee;
	}
}