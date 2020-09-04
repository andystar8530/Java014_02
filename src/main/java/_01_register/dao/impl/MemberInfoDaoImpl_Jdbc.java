package _01_register.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import _00_init.util.GlobalService;
import _01_register.dao.MemberInfoDao;
import _01_register.model.MemberInfoBean;
//import _04_ShoppingCart.model.OrderBean;
//import _04_ShoppingCart.ude.UnpaidOrderAmountExceedingException;
// 本類別使用為標準的JDBC技術來存取資料庫。
public class MemberInfoDaoImpl_Jdbc implements MemberInfoDao {

	private DataSource ds = null;
	private Connection conn = null;
	public MemberInfoDaoImpl_Jdbc() {
		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	// 儲存MemberInfoBean物件，將參數mb新增到Member表格內。
	public int saveMember(MemberInfoBean mb) {
		String sql = "insert into `Memberinfo` " 
				+ " (m_no, m_status, m_code, m_id, m_password,"
				+ "  m_name, m_phone, m_socialnum, m_add, m_propic, m_filename, m_createtime, m_Edittime ) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, mb.getM_No());
			ps.setInt(2, mb.getM_Status());
			ps.setInt(3, mb.getM_Code());
			ps.setString(4, mb.getM_Id());
			ps.setString(5, mb.getM_Password());
			ps.setString(6, mb.getM_Name());
			ps.setString(7, mb.getM_Phone());
			ps.setString(8, mb.getM_Socialnum());
			ps.setString(9, mb.getM_Add());
			ps.setBlob(10, mb.getM_Propic());
			ps.setString(11, mb.getM_FileName());
			ps.setTimestamp(12, mb.getM_Createtime());
			ps.setTimestamp(13, mb.getM_Edittime());

			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberInfoDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		String sql = "SELECT * FROM `Memberinfo` WHERE m_id = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberInfoDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		return exist;
	}
	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public MemberInfoBean queryMember(String id) {
		MemberInfoBean mb = null;
		String sql = "SELECT * FROM `Memberinfo` WHERE m_no = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberInfoBean();
					mb.setM_No(rs.getInt("m_no"));
					mb.setM_Status(rs.getInt("m_status"));
					mb.setM_Code(rs.getInt("m_code"));
					mb.setM_Id(rs.getString("m_id"));
					mb.setM_Password(rs.getString("m_password"));
					mb.setM_Name(rs.getString("m_name"));
					mb.setM_Socialnum(rs.getString("m_socialnum"));
					mb.setM_Add(rs.getString("m_add"));
					mb.setM_Propic(rs.getBlob("m_propic"));
					mb.setM_FileName(rs.getString("m_filename"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberInfoDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Override
	public MemberInfoBean checkIdPassword(String userId, String password) {
		MemberInfoBean mb = null;
		String sql = "SELECT * FROM `Memberinfo` m WHERE m.m_id = ? and m.m_password = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, userId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberInfoBean();
					mb.setM_No(rs.getInt("m_no"));
					mb.setM_Status(rs.getInt("m_status"));
					mb.setM_Code(rs.getInt("m_code"));
					mb.setM_Id(rs.getString("m_id"));
					mb.setM_Password(rs.getString("m_password"));
					mb.setM_Name(rs.getString("m_name"));
					mb.setM_Phone(rs.getString("m_phone"));
					mb.setM_Add(rs.getString("m_add"));
					mb.setM_Propic(rs.getBlob("m_propic"));
					mb.setM_FileName(rs.getString("m_filename"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberInfoDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	/*
	 * 功能：更新客戶的未付款訂購金額。
	 * 說明：處理客戶訂單時，[訂單的總金額 + 該客戶的未付款餘額]不能超過限額，
	 * 此限額定義在 GlobalService類別的常數: ORDER_AMOUNT_LIMIT
	 * 步驟：
	 * 1. 取出Member表格內的 Member#unpaid_amount欄位(未付款餘額) 
	 * 2. unpaid_amount加上本訂單的總金額後，檢查該數值是否超過限額
	 *    (GlobalService.ORDER_AMOUNT_LIMIT)。 
	 *    如果超過限額， 則
	 *    		該訂單不予處裡， 丟出UnpaidOrderAmountExceedingException，
	 * 	    否則更新Member表格的unpaid_amount欄位: Member#unpaid_amount += currentAmount;
	 */
//	@Override
//	public void updateUnpaidOrderAmount(OrderBean ob) {
//		double currentAmount = ob.getTotalAmount(); // 取出該訂單的總金額
//		Double unpaidAmount = 0.0;
//		// 讀取Member表格中，該客戶的未付款金額(unpaid_amount)
//		String sql = "SELECT unpaid_amount FROM `Member` m WHERE m.memberId = ? ";
//		try (
//			PreparedStatement ps = conn.prepareStatement(sql);
//		) {
//			ps.setString(1, ob.getMemberId());
//			try (ResultSet rs = ps.executeQuery();) {
//				if (rs.next()) {
//					unpaidAmount = rs.getDouble(1);
//				}
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#updateUnpaidOrderAmount()發生SQL例外: " + ex.getMessage());
//		}
////        // 如果該客戶的最新未付款總額 大於 公司規定之允許未付款總額
////		if (currentAmount + unpaidAmount > GlobalService.ORDER_AMOUNT_LIMIT) {
////			throw new UnpaidOrderAmountExceedingException("未付款金額超過限額: " + (currentAmount + unpaidAmount));
////		} else {
////			;
////		}
//		// 更新Member表格之未付款餘額欄位 unpaid_amount
//		String sql1 = "UPDATE `Member` SET unpaid_amount = unpaid_amount + ? " 
//		            + " WHERE memberId = ?";
//		
//		try (
//			PreparedStatement ps1 = conn.prepareStatement(sql1);
//		) {
//			ps1.setDouble(1, currentAmount);
//			ps1.setString(2, ob.getMemberId());
//			ps1.executeUpdate();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#updateUnpaidOrderAmount()發生SQL例外: " + ex.getMessage());
//		}
//	}
	
	@Override
	public void setConnection(Connection conn) {
        this.conn = conn;
	}
}
