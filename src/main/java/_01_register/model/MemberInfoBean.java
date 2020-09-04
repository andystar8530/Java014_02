package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.Date;

public class MemberInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int m_No;
	private int m_Status;
	private int m_Code;
	private String m_Id;
	private String m_Password;
	private String m_Name;
	private String m_Phone;
	private String m_Socialnum;
	private String m_Add;
	private Blob m_Propic;
	private String m_FileName;
//	private String m_availabletime;
	private Timestamp m_Createtime;
	private Timestamp m_Edittime;

	public MemberInfoBean() {
	}

	public MemberInfoBean(int m_No, int m_Status, int m_Code, String m_Id, String m_Password, String m_Name,
			String m_Phone, String m_Socialnum, String m_Add, Blob m_Propic, String m_FileName,
			Timestamp m_Createtime, Timestamp m_Edittime) {
		super();
		this.m_No = m_No;
		this.m_Status = m_Status;
		this.m_Code = m_Code;
		this.m_Id = m_Id;
		this.m_Password = m_Password;
		this.m_Name = m_Name;
		this.m_Phone = m_Phone;
		this.m_Socialnum = m_Socialnum;
		this.m_Add = m_Add;
		this.m_Propic = m_Propic;
		this.m_FileName = m_FileName;
		this.m_Createtime = m_Createtime;
		this.m_Edittime=m_Edittime;
	}

	public String toString() {
		return "userid=" + m_Id + " Password=" + m_Password;
	}

	public int getM_No() {
		return m_No;
	}

	public void setM_No(int m_No) {
		this.m_No = m_No;
	}

	public int getM_Status() {
		return m_Status;
	}

	public void setM_Status(int m_Status) {
		this.m_Status = m_Status;
	}

	public int getM_Code() {
		return m_Code;
	}

	public void setM_Code(int m_Code) {
		this.m_Code = m_Code;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Account) {
		this.m_Id = m_Account;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String m_Password) {
		this.m_Password = m_Password;
	}

	public String getM_Name() {
		return m_Name;
	}

	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	public String getM_Phone() {
		return m_Phone;
	}

	public void setM_Phone(String m_Phone) {
		this.m_Phone = m_Phone;
	}

	public String getM_Socialnum() {
		return m_Socialnum;
	}

	public void setM_Socialnum(String m_Socialnum) {
		this.m_Socialnum = m_Socialnum;
	}

	public String getM_Add() {
		return m_Add;
	}

	public void setM_Add(String m_Add) {
		this.m_Add = m_Add;
	}

	public Blob getM_Propic() {
		return m_Propic;
	}

	public void setM_Propic(Blob m_Propic) {
		this.m_Propic = m_Propic;
	}

	public String getM_FileName() {
		return m_FileName;
	}

	public void setM_FileName(String m_FileName) {
		this.m_FileName = m_FileName;
	}

	public Timestamp getM_Createtime() {
		return m_Createtime;
	}

	public void setM_Createtime(Timestamp m_Createtime) {
		this.m_Createtime = m_Createtime;
	}

	public Timestamp getM_Edittime() {
		return m_Edittime;
	}

	public void setM_Edittime(Timestamp m_Edittime) {
		this.m_Edittime = m_Edittime;
	}

}
