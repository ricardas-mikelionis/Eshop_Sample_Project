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
        CriteriaQuery<Product> productCriteriaQuery = entityManager.getCriteriaBuilder().createQuery(Product.class);
        productCriteriaQuery.select(productCriteriaQuery.from(Product.class));
        return entityManager.createQuery(productCriteriaQuery).getResultList();
    }

}
