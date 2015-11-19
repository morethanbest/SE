package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.datafactory.databaseFactory;

public interface IMessage extends Remote{

	public String getdatabase() throws RemoteException, IllegalArgumentException;
	public void echo()throws RemoteException, IllegalArgumentException;
	
}