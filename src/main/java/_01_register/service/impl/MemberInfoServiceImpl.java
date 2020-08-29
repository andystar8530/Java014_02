package _01_register.service.impl;

import _01_register.dao.MemberInfoDao;
import _01_register.dao.impl.MemberInfoDaoImpl_Jdbc;
import _01_register.model.MemberInfoBean;
import _01_register.service.MemberInfoService;
//import _04_ShoppingCart.model.OrderBean;

public class MemberInfoServiceImpl implements MemberInfoService {

	MemberInfoDao  dao ;
	public MemberInfoServiceImpl() {
		this.dao = new MemberInfoDaoImpl_Jdbc();
	}

	@Override
	public int saveMember(MemberInfoBean mb) {
		return dao.saveMember(mb);
	}

	@Override
	public boolean idExists(String id) {
		return dao.idExists(id);
	}

	@Override
	public MemberInfoBean queryMember(String id) {
		return dao.queryMember(id);
	}

//	@Override
//	public void updateUnpaidOrderAmount(OrderBean ob) {
//		dao.updateUnpaidOrderAmount(ob);
//	}
	public MemberInfoBean checkIdPassword(String userId, String password) {
		MemberInfoBean mb = dao.checkIdPassword(userId, password);
		return mb;
	}
}
