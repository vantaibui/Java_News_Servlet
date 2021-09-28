package com.project_news_servlet.service.impl;

import java.util.List;

import com.project_news_servlet.dao.ICategoryDAO;
import com.project_news_servlet.dao.impl.CategoryDAO;
import com.project_news_servlet.model.CategoryModel;
import com.project_news_servlet.service.ICategoryService;

public class CategoryService implements ICategoryService {

	private ICategoryDAO categoryDAO;

	public CategoryService() {
		categoryDAO = new CategoryDAO();
	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
