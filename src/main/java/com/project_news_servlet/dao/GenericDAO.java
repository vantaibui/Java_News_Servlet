package com.project_news_servlet.dao;

import java.util.List;

import com.project_news_servlet.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
}
