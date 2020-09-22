package org.fm.model;

import javax.persistence.*;

@Entity
public class Item {
    private int idItem;
    private Integer billId;
    private Integer productId;
    private int quantity;
    private Bill billByBillId;
    private Product productByProductId;

    @Id
    @Column(name = "IDItem", nullable = false)
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "BillID", nullable = true, insertable = false, updatable = false)
    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
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
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (idItem != item.idItem) return false;
        if (quantity != item.quantity) return false;
        if (billId != null ? !billId.equals(item.billId) : item.billId != null) return false;
        if (productId != null ? !productId.equals(item.productId) : item.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idItem;
        result = 31 * result + (billId != null ? billId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BillID", referencedColumnName = "IDBill")
    public Bill getBillByBillId() {
        return billByBillId;
    }

    public void setBillByBillId(Bill billByBillId) {
        this.billByBillId = billByBillId;
    }

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "IDProduct")
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
