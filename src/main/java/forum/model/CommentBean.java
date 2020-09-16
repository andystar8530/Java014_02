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
	@Table(name="comment")
	public class CommentBean implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer C_Id;
	
	@Column(name="C_POSTID")
	private Integer C_Postid;
	@Column(name="M_NO")
	private Integer M_No;
	@Column(name="C_TEXT")
	private String C_Text;
	@Column(name="C_TIME")
	private Date C_Time;
	@Column(name="C_LIKE")
	private Integer C_Like;
	
	public CommentBean() {
		super();
	}
	
	public CommentBean(Integer C_Id, String C_Postid, String C_Text) {
		super();
		C_Id = C_Id;
		C_Postid = C_Postid;
		C_Text = C_Text;
	}
	
	public Integer getC_Id() {
		return C_Id;
	}
	public void setC_Id(Integer c_Id) {
		C_Id = c_Id;
	}
	public Integer getC_Postid() {
		return C_Postid;
	}
	public void setC_Postid(Integer c_Postid) {
		C_Postid = c_Postid;
	}
	public Integer getM_No() {
		return M_No;
	}
	public void setM_No(Integer m_No) {
		M_No = m_No;
	}
	public String getC_Text() {
		return C_Text;
	}
	public void setC_Text(String c_Text) {
		C_Text = c_Text;
	}
	public Date getC_Time() {
		return C_Time;
	}
	public void setC_Time(Date c_Time) {
		C_Time = c_Time;
	}
	public Integer getC_Like() {
		return C_Like;
	}
	public void setC_Like(Integer c_Like) {
		C_Like = c_Like;
	}
	@Override
	public String toString() {
		return "CommentBean [C_Id=" + C_Id + ", C_Postid=" + C_Postid + ", C_Text=" + C_Text + "]";
	}
	
}

