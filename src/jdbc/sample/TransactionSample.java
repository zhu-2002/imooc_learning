package jdbc.sample;

import jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionSample {
    public static void main(String[] args) {
        Connection connection = null ;
        PreparedStatement stmt = null ;
        try {
            connection = DBUtils.getConnection();
            String sql = "insert into employee(eno,ename,salary,dname) values (?,?,?,?)" ;
            // JDBC默认会执行自动提交模式
            // 关闭JDBC自动提交
            connection.setAutoCommit(false);
            for ( int i = 2000 ; i <2010 ; i++){
//                if ( i == 2005 ){
//                    throw new RuntimeException("插入失败");
//                }
                stmt = connection.prepareStatement(sql) ;
                stmt.setInt(1,i) ;
                stmt.setString(2,"员工"+i) ;
                stmt.setFloat(3,4000) ;
                stmt.setString(4,"市场部") ;
                stmt.executeUpdate() ;
            }
            // 手动提交
            connection.commit();
         } catch (Exception e) {
            e.printStackTrace();
            try {
                if( connection != null & !connection.isClosed() ){
                    // 手动回滚
                    connection.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }finally {
            DBUtils.closeConnection(null,stmt,connection);
        }
    }
}
