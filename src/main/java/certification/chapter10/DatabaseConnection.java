package certification.chapter10;

import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             // scroll and concur types
             //Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("select name from animal")) {
            while (rs.next())
                System.out.println(rs.getString(1));
        }
    }
}
