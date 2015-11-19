package clienttest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMI.IMessage;

public class rmitest {

	public static void main(String[] args) {
		try {
			IMessage message = (IMessage) Naming.lookup("rmi://172.26.99.181:5001/message");
			String msg = message.getdatabase();
			System.out.println(msg);
			System.out.println("yes");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

}
