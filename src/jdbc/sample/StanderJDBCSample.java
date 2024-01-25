package jdbc.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 标准JDBC操作
 */
public class StanderJDBCSample {
    public static void main(String[] args) {
        Connection connection = null ;
        try {
            // 1.加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.创建数据库连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true",
                    "root",
                    "zyf10140715");
            // 3.创建Statement对象
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("");
            // 4.遍历查询结果
            while (rs.next()) {
                // 把当前行指定位置的字段数据进行提取
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename");
                Float saraly = rs.getFloat("saraly");
                String dname = rs.getString("dname");
                System.out.println(eno + "-" + ename + "-" + saraly + "-" + dname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 5.关闭连接，释放资源
            try {
                if (connection != null && connection.isClosed() == false) {
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
