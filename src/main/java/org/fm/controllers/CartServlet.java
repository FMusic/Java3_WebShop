package org.fm.controllers;

import org.fm.model.Cart;
import org.fm.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fetchCart(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fetchCart(request, response);
    }

    private void fetchCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart c = null;
        if (!loggedIn()){
            c = CartController.getCartForSession(request.getSession().getId());
        } else{
            //TODO: make account
            //c = CartController.getCartForAccount();
        }
        request.setAttribute(Constants.CART_ATTRIBUTE, c.getCartItemsByIdCart());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }

    private boolean loggedIn() {
        return false;
    }
}
