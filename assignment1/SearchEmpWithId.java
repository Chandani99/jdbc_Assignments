package assignment1;
import java.sql.*;
import java.util.Scanner;

public class SearchEmpWithId {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter EID :");
		int eid= sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("problem with loding the driver main class");
		}
		
		String cs = "jdbc:mysql://localhost:3306/db1";
		
		try (Connection conn=DriverManager.getConnection(cs, "root", "Chandani@99")){
			
		PreparedStatement ps= conn.prepareStatement("select * from employee where eid= "+eid+"");
			
		ResultSet rs= ps.executeQuery();
		
		
		    rs.next();
		    
		    int e= rs.getInt("Eid");
			String n= rs.getString("name");
			String a= rs.getString("address");
			int s= rs.getInt("salary");
			
			
			System.out.println("Eid is :"+e);
			System.out.println("Name is :"+n);
			System.out.println("Adderss is :"+a);
			System.out.println("Salary is :"+s);
			
			System.out.println("=========================");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			sc.close();
		}

	}

}
