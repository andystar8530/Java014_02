package _01_register.service;

import _01_register.model.MemberInfoBean;
//import _04_ShoppingCart.model.OrderBean;

public interface MemberInfoService {
	boolean idExists(String id);
	int saveMember(MemberInfoBean mb);
//	void updateUnpaidOrderAmount(OrderBean ob);
	MemberInfoBean queryMember(String id);
	MemberInfoBean checkIdPassword(String userId, String password) ;
}
