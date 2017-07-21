package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.ResultSet;
//import java.sql.Statement;



public class ConnectorDB {
	
	 // JDBC URL, username and password of MySQL server
	
    private static final String url = "jdbc:mysql://localhost:3333/monolit";
    private static final String user = "root";
    private static final String password = "masterkey";
 
    //Метод возвращает соединение с параметрами url, user, password
    public static Connection getConnection(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Не найден JDBC драйвер для MySQL");
			e1.printStackTrace();
		}
    	
    	Connection connection = null;
    	try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
    } 
    
    
    //private static ResultSet resultSet;
    
 
}
