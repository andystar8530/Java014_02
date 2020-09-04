package partner.partnerInfoEdit.dao;

import java.sql.Connection;

import partner.partnerInfoEdit.model.PartnerBean;

public interface PartnerDao {
	

	PartnerBean getPartner(int p_mId) ;//由一id取得某合作商資料
	
	public PartnerBean queryPartner(String p_mId);


	int updatePartner(PartnerBean bean, long sizeInBytes) ;
	
	public void setConnection(Connection con);
	
}