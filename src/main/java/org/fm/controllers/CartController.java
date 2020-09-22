package org.fm.controllers;

import org.fm.db.RepoManager;
import org.fm.model.Cart;
import org.fm.model.CartItem;
import org.fm.model.Client;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CartController {
    public static Cart getCartForSession(String session) {
        String query = "from Cart c where c.session ='"+ session+"'";
        Query q = RepoManager.getSession().createQuery(query);
        Cart res;
        try {
            res = (Cart) q.list().get(0);
        } catch (Exception e){
            res = makeNewCart(session);
        }
        return res;
    }

    public static Cart getCartForAccount(Client c){
        String query = "from Cart cart where cart.clientId = " + c.getIdClient();
        Query q = RepoManager.getSession().createQuery(query);
        return (Cart) q.getSingleResult();
    }

    public static void saveItem(CartItem ci) {
        RepoManager.getSession().saveOrUpdate(ci);
    }

    public static Cart makeNewCart(String id) {
        Cart c = new Cart();
        c.setSession(id);
        Transaction tx = RepoManager.getSession().getTransaction();
        try {
            RepoManager.getSession().save(c);
        } catch (Exception ex){
            RepoManager.getSession().evict(c);
            RepoManager.getSession().save(c);
        }
        RepoManager.getSession().flush();
        tx.commit();
        return c;
    }

    public static void deleteCartForSession(String id) {
        String query = "from Cart c where c.session = '" + id + "'";
        Query q = RepoManager.getSession().createQuery(query);
        Cart c = (Cart)q.getSingleResult();
        RepoManager.getSession().delete(c);
    }
}
