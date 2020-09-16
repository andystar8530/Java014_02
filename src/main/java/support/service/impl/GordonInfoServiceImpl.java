package support.service.impl;

import support.dao.impl.GordonDao;
import support.dao.GordonInfoDao;
import support.model.gordonBean;
import support.service.GordonInfoService;

public class GordonInfoServiceImpl implements GordonInfoService {

	GordonInfoDao dao;

	public GordonInfoServiceImpl() {
		this.dao = new GordonDao();
	}

	@Override
	public int saveproduct(gordonBean mb) {
		return dao.saveproduct(mb);
	}
}
