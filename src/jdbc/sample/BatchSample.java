package jdbc.sample;

import jdbc.common.DBUtils;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchSample {
    // 标准方式插入若干数据
    public static void tc1(){
        Connection connection = null ;
        PreparedStatement stmt = null ;
        try {
            long startTime = new Date().getTime() ;
            connection = DBUtils.getConnection();
            String sql = "insert into employee(eno,ename,salary,dname) values (?,?,?,?)" ;
            // JDBC默认会执行自动提交模式
            // 关闭JDBC自动提交
            connection.setAutoCommit(false);
            for ( int i = 62010 ; i <72010 ; i++){
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
            long endTime = new Date().getTime() ;
            System.out.println("tc1()执行时长"+(endTime-startTime));
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
    // 使用批处理插入若干数据
    public static void tc2(){
        Connection connection = null ;
        PreparedStatement stmt = null ;
        try {
            long startTime = new Date().getTime() ;
            connection = DBUtils.getConnection();
            String sql = "insert into employee(eno,ename,salary,dname) values (?,?,?,?)" ;
            // JDBC默认会执行自动提交模式
            // 关闭JDBC自动提交
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(sql) ;
            for ( int i = 82010 ; i <92010 ; i++){
//                if ( i == 2005 ){
//                    throw new RuntimeException("插入失败");
//                }
                stmt.setInt(1,i) ;
                stmt.setString(2,"员工"+i) ;
                stmt.setFloat(3,4000) ;
                stmt.setString(4,"市场部") ;
//                stmt.executeUpdate() ;
                stmt.addBatch();
            }
            //执行批处理任务
            stmt.executeBatch() ;
            // 手动提交
            connection.commit();
            long endTime = new Date().getTime() ;
            System.out.println("tc2()执行时长"+(endTime-startTime));
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
    public static void main(String[] args) {
        tc1();
        tc2();
    }
}
