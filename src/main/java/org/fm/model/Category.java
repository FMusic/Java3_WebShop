package org.fm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category implements Serializable {
    private int idCategory;
    private String categoryName;
    private Integer categoryId;
    private Category categoryByCategoryId;
    private Collection<Category> categoriesByIdCategory;
    private Collection<Product> productsByIdCategory;

    @Id
    @Column(name = "IDCategory", nullable = false, insertable = false, updatable = false)
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "CategoryName", nullable = true, length = 30)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "CategoryID", nullable = true, insertable = false, updatable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (idCategory != category.idCategory) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        if (categoryId != null ? !categoryId.equals(category.categoryId) : category.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategory;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "IDCategory")
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Category> getCategoriesByIdCategory() {
        return categoriesByIdCategory;
    }

    public void setCategoriesByIdCategory(Collection<Category> categoriesByIdCategory) {
        this.categoriesByIdCategory = categoriesByIdCategory;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Product> getProductsByIdCategory() {
        return productsByIdCategory;
    }

    public void setProductsByIdCategory(Collection<Product> productsByIdCategory) {
        this.productsByIdCategory = productsByIdCategory;
    }
}
