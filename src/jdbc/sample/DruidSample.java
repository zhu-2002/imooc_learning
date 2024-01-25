package jdbc.sample;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdbc.common.DBUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidSample {
    public static void main(String[] args) {
        // 1.加载属性文件
        Properties properties = new Properties() ;
        String propertyFile = DruidSample.class.getResource("/jdbc/druid/druid-config.properties").getPath() ;
        try {
            // 空格->%20
            //下面的方法会将%20还原成空格，防止路径不对
            propertyFile = URLDecoder.decode(propertyFile,"UTF-8") ;
            properties.load(new FileInputStream(propertyFile));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.获取DataSource数据源对象
        // 数据源就是数据库在JDBC中的别称
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties) ;
            // 3.创建数据库连接
            connection = dataSource.getConnection() ;
            String sql = "select * from employee limit 0,10" ;
            pstmt = connection.prepareStatement(sql) ;
            rs = pstmt.executeQuery() ;
            while ( rs.next() ){
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename") ;
                float  salary = rs.getFloat("salary") ;
                String dname = rs.getString("dname") ;
                System.out.println(eno + "-" + ename + "-" + salary + "-" + dname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            /**
             * 不使用连接池：connection.close() 关闭连接
             * 使用连接池：connection.clode() 将连接回收至连接池
             */
            DBUtils.closeConnection(rs,pstmt,connection);
        }

    }
}
