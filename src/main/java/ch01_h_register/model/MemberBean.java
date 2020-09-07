package ch01_h_register.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberinfo")
public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer M_NO;
	
	@Column(name = "M_ID")
	private String M_ID;
	@Column(name = "M_PASSWORD")
	private String M_PASSWORD;
	@Column(name = "M_PHONE")
	private String M_PHONE;
	@Column(name = "M_NAME")
	private String M_NAME;
	@Column(name = "M_AVAILABLETIME")
	private String M_AVAILABLETIME;
	
	public MemberBean() {
		super();
	}
	public MemberBean(Integer m_NO, String m_ID, String m_PASSWORD) {
		super();
		M_NO = m_NO;
		M_ID = m_ID;
		M_PASSWORD = m_PASSWORD;
	}
	public Integer getM_NO() {
		return M_NO;
	}
	public void setM_NO(Integer m_NO) {
		M_NO = m_NO;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getM_PASSWORD() {
		return M_PASSWORD;
	}
	public void setM_PASSWORD(String m_PASSWORD) {
		M_PASSWORD = m_PASSWORD;
	}
	public String getM_PHONE() {
		return M_PHONE;
	}
	public void setM_PHONE(String m_PHONE) {
		M_PHONE = m_PHONE;
	}
	public String getM_NAME() {
		return M_NAME;
	}
	public void setM_NAME(String m_NAME) {
		M_NAME = m_NAME;
	}
	public String getM_AVAILABLETIME() {
		return M_AVAILABLETIME;
	}
	public void setM_AVAILABLETIME(String m_AVAILABLETIME) {
		M_AVAILABLETIME = m_AVAILABLETIME;
	}
	@Override
	public String toString() {
		return "MemberBean [M_NO=" + M_NO + ", M_ID=" + M_ID + ", M_PASSWORD=" + M_PASSWORD + "]";
	}
}
