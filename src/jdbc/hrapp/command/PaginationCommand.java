package jdbc.hrapp.command;

import jdbc.common.DBUtils;
import jdbc.hrapp.entity.Employee;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaginationCommand implements Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in) ;
        System.out.print("请输入页号：");
        int page = in.nextInt() ;
        Connection connection = null ;
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        List list = new ArrayList<Employee>() ;
        try {
            connection = DBUtils.getConnection() ;
            String sql = "select * from employee limit ?,10" ;
            stmt = connection.prepareStatement(sql) ;
            stmt.setInt(1,(page-1)*10);
            rs = stmt.executeQuery() ;
            while ( rs.next() ){
                Employee employee = new Employee() ;
                employee.setEno(rs.getInt("eno"));
                employee.setEname(rs.getString("ename"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setDname(rs.getString("dname"));
                // JDBC中获取日期是使用java.sql.Date，其继承自java.util.Date
                // 两者互相兼容
                employee.setHiredate(rs.getDate("hiredate"));
                list.add(employee) ;
            }
            System.out.println("员工数量："+list.size());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(rs,stmt,connection);
        }
    }
}
