package db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String sql = null;
    private String className;
    private String databaseURL;
    private String username;
    private String password;
    private Exception expections;

    public Exception getExpections() {
        return expections;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ConnectToDatabase(String className, String databaseURL, String username, String password) {
        this.className = className;
        this.databaseURL = databaseURL;
        this.username = username;
        this.password = password;
        
        this.setConnection();
    }

    private void setConnection() {

        try {

            Class.forName(this.className);
            this.connection = DriverManager.getConnection(this.databaseURL, this.username, this.password);
            this.statement = this.connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {

            this.expections = e;
        }
    }

    private void executeQuery() {

        try {

//            this.setConnection();
            this.statement.execute(sql);
            this.resultSet = this.statement.getResultSet();
        } catch (SQLException ex) {

            this.expections = ex;
        }
    }

    public ResultSet getResult(String sql) {

        this.sql = sql;
        this.executeQuery();
        return this.resultSet;
    }

    public void closeConnection() {

        try {

            this.connection.close();
            this.statement.close();
            this.resultSet.close();
            this.sql = null;
        } catch (Exception e) {

            this.expections = e;
        }
    }
}

