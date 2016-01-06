package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.DriverManager;

public class ConnectJDBC {
	private Connection connect;

	public ConnectJDBC() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://192.168.1.129/wqftest?"
							+ "user=test&password=test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connect;
	}

	/*public static void main(String[] args) {
		ConnectJDBC connectJDBC = new ConnectJDBC();
		Connection connetion = connectJDBC.getConnection();
		try {
			selectAll(connetion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}*/

	private static void selectAll(java.sql.Connection conn) throws SQLException {
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from status_info");
		while (resultSet.next()) {
			String name = resultSet.getString("STATUS_NAME");
			String population = resultSet.getString("STATUS");
			System.out.print("ÖÐÎÄ:" + name+" , ");
			System.out.println("Æ´Òô:" + population);
		}
	}
}
