/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.Service;
import java.util.List;

import ma.projet.dao.IDao;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author LACHGAR
 */
public class ServiceService implements IDao<Service>{
    @Override
    public boolean create(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean update(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean delete(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Service getById(int id) {
        Service service  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        service  = (Service) session.get(Service.class, id);
        session.getTransaction().commit();
        return service;
    }

    @Override
    public List<Service> getAll() {
        
         List <Service> services = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        services  = session.createQuery("from Service").list();
        session.getTransaction().commit();
        return services;
    }
     public List<Object[]> nbservice(){
        List<Object[]> services = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        services  = session.createQuery("select count(s.code), s.code from Service s group by s.code").list();
        session.getTransaction().commit();
        return services ;
    }
}
