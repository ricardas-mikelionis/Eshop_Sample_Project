package DAO;

import Entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class OrderDAO {
    @PersistenceContext(unitName = "org.hibernate.tutorial.jpa")
    private EntityManager entityManager;

    public List<Order> getOrders(){
        CriteriaQuery<Order> orderCriteriaQuery = entityManager.getCriteriaBuilder().createQuery(Order.class);
        orderCriteriaQuery.select(orderCriteriaQuery.from(Order.class));
        return entityManager.createQuery(orderCriteriaQuery).getResultList();
    }
}