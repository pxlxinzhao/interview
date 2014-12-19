package com.patrick.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.patrick.model.Book;
import com.patrick.model.OMGBook;

public class HCriteriaMain {
	
	
	public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
//        System.out.println("Start creating query");
        String hql = 
//        		  "from OMGBook";
        	      "select book.bookId, book.bookname from OMGBook book"
        		+ " inner join User user"
        		+ "on book.userId = user.userId";
//        System.out.println("Start creating query");
    	Query query = session.createQuery(hql);
    	@SuppressWarnings("unchecked")
//		List<OMGBook> results = query.list();
//    	System.out.println("Stop creating query");
//		@SuppressWarnings("unchecked")
		List<Object[]> results = query.list();
		for(Object[] entry : results){
			System.out.println((Integer)entry[0]);
			System.out.println((String)entry[1]);
		}
//    	for(OMGBook book: results){
//    		
//    		System.out.println(book.getBookId());
//    		System.out.println(book.getBookname());
//    	}
    	session.close();
	}
}

//
//public void listEmployeesScalar( ){
//    Session session = factory.openSession();
//    Transaction tx = null;
//    try{
//       tx = session.beginTransaction();
//       String sql = "SELECT first_name, salary FROM EMPLOYEE";
//       SQLQuery query = session.createSQLQuery(sql);
//       query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//       List data = query.list();
//
//       for(Object object : data)
//       {
//          Map row = (Map)object;
//          System.out.print("First Name: " + row.get("first_name")); 
//          System.out.println(", Salary: " + row.get("salary")); 
//       }
//       tx.commit();
//    }catch (HibernateException e) {
//       if (tx!=null) tx.rollback();
//       e.printStackTrace(); 
//    }finally {
//       session.close(); 
//    }
// }

