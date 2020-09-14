package partner_h.partnerInfoEdit_h.dao.Impl;

import java.io.Serializable;
import java.sql.Connection;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ch01_h_register.dao.MemberDao;
import ch01_h_register.model.MemberBean;
import partner_h.partnerInfoEdit_h.dao.PartnerDao;
import partner_h.partnerInfoEdit_h.model.PartnerBean;
import partner_h.partnerInfoEdit_h.util.HibernateUtils;

public class PartnerDaoImpl_Hibernate implements Serializable , PartnerDao{


	private static final long serialVersionUID = 1L;

	SessionFactory factory;
	
	public PartnerDaoImpl_Hibernate() {
		this.factory = HibernateUtils.getSessionFactory();
	}
	

	//由一id取得某合作商資料
	@Override
	public PartnerBean getPartner(int p_mId) {
		PartnerBean pb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM PartnerBean WHERE p_mId = :mid";
		
		try {
			pb = (PartnerBean) session.createQuery(hql)
					.setParameter("mid",p_mId)
					.getSingleResult();
		}catch (NoResultException e) {
			pb = null; 
		}	
		return pb;
	}

	
	@Override
	public int savePartner(PartnerBean pb) {
		int n = 0 ;
		Session session = factory.getCurrentSession();
		if(pb.getMemberBean() == null) {
			MemberBean mb = session.get(MemberBean.class,pb.getP_mId());
			pb.setMemberBean(mb);
		}
		session.persist(pb);
		n++;
		return n;
	}


	//更新店家資訊
	@Override
	public int updatePartner(PartnerBean pb) {
		
		int n = 0;
		
		
		
		PartnerBean bean = null;
//		
//		String hql1 = "FROM PartnerBean p WHERE p.p_mId = :p_mid";
//		String hql2="UPDATE PartnerBean p SET "
//					+" p.p_storeName=:p_storeName,p.p_info=:p_info,p.p_coverPic=:p_coverPic, p.p_stamp=:p_stamp,"
//					+ " p.p_service=:p_service,p.p_area=:p_area,p.p_review=:p_review,p.p_bankAcc=:p_bankAcc,"
//					+ " p.p_lineId=:p_lineId,p.p_hRate=:p_hRate,p.p_createTime=:p_createTime,p.p_editTime=:p_editTime,"
//					+ " p.p_covFilename=:p_covFilename ,p.p_staFilename=:p_staFilename" ;
//	
		Session session = factory.getCurrentSession();
		session.merge(pb);
		n++;
//		try {
//			 bean = (PartnerBean) session.createQuery(hql1).setParameter("p_mid",pb.getMemberBean().getM_No()).getSingleResult();
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("合作商" + pb.getMemberBean().getM_No() + "不存在");
//		}
//		
//		n = session.createNamedQuery(hql2).setParameter("p_storeName", bean.getP_storeName())
//									.setParameter("p_info", bean.getP_info())
//									.setParameter("p_coverPic", bean.getP_coverPic())
//									.setParameter("p_stamp", bean.getP_stamp())
//									.setParameter("p_service",  bean.getP_service())
//									.setParameter("p_area", bean.getP_area())
//									.setParameter("p_review", bean.getP_review())
//									.setParameter("p_bankAcc", bean.getP_bankAcc())
//									.setParameter("p_lineId", bean.getP_lineId())
//									.setParameter("p_hRate", bean.getP_hRate())
//									.setParameter("p_createTime", bean.getP_createTime())
//									.setParameter("p_editTime", bean.getP_editTime())
//									.setParameter("p_covFilename", bean.getP_covFilename())
//									.setParameter("p_staFilename", bean.getP_staFilename())
//									.executeUpdate();
			
		return n;
	}



	@Override
	public void setConnection(Connection conn) {
//		 this.conn = conn;
		
	}


	@Override
	public PartnerBean queryPartner(String p_mid) {
		PartnerBean bean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM PartnerBean p  WHERE p.p_mId = :mid";
		try {
		bean = (PartnerBean) session.createQuery(hql).setParameter("mid", p_mid)
								.getSingleResult();
		}catch(NoResultException e) {
			bean = null ;
			
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
		Session session = factory.getCurrentSession();
		String hql = "FROM PartnerBean WHERE p_mId = :mid";
		try {
			PartnerBean pb = (PartnerBean) session.createQuery(hql)
							.setParameter("mid",p_mId)
							.getSingleResult();
			if(pb != null) {
				exist = true ;
			}
			
		}catch (NoResultException e) {
			exist = false;
		}catch (NonUniqueResultException ex) {
			exist = true ;
		}

		return exist;
		
	}


	
	

}
