package _01_register.dao;

import java.sql.Connection;

import _01_register.model.MemberInfoBean;
//import _04_ShoppingCart.model.OrderBean;

public interface MemberInfoDao {
	
	public boolean idExists(String id);

	public int saveMember(MemberInfoBean mb) ;
	
	public MemberInfoBean queryMember(String id);
	
	public MemberInfoBean checkIdPassword(String userId, String password);	
	
//	void updateUnpaidOrderAmount(OrderBean ob);

	public void setConnection(Connection con);
}