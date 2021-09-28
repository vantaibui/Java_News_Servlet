package com.project_news_servlet.service;

import java.util.List;

import com.project_news_servlet.model.NewsModel;

public interface INewsService {
	List<NewsModel> findAll();
}
