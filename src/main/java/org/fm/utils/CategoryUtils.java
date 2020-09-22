package org.fm.utils;

import org.fm.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryUtils {
    public static List<Category> setCategoriesForShow(List<Category> cats) {
        List<Category> catsToReturn = new ArrayList<>();
        List<Category> catsChecked = new ArrayList<>();
        for (Category cat: cats){
            if (!catsChecked.contains(cat)){
                catsToReturn.add(cat);
                catsChecked.addAll(cat.getCategoriesByIdCategory());
            }
        }
        return catsToReturn;
    }
}
