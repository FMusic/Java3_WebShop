package org.fm.model;

import javax.persistence.*;

@Entity
public class CartItem {
    private int idCartItem;
    private Integer productId;
    private Integer quantity;
    private Integer cartId;
    private Product productByProductId;
    private Cart cartByCartId;

    public CartItem(int productId, int quantity, Cart cart) {
        this.productId = productId;
        this.quantity = quantity;
        this.cartByCartId = cart;
    }

    @Id
    @Column(name = "IDCartItem", nullable = false)
    public int getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(int idCartItem) {
        this.idCartItem = idCartItem;
    }

    @Basic
    @Column(name = "ProductID", nullable = true, insertable = false, updatable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "CartID", nullable = true, insertable = false, updatable = false)
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (idCartItem != cartItem.idCartItem) return false;
        if (productId != null ? !productId.equals(cartItem.productId) : cartItem.productId != null) return false;
        if (quantity != null ? !quantity.equals(cartItem.quantity) : cartItem.quantity != null) return false;
        if (cartId != null ? !cartId.equals(cartItem.cartId) : cartItem.cartId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCartItem;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "IDProduct")
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "CartID", referencedColumnName = "IDCart")
    public Cart getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(Cart cartByCartId) {
        this.cartByCartId = cartByCartId;
    }

    public CartItem() {
    }
}
