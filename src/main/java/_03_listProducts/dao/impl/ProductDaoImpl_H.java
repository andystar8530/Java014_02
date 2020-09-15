package _03_listProducts.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_init.util.GlobalService;
import _03_listProducts.dao.ProductDao;
import _03_listProducts.model.ProductBean;
import _03_listProducts.util.HibernateUtils;

//本類別使用純JDBC的技術來存取資料庫。
//所有SQLException都以catch區塊捕捉，然後一律再次丟出RuntimeException。
//對SQLException而言，即使catch下來，程式依然無法正常執行，所以捕捉SQLException，再次丟出
//RuntimeException。

public class ProductDaoImpl_H implements Serializable, ProductDao {

	private static final long serialVersionUID = 1L;
//	private int bookId = 0; 	// 查詢單筆商品會用到此代號
//	private int pageNo = 0;		// 存放目前顯示之頁面的編號
	private int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁三筆
	private int totalPages = -1;
	DataSource ds = null;
	
//	private String tagName = "";
	String selected = "";
	//H_Star
	SessionFactory factory;
	//H_End
	
	public ProductDaoImpl_H() {
		//H_Star
		factory = HibernateUtils.getSessionFactory();
		//H_End
	}
	
	// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}
	
	// 查詢某一頁的商品(書籍)資料，執行本方法前，一定要先設定實例變數pageNo的初值
	//H_Star
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, ProductBean> getPageProducts(int pageNo) {
		Map<Integer, ProductBean> map = new HashMap<>();
		String hql = "FROM ProductBean";
        Session session = factory.getCurrentSession();
        int startRecordNo = (pageNo - 1) * recordsPerPage;
        List<ProductBean> list = session.createQuery(hql)
                      .setFirstResult(startRecordNo)
                      .setMaxResults(recordsPerPage)
                      .list();
		for(ProductBean bean: list) {
			map.put(bean.getP_Id(), bean);
		}
		return map;
	}
	
	//H_End
	
	//H_Star
	@Override
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String hql = "SELECT count(*) FROM ProductBean";
		Session session = factory.getCurrentSession();
		count = (Long)session.createQuery(hql).getSingleResult();
		return count;
	}
	//H_End
	
	//H_Star
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCategory() {
		String hql = "SELECT DISTINCT category FROM ProductBean";
        Session session = factory.getCurrentSession();
        List<String> list = null;
        list = session.createQuery(hql).list();
        return list;
	}
	//H_End
	
	@Override
	public String getCategoryTag() {
		String ans = "";
		List<String> list = getCategory();
		ans += "<SELECT name='category'>";
		for (String cate : list) {
			if (cate.equals(selected)) {
				ans += "<option value='" + cate + "' selected>" + cate + "</option>";
			} else {
				ans += "<option value='" + cate + "'>" + cate + "</option>";
			}
		}
		ans += "</SELECT>";
		return ans;
	}
	
	//H_Star
	// 修改一筆書籍資料，不改圖片
	@Override
	public int updateProduct(ProductBean bean, long sizeInBytes) {
		int n = 0;
		if (sizeInBytes == -1) { // 不修改圖片
            n = updateProduct(bean);
            return n;
        }
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(bean);
        n++;

		return n;
	}
	//H_End
	
	//H_Star
	// 修改一筆書籍資料
	public int updateProduct(ProductBean bean) {
		int n = 0;
        ProductBean pb0 = null;
        Session session = factory.getCurrentSession();
        pb0 = session.get(ProductBean.class, bean.getP_Id());
        bean.setP_Category(pb0.getP_Category());
        bean.setP_Pdqty(pb0.getP_Pdqty());
        bean.setP_Pdsum(pb0.getP_Pdsum());
        bean.setP_Stock(pb0.getP_Stock());
        bean.setP_Sdqty(pb0.getP_Sdqty());
        bean.setP_Price(pb0.getP_Price());
        bean.setP_Note(pb0.getP_Note());
        bean.setP_UpdataTime(pb0.getP_UpdataTime());
        session.evict(pb0);
        session.saveOrUpdate(bean);
        n++;
        return n;
	}
	//H_End

	//H_Star
	// 依bookId來刪除單筆記錄
	@Override
	public int deleteProduct(int no) {
		int n = 0;
        Session session = factory.getCurrentSession();
        ProductBean pb = new ProductBean();
        pb.setP_Id(no);
        session.delete(pb);
        n++;
        return n;
	}
	//H_End

	//H_Star
	// 新增一筆記錄---
	@Override
	public int saveProduct(ProductBean bean) {
		int n = 0;
        Session session = factory.getCurrentSession();
        session.save(bean);
        n++;
        return n;
	}
	//H_End
	
	

	@Override
	public void setSelected(String selected) {
		this.selected = selected;
	}

//	@Override
//	public int getPageNo() {
//		return pageNo;
//	}
//
//	@Override
//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//	}

	@Override
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	
	//H_Star
	@Override
	public ProductBean getProduct(int P_ID) {
		ProductBean bean = null;
        Session session = factory.getCurrentSession();
        bean = session.get(ProductBean.class, P_ID);
        return bean;
	}
	//H_End

}