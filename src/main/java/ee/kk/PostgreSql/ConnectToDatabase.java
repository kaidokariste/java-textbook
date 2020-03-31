package ee.kk.PostgreSql;

import java.sql.*;

public class ConnectToDatabase {
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect(String dbUrl, String dbUser, String dbPassword) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println (e);
            System.exit (-1);
        }

        try {
            // open connection to database
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            // build query, here we get info about all databases"
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}