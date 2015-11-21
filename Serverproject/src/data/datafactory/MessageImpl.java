package data.datafactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements IMessage {
	public MessageImpl() throws RemoteException {
	///protected MessageImpl() throws RemoteException {
		super();
	}

	@Override
	public String getdatabase() throws RemoteException,
			IllegalArgumentException {
		databaseFactory factory=new databaseFactory();
		return "hello";
	}

	@Override
	public void echo() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("success");
		
	}



}