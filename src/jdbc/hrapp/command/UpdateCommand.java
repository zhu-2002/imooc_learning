package jdbc.hrapp.command;

import jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCommand implements Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in) ;
        System.out.print("请输入员工编号：");
        int eno = in.nextInt();
        System.out.print("请输入员工新的薪资：");
        float salary = in.nextFloat() ;
        Connection connection = null ;
        PreparedStatement stmt = null ;
        try{
            connection = DBUtils.getConnection() ;
            String sql = "update employee set salary = ? where eno = ?";
            stmt = connection.prepareStatement(sql) ;
            stmt.setFloat(1,salary);
            stmt.setInt(2,eno);
            int cnt = stmt.executeUpdate() ;
            if ( cnt == 1 ) {
                System.out.println("[INFO]编号为：" + eno + "的员工薪资已修改," + cnt + "条记录已成功载入");
            }
            else{
                System.out.println("[INFO]暂无该员工信息");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtils.closeConnection(null,stmt,connection);
        }
    }
}
