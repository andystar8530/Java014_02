package _03_listProducts.dao;

import java.util.List;
import java.util.Map;

import _03_listProducts.model.ProductBean;

public interface ProductDao {
	// 依productId來刪除單筆記錄
	int deleteProduct(int no);

	// 依productId來查詢單筆記錄
	ProductBean getProduct(int PId);
	
	List<String> getCategory();
	
	String getCategoryTag();
	
	Map<Integer, ProductBean> getPageProducts(int pageNo);

//	int getPageNo();
	
	long getRecordCounts();

	int getRecordsPerPage();

	int getTotalPages();
	
	// 新增一筆記錄
	int saveProduct(ProductBean bean);

//    void setPageNo(int pageNo);
	
    void setRecordsPerPage(int recordsPerPage);
	
    void setSelected(String selected);
	// 計算紀錄總筆數

	int updateProduct(ProductBean bean, long sizeInBytes) ;
}
