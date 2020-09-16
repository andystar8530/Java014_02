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
  public List<ForumBean> selectAll(){
	  List<ForumBean> li=null;
	  Session session =factory.getCurrentSession();
	  Transaction tx =null;
	  try {
		tx =session.beginTransaction();
		  li =dao.getAll();
		  tx.commit();
	} catch (Exception e) {
		if(tx !=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}
	  return li;
  }
  public ForumBean getMB(Integer f_Id){
	  
	  return dao.getMB(f_Id);
	  
  }
public ForumBean selectOne(int f_id) {
	return dao.getMB(f_id);
}
  
}
