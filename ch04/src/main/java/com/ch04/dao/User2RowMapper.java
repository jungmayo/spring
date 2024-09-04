package com.ch04.dao;

import com.ch04.dto.User2DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User2RowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        User2DTO dto = new User2DTO();
        dto.setUid(rs.getString(1));
        dto.setUid(rs.getString(2));
        dto.setUid(rs.getString(3));
        dto.setUid(rs.getString(4));
        dto.setUid(rs.getString(5));

        return dto;
    }
}