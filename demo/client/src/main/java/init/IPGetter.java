package init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IPGetter {
	public static String getIP(){
		String ip="localhost";
		try{
			FileReader f=new FileReader(new File("ip.txt"));
			BufferedReader bufferedReader=new BufferedReader(f);
			ip=bufferedReader.readLine();
			bufferedReader.close();
		}catch(Exception e){
			
		}
		return ip;
	}
}
