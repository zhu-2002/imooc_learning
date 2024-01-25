package jdbc.hrapp.command;

import jdbc.common.DBUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 新增员工数据
 */
public class InsertCommand implements Command{

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in) ;
        System.out.print("请输入员工编号：");
        int eno = in.nextInt() ;
        System.out.print("请输入员工姓名：");
        String ename = in.next() ;
        System.out.print("请输入员工薪资：");
        Float salary = in.nextFloat() ;
        System.out.print("请输入员工隶属部门：");
        String dname = in.next() ;
        System.out.print("请输入员工入职日期：");
        String strHiredate = in.next() ;
        // String转换成java.util.Date
        // 1.String 转为java.util.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        java.util.Date hiredate = null;
        try {
            hiredate = sdf.parse(strHiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 2.java.util.Date转为java.sql.Date
        long timeBias = hiredate.getTime() ;
        java.sql.Date HireDate = new java.sql.Date(timeBias) ;

        Connection connection = null ;
        PreparedStatement stmt = null ;
        try {
            connection = DBUtils.getConnection() ;
            String sql = "insert into employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)" ;
            stmt = connection.prepareStatement(sql) ;
            stmt.setInt(1,eno);
            stmt.setString(2,ename);
            stmt.setFloat(3,salary);
            stmt.setString(4,dname);
            stmt.setDate(5,HireDate);
            int cnt = stmt.executeUpdate();
            System.out.println("[INFO]员工入职已办理,"+cnt+"条记录已成功载入");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(null,stmt,connection);
        }
    }
}
