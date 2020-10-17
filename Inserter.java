import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
  This program lets the user insert a row into the
  Registrar database's tables.
*/

public class Inserter {
   public static void main(String[] args)
   {
      
      int studentID; // To hold student's student ID 
      String firstName;  // To hold the student's first name.
      String lastName;  // To hold student's last name. 
      String birthDate; //To hold the student's birth date.
      int phone; // To hold the student's phone 
      String email; // To hold the studet's email. 
      String major; // To hold the student's major 
      String minor; // To hold the student's minor
           
      
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:RegistrarDB";
      
     // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         
         // Get the data for the new coffee.
         System.out.print("Enter the student's studentID: "); 
         studentID = keyboard.nextInt(); 
         keyboard.nextLine();
         System.out.print("Enter the student's first name: ");
         firstName = keyboard.nextLine();
         System.out.print("Enter the student's last name: ");
         lastName = keyboard.nextLine();
         System.out.print("Enter the student's birthDate: ");
         birthDate = keyboard.nextLine();
         System.out.print("Enter the student's phone number: "); 
         phone = keyboard.nextInt();
         keyboard.nextLine(); 
         System.out.print("Enter the student's email address: "); 
         email = keyboard.nextLine(); 
         System.out.print("Enter the students major: "); 
         major = keyboard.nextLine(); 
         System.out.print("Enter the student's minor if any: "); 
         minor = keyboard.nextLine(); 
         
         /*/ToDo: make it possible to not answer or submit an empty string*/ 

         // Create a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create a string with an INSERT statement.
         String sqlStatement = "INSERT INTO Stdnts " +
                      "" +
                      "VALUES ('" +
                        studentID + "', '" +
                        firstName + "', '" +
                        lastName + "', '" +
                        birthDate + "', '" +
                        email + "', '" +
                        major + "', '" +
                        minor + "', '" +
                        phone + "')";
         
         // Send the statement to the DBMS.
         int rows = stmt.executeUpdate(sqlStatement);
         
         // Display the results.
         System.out.println(rows + " row(s) added to the table.");
         
         // Close the connection.
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}





