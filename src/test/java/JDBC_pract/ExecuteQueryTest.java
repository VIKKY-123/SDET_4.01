package JDBC_pract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;


public class ExecuteQueryTest {
	@Test
	
	public void executeQueryTest() throws SQLException  {
		//step1 Register the driver with java
		//step2 create connection with database
		Connection con=null;
		try {
			Driver driref=new Driver();
			
			
			DriverManager.registerDriver(driref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
			//step 3 create statement
			Statement stmt = con.createStatement();
			//step 4 execute query
			ResultSet result = stmt.executeQuery("select * from students_info");
			while(result.next())
			{
				System.out.println(result.getInt(3)+" "+result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("Connection closed");
		//step 5 close connection with database
		con.close();
	}}
		
	

}
