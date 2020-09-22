package org.fm.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Product {
    private int idProduct;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private String picPath;
    private Collection<CartItem> cartItemsByIdProduct;
    private Collection<Item> itemsByIdProduct;
    private Category categoryByCategoryId;
    private int numberSold;

    @Column(name ="numberSold", nullable = false)
    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    @Id
    @Column(name = "IDProduct", nullable = false)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "ProductName", nullable = true, length = 30)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Price", nullable = true)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "CategoryID", nullable = true, insertable = false, updatable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "PicPath", nullable = true, length = 100)
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (idProduct != product.idProduct) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (categoryId != null ? !categoryId.equals(product.categoryId) : product.categoryId != null) return false;
        if (picPath != null ? !picPath.equals(product.picPath) : product.picPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (picPath != null ? picPath.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<CartItem> getCartItemsByIdProduct() {
        return cartItemsByIdProduct;
    }

    public void setCartItemsByIdProduct(Collection<CartItem> cartItemsByIdProduct) {
        this.cartItemsByIdProduct = cartItemsByIdProduct;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<Item> getItemsByIdProduct() {
        return itemsByIdProduct;
    }

    public void setItemsByIdProduct(Collection<Item> itemsByIdProduct) {
        this.itemsByIdProduct = itemsByIdProduct;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "IDCategory")
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
