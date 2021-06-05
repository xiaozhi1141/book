package com.example.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 打开连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = conns.get();
        if(conn == null){
            try {
                conn = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(conn);//保存到ThreadLocal对象中,供后面jdbc操作使用

                conn.setAutoCommit(false);//设置为手动管理事务
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if(connection != null){ //如果不等于null,说明之前使用过连接操作过数据库
            try {
                connection.commit(); //提交事务
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close(); //关闭连接，释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove()操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if(connection != null){ //如果不等于null,说明之前使用过连接操作过数据库
            try {
                connection.rollback(); //回滚事务
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close(); //关闭连接，释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove()操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }
//    /**
//     * 关闭连接
//     * @param conn
//     */
//    public static void close(Connection conn){
//    if(conn != null){
//        try {
//            conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    }
}