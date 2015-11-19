package data.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	public static byte[] Object2Bytes(Object obj)throws IOException{
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  ObjectOutputStream oos = new ObjectOutputStream(baos);
		  oos.writeObject(obj);
		  return baos.toByteArray();
	}
	public static Object Bytes2Object(byte[] b) throws IOException,
	   ClassNotFoundException {

	  ByteArrayInputStream bais = new ByteArrayInputStream(b);
	  ObjectInputStream ois = new ObjectInputStream(bais);

	  Object obj = ois.readObject();
	  return obj;
	 }
}
