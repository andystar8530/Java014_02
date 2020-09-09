package ch01_h_register.service;

import ch01_h_register.dao.MemberDao;
import ch01_h_register.model.MemberBean;

public class MemberService {

	MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	public void persist(MemberBean mb) {
		dao.persist(mb);
	}
	
	public MemberBean checkIDPassword(String id, String password) {
		MemberDao dao = new MemberDao();
		MemberBean mb = dao.select(id);
		if(mb!=null && mb.getM_Password().equals(password)) {
			return mb;
		}
		return null;
	}
	
	public MemberBean checkEmail(String id) {
		MemberDao dao = new MemberDao();
		MemberBean mb = dao.select(id);
		if(mb!=null) {
			return mb;
		}
		return null;
	}
	
	public void updateMember(MemberBean mb) {
		dao.updateMember(mb);
	}
	
	public MemberBean get(int pk) {
		return dao.get(pk);
	}
	
	public void close() {
		dao.close();
	}
}
