package jdbc.hrapp.command;

import jdbc.common.DBUtils;

import java.sql.*;
import java.util.Scanner;

public class QueryCommand implements Command{

    @Override
    public void execute() {
        System.out.println("请输入部门名称：");
        Scanner in = new Scanner(System.in) ;
        String dname = in.next() ;
        Connection connection = null ;
//        Statement stmt = null ;
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        try {
            // 创建连接
            connection = DBUtils.getConnection();
            // 3.创建statement对象
//            stmt =  connection.createStatement() ;
//            rs = stmt.executeQuery("select * from employee where dname = '"+dname+"'");
//
            // Statement 有SQL注入的风险 开发中不建议使用
            // PreparedStatement 预编译Statement是Statement的子接口
            // PreparedStatment 对SQL进行参数化，预防SQL注入攻击
            // PreparedStatement 比Statement执行效率更高
            String sql = "select * from employee where dname = ? " ;
            stmt = connection.prepareStatement(sql) ;
            // 第一个参数是参数下标，从1开始
            stmt.setString(1,dname);
            rs = stmt.executeQuery() ;
            // 4.遍历查询结果
            // next方法返回boolean值，代表是否存在下一条记录
            while( rs.next() ){
                // JDBC中的索引都是从1开始，而非0
                Integer eno = rs.getInt(1) ;
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary") ;
                System.out.println(eno + "-" + ename + "-" + salary + "-" + dname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(rs,stmt,connection);
        }

    }
}
