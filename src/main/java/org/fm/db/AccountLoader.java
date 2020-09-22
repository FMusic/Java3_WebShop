package org.fm.db;

import org.fm.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountLoader {
    public static boolean checkPassAndEmail(String email, String password){
        Session session = RepoManager.getSession();
        String query = "from Client c where c.Email = '" + email + "'";
        Query q = session.createQuery(query);
        List list = q.list();
        Client c = (Client) list.get(0);
        if (c.getHashPass().equals(password)){
            return true;
        }
        return false;
    }
}
