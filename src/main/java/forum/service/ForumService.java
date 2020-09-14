package forum.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import forum.dao.ForumDao;
import forum.model.ForumBean;
import forum.util.HibernateUtils;

public class ForumService {
  ForumDao dao;
  SessionFactory factory;
  
  public ForumService(){
	  dao =new ForumDao();
	  factory=HibernateUtils.getSessionFactory();
  }
  public void persist(ForumBean fb) {
	  dao.persist(fb);
  }
  public List<ForumBean> select(int page){
	  List<ForumBean> bean=null;
	  Session session =factory.getCurrentSession();
	  Transaction tx =null;
	  try {
		tx =session.beginTransaction();
		  bean =dao.getAll(page);
		  tx.commit();
	} catch (Exception e) {
		if(tx !=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}
	  return bean;
  }
  public ForumBean getMB(Integer f_Id){
	  
	  return dao.getMB(f_Id);
	  
  }
  
  public List<ForumBean> getAllTalk(int page){
	  return select(page);
  }
}
