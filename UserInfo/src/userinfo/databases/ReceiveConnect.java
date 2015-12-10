package userinfo.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReceiveConnect {
private static Connection connectDataBase;
	
	private ReceiveConnect() {
		System.setProperty("jdbc.driver", "org.postgresql.Driver");
	}
	
	public static Connection getConnectionDatabase(){
		if(null==connectDataBase){
			try {
				connectDataBase= DriverManager.getConnection("jdbc:postgresql://10.0.1.5/user_secyrity", "sa", "1q2w3e4r");
				return connectDataBase;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connectDataBase;
	}
}
