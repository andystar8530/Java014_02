package partner.partnerInfoEdit.model; 
//合作商資料
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;


public class PartnerBean implements Serializable {
	
	// 本類別封裝單筆合作商家資料	
	private static final long serialVersionUID = 1L;
	private int p_id;      //合作商家ID
	private int p_mId;      //會員編號
	private String p_storeName;   //店家名稱
	private Blob p_stamp; //公司大小章
	private Blob p_coverPic; //封面圖
	private String p_service; //主要服務類型
	private String p_info;       			// 簡介
	private int p_area;    			// 服務區域
	private double	p_review;     			// 評價
	private String p_lineId;    //LINE ID
	private String p_bankAcc; //銀行帳戶
	private int p_hRate; // 預估時薪
	private java.sql.Timestamp p_createTime;	// 會員建立日期
	private java.sql.Timestamp p_editTime;	// 最後編輯日期
	private String p_covFilename;
	private String p_staFilename;
	

	

		public PartnerBean() {
		super();
	}
		




		public PartnerBean(int p_id, int p_mId, String p_storeName, Blob p_stamp, Blob p_coverPic, String p_service,
				String p_info, int p_area, double p_review, String p_lineId, String p_bankAcc, int p_hRate,
				Timestamp p_createTime, Timestamp p_editTime, String p_covFilename, String p_staFilename) {
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

		

		public int getP_id() {
			return p_id;
		}



		public void setP_id(int p_id) {
			this.p_id = p_id;
		}



		public int getP_mId() {
			return p_mId;
		}



		public void setP_mId(int p_mId) {
			this.p_mId = p_mId;
		}



		public String getP_storeName() {
			return p_storeName;
		}



		public void setP_storeName(String p_storeName) {
			this.p_storeName = p_storeName;
		}



		public Blob getP_stamp() {
			return p_stamp;
		}



		public void setP_stamp(Blob p_stamp) {
			this.p_stamp = p_stamp;
		}



		public Blob getP_coverPic() {
			return p_coverPic;
		}



		public void setP_coverPic(Blob p_coverPic) {
			this.p_coverPic = p_coverPic;
		}



		public String getP_service() {
			return p_service;
		}



		public void setP_service(String p_service) {
			this.p_service = p_service;
		}



		public String getP_info() {
			return p_info;
		}



		public void setP_info(String p_info) {
			this.p_info = p_info;
		}



		public int getP_area() {
			return p_area;
		}



		public void setP_area(int p_area) {
			this.p_area = p_area;
		}



		public double getP_review() {
			return p_review;
		}



		public void setP_review(double p_review) {
			this.p_review = p_review;
		}



		public String getP_lineId() {
			return p_lineId;
		}



		public void setP_lineId(String p_lineId) {
			this.p_lineId = p_lineId;
		}



		public String getP_bankAcc() {
			return p_bankAcc;
		}



		public void setP_bankAcc(String p_bankAcc) {
			this.p_bankAcc = p_bankAcc;
		}



		public int getP_hRate() {
			return p_hRate;
		}



		public void setP_hRate(int p_hRate) {
			this.p_hRate = p_hRate;
		}



		public java.sql.Timestamp getP_createTime() {
			return p_createTime;
		}



		public void setP_createTime(java.sql.Timestamp p_createTime) {
			this.p_createTime = p_createTime;
		}



		public java.sql.Timestamp getP_editTime() {
			return p_editTime;
		}



		public void setP_editTime(java.sql.Timestamp p_editTime) {
			this.p_editTime = p_editTime;
		}



		public String getP_covFilename() {
			return p_covFilename;
		}



		public void setP_covFilename(String p_covFilename) {
			this.p_covFilename = p_covFilename;
		}





		public String getP_staFilename() {
			return p_staFilename;
		}





		public void setP_staFilename(String p_staFilename) {
			this.p_staFilename = p_staFilename;
		}





		@Override
		public String toString() {
			return p_id+"/"+p_storeName+"/"+p_info+"/"+p_lineId;
		}


	


	
	

}