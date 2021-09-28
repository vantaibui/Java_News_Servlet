package com.project_news_servlet.dao;

import java.util.List;

import com.project_news_servlet.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();

	CategoryModel findOneByCode(String code);

}
