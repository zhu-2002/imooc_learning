package jdbc.sample;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdbc.hrapp.entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DbUtilsSample {
    // 数据查询
    private static void query(){
        Properties properties = new Properties( );
        String propertyFile = DbUtilsSample.class.getResource("/jdbc/druid/druid-config.properties").getPath() ;
        try {
            propertyFile = URLDecoder.decode(propertyFile,"UTF-8") ;
            properties.load(new FileInputStream(propertyFile));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties) ;
            // DBUtils查询执行者
            QueryRunner qr = new QueryRunner(dataSource) ;
            // BeanListHandler<>()自动将结果转换成实体类
            // object数组中的参数要与？一一对应
            List<Employee> list = qr.query("select * from employee limit ?,10",
                    new BeanListHandler<>(Employee.class),
                    new Object[]{10});
            for ( Employee emp : list ){
                System.out.println(emp.getEname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 数据更新
    public static void update(){
        Properties properties = new Properties( );
        String propertyFile = DbUtilsSample.class.getResource("/jdbc/druid/druid-config.properties").getPath() ;
        Connection connection = null ;
        try {
            propertyFile = URLDecoder.decode(propertyFile,"UTF-8") ;
            properties.load(new FileInputStream(propertyFile));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties) ;
            // 写操作基于事务，所以写操作必须获取到数据库连接
            connection = dataSource.getConnection() ;
            connection.setAutoCommit(false);
            String sql1 = "update employee set salary=salary+1000 where eno =?" ;
            String sql2 = "update employee set salary=salary-1000 where eno =?" ;
            QueryRunner qr = new QueryRunner() ;
            qr.update(connection,sql1,new Object[]{1000}) ;
            qr.update(connection,sql2,new Object[]{1001}) ;
            connection.commit();
        } catch (Exception e) {
                try {
                    if( connection != null && !connection.isClosed() ){
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            e.printStackTrace();
        }finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    // 回收非关闭
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        update();
    }
}
