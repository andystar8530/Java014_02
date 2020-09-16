package support; 

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer PAID;   			//  編號
	private String PANAME;               // 名稱
	private String PACONTENT;  
	private Timestamp PADATE;
	private Timestamp PAENDATE;//內容
	
	
	public MemberBean() {
	} 
	

	public MemberBean(Integer PAID, String PANAME, String PACONTENT,Timestamp PADATE,Timestamp PAENDATE ) {
		super();
		this.PAID = PAID;
		this.PANAME = PANAME;
		this.PACONTENT = PACONTENT;
		this.PADATE = PADATE;
		this.PAENDATE = PAENDATE;
	}

	public Integer getPAID() {
		return PAID;
	}

	public void setPAID(Integer pAID) {
		PAID = pAID;
	}

	public String getPANAME() {
		return PANAME;
	}

	public void setPANAME(String pANAME) {
		PANAME = pANAME;
	}

	public String getPACONTENT() {
		return PACONTENT;
	}

	public void setPACONTENT(String pACONTENT) {
		PACONTENT = pACONTENT;
	}

	public Timestamp getPADATE() {
		return PADATE;
	}

	public void setPADATE(Timestamp pADATE) {
		PADATE = pADATE;
	}

	public Timestamp getPAENDATE() {
		return PAENDATE;
	}

	public void setPAENDATE(Timestamp pAENDATE) {
		PAENDATE = pAENDATE;
	}


	@Override
	public String toString() {
		return "MemberBean [PAID=" + PAID + ", PANAME=" + PANAME + ", PACONTENT=" + PACONTENT + ", PADATE=" + PADATE
				+ ", PAENDATE=" + PAENDATE + "]";
	}

	
//	public String toString() {
//		return "["+memNo+","+mname+","+content+"]";
//	}	
//
//	public String getMemNo() {
//		return memNo;
//	}
//
//	public void setMemNo(String memNo) {
//		this.memNo = memNo;
//	}
//
//
//	public String getMname() {
//		return mname;
//	}
//
//	public void setMname(String mname) {
//		this.mname = mname;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//


	
	
}