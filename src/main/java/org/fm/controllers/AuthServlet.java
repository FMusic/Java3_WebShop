package org.fm.controllers;

import org.fm.db.AccountLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    private void solve(HttpServletRequest req, HttpServletResponse resp) {
        //boolean auth = AccountLoader.checkPassAndEmail(req.get)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        solve(req, resp);
    }
}
