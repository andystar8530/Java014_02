package forum.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import forum.model.CommentBean;
import forum.model.ForumBean;
import forum.util.HibernateUtils;

public class CommentDao {
   SessionFactory factory;
   public CommentDao() {
		  factory =HibernateUtils.getSessionFactory();
	  }
   public void persist(CommentBean cb) {
		  Session session =factory.getCurrentSession();
		  Transaction tx =null;
		  try {
			tx=session.beginTransaction();
			  session.persist(cb);
			  tx.commit();
		} catch (Exception e) {
			if(tx !=null) {
			tx.rollback();
			}
			e.printStackTrace();
		}
	  }
	  public List<CommentBean> getAll(){
		  List<CommentBean> li=new ArrayList<>();
		  String hql ="From CommentBean";
		  Session session =factory.getCurrentSession();
		  li=session.createQuery(hql).list();
		  return li;
	  }
	  public CommentBean getMB(Integer C_Id){
		  CommentBean cb=new CommentBean();
		  String hql ="From CommentBean c WHERE c.C_Id=:C_Id";
		  Session session =factory.getCurrentSession();
		  Transaction tx=null;
		  try {
			tx=session.beginTransaction();
			  cb=(CommentBean)session.createQuery(hql).setParameter("C_Id", C_Id).getSingleResult();
			  tx.commit();
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
				throw new RuntimeException(e);
			}
		}
		  return cb;
	  }
}
