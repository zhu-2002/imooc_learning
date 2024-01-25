package jdbc;

import java.sql.*;

public class JDBCSample {
    public static void main(String[] args) {
        Connection connection = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            // 2.创建数据库连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true",
                    "root",
                    "zyf10140715");
            stmt = connection.createStatement() ;
            rs = stmt.executeQuery("select * from employee ");
            while ( rs.next() ){
                Integer eno = rs.getInt(1) ;
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary") ;
                System.out.println(eno + "-" + ename + "-" + salary);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if ( connection != null && !connection.isClosed() ){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
