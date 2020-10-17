import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
  This program lets the user delete a student
  from the Registrar database's Coffee table.
*/

public class StudentDeleter{
   public static void main(String[] args)
   {
      int studentID;   // To hold the studentID
      String sure;      // To make sure the user wants to delete

      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:RegistrarDB";

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);

      try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);

         // Create a Statement object.
         Statement stmt = conn.createStatement();

         // Get the studentID for the desired coffee.
         System.out.print("Enter the student ID: ");
         studentID = keyboard.nextInt();

         // Display the coffee's current data.
         if (findAndDisplayStudent(stmt, studentID))
         {
            // Make sure the user wants to delete this student
            System.out.print("Are you sure you want to delete " +
                             "this student? (y/n): ");
            sure = keyboard.nextLine();

            if (Character.toUpperCase(sure.charAt(0)) == 'Y')
           {
               // Delete the specified coffee.
               deleteStudent(stmt, studentID);
            }
            else
            {
               System.out.println("The student was not deleted.");
            }
         }
         else
         {
            // The specified studentID was not found.
            System.out.println("That student was not found.");
         }

         // Close the connection.
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /**
     The findAndDisplayStudent method finds a specified students
     data and displays it.
     @param stmt A Statement object for the database.
     @param studentID The ID number for the desired student.
     @return true or false to indicate whether the studentID was found.
   */

   public static boolean findAndDisplayStudent(Statement stmt,
                                               int studentID)
                                               throws SQLException
   {
      boolean studentFound; // Flag

      // Create a SELECT statement to get the specified
      // row from the Coffee table.
      String sqlStatement =
         "SELECT * FROM Stdnts WHERE StudentID = '" +
         studentID + "'";

      // Send the SELECT statement to the DBMS.
      ResultSet result = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      if (result.next())
      {
            // Display the student's information.
            System.out.println("First Name: " +
                               result.getString("FirstName"));
            System.out.println("Last Name: " + 
                                results.getString("LastName")); 
            System.out.println("StudentID: " +
                              result.getString("StudentID"));
            

            // Set the flag to indicate the student was found.
            studentFound = true;
      }
      else
      {
         // Indicate the student was not found.
         studentFound = false;
      }

      return studentFound;
   }

   /**
     The deleteStudent method deletes a specified student.
     @param stmt A Statement object for the database.
     @param studentID The ID for the desired student.
   */

   public static void deleteStudent(Statement stmt, String studentID)
                                   throws SQLException
   {
      // Create a DELETE statement to delete the
      // specified StudentID.
      String sqlStatement = "DELETE FROM Stdnts " +
                            "WHERE StudentID = '" + studentID + "'";

      // Send the DELETE statement to the DBMS.
      int rows = stmt.executeUpdate(sqlStatement);

      // Display the results.
      System.out.println(rows + " row(s) deleted.");
   }
}
