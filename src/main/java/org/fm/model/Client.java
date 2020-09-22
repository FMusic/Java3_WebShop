package org.fm.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    private int idClient;
    private String firstName;
    private String lastName;
    private String hashPass;
    private String email;
    private Collection<Bill> billsByIdClient;
    private Collection<Cart> cartsByIdClient;

    @Id
    @Column(name = "IDClient", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "FirstName", nullable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName", nullable = true, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "HashPass", nullable = true, length = 50)
    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (hashPass != null ? !hashPass.equals(client.hashPass) : client.hashPass != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (hashPass != null ? hashPass.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<Bill> getBillsByIdClient() {
        return billsByIdClient;
    }

    public void setBillsByIdClient(Collection<Bill> billsByIdClient) {
        this.billsByIdClient = billsByIdClient;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<Cart> getCartsByIdClient() {
        return cartsByIdClient;
    }

    public void setCartsByIdClient(Collection<Cart> cartsByIdClient) {
        this.cartsByIdClient = cartsByIdClient;
    }
}
