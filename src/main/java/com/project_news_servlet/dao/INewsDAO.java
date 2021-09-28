package com.project_news_servlet.dao;

import java.util.List;

import com.project_news_servlet.model.NewsModel;

public interface INewsDAO {
	List<NewsModel> findAll();
}
