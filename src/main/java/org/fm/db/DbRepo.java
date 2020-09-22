package org.fm.db;

import org.fm.model.Category;
import org.fm.model.Item;
import org.fm.model.Product;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DbRepo {
    public static List<Category> getAllCategories(){
        Session s = RepoManager.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> root = cq.from(Category.class);
        cq.select(root);
        List<Category> resultList = s.createQuery(cq).getResultList();
        //RepoManager.closeSession();
        return resultList;
    }

    public static List<Product> getProductsForCategory(Category cat){
        Session s = RepoManager.getSession();
        var cb = s.getCriteriaBuilder();
        var cq = cb.createQuery(Product.class);
        var root = cq.from(Product.class);
        cq.select(root);
        var gotList = s.createQuery(cq).getResultList();
        //RepoManager.closeSession();
        var resultList = gotList.stream()
                .filter(item -> Objects.equals(item.getCategoryByCategoryId(), cat))
                .collect(Collectors.toList());
        return resultList;
    }

    public static List<Product> getAllProducts() {
        Session s = RepoManager.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        List<Product> resultList = s.createQuery(cq).getResultList();
        //RepoManager.closeSession();
        return resultList;
    }

    public static Product getProductForId(int id) {
        List<Product> allProducts = getAllProducts();
        var res = allProducts.stream()
                .filter(product -> Objects.equals(product.getIdProduct(), id))
                .findFirst()
                .get();
        return res;
    }
}
