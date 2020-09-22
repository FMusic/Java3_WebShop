package org.fm.controllers;

import org.fm.model.Cart;
import org.fm.model.CartItem;
import org.fm.model.Client;
import org.fm.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    private Client client;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addToCart(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addToCart(request, response);
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse rsp) {
        String id_param = req.getParameter(Constants.PRODUCT_ID_PARAM);
        String quantity_param = req.getParameter(Constants.PRODUCT_QUANTITY_PARAM);

        int id = Integer.parseInt(id_param);
        int quantity = Integer.parseInt(quantity_param);
        HttpSession session = req.getSession();
        String sessionId = session.getId();
        add(sessionId, id, quantity);
    }

    private void add(String sessionId, int product_id, int quantity) {
        Cart c;
        if(loggedIn()){
            c = getCartForAccount();
        } else{
            c = getCartForSession(sessionId);
        }
        CartItem ci = new CartItem(product_id, quantity, c);
        CartController.saveItem(ci);
    }

    private Cart getCartForSession(String sessionId) {
        return CartController.getCartForSession(sessionId);
    }

    private Cart getCartForAccount() {
        return CartController.getCartForAccount(client);
    }

    private boolean loggedIn() {
        return false;
    }
}
