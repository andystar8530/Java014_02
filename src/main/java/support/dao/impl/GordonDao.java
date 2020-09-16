package support.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import support.dao.GordonInfoDao;
import support.model.gordonBean;
import support.util.DBservice;

public class GordonDao implements GordonInfoDao {

	private DataSource ds = null;
	private Connection conn = null;

	public GordonDao() {
		System.out.println("DBService.JNDI_DB_NAME=" + DBservice.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBservice.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("gordonDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}

		// 儲存MemberInfoBean物件，將參數mb新增到Member表格內。

	}

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int saveproduct(gordonBean mb) {
		String sql = "insert into `product` " + " (P_ID, P_CATEGORY, P_NAME, P_COVER, P_FILENAME,"
				+ "  P_PDQTY, P_PDSUM, P_STOCK, P_SDQTY, P_PRICE, P_PIC1,"
				+ " P_FILENAME1, P_PIC2, P_FILENAME2, P_PIC3, P_FILENAME3) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, mb.getP_ID());
			ps.setString(2, mb.getP_CATEGORY());
			ps.setString(3, mb.getP_NAME());
			ps.setBlob(4, mb.getP_COVER());
			ps.setString(5, mb.getP_FILENAME());
			ps.setInt(6, mb.getP_PDQTY());
			ps.setInt(7, mb.getP_PDSUM());
			ps.setInt(8, mb.getP_STOCK());
			ps.setInt(9, mb.getP_SDQTY());
			ps.setDouble(10, mb.getP_PRICE());
			ps.setBlob(11, mb.getP_PIC1());
			ps.setString(12, mb.getP_FILENAME1());
			ps.setBlob(13, mb.getP_PIC2());
			ps.setString(14, mb.getP_FILENAME2());
			ps.setBlob(15, mb.getP_PIC3());
			ps.setString(16, mb.getP_FILENAME3());
//			ps.setClob(17, mb.getP_NOTE());

			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberInfoDaoImpl_Jdbc類別#saveMember()發生例外: " + ex.getMessage());
		}
		return n;
	}

}
