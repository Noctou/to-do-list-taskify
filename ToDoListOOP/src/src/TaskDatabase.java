package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import static src.InsertUserToDatabase.LocalDatabaseConnect;

public class TaskDatabase {
    public static boolean deleteTask(String taskTitle) {      
        String deleteSQL = "DELETE FROM task WHERE taskTitle = ?";
        
        try (Connection connect = LocalDatabaseConnect();
             PreparedStatement query = connect.prepareStatement(deleteSQL)) {
            
            query.setString(1, taskTitle);
            return query.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertTask(String title, String description, Date deadline) {
        String insertSQL = "INSERT INTO task (taskTitle, taskDescription, taskDeadline) VALUES (?, ?, ?);";
        
        if (taskExists(title)) {
            return false;
        }

        try (Connection connect = LocalDatabaseConnect();
            PreparedStatement query = connect.prepareStatement(insertSQL)) {

            query.setString(1, title);
            query.setString(2, description);

            if (deadline != null) {
                java.sql.Date sqlDate = new java.sql.Date(deadline.getTime());
                query.setDate(3, sqlDate);
            } else {
                query.setNull(3, java.sql.Types.DATE);
            } int rowsAffected = query.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateTask(String originalTitle, String newTitle, String newDescription, Date newDeadline) {
        String updateSQL = "UPDATE task SET taskTitle = ?, taskDescription = ?, taskDeadline = ? WHERE taskTitle = ?";

        try (Connection connect = InsertUserToDatabase.LocalDatabaseConnect();
             PreparedStatement query = connect.prepareStatement(updateSQL)) {

            query.setString(1, newTitle);
            query.setString(2, newDescription);
            query.setDate(3, new java.sql.Date(newDeadline.getTime()));
            query.setString(4, originalTitle);

            int rowsAffected = query.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean taskExists(String title) {
        String checkSQL = "SELECT COUNT(*) FROM task WHERE taskTitle = ?";

        try (Connection connect = LocalDatabaseConnect();
             PreparedStatement query = connect.prepareStatement(checkSQL)) {

            query.setString(1, title);
            ResultSet resultSet = query.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
