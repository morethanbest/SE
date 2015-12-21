package init;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ClientConfig {
	public static String getIP(){
		String ip="localhost";
		try{
			Properties properties=new Properties();
			String path=System.getProperty("user.dir")+"\\ip.properties";
			File file=new File(path);
			FileInputStream fiStream=new FileInputStream(file);
			properties.load(fiStream);
			ip=properties.getProperty("ip");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ip;
	}
	
}
