package JDBC_pract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataTest {
	
	@Test
	
	
	public void verifytheDataTest() throws SQLException {
		
		String expectedData= "sruthi";
		
		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
		//step 3 create statement
		Statement stmt = con.createStatement();
		//step 4 execute query
		ResultSet result = stmt.executeQuery("select * from students_info");
		while(result.next())
		{
			String actualData = result.getString(2);
			if(actualData.equals(expectedData)) {
				System.out.println(expectedData+" is present");
				break;
			}
			else {
				
			}
		}
		
		
	}

}
