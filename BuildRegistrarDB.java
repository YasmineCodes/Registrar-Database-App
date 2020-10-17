import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;


/**
  This program shows how to create a new database   *
 using Java DB.                                    *
*/

 
public class BuildRegistrarDB
{
   
   public static void main(String[] args)
                      throws Exception
   {
      //DriverManager.registerDriver(org.apache.derby.jdbc.EmbeddedDriver());
      //Class.forName("com.mysql.jdbc.Driver");
     
     // final String DB_URL =
            //"jdbc:mysql://localhost:3306/sys";
      final String DB_URL = "jdbc:derby:RegistrarDB;create=true";
      try
      {    
         // Create a connection to the database.
         Connection conn = 
                    DriverManager.getConnection(DB_URL);
            
         // Create a Statement object.
         Statement stmt = conn.createStatement();
            
         // Create the Dvd table.
         System.out.println("Creating the Students table...");
         /*stmt.execute("CREATE TABLE myStudents ("    +
                     "StudentID INTEGER NOT NULL PRIMARY KEY, " +
                     "FirstName CHAR(20) NOT NULL, " +
                     "LastName CHAR(20) NOT NULL, " +
                     "BirthDate DATE NOT NULL, " +
                     "Phone INTEGER NOT NULL, " +
                     "Email CHAR(30) CHECK (email LIKE '%@%'), " + 
                     "Major CHAR(15)," +
                     "Minor CHAR(15))");*/
         ResultSet output = stmt.executeQuery("select * from stdnts"); 
         System.out.print(output); 
         /*stmt.executeQuery("Select * from stdnts"); */

        /* stmt.execute("create table courses ( " +
                     "department char(15) not null," + 
                     "courseID char(8) not null primary key," + 
                     "courseName char(20) not null," + 
                     "prerequisites char(50)," + 
                     "credits integer not null, " + 
                     "courseAttribute char(20))"); 
         
         stmt.execute("create table studentGrades (" +
                     "studentID INTEGER not null," +
                     "courseID char(8) not null," +
                     "term Char(10) not null," +
                     "grade float," +
                     "studentGPA float, " +
                     "constraint PK_CourseGrade primary key (studentID, courseID), " + 
                     "constraint FK_studentID foreign key (studentID) " +
                     "references stdnts(studentID)," + 
                     "constraint FK_courseID foreign key (courseID) " +
                     "references courses(courseID))"); */

          /*stmt.execute("CREATE TABLE StudentEnrollment (studentID Integer not null, " + 
          "courseID char(8) not null, " + 
          "credits Integer not null, " + 
          "department char(15), " + 
          "instructor char(10), " + 
          "constraint PK_Enrollment primary key (courseID, studentID), " + 
          "constraint FK_toStudents foreign key(studentID) " + 
          "references stdnts(studentID), " + 
          "constraint FK_toCourses foreign key (courseID) " + 
          "references courses(courseID))");  */         

                   
                     
         /*stmt.execute("create table Bursar " + 
                     "(billingID integer not null primary key," +
                     "studentID integer not null, " + 
                     "amountDue float not null, " +
                     "lastPaymentAmount float, " +
                     "lastPaymentDate date, " + 
                     "constraint FK_billingStudentID foreign key (studentID) " + 
                     "references stdnts(studentID))");*/
         
           
         // Close the resources.
         stmt.close();     
         conn.close();
         System.out.println("Done");
       
      }
      catch(Exception ex)
      {
        System.out.println("ERROR: " + ex.getMessage());
     }
  } 
}