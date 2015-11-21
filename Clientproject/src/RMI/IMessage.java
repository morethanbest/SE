package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.datafactory.databaseFactory;

public interface IMessage extends Remote{

	public databaseFactory getdatabase() throws RemoteException, IllegalArgumentException;
	
	
}

