package Controllers;

import DAO.OrderDAO;
import DAO.ProductDAO;
import Entities.Product;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import java.util.List;

public class SimpleController {
    @Inject
    private OrderDAO orderDAO;

    @Inject
    private ProductDAO productDAO;

    private Product product = new Product();

    public List<Product> getProducts(){
        return productDAO.getProducts();
    }
}
