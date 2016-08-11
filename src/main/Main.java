package main;

import db.config.ConnectToDatabase;
import java.sql.ResultSet;

/**
 *
 * @author ashik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static ConnectToDatabase connectToDatabase = new ConnectToDatabase("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/studevs", "root", "studevsdb");
    
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            
            String sql;
            ResultSet resultSet;
            
            for (int i = 0; i < 5; i++) {
                
                sql = "INSERT INTO USERS (NAME, EMAIL) VALUES('Test " + i + "', 'test" + i + "@gmail.com')";
                connectToDatabase.getResult(sql);
            }
            
//            sql = "SELECT * FROM USERS";
//            resultSet = connectToDatabase.getResult(sql);
//            
//            while (resultSet != null && resultSet.next()) {
//                
//                System.out.println("ID: " + resultSet.getString("ID") + ", Name: " + resultSet.getString("NAME") + ", Email: " + resultSet.getString("EMAIL"));
//            }
        } catch (Exception e) {
            
            throw new ExceptionInInitializerError(e);
        } finally {
            
            connectToDatabase.closeConnection();
        }
    }
}
