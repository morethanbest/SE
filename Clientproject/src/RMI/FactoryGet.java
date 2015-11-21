package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import data.datafactory.databaseFactory;

public class FactoryGet {

	public static databaseFactory getfactory(){
		try {
			IMessage message = (IMessage) Naming.lookup("rmi://172.26.99.181:5001/message");
			databaseFactory msg = message.getdatabase();
			return msg;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
