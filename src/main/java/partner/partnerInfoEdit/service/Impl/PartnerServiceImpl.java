package partner.partnerInfoEdit.service.Impl;

import partner.partnerInfoEdit.dao.PartnerDao;
import partner.partnerInfoEdit.dao.Impl.PartnerDaoImpl_Jdbc;
import partner.partnerInfoEdit.model.PartnerBean;
import partner.partnerInfoEdit.service.PartnerService;

public class PartnerServiceImpl implements PartnerService {

	PartnerDao dao ;
	//dao 不能commit，交給service去做try-catch攔截例外
	public PartnerServiceImpl() {
		this.dao = new PartnerDaoImpl_Jdbc();
	}

	
	
	@Override
	public PartnerBean getPartner(int p_mId) {	
		return dao.getPartner(p_mId);
	}



	@Override
	public int savePartner(PartnerBean mb) {
		return dao.savePartner(mb);
	}

	@Override
	public boolean idExists(String m_No) {
		return dao.idExists(m_No);
	}

	@Override
	public PartnerBean queryPartner(String p_mId) {
		return dao.queryPartner(p_mId);
	}
	
	
	
	
	
	
}
