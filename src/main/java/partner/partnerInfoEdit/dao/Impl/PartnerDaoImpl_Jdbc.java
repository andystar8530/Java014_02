package partner.partnerInfoEdit.dao.Impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import partner.partnerInfoEdit.dao.PartnerDao;
import partner.partnerInfoEdit.model.PartnerBean;

public class PartnerDaoImpl_Jdbc implements Serializable , PartnerDao{


	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	private Connection conn = null;

	public PartnerDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("PartnerDaoImpl_Jdbc()#建構子發生例外: " 
										+ ex.getMessage());
		}
	}
	

	//由一id取得某合作商資料
	@Override
	public PartnerBean getPartner(int p_mId) {
		PartnerBean bean = null;
		String sql = "SELECT * FROM Partner WHERE p_mId = ?";

		try (
			Connection conn = ds.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
		) {
			ps.setInt(1, p_mId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new PartnerBean();
					bean.setP_id(rs.getInt("p_id"));
					bean.setP_mId(rs.getInt("p_mId"));
					bean.setP_storeName(rs.getString("p_storeName"));
					bean.setP_stamp(rs.getBlob("p_stamp"));
					bean.setP_coverPic(rs.getBlob("p_coverPic"));
					bean.setP_service(rs.getString("p_service"));
					bean.setP_info(rs.getString("p_info"));
					bean.setP_area(rs.getInt("p_area"));
					bean.setP_review(rs.getDouble("p_review"));
					bean.setP_lineId(rs.getString("p_lineId"));
					bean.setP_bankAcc(rs.getString("p_bankAcc"));
					bean.setP_hRate(rs.getInt("p_hRate"));
					bean.setP_createTime(rs.getTimestamp("p_createTime"));
					bean.setP_editTime(rs.getTimestamp("p_editTime"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#queryBook()發生例外: " 
										+ ex.getMessage());
		}
		
		return bean;
	}

	
	@Override
	public int savePartner(PartnerBean mb) {
		String sql = "insert into Partner " 
				+ " (p_Id, p_mId, p_storeName, p_info, p_coverPic,"
				+ " p_stamp, p_service, p_area, p_review, p_bankAcc, "
				+ "  p_lineId, p_hRate, p_createTime, p_editTime ,p_covFilename ,p_staFilename ) "
				+ " values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?)";
		int n = 0;
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, mb.getP_mId());
			ps.setString(2, mb.getP_storeName());
			ps.setString(3, mb.getP_info());
			ps.setBlob(4, mb.getP_coverPic());
			ps.setBlob(5, mb.getP_stamp());
			ps.setString(6, mb.getP_service());
			ps.setInt(7, mb.getP_area());
			ps.setDouble(8, mb.getP_review());
			ps.setString(9, mb.getP_bankAcc());
			ps.setString(10, mb.getP_lineId());
			ps.setInt(11, mb.getP_hRate());
			ps.setTimestamp(12, mb.getP_createTime());
			ps.setTimestamp(13, mb.getP_editTime());
			ps.setString(14, mb.getP_covFilename());
			ps.setString(15, mb.getP_staFilename());
			

			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("PartnerDaoImpl_Jdbc類別#savePartner()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}


	//更新店家資訊
	@Override
	public int updatePartner(PartnerBean mb) {
		
		int n = 0;
		String sql = "UPDATE partner SET " 
				+ " p_storeName=?,p_info=?,p_coverPic=?, p_stamp=?,p_service=?,p_area=?,p_review=?,p_bankAcc=?,p_lineId=?,p_hRate=?,p_createTime=?,p_editTime=? ,p_covFilename=? ,p_staFilename=? "
				+ " WHERE p_mId = ?";
		try (
			Connection conn = ds.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
		) {
			
			ps.clearParameters();
			ps.setString(1, mb.getP_storeName());
			ps.setString(2, mb.getP_info());
			ps.setBlob(3, mb.getP_coverPic());
			ps.setBlob(4, mb.getP_stamp());
			ps.setString(5, mb.getP_service());
			ps.setInt(6, mb.getP_area());
			ps.setDouble(7, mb.getP_review());
			ps.setString(8, mb.getP_bankAcc());
			ps.setString(9, mb.getP_lineId());
			ps.setInt(10, mb.getP_hRate());
			ps.setTimestamp(11, mb.getP_createTime());
			ps.setTimestamp(12, mb.getP_editTime());
			ps.setString(13, mb.getP_covFilename());
			ps.setString(14, mb.getP_staFilename());			
			ps.setInt(15, mb.getP_mId());
			
	
			n = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("PartnerDaoImpl_Jdbc()#updatePartner(PartnerBean)發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}



	@Override
	public void setConnection(Connection conn) {
		 this.conn = conn;
		
	}


	@Override
	public PartnerBean queryPartner(String p_mid) {
		PartnerBean bean = null;
		String sql = "SELECT * FROM Partner WHERE p_mId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, Integer.parseInt(p_mid));
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new PartnerBean();
					bean.setP_id(rs.getInt("p_id"));
					bean.setP_mId(rs.getInt("p_mId"));
					bean.setP_storeName(rs.getString("p_storeName"));
					bean.setP_stamp(rs.getBlob("p_stamp"));
					bean.setP_coverPic(rs.getBlob("p_coverPic"));
					bean.setP_service(rs.getString("p_service"));
					bean.setP_info(rs.getString("p_info"));
					bean.setP_area(rs.getInt("p_area"));
					bean.setP_review(rs.getDouble("p_review"));
					bean.setP_lineId(rs.getString("p_lineId"));
					bean.setP_bankAcc(rs.getString("p_bankAcc"));
					bean.setP_hRate(rs.getInt("p_hRate"));
					bean.setP_createTime(rs.getTimestamp("p_createTime"));
					bean.setP_editTime(rs.getTimestamp("p_editTime"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("PartnerDaoImpl_Jdbc類別#queryPartner()發生例外: " 
					+ ex.getMessage());
		}
		return bean;
	
	}


//	@Override
//	public int updatePartner(PartnerBean mb) {
//		String sql = "insert into Partner " 
//				+ " (memberID, name, password, address, email, "
//				+ " tel, userType, registerTime, totalAmt, memberImage," 
//				+ " fileName, comment, unpaid_amount) "
//				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
////		 PartnerBean(int p_id, int p_mId, String p_storeName, Blob p_stamp, Blob p_coverPic, String p_service,
////					String p_info, int p_area, double p_review, String p_lineId, String p_bankAcc, int p_hRate,
////					Timestamp p_createTime, Timestamp p_editTime, String p_covFilename, String p_staFilename) 
//		int n = 0;
//		try (
//			Connection con = ds.getConnection(); 
//			PreparedStatement ps = con.prepareStatement(sql);
//		) {
//			ps.setString(1, mb.getMemberId());
//			ps.setString(2, mb.getName());
//			
//			ps.setString(3, mb.getPassword());
//			ps.setString(4, mb.getAddress());
//			ps.setString(5, mb.getEmail());
//			ps.setString(6, mb.getTel());
//			ps.setString(7, mb.getUserType());
//			ps.setTimestamp(8, mb.getRegisterTime());
//			
//			ps.setDouble(9, mb.getTotalAmt());
//			ps.setBlob(10, mb.getMemberImage());
//			ps.setString(11, mb.getFileName());
//			ps.setClob(12, mb.getComment());
//			ps.setDouble(13, mb.getUnpaid_amount());
//			n = ps.executeUpdate();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("PartnerDaoImpl_Jdbc類別#savePartner()發生例外: " 
//										+ ex.getMessage());
//		}
//
//		return 0;
//	}


	@Override
	public boolean idExists(String p_mId) {
		boolean exist = false;
		String sql = "SELECT * FROM Partner WHERE p_mId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, p_mId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("PartnerDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		return exist;
		
	}


	
	

}
