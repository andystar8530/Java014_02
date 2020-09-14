package forum.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import forum.dao.CommentDao;
import forum.dao.ForumDao;
import forum.model.CommentBean;
import forum.model.ForumBean;
import forum.util.HibernateUtils;

public class CommentService {
  CommentDao dao;
  SessionFactory factory;
  
  public CommentService(){
	  dao =new CommentDao();
	  factory=HibernateUtils.getSessionFactory();
  }
  public void persist(CommentBean cb) {
	  dao.persist(cb);
  }
  public List<CommentBean> selectAll(){
	  List<CommentBean> li=null;
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
  public CommentBean getMB(Integer c_Id){
	  
	  return dao.getMB(c_Id);
	  
  }
  
}
