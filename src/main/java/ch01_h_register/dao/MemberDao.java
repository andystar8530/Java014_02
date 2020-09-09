package ch01_h_register.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch01_h_register.model.MemberBean;
import ch01_h_register.util.HibernateUtils;

public class MemberDao {

	SessionFactory factory;

	public MemberDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(MemberBean mb) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(mb);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	private static final String HQL_SELECT_BY_ID = "FROM MemberBean mb WHERE mb.M_Id = :mid";

	public MemberBean select(String id) {
		MemberBean result = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try {
			result = (MemberBean) session.createQuery(HQL_SELECT_BY_ID).setParameter("mid", id).getSingleResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return result;
	}

	public void updateMember(MemberBean memberBean) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mb = (MemberBean) session.get(MemberBean.class, memberBean.getM_No());
			if (mb != null) {
				mb.setM_Phone(memberBean.getM_Phone());
				mb.setM_Name(memberBean.getM_Name());
				mb.setM_Availabletime(memberBean.getM_Availabletime());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return;
	}
	
	public MemberBean get(int pk) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mb = (MemberBean) session.get(MemberBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return mb;
	}
	
	public void close() {
		factory.close();
	}
}
