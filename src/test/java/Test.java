import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/course_db", "lwenjim", "111111");
        PreparedStatement stmt = conn.prepareStatement("select * from course limit ?");
        stmt.setInt(1,10);
        ResultSet st = stmt.executeQuery();
        while (st.next()) {
            System.out.println(st.getString("course_id") +" "+ st.getString("course_name"));
        }
    }

    private static void extracted(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        conn.setAutoCommit(false);
        try {
            int i = stmt.executeUpdate("update course set course_name='123' where course_id=760");
            int i2 = stmt.executeUpdate("update course set course_name='234' where course_id=760");
            if (i > 0 && i2 > 0) {
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
    }
}