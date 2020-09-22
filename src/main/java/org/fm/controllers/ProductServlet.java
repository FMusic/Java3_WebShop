package org.fm.controllers;

import org.fm.db.DbRepo;
import org.fm.model.Product;
import org.fm.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fetchProduct(req, resp);
    }

    private void fetchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter(Constants.PRODUCT_ID_PARAM);
        int id = Integer.parseInt(strId);
        Product p = DbRepo.getProductForId(id);
        req.setAttribute(Constants.PRODUCT_INFO_PARAM, p);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsps/productinfo.jsp");
        dispatcher.forward(req, resp);
    }
}
