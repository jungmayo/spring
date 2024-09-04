package com.ch04.dao;

import com.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User2DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User2DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    public void insertUser2(User2DTO dto){
        String sql = "insert into user2 values(?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAddr()
        };
        jdbcTemplate.update(sql,params);


    }
    public User2DTO selectUser2(String uid){

        String sql = "select * from user2 where uid=?";
        User2DTO dto = (User2DTO) jdbcTemplate.query(sql, new User2RowMapper(), uid);
        return dto;
    }

    public List<User2DTO> selectUser2s(){

        String sql = "select * from user2";
        return jdbcTemplate.query(sql, new User2RowMapper());
    }

    public void updateUser2(User2DTO dto){

    }
    public void deleteUser2(String uid){

    }
}
