package partner_h.partnerInfoEdit_h.service.Impl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import partner_h.partnerInfoEdit_h.dao.PartnerDao;
import partner_h.partnerInfoEdit_h.dao.Impl.PartnerDaoImpl_Hibernate;
import partner_h.partnerInfoEdit_h.model.PartnerBean;
import partner_h.partnerInfoEdit_h.service.PartnerService;
import partner_h.partnerInfoEdit_h.util.HibernateUtils;

public class PartnerServiceImpl implements PartnerService {

	PartnerDao dao ;
	SessionFactory factory;
	//dao 不能commit，交給service去做try-catch攔截例外
	public PartnerServiceImpl() {
		this.dao = new PartnerDaoImpl_Hibernate();
		this.factory = HibernateUtils.getSessionFactory();
	}

	
	
	@Override
	public PartnerBean getPartner(int p_mId) {	
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		PartnerBean pb = null;
		try {
			tx = session.beginTransaction();
			pb = dao.getPartner(p_mId);
			tx.commit();
		}catch(Exception ex) {
			if(tx!= null) {
				tx.rollback();
			}				
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

		return pb;
	}



	


	@Override
	public int savePartner(PartnerBean pb) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		int n = 0;
		try {
			tx = session.beginTransaction();
			n = dao.savePartner(pb);
			tx.commit();
		}catch(Exception ex) {
			if(tx!= null) {
				tx.rollback();
			}				
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

		return n ;
	}



	@Override
	public int updatePartner(PartnerBean pb) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		int n = 0;
		try {
			tx = session.beginTransaction();
			n = dao.updatePartner(pb);
			tx.commit();
		}catch(Exception ex) {
			if(tx!= null) {
				tx.rollback();
			}				
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

		return n ;
	}



	@Override
	public boolean idExists(String m_No) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		boolean exist = false;
		try {
			tx = session.beginTransaction();
			exist = dao.idExists(m_No);
			tx.commit();
		}catch(Exception ex) {
			if(tx!= null) {
				tx.rollback();
			}				
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		
		return exist ;
	}

	@Override
	public PartnerBean queryPartner(String p_mId) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		PartnerBean pb = null;
		try {
			tx = session.beginTransaction();
			pb = dao.queryPartner(p_mId);
			tx.commit();
		}catch(Exception ex) {
			if(tx!= null) {
				tx.rollback();
			}				
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		return pb;
	}


	
	
	
	
	
	
}
