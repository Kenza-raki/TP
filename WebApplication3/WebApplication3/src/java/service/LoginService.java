/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entities.Login;
import java.util.List;
import ma.projet.dao.IDao;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author HP
 */
public class LoginService implements IDao<Login>{

    @Override
    public boolean create(Login l) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(l);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Login l) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(l);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Login o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Login getById(int id) {
        Login employe  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employe  = (Login) session.get(Login.class, id);
        session.getTransaction().commit();
        return employe;
    }

    @Override
    public List<Login> getAll() {
        List <Login> employes = null;
      
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes  = session.createQuery("from Login").list();
        session.getTransaction().commit();
        return employes;
    }
    
}
