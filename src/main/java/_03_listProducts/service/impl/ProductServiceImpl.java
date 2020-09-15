package _03_listProducts.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _03_listProducts.dao.ProductDao;
import _03_listProducts.dao.impl.ProductDaoImpl_H;
import _03_listProducts.model.ProductBean;
import _03_listProducts.service.ProductService;
import _03_listProducts.util.HibernateUtils;

public class ProductServiceImpl implements ProductService {
	ProductDao dao;
	// H_Star
	SessionFactory factory;

	// H_End
	public ProductServiceImpl() {
		this.dao = new ProductDaoImpl_H();
		this.factory = HibernateUtils.getSessionFactory();
	}

	//H_Star
	@Override
	public int deleteProduct(int no) {
		int n = 0;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            n = dao.deleteProduct(no);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)  tx.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return n;
	}
	//H_End

	// H_Star
	@Override
	public ProductBean getProduct(int pId) {
		ProductBean bean = null;

		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = dao.getProduct(pId);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return bean;
	}
	//H_End
	
	//H_Star
	@Override
	public List<String> getCategory() {
		List<String> list = null;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            list = dao.getCategory();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)  tx.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
	}
	//H_End
	
	//H_Star
	@Override
	public String getCategoryTag() {
		String tag = "";
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            tag = dao.getCategoryTag();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)  tx.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return tag;
	}
	//H_End

	// H_Star
	@Override
	public Map<Integer, ProductBean> getPageProducts(int pageNo) {
		Map<Integer, ProductBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getPageProducts(pageNo);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}
	// H_End

	@Override
	public int getRecordsPerPage() {
		return dao.getRecordsPerPage();
	}

	@Override
	public long getRecordCounts() {
		return dao.getRecordCounts();
	}

	// H_Star
	@Override
	public int getTotalPages() {
		// DB-Accessed
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			n = dao.getTotalPages();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return n;
	}
	// H_End
	
	//H_Star
	@Override
	public int saveProduct(ProductBean bean) {
		int n = 0;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            n = dao.saveProduct(bean);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)  tx.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return n;
	}
	//H_End

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		dao.setRecordsPerPage(recordsPerPage);
	}

	@Override
	public void setSelected(String category) {
		dao.setSelected(category);
	}

	//H_Star
	@Override
	public int updateProduct(ProductBean bean, long sizeInBytes) {
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
		    tx = session.beginTransaction();
		    n = dao.updateProduct(bean, sizeInBytes);
		    tx.commit();
		} catch (Exception ex) {
		    if (tx != null)  tx.rollback();
		    ex.printStackTrace();
		    throw new RuntimeException(ex);
		}
		return n;
	}
	//H_End

}
