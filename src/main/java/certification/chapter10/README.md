![Connection URL](connection_url.png)

Examples:
```
jdbc:derby:zoo

jdbc:postgresql://localhost/zoo
jdbc:oracle:thin:@123.123.123.123:1521:zoo
jdbc:mysql://localhost:3306/zoo?profileSQL=true
```
![JDBC3 vs JDBC4](jdbc3_vs_jdbc4.png)

![ResultSet Types](resultset_types.png)

![ResultSet Types](resultset_types_concurent.png)

```
PreparedStatement ps = conn.prepareStatement("delete from animal where name = ?");
ps.setString(1, name);
ps.execute();
```
performance, security, and readability

![Execute Methods](executes.png)

![ResultSet Methods](resultset.png)

```
java.sql.Time sqlTime = rs.getTime(1);
LocalTime localTime = sqlTime.toLocalTime();

java.sql.Timestamp sqlTimeStamp = rs.getTimestamp(1);
LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();
```

![JDBC date and time types](jdbc_sql_time.png)

![Scrolling Methods](scrolling_methods.png)

![Absolute method](absolute.png)