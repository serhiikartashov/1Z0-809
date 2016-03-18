package certification.chapter10;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Serhii K. on 3/18/2016.
 */
public class ReadingResultSet {

    private static String url = "jdbc:derby:zoo";

    public static void main(String[] args) throws SQLException {
        Map<Integer, String> idToNameMap = new HashMap<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("select id, name from species");
            while(rs.next()) {
//                int id = rs.getInt("id");
                int id = rs.getInt(1);
//                String name = rs.getString("name");
                String name = rs.getString(2);
                idToNameMap.put(id, name);
            }
            System.out.println(idToNameMap); // {1=African Elephant, 2=Zebra}
        }

    }
}
