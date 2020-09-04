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

	
	//更新店家資訊
	@Override
	public int updatePartner(PartnerBean bean, long sizeInBytes) {
		int n = 0;
		String sql = "UPDATE partner SET " 
				+ " p_stamp=?,  p_coverPic=?,  p_service=?, p_info=?, "
				+ " p_area=?,  p_lineId=?, p_bankAcc=?, p_hRate=?  WHERE p_mId = ?";
		try (
			Connection conn = ds.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
		) {
			ps.clearParameters();
			ps.setBlob(1, bean.getP_stamp());
			ps.setBlob(2, bean.getP_coverPic());
			ps.setString(3, bean.getP_service());
			ps.setString(4, bean.getP_info());
			ps.setInt(5, bean.getP_area());
			ps.setString(6, bean.getP_lineId());
			ps.setString(7, bean.getP_bankAcc());
			ps.setInt(8, bean.getP_hRate());
			ps.setInt(9, bean.getP_mId());
			
	
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


	
	

}
