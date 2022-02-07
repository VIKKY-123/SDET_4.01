package JDBC_pract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryT {
	
	public void executeQuery() throws SQLException {
		
		Connection con=null;
		try {
			Driver dri=new Driver();
			DriverManager.registerDriver(dri);
			
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


