package DataTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MysqlConnector
{
	private static String url = "jdbc:mysql://localhost/java_example_factures";
	private static String user = "root";
	private static String passwd = "";
	private static Connection connect;
	public static Connection getInstance()
	{
		if(connect == null)
		{
			try
			{
			      Class.forName("com.mysql.jdbc.Driver");

			      connect = DriverManager.getConnection(url,user, passwd);
			}
			catch(SQLException | ClassNotFoundException e)
			{
				System.out.println("Connexion Impossible" + e.getMessage());
			}
		}       
		return connect;
	}
}

