package certification.chapter10;

import java.sql.*;

/**
 * Created by Serhii K. on 3/18/2016.
 */
public class ScrollingExamples {

    private static String url = "jdbc:derby:zoo";

    public static void main(String[] args) throws SQLException {

        /*try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {

            ResultSet rs = stmt.executeQuery("select id from species order by id");
            rs.afterLast();
            System.out.println(rs.previous()); // true
            System.out.println(rs.getInt(1)); // 2
            System.out.println(rs.previous()); // true
            System.out.println(rs.getInt(1)); // 1
            System.out.println(rs.last()); // true
            System.out.println(rs.getInt(1)); // 2
            System.out.println(rs.first()); // true
            System.out.println(rs.getInt(1)); // 1
            rs.beforeFirst();
            System.out.println(rs.getInt(1)); // throws SQLException
        }*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery("select id from animal order by id");
            System.out.println(rs.absolute(2)); // true
            System.out.println(rs.getString("id")); // 2
            System.out.println(rs.absolute(0)); // false
            System.out.println(rs.absolute(5)); // true
            System.out.println(rs.getString("id")); // 5
            System.out.println(rs.absolute(-2)); // true
            System.out.println(rs.getString("id")); // 4
        }

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery("select id from animal order by id");
            System.out.println(rs.next()); // true
            System.out.println(rs.getString("id")); // 1
            System.out.println(rs.relative(2)); // true
            System.out.println(rs.getString("id")); // 3
            System.out.println(rs.relative(-1)); // true
            System.out.println(rs.getString("id")); // 2
            System.out.println(rs.relative(4)); // false
        }
    }
}
