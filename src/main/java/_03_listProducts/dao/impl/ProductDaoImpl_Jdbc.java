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
	private int pageNo = 0;		// 存放目前顯示之頁面的編號
	private int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁2筆
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
			throw new RuntimeException("ProductImpl_Jdbc()#建構子發生例外: " 
										+ ex.getMessage());
		}
	}
	
	
	// 依productId來刪除單筆記錄
	@Override
	public int deleteProduct(int no) {
		int n = 0;
		String sql = "DELETE FROM product WHERE pid = ?";

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

	@Override
	public ProductBean getProduct(int PId) {
		ProductBean bean = null;
		String sql = "SELECT * FROM product WHERE pid = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, PId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new ProductBean();
					bean.setPid(rs.getInt("pid"));
					bean.setPcategory(rs.getString("pcategory"));
					bean.setPname(rs.getString(3));
					bean.setPcover(rs.getBlob(4));
					bean.setPpdqty(rs.getString(5));
					bean.setPpdsum(rs.getString(6));
					bean.setPstock(rs.getString(7));
					bean.setPsdqty(rs.getString(8));
					bean.setPprice(rs.getDouble(9));
					bean.setPpic1(rs.getBlob(10));
					bean.setPpic2(rs.getBlob(11));
					bean.setPpic3(rs.getBlob(12));
					bean.setPnote(rs.getString(13));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#queryBook()發生例外: " 
										+ ex.getMessage());
		}
		return bean;
	}

	@Override
	public List<String> getCategory() {
		String sql = "SELECT DISTINCT Pcategory FROM Product";
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

	// 查詢某一頁的商品(書籍)資料，執行本方法前，一定要先設定實例變數pageNo的初值
	//未完成…                    //
	@Override
	public Map<Integer, ProductBean> getPageProducts(int pageNo) {
Map<Integer, ProductBean> map = new HashMap<>();

//String sql0 = "SELECT  * FROM Product";

		String sql0 = "SELECT  * FROM (SELECT  ROW_NUMBER() OVER (ORDER BY PID)"
				+ " AS RowNum, b.pid, b.pcategory, b.pcover, b.ppdqty, b.ppdsum, b.pstock, "
				+ " b.pprice, b.ppic1, b.ppic2, b.ppic3, b.pnote "
				+ " FROM Product b )"
				+ " AS NewTable WHERE RowNum >= ? AND RowNum <= ?";
		
//		String sql1 = "SELECT b.BookId, b.author, b.bookNo, b.category, b.TITLE, "
//				+ "b.ListPrice, b.discount, b.companyID, b.fileName, b.coverImage, "
//				+ "bc.name FROM Book b JOIN BookCompany bc ON  b.companyId = bc.id "
//						+ " LIMIT ?, ?";
		String sql = sql0;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(1 based)
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
//		int startRecordNo = 1;
		int endRecordNo = (pageNo) * recordsPerPage;
//		int endRecordNo = 1;
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
					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
					ProductBean bean = new ProductBean();
					bean.setPid(rs.getInt("PId"));
					bean.setPcategory(rs.getString("pcategory"));
					bean.setPname(rs.getString(3));
					bean.setPcover(rs.getBlob(4));
					bean.setPpdqty(rs.getString(5));
					bean.setPpdsum(rs.getString(6));
					bean.setPstock(rs.getString(7));
					bean.setPsdqty(rs.getString(8));
					bean.setPprice(rs.getDouble(9));
					bean.setPpic1(rs.getBlob(10));
					bean.setPpic2(rs.getBlob(11));
					bean.setPpic3(rs.getBlob(12));
					bean.setPnote(rs.getString(13));
					// 最後將BookBean物件放入大的容器內
					map.put(rs.getInt("PId"), bean);
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
	public int getRecordsPerPage() {
		return recordsPerPage;
	}
	
	// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}

	// 新增一筆記錄---
	@Override
	public int saveProduct(ProductBean bean) {
		int n = 0;

		String sql = "INSERT INTO Product " 
				+ " (pcategory, pname, pcover, ppdqty, ppdsum, pstock, "
				+ " psdqty, pprice, ppic1, ppic2, ppic3, pnote) " 
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (
			Connection connection = ds.getConnection();
			PreparedStatement pStmt = connection.prepareStatement(sql);
		) {
			pStmt.setString(1, bean.getPcategory());
			pStmt.setString(2, bean.getPname());
			pStmt.setBlob(3, bean.getPcover());
			pStmt.setString(4, bean.getPpdqty());
			pStmt.setString(5, bean.getPpdsum());
			pStmt.setString(6, bean.getPstock());
			pStmt.setString(7, bean.getPsdqty());
			pStmt.setDouble(8, bean.getPprice());
			pStmt.setBlob(9, bean.getPpic1());
			pStmt.setBlob(10, bean.getPpic2());
			pStmt.setBlob(11, bean.getPpic3());
			pStmt.setString(12, bean.getPnote());
			n = pStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#saveBook()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;		
	}

	@Override
	public void setSelected(String selected) {
		this.selected = selected;
		
	}
	
	// 修改一筆書籍資料
	@Override
	public int updateProduct(ProductBean bean, long sizeInBytes) {
		int n = 0;
		String sql = "UPDATE Product SET " 
				+ " pcategory=?,  pname=?,  pcover=?,  ppdqty= ?, ppdsum = ?, pstock=?,"
				+ " psdqty=?, ppic1=?, ppic2=?, ppic3=? , pnote = ? WHERE pid = ?";
		if (sizeInBytes == -1) { // 不修改圖片
			n = updateProduct(bean);
			return n;
		}
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			
			ps.setString(1, bean.getPcategory());
			ps.setString(2, bean.getPname());
			ps.setBlob(3, bean.getPcover());
			ps.setString(4, bean.getPpdqty());
			ps.setString(5, bean.getPpdsum());
			ps.setString(6, bean.getPstock());
			ps.setString(7, bean.getPsdqty());
			ps.setDouble(8, bean.getPprice());
			ps.setBlob(9, bean.getPpic1());
			ps.setBlob(10, bean.getPpic2());
			ps.setBlob(11, bean.getPpic3());
			ps.setString(12, bean.getPnote());
			ps.setInt(13, bean.getPid());
			n = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#updateBook(ProductBean, long)發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	// 修改一筆書籍資料，不改圖片
	public int updateProduct(ProductBean bean) {
		int n = 0;
		String sql = "UPDATE Product SET " 
				+ " pcategory=?,  pname?,  ppdqty=?, ppdsum=?,  pstock=?, "
				+ " psdqty=?,  pprice=?,  pnote=?  WHERE pId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.clearParameters();
			ps.setString(1, bean.getPcategory());
			ps.setString(2, bean.getPname());
			ps.setString(3, bean.getPpdqty());
			ps.setString(4, bean.getPpdsum());
			ps.setString(5, bean.getPstock());
			ps.setString(6, bean.getPsdqty());
			ps.setDouble(7, bean.getPprice());
			ps.setString(8, bean.getPnote());
			ps.setInt(9, bean.getPid());

			n = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ProductDaoImpl_Jdbc()#updateBook(ProductBean)發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	

}
