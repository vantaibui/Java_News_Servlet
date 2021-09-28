package com.project_news_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.project_news_servlet.connection.ConnectionDB;
import com.project_news_servlet.dao.ICategoryDAO;
import com.project_news_servlet.mapper.impl.CategoryMapper;
import com.project_news_servlet.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

	String jdbcDriver = resourceBundle.getString("jdbcDriver");
	String hostName = resourceBundle.getString("hostName");
	String dbName = resourceBundle.getString("dbName");
	String username = resourceBundle.getString("username");
	String password = resourceBundle.getString("password");

	@Override
	public List<CategoryModel> findAll() {

		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());

	}

	@Override
	public CategoryModel findOneByCode(String code) {
		List<CategoryModel> results = new ArrayList<CategoryModel>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "SELECT * FROM category WHERE code = ?";

		connection = ConnectionDB.getConnection(jdbcDriver, hostName, dbName, username, password);
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, code);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CategoryModel categoryModel = new CategoryModel();
				categoryModel.setCode(resultSet.getString("code"));
				categoryModel.setName(resultSet.getString("name"));

				results.add(categoryModel);
			}
			System.out.println(results);
			return results.isEmpty() ? null : results.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAO();
//		categoryDAO.findOneByCode("the-thao");
		categoryDAO.findAll();
	}

}
