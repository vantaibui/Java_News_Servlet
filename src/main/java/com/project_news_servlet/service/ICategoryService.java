package com.project_news_servlet.service;

import java.util.List;

import com.project_news_servlet.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
