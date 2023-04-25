package Connection;

import java.beans.Statement;
import java.sql.DriverManager;

public class Connection {
	private final String serverName = "LAPTOP-9RL7E1JG";
	private final String dbName = "TMDT";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "sa";
	private final String password = "123";
	public java.sql.Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public Statement createStatement() {
		return null;
	}
	public static void main(String[] args) {
		try {
			System.out.println(new Connection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
