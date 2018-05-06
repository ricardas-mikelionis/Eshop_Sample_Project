package Entities;

import org.apache.johnzon.mapper.JohnzonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "order_date")
    @Size(max = 10)
    private String order_date;

    @JoinColumn(name = "customer_id", referencedColumnName = "ID")
    @ManyToOne
    @JohnzonIgnore
    private Customer customer;

    @JoinTable(name = "order_product", joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "idproduct")})
    @ManyToMany
    @JohnzonIgnore
    private List<Product> productList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}
