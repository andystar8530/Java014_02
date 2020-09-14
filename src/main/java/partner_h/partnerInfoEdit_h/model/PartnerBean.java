package partner_h.partnerInfoEdit_h.model; 
//合作商資料
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ch01_h_register.model.MemberBean;

@Entity
@Table(name="Partner")
public class PartnerBean implements Serializable {
	
	// 本類別封裝單筆合作商家資料	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id; //合作商家ID
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="p_mId")
	private MemberBean memberBean;
	
	@Transient
	private Integer p_mId;      //會員編號
	private String p_storeName;   //店家名稱
	private Blob p_stamp; //公司大小章
	private Blob p_coverPic; //封面圖
	private String p_service; //主要服務類型
	private String p_info;       			// 簡介
	private Integer p_area;    			// 服務區域
	private Double	p_review;     			// 評價
	private String p_lineId;    //LINE ID
	private String p_bankAcc; //銀行帳戶
	private Integer p_hRate; // 預估時薪
	private java.sql.Timestamp p_createTime;	// 會員建立日期
	private java.sql.Timestamp p_editTime;	// 最後編輯日期
	private String p_covFilename;
	private String p_staFilename;
	

	public PartnerBean() {}



		public PartnerBean(int p_id, Integer p_mId, String p_storeName, Blob p_stamp,
			Blob p_coverPic, String p_service, String p_info, Integer p_area, Double p_review, String p_lineId,
			String p_bankAcc, Integer p_hRate, Timestamp p_createTime, Timestamp p_editTime, String p_covFilename,
			String p_staFilename) {
		super();
		this.p_id = p_id;
		this.p_mId = p_mId;
		this.p_storeName = p_storeName;
		this.p_stamp = p_stamp;
		this.p_coverPic = p_coverPic;
		this.p_service = p_service;
		this.p_info = p_info;
		this.p_area = p_area;
		this.p_review = p_review;
		this.p_lineId = p_lineId;
		this.p_bankAcc = p_bankAcc;
		this.p_hRate = p_hRate;
		this.p_createTime = p_createTime;
		this.p_editTime = p_editTime;
		this.p_covFilename = p_covFilename;
		this.p_staFilename = p_staFilename;
	}





		/**
		 * @return the p_id
		 */
		public int getP_id() {
			return p_id;
		}






		/**
		 * @param p_id the p_id to set
		 */
		public void setP_id(int p_id) {
			this.p_id = p_id;
		}






		/**
		 * @return the memberBean
		 */
		public MemberBean getMemberBean() {
			return memberBean;
		}






		/**
		 * @param memberBean the memberBean to set
		 */
		public void setMemberBean(MemberBean memberBean) {
			this.memberBean = memberBean;
		}






		/**
		 * @return the p_mId
		 */
		public Integer getP_mId() {
			return p_mId;
		}






		/**
		 * @param p_mId the p_mId to set
		 */
		public void setP_mId(Integer p_mId) {
			this.p_mId = p_mId;
		}






		/**
		 * @return the p_storeName
		 */
		public String getP_storeName() {
			return p_storeName;
		}






		/**
		 * @param p_storeName the p_storeName to set
		 */
		public void setP_storeName(String p_storeName) {
			this.p_storeName = p_storeName;
		}






		/**
		 * @return the p_stamp
		 */
		public Blob getP_stamp() {
			return p_stamp;
		}






		/**
		 * @param p_stamp the p_stamp to set
		 */
		public void setP_stamp(Blob p_stamp) {
			this.p_stamp = p_stamp;
		}






		/**
		 * @return the p_coverPic
		 */
		public Blob getP_coverPic() {
			return p_coverPic;
		}






		/**
		 * @param p_coverPic the p_coverPic to set
		 */
		public void setP_coverPic(Blob p_coverPic) {
			this.p_coverPic = p_coverPic;
		}






		/**
		 * @return the p_service
		 */
		public String getP_service() {
			return p_service;
		}






		/**
		 * @param p_service the p_service to set
		 */
		public void setP_service(String p_service) {
			this.p_service = p_service;
		}






		/**
		 * @return the p_info
		 */
		public String getP_info() {
			return p_info;
		}






		/**
		 * @param p_info the p_info to set
		 */
		public void setP_info(String p_info) {
			this.p_info = p_info;
		}






		/**
		 * @return the p_area
		 */
		public Integer getP_area() {
			return p_area;
		}






		/**
		 * @param p_area the p_area to set
		 */
		public void setP_area(Integer p_area) {
			this.p_area = p_area;
		}






		/**
		 * @return the p_review
		 */
		public Double getP_review() {
			return p_review;
		}






		/**
		 * @param p_review the p_review to set
		 */
		public void setP_review(Double p_review) {
			this.p_review = p_review;
		}






		/**
		 * @return the p_lineId
		 */
		public String getP_lineId() {
			return p_lineId;
		}






		/**
		 * @param p_lineId the p_lineId to set
		 */
		public void setP_lineId(String p_lineId) {
			this.p_lineId = p_lineId;
		}






		/**
		 * @return the p_bankAcc
		 */
		public String getP_bankAcc() {
			return p_bankAcc;
		}






		/**
		 * @param p_bankAcc the p_bankAcc to set
		 */
		public void setP_bankAcc(String p_bankAcc) {
			this.p_bankAcc = p_bankAcc;
		}






		/**
		 * @return the p_hRate
		 */
		public Integer getP_hRate() {
			return p_hRate;
		}






		/**
		 * @param p_hRate the p_hRate to set
		 */
		public void setP_hRate(Integer p_hRate) {
			this.p_hRate = p_hRate;
		}






		/**
		 * @return the p_createTime
		 */
		public java.sql.Timestamp getP_createTime() {
			return p_createTime;
		}






		/**
		 * @param p_createTime the p_createTime to set
		 */
		public void setP_createTime(java.sql.Timestamp p_createTime) {
			this.p_createTime = p_createTime;
		}






		/**
		 * @return the p_editTime
		 */
		public java.sql.Timestamp getP_editTime() {
			return p_editTime;
		}






		/**
		 * @param p_editTime the p_editTime to set
		 */
		public void setP_editTime(java.sql.Timestamp p_editTime) {
			this.p_editTime = p_editTime;
		}






		/**
		 * @return the p_covFilename
		 */
		public String getP_covFilename() {
			return p_covFilename;
		}






		/**
		 * @param p_covFilename the p_covFilename to set
		 */
		public void setP_covFilename(String p_covFilename) {
			this.p_covFilename = p_covFilename;
		}






		/**
		 * @return the p_staFilename
		 */
		public String getP_staFilename() {
			return p_staFilename;
		}






		/**
		 * @param p_staFilename the p_staFilename to set
		 */
		public void setP_staFilename(String p_staFilename) {
			this.p_staFilename = p_staFilename;
		}






		@Override
		public String toString() {
			return p_id+"/"+p_storeName+"/"+p_info+"/"+p_lineId;
		}


	


	
	

}