package com.example.dao.impl;

import com.example.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用dbutils进行数据库的操作
        private QueryRunner queryRunner = new QueryRunner();
        public int update(String sql,Object...args){
            Connection connection = JdbcUtils.getConnection();
            try {
                return queryRunner.update(connection,sql,args);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JdbcUtils.close(connection);
            }
            return -1;
        }
    /**
     *  查寻返回一个javabean的sql语句
     *  type:返回类型
     *  sql:sql语句
     *  args:sql的参数
     *  <T> :返回的类型的泛型
     */


        public <T> T queryForOne(Class<T> type,String sql,Object...args){
            Connection connection = JdbcUtils.getConnection();
            try {
               return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JdbcUtils.close(connection);
            }
            return null;
        }
    /**
     *  查寻返回多个javabean的sql语句
     *  type:返回类型
     *  sql:sql语句
     *  args:sql的参数
     *  <T> :返回的类型的泛型
     */

        public  <T>List<T> queryForList(Class<T> type,String sql,Object...args){
            Connection connection = JdbcUtils.getConnection();
            try {
                return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JdbcUtils.close(connection);
            }
            return null;
        }

    /**
     *  返回单个值的情况
     *  sql:sql语句
     *  args:sql的参数
     */

      public Object queryForSingleValue(String sql,Object...args){
          Connection connection = JdbcUtils.getConnection();
          try {
              return queryRunner.query(connection,sql,new ScalarHandler(),args);
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }finally {
              JdbcUtils.close(connection);
          }
          return null;
      }
}
