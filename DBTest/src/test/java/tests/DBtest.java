package tests;

import static org.testng.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DBtest 
{
	static Connection con = null;
	private static Statement stmt;
	public static String DB_URL = "jdbc:mysql://localhost:3306/user";
	public static String DB_USER = "root";
	public static String DB_PASSWORD = "dima1234";
	public static String string0 = null;
	public static String string1 = null;
	
	@BeforeTest
	public void setUp() throws Exception
	{
	//Opening connection
		String dbClass = "com.mysql.cj.jdbc.Driver";
		Class.forName(dbClass).getDeclaredConstructor().newInstance();
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = con.createStatement();
	}
	
	@Test
	public void tst() throws SQLException 
	{
	//Getting table via query
		String query = "SELECT * FROM userinfo WHERE userName = 'shruti'";
		ResultSet res = stmt.executeQuery(query);
		while (res.next())
		{
			string0 = res.getString(1);
		}
		assertEquals("shruti",string0);
		
	}
	
	@AfterTest
	public void tearDown() throws Exception 
	{
	// Close DB connection
		if (con != null) 
		{
				con.close();
		}
	}	

}
