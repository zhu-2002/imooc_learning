package jdbc.common;

import java.sql.*;

public class DBUtils {
    /**
     * 创建新的数据库连接
     * @return 新的数据库连接
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 1.加载并注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver" );
        // 2.创建并建立数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true",
                "root",
                "zyf10140715");
        return connection ;
    }

    /**
     * 关闭连接，释放资源
     * @param rs ResultSet对象
     * @param stmt PreparedStatement对象
     * @param connection Connection对象
     */
    public static void closeConnection(ResultSet rs, PreparedStatement stmt, Connection connection){
        // 关闭连接，释放资源
        try {
            if( rs != null ){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if( stmt != null ){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if ( connection != null && !connection.isClosed() ){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
