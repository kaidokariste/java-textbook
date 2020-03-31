package ee.kk.PostgreSql;

import java.sql.*;
import java.util.logging.*;

public class Example {
    public static void main(String[] args) {

        //Initiate database connection class
        ConnectToDatabase dbConnect = new ConnectToDatabase();

        /*
         * Prepare SQL query -- SELECT
         */
        try {
            Connection conn = dbConnect.connect("jdbc:postgresql://myServer:5432/myDatabase", "myUser", "myPassword");

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM myTable");
            ResultSet rs = stmt.executeQuery();

            // Loop trough result set to get the information
            while (rs.next()) {
                System.out.println(rs.getInt("columnOneName"));  // Get Integer data from column one
                System.out.println(rs.getArray("columnTwoName")); // getArray data from column two
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Example.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
