package support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	
	DataSource ds = null;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MarryMeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	

	private static final String SELECT_BY_PAID = "Select  PAID, PANAME, PACONTENT, PADATE, PAENDATE from plateannouncement where PAID = ?";

	public MemberBean select(String id) {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PAID);
		) {
			stmt.setString(1, id);
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					result = new MemberBean();
					result.setPAID(rset.getInt("PAID"));
					result.setPANAME(rset.getString("PANAME"));
					result.setPACONTENT(rset.getString("PACONTENT"));
					result.setPADATE(rset.getTimestamp("PADATE"));
					result.setPAENDATE(rset.getTimestamp("PAENDATE"));
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private static final String SELECT_ALL = "Select PAID, PANAME, PACONTENT, PADATE, PAENDATE from plateannouncement";
	
	public List<MemberBean> select() {
		List<MemberBean> result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();				
		) {
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setPAID(rset.getInt("PAID"));
				temp.setPANAME(rset.getString("PANAME"));
				temp.setPACONTENT(rset.getString("PACONTENT"));
				temp.setPADATE(rset.getTimestamp("PADATE"));
				temp.setPAENDATE(rset.getTimestamp("PAENDATE"));
				result.add(temp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	private static final String INSERT = "Insert into plateannouncement (PAID, PANAME, PACONTENT, PADATE, PAENDATE) values (?, ?, ?, ? ,?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {			
			stmt.setInt(1,bean.getPAID());
			stmt.setString(1,bean.getPANAME());
			stmt.setString(1,bean.getPACONTENT());
			stmt.setTimestamp(1,bean.getPADATE());
			stmt.setTimestamp(1,bean.getPAENDATE());
		}
		return result;
	}
	private static final String update = "update  plateannouncement set PACONTENT=?  where PAID=? ";

	public MemberBean updateMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(update);
		) {
			stmt.setInt(1,bean.getPAID());
			stmt.setString(2,bean.getPANAME());
			stmt.setString(3,bean.getPACONTENT());
			stmt.setTimestamp(4,bean.getPADATE());
			stmt.setTimestamp(5,bean.getPAENDATE());
			
		}
		return result;
	}

	private static final String updatePACONTENT = "update plateannouncement set PACONTENT=? where PAID=?";

	public int updatePACONTENT(MemberBean bean) {
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(updatePACONTENT)
		) {
			stmt.setString(1, bean.getPACONTENT());
			stmt.setInt(2, bean.getPAID());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	private static final String deletePACONTENT = "Delete from plateannouncement where PAID=?";

	public int delete(String PAId) {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(deletePACONTENT);
		) {
			stmt.setString(1, PAId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}