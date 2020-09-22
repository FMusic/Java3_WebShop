package org.fm.controllers;

import org.fm.db.DbRepo;
import org.fm.model.Category;
import org.fm.model.Item;
import org.fm.model.Product;
import org.fm.utils.CategoryUtils;
import org.fm.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class BeginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fetchCategories(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fetchCategories(req, resp);
    }

    private void fetchCategories(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        List<Category> categories = CategoryUtils.setCategoriesForShow(DbRepo.getAllCategories());

        List<Product> itemsByPopular = DbRepo.getAllProducts();
        itemsByPopular.sort(Comparator.comparing(product -> product.getNumberSold()));

        rq.setAttribute(Constants.CATEGORIES_PARAM, categories);
        rq.setAttribute(Constants.MOST_POPULAR_ITEMS, itemsByPopular);
        rq.setAttribute(Constants.MONEY_TYPE, "Kn");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(rq, rsp);
    }
}
