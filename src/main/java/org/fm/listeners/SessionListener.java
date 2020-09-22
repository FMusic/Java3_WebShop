package org.fm.listeners;

import org.fm.controllers.CartController;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String id = se.getSession().getId();
        CartController.makeNewCart(id);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        CartController.deleteCartForSession(se.getSession().getId());
    }
}
