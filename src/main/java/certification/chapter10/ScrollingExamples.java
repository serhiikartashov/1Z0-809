package certification.chapter10;

import java.sql.*;

/**
 * Created by Serhii K. on 3/18/2016.
 */
public class ScrollingExamples {

    private static String url = "jdbc:derby:zoo";
//    private static String oracle_url = "jdbc:oracle:thin:@localhost:1521:zoo";

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


//        try{
//            //Assume a valid connection object conn
//            conn.setAutoCommit(false);
//            Statement stmt = conn.createStatement();
//
//            String SQL = "INSERT INTO Employees  " +
//                    "VALUES (106, 20, 'Rita', 'Tez')";
//            stmt.executeUpdate(SQL);
//            //Submit a malformed SQL statement that breaks
//            String SQL = "INSERTED IN Employees  " +
//                    "VALUES (107, 22, 'Sita', 'Singh')";
//            stmt.executeUpdate(SQL);
//            // If there is no error.
//            conn.commit();
//        }catch(SQLException se){
//            // If there is any error.
//            conn.rollback();
//        }
//
//
//
//        // Create statement object
//        Statement stmt = conn.createStatement();
//
//        // Set auto-commit to false
//        conn.setAutoCommit(false);
//
//        // Create SQL statement
//        String SQL = "INSERT INTO Employees (id, first, last, age) " +
//                "VALUES(200,'Zia', 'Ali', 30)";
//        // Add above SQL statement in the batch.
//        stmt.addBatch(SQL);
//
//        // Create one more SQL statement
//        String SQL = "INSERT INTO Employees (id, first, last, age) " +
//                "VALUES(201,'Raj', 'Kumar', 35)";
//        // Add above SQL statement in the batch.
//        stmt.addBatch(SQL);
//
//        // Create an int[] to hold returned values
//        int[] count = stmt.executeBatch();
//
//        //Explicitly commit statements to apply changes
//        conn.commit();
    }
}
