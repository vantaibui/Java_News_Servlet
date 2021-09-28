package com.project_news_servlet.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project_news_servlet.mapper.RowMapper;
import com.project_news_servlet.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {

		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setCode(resultSet.getString("code"));
			categoryModel.setName(resultSet.getString("name"));
			categoryModel.setCreateDate(resultSet.getTimestamp("createdate"));
			categoryModel.setCreateBy(resultSet.getString("createby"));
			categoryModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			categoryModel.setModifiedBy(resultSet.getString("modifiedby"));

			return categoryModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
