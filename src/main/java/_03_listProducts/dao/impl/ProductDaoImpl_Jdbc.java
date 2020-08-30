package _03_listProducts.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import _00_init.util.GlobalService;
import _03_listProducts.dao.ProductDao;
import _03_listProducts.model.ProductBean;

//本類別使用純JDBC的技術來存取資料庫。
//所有SQLException都以catch區塊捕捉，然後一律再次丟出RuntimeException。
//對SQLException而言，即使catch下來，程式依然無法正常執行，所以捕捉SQLException，再次丟出
//RuntimeException。

public class ProductDaoImpl_Jdbc implements Serializable, ProductDao {

	private static final long serialVersionUID = 1L;
//	private int bookId = 0; 	// 查詢單筆商品會用到此代號
//	private int pageNo = 0;		// 存放目前顯示之頁面的編號
	private int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁三筆
	private int totalPages = -1;
	DataSource ds = null;
	
//	private String tagName = "";
	String selected = "";

	public ProductDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#建構子發生例外: " 
										+ ex.getMessage());
		}
	}
	
	// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));

		return totalPages;
	}
	
	// 查詢某一頁的商品(書籍)資料，執行本方法前，一定要先設定實例變數pageNo的初值
	@Override
	public Map<Integer, ProductBean> getPageProducts(int pageNo) {
		Map<Integer, ProductBean> map = new HashMap<>();
		
//		SELECT *, ROW_NUMBER() OVER (ORDER BY p_id ) p_id FROM product

			
		String sql0 = "SELECT  * FROM (SELECT  ROW_NUMBER() OVER (ORDER BY P_ID)"
				+ " AS RowNum, b.p_Id, b.p_Category, b.p_Name, b.p_Cover, b.p_FileName, b.p_Pdqty,  b.p_Pdsum, b.p_Stock, b.p_Sdqty,"
				+ " b.p_Price, b.p_Pic1, b.p_FileName1, b.p_Pic2, b.p_FileName2, b.p_Pic3, b.p_FileName3, b.p_Note"
				+ " FROM Product b)"
				+ " AS NewTable WHERE RowNum >= ? AND RowNum <= ?";
		
//		String sql0 = "SELECT  * FROM (SELECT  ROW_NUMBER() OVER (ORDER BY BOOKID)"
//				+ " AS RowNum, b.BookId, b.author, b.bookNo, b.category, b.title, b.listPrice, "
//				+ " b.discount, b.companyID, b.fileName, b.coverImage, bc.name "
//				+ " FROM Book b JOIN BookCompany bc ON  b.companyId = bc.id )"
//				+ " AS NewTable WHERE RowNum >= ? AND RowNum <= ?";
//		
//		String sql1 = "SELECT b.BookId, b.author, b.bookNo, b.category, b.TITLE, "
//				+ "b.ListPrice, b.discount, b.companyID, b.fileName, b.coverImage, "
//				+ "bc.name FROM Book b JOIN BookCompany bc ON  b.companyId = bc.id "
//						+ " LIMIT ?, ?";
		String sql = sql0;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(1 based)
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(0 based)		
//		int startRecordNo = (pageNo - 1) * recordsPerPage;
//		int endRecordNo = recordsPerPage;
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, startRecordNo);
			ps.setInt(2, endRecordNo);
			try (
				ResultSet rs = ps.executeQuery();
			) {
				// 只要還有紀錄未取出，rs.next()會傳回true
				// 迴圈內將逐筆取出ResultSet內的紀錄
				while (rs.next()) {
					// 準備一個新的ProductBean，將ResultSet內的一筆紀錄移植到ProductBean內
					ProductBean bean = new ProductBean();    	
					bean.setP_Id(rs.getInt("P_Id"));		
					bean.setP_Category(rs.getString("P_Category"));
					bean.setP_Name(rs.getString("P_Name"));
					bean.setP_Cover(rs.getBlob("P_Cover"));
					bean.setP_FileName(rs.getString("P_FileName"));
					bean.setP_Pdqty(rs.getInt("P_Pdqty"));
					bean.setP_Pdsum(rs.getInt("P_Pdsum"));
					bean.setP_Stock(rs.getInt("P_Stock"));
					bean.setP_Sdqty(rs.getInt("P_Sdqty"));
					bean.setP_Price(rs.getDouble("P_Price"));
					bean.setP_Pic1(rs.getBlob("P_Pic1"));
					bean.setP_FileName1(rs.getString("P_FileName1"));
					bean.setP_Pic2(rs.getBlob("P_Pic2"));
					bean.setP_FileName2(rs.getString("P_FileName2"));
					bean.setP_Pic3(rs.getBlob("P_Pic3"));
					bean.setP_FileName3(rs.getString("P_FileName3"));
					bean.setP_Note(rs.getString("p_Note"));
					// 最後將BookBean物件放入大的容器內
					map.put(rs.getInt("P_Id"), bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#getPageProducts()發生例外: " 
										+ ex.getMessage());
		}
		return map;
	}

	@Override
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String sql = "SELECT count(*) FROM Product";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#getRecordCounts()發生例外: " 
										+ ex.getMessage());
		}
		return count;
	}
	
	@Override
	public List<String> getCategory() {
		String sql = "SELECT DISTINCT P_Category FROM Product";
		List<String> list = new ArrayList<>();
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			while (rs.next()) {
				String cate = rs.getString(1);
				if (cate != null) {
					list.add(cate);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#getCategory()發生例外: " 
										+ ex.getMessage());
		}
		return list;
	}
	
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
	
	// 修改一筆書籍資料
	@Override
	public int updateProduct(ProductBean bean, long sizeInBytes) {
		int n = 0;
		String sql = "UPDATE Product SET " 
				+ " p_Category=?,  p_Cover = ?, p_FileName=?,  p_Dqty = ?, p_Dsum = ?, p_Stock = ?, p_Sdqty = ?, p_Price=?,"
				+ " p_Pic1=?, p_FileName1=?, p_Pic2=?, p_FileName2=?, p_Pic3=?, p_FileName3=?, p_Note = ? WHERE p_Id = ?";
		if (sizeInBytes == -1) { // 不修改圖片
			n = updateProduct(bean);
			return n;
		}
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, bean.getP_Category());
			ps.setBlob(2, bean.getP_Cover());
			ps.setString(3, bean.getP_FileName());
			ps.setInt(4, bean.getP_Pdqty());
			ps.setInt(5, bean.getP_Pdsum());
			ps.setInt(6, bean.getP_Stock());
			ps.setInt(7, bean.getP_Sdqty());
			ps.setDouble(8, bean.getP_Price());
			ps.setBlob(9, bean.getP_Pic1());
			ps.setString(10, bean.getP_FileName1());
			ps.setBlob(11, bean.getP_Pic2());
			ps.setString(12, bean.getP_FileName2());
			ps.setBlob(13, bean.getP_Pic3());
			ps.setString(14, bean.getP_FileName3());
			ps.setString(15, bean.getP_Note());
			ps.setInt(16, bean.getP_Id());
			n = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#updateProduct(ProductBean, long)發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	// 修改一筆書籍資料，不改圖片
	public int updateProduct(ProductBean bean) {
		int n = 0;
		String sql = "UPDATE Product SET " 
				+ " p_Category=?, p_Dqty = ?, p_Dsum = ?, p_Stock = ?,"
				+ "  p_Sdqty = ?, p_Price=?,p_Note = ? WHERE p_Id = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, bean.getP_Category());
			ps.setInt(2, bean.getP_Pdqty());
			ps.setInt(3, bean.getP_Pdsum());
			ps.setInt(4, bean.getP_Stock());
			ps.setInt(5, bean.getP_Sdqty());
			ps.setDouble(6, bean.getP_Price());
			ps.setString(7, bean.getP_Note());
			ps.setInt(8, bean.getP_Id());

			n = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#updateBook(BookBean)發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	// 依bookId來刪除單筆記錄
	@Override
	public int deleteProduct(int no) {
		int n = 0;
		String sql = "DELETE FROM Product WHERE P_ID = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement pStmt = connection.prepareStatement(sql);
		) {
			pStmt.setInt(1, no);
			n = pStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#deleteBook()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	// 新增一筆記錄---
	@Override
	public int saveProduct(ProductBean bean) {
		int n = 0;

		String sql = "INSERT INTO Product " 
				+ " (p_Category, p_Cover, p_FileName, p_Dqty, p_Dsum, p_Stock, p_Sdqty, p_Price,"
				+ " p_Pic1, p_FileName1, p_Pic2, p_FileName2, p_Pic3, p_FileName3, p_Note) " 
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (
			Connection connection = ds.getConnection();
			PreparedStatement pStmt = connection.prepareStatement(sql);
		) {
			pStmt.setString(1, bean.getP_Category());
			pStmt.setBlob(2, bean.getP_Cover());
			pStmt.setString(3, bean.getP_FileName());
			pStmt.setInt(4, bean.getP_Pdqty());
			pStmt.setInt(5, bean.getP_Pdsum());
			pStmt.setInt(6, bean.getP_Stock());
			pStmt.setInt(7, bean.getP_Sdqty());
			pStmt.setDouble(8, bean.getP_Price());
			pStmt.setBlob(9, bean.getP_Pic1());
			pStmt.setString(10, bean.getP_FileName1());
			pStmt.setBlob(11, bean.getP_Pic2());
			pStmt.setString(12, bean.getP_FileName2());
			pStmt.setBlob(13, bean.getP_Pic3());
			pStmt.setString(14, bean.getP_FileName3());
			pStmt.setString(15, bean.getP_Note());
			n = pStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#saveBook()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	
	

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

	@Override
	public ProductBean getProduct(int P_ID) {
		ProductBean bean = null;
		String sql = "SELECT * FROM Product WHERE P_ID = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, P_ID);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new ProductBean();
					bean.setP_Id(rs.getInt("P_Id"));		
					bean.setP_Category(rs.getString("P_Category"));
					bean.setP_Cover(rs.getBlob("P_Cover"));
					bean.setP_FileName(rs.getString("P_FileName"));
					bean.setP_Pdqty(rs.getInt("P_Pdqty"));
					bean.setP_Pdsum(rs.getInt("P_Pdsum"));
					bean.setP_Stock(rs.getInt("P_Stock"));
					bean.setP_Sdqty(rs.getInt("P_Sdqty"));
					bean.setP_Price(rs.getDouble("P_Price"));
					bean.setP_Pic1(rs.getBlob("P_Pic1"));
					bean.setP_FileName1(rs.getString("P_FileName1"));
					bean.setP_Pic2(rs.getBlob("P_Pic2"));
					bean.setP_FileName2(rs.getString("P_FileName2"));
					bean.setP_Pic3(rs.getBlob("P_Pic3"));
					bean.setP_FileName3(rs.getString("P_FileName3"));
					bean.setP_Note(rs.getString("p_Note"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#queryProduct()發生例外: " 
										+ ex.getMessage());
		}
		return bean;
	}

}