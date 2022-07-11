package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpWithBonus {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter bonus :");
			int bonus= sc.nextInt();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("problem with loding the driver main class");
			}
			
			String cs = "jdbc:mysql://localhost:3306/db2";
			
			try (Connection conn=DriverManager.getConnection(cs, "root", "Chandani@99")){
				
				

				PreparedStatement ps= conn.prepareStatement("update employee2 set salary = salary+"+bonus+"");	
					
//				ps.setInt(bonus, bonus);	
				
				int x = ps.executeUpdate();
				
				 if(x >0 )
					 System.out.println(x+" records updated..");
				 else
					 System.out.println("not updated");
				 
				}catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
			finally {
				sc.close();
			}
	}

}
