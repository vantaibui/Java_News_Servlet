package com.project_news_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.project_news_servlet.connection.ConnectionDB;
import com.project_news_servlet.dao.GenericDAO;
import com.project_news_servlet.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

	String jdbcDriver = resourceBundle.getString("jdbcDriver");
	String hostName = resourceBundle.getString("hostName");
	String dbName = resourceBundle.getString("dbName");
	String username = resourceBundle.getString("username");
	String password = resourceBundle.getString("password");

	public void setParameters(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
		for (int i = 0; i < parameters.length; i++) {
			Object parameter = parameters[i];
			int index = i + 1;

			if (parameter instanceof Integer) {
				preparedStatement.setInt(index, (int) parameter);
			} else if (parameter instanceof Long) {
				preparedStatement.setLong(index, (long) parameter);
			} else if (parameter instanceof String) {
				preparedStatement.setString(index, (String) parameter);
			} else if (parameter instanceof Timestamp) {
				preparedStatement.setTimestamp(index, (Timestamp) parameter);
			} else if (parameter == null) {
				preparedStatement.setNull(index, Types.NULL);
			}
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = ConnectionDB.getConnection(jdbcDriver, hostName, dbName, username, password);
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				setParameters(preparedStatement, parameters);

				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					results.add(rowMapper.mapRow(resultSet));
				}
				System.out.println(results);
				return results;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("Không có kết nối!");
			return null;
		}

	}
}
