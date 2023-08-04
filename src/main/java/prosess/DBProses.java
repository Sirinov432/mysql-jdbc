package prosess;

import az.company.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;





public class DBProses {


    private static PreparedStatement preparedStatement = null;
    private static Connection connection = DBConnection.getConnection1();


    public static  void createStudent()  {
        try {
        String query = "CREATE TABLE student(studentId INT PRIMARY KEY NOT NULL,name VARCHAR(55),"
                +"surname VARCHAR(255),birthday INT,studentNumber VARCHAR(25))";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.println("table has created succesfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }DBConnection.closeConnection();
    }
    public static void insertStudent(){
        String query="INSERT INTO  student (studentId, name , surname , birthday, studentNumber)VALUES(?,?,?,?,?)";

        try {

            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,"Eli");
            preparedStatement.setString(3,"Sirinov");
            preparedStatement.setInt(4,2002);
            preparedStatement.setString(5,"7885544");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void updateStudent(){
        String query="UPDATE student SET name=?,surname=?,birthday=?,studentNumber=? WHERE studentId=?";
        try {
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"Umid");
            preparedStatement.setString(2,"Alizada");
            preparedStatement.setInt(3,1998);
            preparedStatement.setString(4,"524879");
            preparedStatement.setInt(5,1);
            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteStudent(){
        String query="DELETE from student WHERE studentId=?";
        try {
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,2);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
