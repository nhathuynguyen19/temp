package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class Connector {
	public static Connection connection;
	public static Logger logger = Logger.getLogger(Connector.class.getName());
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://LAB401-25:1433;databaseName=SinhVienTin;user=sa;password=123;encrypt=false;trustCertificate=true";
	
	public void connect() throws Exception {
		Class.forName(driver);
		logger.info("Da phat hien driver");
		connection = DriverManager.getConnection(url);
		logger.info("Ket noi database thanh cong");
	}
	
	public void disconnect() throws Exception {
		connection.close();
	}
}
