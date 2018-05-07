package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries({@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product {
    @Id
    @Column(name = "idproduct")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "product_name")
    private String product_name;

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderListList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
