package partner_h.partnerInfoEdit_h.dao;

import java.sql.Connection;

import partner_h.partnerInfoEdit_h.model.PartnerBean;



public interface PartnerDao {
	


	PartnerBean getPartner(int p_mId) ;//由一id取得某合作商資料
	
	public PartnerBean queryPartner(String p_mId);

	
	public void setConnection(Connection con);
	
	public int updatePartner(PartnerBean mb); 
	
	public int savePartner(PartnerBean mb);//參考老師saveMember(MemberBean mb)
	
	public boolean idExists(String p_mId);
	
	
}