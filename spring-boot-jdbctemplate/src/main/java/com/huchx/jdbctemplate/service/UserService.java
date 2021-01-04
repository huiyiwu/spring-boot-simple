package com.huchx.jdbctemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    // =====================================================================
    // **************************动态连接数据库使用**************************
    // =====================================================================
//   private JdbcTemplate initJdbcTemplate(){
//       DriverManagerDataSource dataSource = new DriverManagerDataSource();
//       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//       dataSource.setUrl("jdbc:mysql://localhost:3306/spring_boot?serverTimezone=UTC");
//       dataSource.setUsername("root");
//       dataSource.setPassword("123456");
//       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//       return jdbcTemplate;
//   }
//
//    /**
//     * 查询
//     * @return
//     */
//    public List<Map<String,Object>> select() {
//        JdbcTemplate jdbcTemplate = initJdbcTemplate();
//        String sql = "Select * from m_user";
//        List<Map<String,Object>> users = jdbcTemplate.queryForList(sql);
//        return users;
//    }
//
//    /**
//     * 插入
//     */
//    public void insert(String name) {
//        JdbcTemplate jdbcTemplate = initJdbcTemplate();
//        String sql = "insert into m_user (id,name) values (null,?)";
//        jdbcTemplate.update(sql,name);
//    }
//
//    /**
//     * 更新
//     */
//    public void update(int id,String name) {
//        JdbcTemplate jdbcTemplate = initJdbcTemplate();
//        String sql = "update m_user set name = ? where id = ?";
//        jdbcTemplate.update(sql,name,id);
//    }
//
//    /**
//     * 删除
//     */
//    public void delete(int id) {
//        JdbcTemplate jdbcTemplate = initJdbcTemplate();
//        String sql = "delete from m_user where id = ?";
//        jdbcTemplate.update(sql,id);
//    }

    // ============================================================================
    // **************************配置文件连接数据库使用部分**************************
    // ============================================================================
   @Autowired
   JdbcTemplate jdbcTemplate;
        /**
     * 查询
     * @return
     */
    public List<Map<String,Object>> select() {

        String sql = "Select * from m_user";
        List<Map<String,Object>> users = jdbcTemplate.queryForList(sql);
        return users;
    }

    /**
     * 插入
     */
    public void insert(String name) {
        String sql = "insert into m_user (id,name) values (null,?)";
        jdbcTemplate.update(sql,name);
    }

    /**
     * 更新
     */
    public void update(int id,String name) {
        String sql = "update m_user set name = ? where id = ?";
        jdbcTemplate.update(sql,name,id);
    }

    /**
     * 删除
     */
    public void delete(int id) {
        String sql = "delete from m_user where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
