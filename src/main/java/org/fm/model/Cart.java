package org.fm.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Cart {
    private int idCart;
    private Integer clientId;
    private String sessionId;
    private Client clientByClientId;
    private Collection<CartItem> cartItemsByIdCart;

    @Id
    @Column(name = "IDCart", nullable = false)
    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    @Basic
    @Column(name = "ClientID", nullable = true, insertable = false, updatable = false)
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name="sessionID", nullable = true, insertable = false, updatable = false, length = 50)
    public String getSession(){
        return sessionId;
    }

    public void setSession(String session){
        this.sessionId = session;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (idCart != cart.idCart) return false;
        if (clientId != null ? !clientId.equals(cart.clientId) : cart.clientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCart;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ClientID", referencedColumnName = "IDClient")
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @OneToMany(mappedBy = "cartByCartId")
    public Collection<CartItem> getCartItemsByIdCart() {
        return cartItemsByIdCart;
    }

    public void setCartItemsByIdCart(Collection<CartItem> cartItemsByIdCart) {
        this.cartItemsByIdCart = cartItemsByIdCart;
    }
}
