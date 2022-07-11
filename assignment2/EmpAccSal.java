package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpAccSal {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Insert Salary");
		int sal=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //
			String cs="jdbc:mysql://localhost:3306/db2"; // connection string
			try (Connection conn=DriverManager.getConnection(cs, "root", "Chandani@99")){
				

				
				PreparedStatement ps=conn.prepareStatement("select * from employee2 where salary<"+sal+"");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int i=rs.getInt("eid");
					String n=rs.getString("name");
					String ad=rs.getString("address");
					int sal1=rs.getInt("salary");
					
					System.out.println("EId: "+i);
					System.out.println("Name: "+n);
					System.out.println("Address: "+ad);
					System.out.println("Salary: "+sal1);
					System.out.println("==================================== ");
					System.out.println(" ");
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
