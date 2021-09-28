package com.project_news_servlet.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project_news_servlet.service.ICategoryService;
import com.project_news_servlet.service.impl.CategoryService;

@WebServlet(urlPatterns = { "/admin-home" })
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICategoryService categoryService;

	public AdminController() {
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", categoryService.findAll());

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/admin.jsp");
		requestDispatcher.forward(req, resp);

	}

}
