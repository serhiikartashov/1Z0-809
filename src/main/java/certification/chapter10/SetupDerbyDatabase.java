package certification.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class SetupDerbyDatabase {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:derby:zoo;create=true";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DROP TABLE animal");
            stmt.executeUpdate("DROP TABLE species");


            stmt.executeUpdate("CREATE TABLE species ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL)");
            stmt.executeUpdate(
                    "CREATE TABLE animal ("
                            + "id INTEGER PRIMARY KEY, "
                            + "species_id integer, "
                            + "name VARCHAR(255), "
                            + "date_born TIMESTAMP)");
            stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
            stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
            stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', '2001-05-06 02:15:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', '2002-08-15 09:12:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', '2002-09-09 10:36:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', '2010-06-08 01:24:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2005-11-12 03:44:00')");
        }
    }
}
