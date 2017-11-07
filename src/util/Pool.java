package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class Pool {
   // private static Properties pr = new Properties();
    private static BasicDataSource datasource = new BasicDataSource();
    
    static {
    	Properties pr = new Properties();
		try {
			
			pr.load(Pool.class.getClassLoader().getResourceAsStream("DBconfig.properties"));
			
			//配置四大参数
			datasource.setDriverClassName(pr.getProperty("driver"));
			datasource.setUrl(pr.getProperty("url"));
			datasource.setUsername(pr.getProperty("user"));
			datasource.setPassword(pr.getProperty("password"));
			
			//配置池参数
		    
			datasource.setMinIdle(3);
			datasource.setMaxTotal(10);
			datasource.setMaxWaitMillis(1000);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
    public static Connection getConnection() {
    	Connection ct;
    	try {
			ct = datasource.getConnection();
			return ct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}
