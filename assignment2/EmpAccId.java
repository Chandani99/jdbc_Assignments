package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpAccId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id..");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //
			String cs="jdbc:mysql://localhost:3306/db2"; // connection string
			try {
				Connection conn=DriverManager.getConnection(cs, "root", "Chandani@99");
		
				
				PreparedStatement ps=conn.prepareStatement("select * from employee2 where eid= "+id+"");
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					int e= rs.getInt("Eid");
					String n= rs.getString("name");
					String a= rs.getString("address");
					int s= rs.getInt("salary");
					
					
					System.out.println("Eid is :"+e);
					System.out.println("Name is :"+n);
					System.out.println("Adderss is :"+a);
					System.out.println("Salary is :"+s);
					
					System.out.println("=========================");    
					    
				}
				else {
					System.out.println("Record does not exists ");	
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
