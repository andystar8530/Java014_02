package _03_listProducts.service.impl;

import java.util.List;
import java.util.Map;

import _03_listProducts.dao.ProductDao;
import _03_listProducts.dao.impl.ProductDaoImpl_Jdbc;
import _03_listProducts.model.ProductBean;
import _03_listProducts.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao dao;
	public ProductServiceImpl() {
		this.dao = new ProductDaoImpl_Jdbc();
	}
	
	@Override
	public int deleteProduct(int no) {
		return dao.deleteProduct(no);
	}

	@Override
	public ProductBean getProduct(int pId) {
		return dao.getProduct(pId);
	}

	@Override
	public List<String> getCategory() {
		return dao.getCategory();
	}

	@Override
	public String getCategoryTag() {
		return dao.getCategoryTag();
	}

	@Override
	public Map<Integer, ProductBean> getPageProducts(int pageNo) {
		return dao.getPageProducts(pageNo);
	}

	@Override
	public int getRecordsPerPage() {
		return dao.getRecordsPerPage();
	}

	@Override
	public long getRecordCounts() {
		return dao.getRecordCounts();
	}

	@Override
	public int getTotalPages() {
		return dao.getTotalPages();
	}

	@Override
	public int saveProduct(ProductBean bean) {
		return dao.saveProduct(bean);
	}

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		dao.setRecordsPerPage(recordsPerPage);
	}

	@Override
	public void setSelected(String category) {
		dao.setSelected(category);
	}

	@Override
	public int updateProduct(ProductBean bean, long sizeInBytes) {
		return dao.updateProduct(bean, sizeInBytes);
	}

}
