package servertest;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.IMessage;
import data.datafactory.MessageImpl;

public class rmitest {

	public static void main(String[] args){
		try {
			IMessage msg = new MessageImpl();
			Registry registry = LocateRegistry.createRegistry(5001);
			registry.rebind("message", msg);
			System.out.println("create sever");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}