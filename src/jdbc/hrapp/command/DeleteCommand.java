package jdbc.hrapp.command;

import jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCommand implements Command{

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in) ;
        System.out.print("请输入员工编号：");
        int eno = in.nextInt();
        Connection connection = null ;
        PreparedStatement stmt = null ;
        try{
            connection = DBUtils.getConnection() ;
            String sql = "delete from employee where eno = ?";
            stmt = connection.prepareStatement(sql) ;
            stmt.setInt(1,eno);
            int cnt = stmt.executeUpdate() ;
            if ( cnt == 1 ) {
                System.out.println("[INFO]编号为：" + eno + "的员工离职手续已完成," + cnt + "条记录已成功删除");
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
