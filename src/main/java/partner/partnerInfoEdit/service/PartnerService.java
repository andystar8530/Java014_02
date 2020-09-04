package partner.partnerInfoEdit.service;


import partner.partnerInfoEdit.model.PartnerBean;

public interface PartnerService {
	
	// 依pmId來查詢單筆記錄
	PartnerBean getPartner(int p_mId);
	boolean idExists(String m_No);
	int savePartner(PartnerBean mb);
	PartnerBean queryPartner(String p_mId);
}
