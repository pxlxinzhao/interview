package com.patrick.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.patrick.model.User;

public class HibernateMain {
	
	
	public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        
        @SuppressWarnings("unchecked")
		List<User> users = session.createCriteria(User.class)
        	    .add( Restrictions.like("username", "pat%%"))
        	    .list();
        
        for(User user: users){
        	
        	System.out.println(user.getUsername());
        	System.out.println(user.getPasswd());
        }
        session.close();
	}
}
