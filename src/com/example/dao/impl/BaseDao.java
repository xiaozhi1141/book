package com.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class BaseDao {
    //使用dbutils进行数据库的操作

//    private QueryRunner queryRunner = new QueryRunner();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 修改表操作
     * @param sql
     * @param args
     * @return 如果为-1则操作失败，否则返回影响行数
     */
    public int update(String sql,Object...args){
       return jdbcTemplate.update(sql,args);
    }
    /**
     *  查寻返回一个javabean的sql语句
     *  type:返回类型
     *  sql:sql语句
     *  args:sql的参数
     *  <T> :返回的类型的泛型
     */


    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        T object = null;
        try {
            object = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(type), args);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
    /**
     *  查寻返回多个javabean的sql语句
     *  type:返回类型
     *  sql:sql语句
     *  args:sql的参数
     *  <T> :返回的类型的泛型
     */

    public  <T>List<T> queryForList(Class<T> type,String sql,Object...args){
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(type), args);
    }

    /**
     *  返回单个值的情况
     *  sql:sql语句
     *  args:sql的参数
     */

    public Object queryForSingleValue(String sql,Object...args){
        return jdbcTemplate.queryForObject(sql,Object.class,args);
    }
}