package partner.partnerInfoEdit.service;


import java.sql.Connection;

import partner.partnerInfoEdit.model.PartnerBean;

public interface PartnerService {
	
	// 依pmId來查詢單筆記錄
	PartnerBean getPartner(int p_mId) ;//由一id取得某合作商資料
	
	public PartnerBean queryPartner(String p_mId);


	
	public int updatePartner(PartnerBean mb); 
	
	public int savePartner(PartnerBean mb);//參考老師saveMember(MemberBean mb)
	
	public boolean idExists(String p_mId);
}
