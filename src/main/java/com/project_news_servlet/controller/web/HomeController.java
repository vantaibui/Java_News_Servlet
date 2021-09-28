package com.project_news_servlet.controller.web;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project_news_servlet.service.ICategoryService;

@ManagedBean
@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", categoryService.findAll());
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
		requestDispatcher.forward(req, resp);
	}

}
