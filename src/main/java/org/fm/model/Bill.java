package org.fm.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Bill {
    private int idBill;
    private Integer clientId;
    private String paymentMethod;
    private Client clientByClientId;
    private Collection<Item> itemsByIdBill;

    @Id
    @Column(name = "IDBill", nullable = false)
    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
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
    @Column(name = "PaymentMethod", nullable = false, length = 7)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (idBill != bill.idBill) return false;
        if (clientId != null ? !clientId.equals(bill.clientId) : bill.clientId != null) return false;
        if (paymentMethod != null ? !paymentMethod.equals(bill.paymentMethod) : bill.paymentMethod != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBill;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
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

    @OneToMany(mappedBy = "billByBillId")
    public Collection<Item> getItemsByIdBill() {
        return itemsByIdBill;
    }

    public void setItemsByIdBill(Collection<Item> itemsByIdBill) {
        this.itemsByIdBill = itemsByIdBill;
    }
}
