package support.dao;

import java.sql.Connection;

import support.model.gordonBean;

public interface GordonInfoDao {

	int saveproduct(gordonBean mb);

	public void setConnection(Connection con);

}