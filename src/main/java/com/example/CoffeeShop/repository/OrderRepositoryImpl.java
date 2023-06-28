package com.example.CoffeeShop.repository;

import com.example.CoffeeShop.model.entity.Order;
import com.example.CoffeeShop.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public List<Order> getAllOrders() {
        List<Order> coffeeOrders = new ArrayList<>();
        try (Session session = openSession()) {
            openTransaction(session);
            coffeeOrders = session.createQuery("SELECT * FROM orders", Order.class).list();
            closeSession(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coffeeOrders;
    }

    @Override
    public void addOrder(Order order) {
        try (Session session = openSession()) {
            openTransaction(session);
            session.persist(order);
            closeSession(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(Order order) {
        try (Session session = openSession()) {
            openTransaction(session);
            session.createQuery("DELETE FROM orders WHERE id = " + order.getOrderNumber(), Order.class);
            closeSession(session);
        }
    }


    @Override
    public Order findById(Long id) {
        Order order = new Order();
        try (Session session = openSession()) {
            openTransaction(session);
            order = session.createQuery("SELECT id FROM orders WHERE id = " + id, Order.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order findLastOrder() {
        Order order = new Order();
        try (Session session = openSession()) {
            openTransaction(session);
            order = session.createQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1", Order.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }


    //Open and close session + transaction open/close
    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    private void closeSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    private void openTransaction(Session session) {
        session.beginTransaction();
    }
}
