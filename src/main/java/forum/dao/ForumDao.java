package forum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import forum.model.ForumBean;
import forum.util.HibernateUtils;

public class ForumDao {
  SessionFactory factory ;
  public ForumDao() {
	  factory =HibernateUtils.getSessionFactory();
  }
  public void persist(ForumBean fb) {
	  Session session =factory.getCurrentSession();
	  Transaction tx =null;
	  try {
		tx=session.beginTransaction();
		  session.persist(fb);
		  tx.commit();
	} catch (Exception e) {
		if(tx !=null) {
		tx.rollback();
		}
		e.printStackTrace();
	}
  }
  public List<ForumBean> getAll(){
	  List<ForumBean> li=new ArrayList<>();
	  String hql ="From ForumBean";
	  Session session =factory.getCurrentSession();
	  li=session.createQuery(hql).list();
	  return li;
  }
  public ForumBean getMB(Integer f_Id){
	  ForumBean fb=new ForumBean();
	  String hql ="From ForumBean f WHERE f.F_Id=:f_Id";
	  Session session =factory.getCurrentSession();
	  Transaction tx=null;
	  try {
		tx=session.beginTransaction();
		  fb=(ForumBean)session.createQuery(hql).setParameter("f_Id", f_Id).getSingleResult();
		  tx.commit();
	} catch (Exception e) {
		if(tx !=null) {
			tx.rollback();
			throw new RuntimeException(e);
		}
	}
	  return fb;
  }
  
}
