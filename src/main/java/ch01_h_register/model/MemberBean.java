package ch01_h_register.model;

import java.io.Serializable;
import java.sql.Timestamp;

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
	private Integer M_No;
	
	@Column(name = "M_ID")
	private String M_Id;
	@Column(name = "M_PASSWORD")
	private String M_Password;
	@Column(name = "M_PHONE")
	private String M_Phone;
	@Column(name = "M_NAME")
	private String M_Name;
	@Column(name = "M_AVAILABLETIME")
	private String M_Availabletime;
	@Column(name = "M_CODE")
	private Integer M_Code;
	@Column(name = "M_CREATETIME")
	private Timestamp M_CreateTime;
	

	public MemberBean(Integer m_No, String m_Id, String m_Password, Integer m_Code) {
		super();
		M_No = m_No;
		M_Id = m_Id;
		M_Password = m_Password;
		M_Code = m_Code;
	}
	
	public MemberBean() {
		super();
	}

	public Integer getM_No() {
		return M_No;
	}

	public void setM_No(Integer m_No) {
		M_No = m_No;
	}

	public String getM_Id() {
		return M_Id;
	}

	public void setM_Id(String m_Id) {
		M_Id = m_Id;
	}

	public String getM_Password() {
		return M_Password;
	}

	public void setM_Password(String m_Password) {
		M_Password = m_Password;
	}

	public String getM_Phone() {
		return M_Phone;
	}

	public void setM_Phone(String m_Phone) {
		M_Phone = m_Phone;
	}

	public String getM_Name() {
		return M_Name;
	}

	public void setM_Name(String m_Name) {
		M_Name = m_Name;
	}

	public String getM_Availabletime() {
		return M_Availabletime;
	}

	public void setM_Availabletime(String m_Availabletime) {
		M_Availabletime = m_Availabletime;
	}

	public Integer getM_Code() {
		return M_Code;
	}

	public void setM_Code(Integer m_Code) {
		M_Code = m_Code;
	}

	public Timestamp getM_CreateTime() {
		return M_CreateTime;
	}

	public void setM_CreateTime(Timestamp m_CreateTime) {
		M_CreateTime = m_CreateTime;
	}

	@Override
	public String toString() {
		return "MemberBean [M_No=" + M_No + ", M_Id=" + M_Id + ", M_Password=" + M_Password + ", M_Phone=" + M_Phone
				+ ", M_Name=" + M_Name + ", M_Availabletime=" + M_Availabletime + ", M_Code=" + M_Code + "]";
	}

}

