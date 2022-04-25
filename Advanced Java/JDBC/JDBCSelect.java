package JdbcDemo;

import java.sql.*;

public class JDBCSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        // 1. allocate a connection object to database
        try {
            conn = DriverManager.getConnection(
                    JdbcConfig.getUrl(),
                    JdbcConfig.getUser(),
                    JdbcConfig.getPassword()
            );
            stmt = conn.createStatement();

            String strSelect = "select title, price, qty from books";
            System.out.println("The sql query is " + strSelect + "\n");

            ResultSet resultSet = stmt.executeQuery(strSelect);
            System.out.println("The records selected are: ");
            int rowCount = 0;

            while(resultSet.next()) {
                String title = resultSet.getString("title");
                String price = resultSet.getString("price");
                int qty = resultSet.getInt("qty");

                System.out.println(title + ", " + price + ", " + qty);
                rowCount++;
            }

            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
