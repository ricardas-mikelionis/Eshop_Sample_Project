package DAO;

import Entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class ProductDAO {
    @PersistenceContext(unitName = "org.hibernate.tutorial.jpa")
    private EntityManager entityManager;

    public List<Product> getProducts(){
        return entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

}
