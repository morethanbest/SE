package data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
  
public class DBHelper {  
	//寝室的ip为172.26.15.52
    private static final String url = "jdbc:mysql://172.26.15.52/delivery?"+ "useUnicode=true&characterEncoding=UTF8";  
    private static final String name = "com.mysql.jdbc.Driver";  
    private static final String user = "sunchao";  
    private static final String password = "123456";  
  
    private Connection conn = null;  
    private PreparedStatement pst = null;  
  
	public DBHelper() {  
        try {  
            Class.forName(name);//指定连接类型 
            conn = DriverManager.getConnection(url, user, password);//获取连接  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    public PreparedStatement prepare(String sql){
    	try{
    	 pst = conn.prepareStatement(sql);//准备执行语句
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	 return pst;
    }
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  
