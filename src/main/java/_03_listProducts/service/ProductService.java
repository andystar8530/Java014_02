package _03_listProducts.service;

import java.util.List;
import java.util.Map;

import _03_listProducts.model.ProductBean;

public interface ProductService {
	// 依bookId來刪除單筆記錄
	int deleteProduct(int no);
	
	// 依bookId來查詢單筆記錄
	ProductBean getProduct(int bookId);

	// 取出所有的類型
	List<String> getCategory();
	
	String getCategoryTag();
	
	Map<Integer, ProductBean> getPageProducts(int pageNo);
	
//	int getPageNo();
	
	int getRecordsPerPage();

	long getRecordCounts();
	
	int getTotalPages();
	
	// 新增一筆記錄
	int saveProduct(ProductBean bean);

//	void setPageNo(int pageNo);

	void setRecordsPerPage(int recordsPerPage);

	void setSelected(String category);
	// 計算紀錄總筆數
	int updateProduct(ProductBean bean, long sizeInBytes) ;
}
