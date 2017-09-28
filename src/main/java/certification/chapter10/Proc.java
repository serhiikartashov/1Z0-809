package certification.chapter10;

import java.sql.*;
public class Proc {
    public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

        CallableStatement stmt=con.prepareCall("{call insertR(?,?)}");
        stmt.setInt(1,1011);
        stmt.setString(2,"Amit");
        stmt.execute();

        System.out.println("success");
    }
}
