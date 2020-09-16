package forum.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forum")
public class ForumBean implements Serializable {
private static final long serialVersionUID=1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer F_Id;

@Column(name = "M_NO")
private Integer M_No;
@Column(name = "F_TITLE")
private String F_Title;
@Column(name = "F_TEXT")
private String F_Text;
@Column(name = "F_TIME")
private Date F_Time;
@Column(name = "F_COM")
private Integer F_Com;
@Column(name = "F_CATEGORY")
private Integer F_Category;
@Column(name = "F_LIKE")
private Integer F_Like;

public ForumBean() {
	super();
}

public Integer getF_Id() {
	return F_Id;
}

public void setF_Id(Integer f_Id) {
	F_Id = f_Id;
}

public ForumBean(Integer f_Id, String f_Title, String f_Text) {
	super();
	F_Id = f_Id;
	F_Title = f_Title;
	F_Text = f_Text;
}


public Integer getM_No() {
	return M_No;
}
public void setM_No(Integer m_No) {
	M_No = m_No;
}
public String getF_Title() {
	return F_Title;
}
public void setF_Title(String f_Title) {
	F_Title = f_Title;
}
public String getF_Text() {
	return F_Text;
}
public void setF_Text(String f_Text) {
	F_Text = f_Text;
}
public Date getF_Time() {
	return F_Time;
}
public void setF_Time(Date f_Time) {
	F_Time = f_Time;
}
public Integer getF_Com() {
	return F_Com;
}
public void setF_Com(Integer f_Com) {
	F_Com = f_Com;
}
public Integer getF_Category() {
	return F_Category;
}
public void setF_Category(Integer f_Category) {
	F_Category = f_Category;
}
public Integer getF_Like() {
	return F_Like;
}
public void setF_Like(Integer f_Like) {
	F_Like = f_Like;
}

@Override
public String toString() {
	return "ForumBean [F_Id=" + F_Id + ", M_No=" + M_No + ", F_Title=" + F_Title + ", F_Text=" + F_Text + ", F_Time="
			+ F_Time + ", F_Com=" + F_Com + ", F_Category=" + F_Category + ", F_Like=" + F_Like + "]";
}

}