package JdbcDemo;

import java.sql.*;

public class JdbcPreparedStatement {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        JdbcConfig.getUrl(),
                        JdbcConfig.getUser(),
                        JdbcConfig.getPassword()
                );

                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT DISTINCT loan_type FROM bank_loans WHERE bank_name=?"
                );
                )
        {
            pstmt.setString(1, "Citibank");
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()) {
                System.out.println("Loan Type = " + resultSet.getString("loan type"));
            }
        } catch (SQLException ex) { 
            ex.printStackTrace();
        }
    }
}
