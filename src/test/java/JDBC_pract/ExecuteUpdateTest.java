package JDBC_pract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest {

	@Test
	
	public void executeUpdateTest() throws Throwable {
		
		Connection con=null;
		try {
			Driver dr = new Driver();
			DriverManager.registerDriver(dr);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
			Statement st = con.createStatement();
			//int result = st.executeUpdate("insert into students_info (regno, firstName, middleName, lastName) values('8', 'ramyaa','sree', 'Z');");
			int result = st.executeUpdate("insert into students_info (regno, firstName, middleName, lastName) values('9', 'sri','lakshmi', 'r');");
			//int result = st.executeUpdate("insert into students_info (regno, firstName, middleName, lastName) values('3', 'ram','dev', 'Z');");
			if(result==1) {
				System.out.println("Data succesfully stored");
			}
			else
				System.out.println("Data not Stored");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
		con.close();
		}
	}
}
