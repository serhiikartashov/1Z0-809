package certification.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        System.out.println(conn);
    }

    /*public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ocp-book",
                "username",
                "password");
        System.out.println(conn);
    }*/

    /*public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ocp-book",
                "username",
                "password");
    }*/
}
