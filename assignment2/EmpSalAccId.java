package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpSalAccId {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String cs="jdbc:mysql://localhost:3306/db2";
			try(Connection conn=DriverManager.getConnection(cs,"root","Chandani@99")){
				PreparedStatement ps=conn.prepareStatement("select salary from employee2 where eid="+id+"");
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					System.out.println("Salary :" +rs.getInt("salary"));
					
				}else {
					System.out.println("Record not found..");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //
		

	}

}
