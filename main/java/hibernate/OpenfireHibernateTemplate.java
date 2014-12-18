package hibernate;

import java.util.List;

import model.Identity_dating;
import model.Identity_message;
import model.Users;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OpenfireHibernateTemplate implements HibernateHelper {
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getMessagebyRecipientId(int, java.lang.String)
	 */
	public List<Identity_message> getMessagebyRecipientId(int RecipientId, String type){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
		String hql = "FROM Identity_message where recipient_type = '" + type + "' and recipient = '" + String.valueOf(RecipientId) + "'";
		Query query = session.createQuery(hql);
		List<Identity_message> results = query.list();
		return results;
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getMessagebySenderAndRecipient(int, int, java.lang.String)
	 */
	public List<Identity_message> getMessagebySenderAndRecipient(int SenderId, int RecipientId, String type){
		    Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
	        Session session = sessionFactory.openSession();
			String hql = "FROM Identity_message where recipient_type = '" + type + "' and sender = "
					+ "'" + String.valueOf(SenderId) + "' and recipient = '" + String.valueOf(RecipientId) + "'";
			Query query = session.createQuery(hql);
			List<Identity_message> results = query.list();
			return results;
		
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getRecentMessagebyRecipient(int, java.lang.String)
	 */
	public List<Identity_message> getRecentMessagebyRecipient(int RecipientId, String type){
	    Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
		String hql = "FROM Identity_message where recipient_type = '" + type + "' and recipient = '" + String.valueOf(RecipientId) + "'";
		Query query = session.createQuery(hql);
		List<Identity_message> results = query.list();
		return results;
	
}
	

	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#saveUser(model.Users)
	 */
	public void saveUser(Users user){
		
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#saveIdentity_message(model.Identity_message)
	 */
	public void saveIdentity_message(Identity_message message){
		
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();
        session.close();
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getUserByName(java.lang.String)
	 */
	public Users getUserByName(String username){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        String hql = "FROM Users where username = '" + username + "'";
        Query query = session.createQuery(hql);
		List<Users> results = query.list();
        session.close();
        return results.get(0);
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getUserById(int)
	 */
	public Users getUserById(int Id){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        String hql = "FROM Users where id = " + String.valueOf(Id);
        Query query = session.createQuery(hql);
		List<Users> results = query.list();
        session.close();
        return results.get(0);
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getSenderIdByName(java.lang.String)
	 */
	public Users getSenderIdByName(String username){
		
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        String hql = "FROM Users where username = '" + username + "'";
        Query query = session.createQuery(hql);
		List<Users> results = query.list();
        session.close();
        return results.get(0);
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#getDatingUserIdentityByUserId(int)
	 */
	public Identity_dating getDatingUserIdentityByUserId(int userId){
		
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        String hql = "FROM Identity_dating where user_id = " + String.valueOf(userId) ;
        Query query = session.createQuery(hql);
		List<Identity_dating> results = query.list();
        session.close();
        return results.get(0);
	}
	
	/* (non-Javadoc)
	 * @see hibernate.HibernateHelper#saveIdd(model.Identity_dating)
	 */
	public void saveIdd(Identity_dating idd){
			
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        session.save(idd);
	        session.getTransaction().commit();
	        session.close();
		}

}
