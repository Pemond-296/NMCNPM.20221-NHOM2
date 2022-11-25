package com.example.dao;

import com.example.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... params);
    public Long insert(String sql, Object... params);
//    public void update(String sql, Object... params);
}
