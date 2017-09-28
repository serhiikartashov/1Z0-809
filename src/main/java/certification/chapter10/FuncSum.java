package certification.chapter10;

import java.sql.*;

public class FuncSum {
    public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

        CallableStatement stmt=con.prepareCall("{?= call sum4(?,?)}");
        stmt.setInt(2,10);
        stmt.setInt(3,43);
        stmt.registerOutParameter(1,Types.INTEGER);
        stmt.execute();

        System.out.println(stmt.getInt(1));

    }
}
