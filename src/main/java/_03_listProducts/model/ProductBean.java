package _03_listProducts.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class ProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_Id;
	private String p_Category;
	private String p_Name;
	private Blob p_Cover;
	private String p_FileName;
	private int p_Pdqty;
	private int p_Pdsum;
	private int p_Stock;
	private int p_Sdqty;
	private Double p_Price;
	private Blob p_Pic1;
	private String p_FileName1;
	private Blob p_Pic2;
	private String p_FileName2;
	private Blob p_Pic3;
	private String p_FileName3;
	private String p_Note;
	private Timestamp p_CreateTime;
	private Timestamp p_UpdataTime;
	
	
	public ProductBean(int p_Id, String p_Category, String p_Name, Blob p_Cover, String p_FileName, int p_Pdqty,
			int p_Pdsum, int p_Stock, int p_Sdqty, Double p_Price, Blob p_Pic1, String p_FileName1, Blob p_Pic2,
			String p_FileName2, Blob p_Pic3, String p_FileName3, String p_Note, Timestamp p_CreateTime,
			Timestamp p_UpdataTime) {
		super();
		this.p_Id = p_Id;
		this.p_Category = p_Category;
		this.p_Name = p_Name;
		this.p_Cover = p_Cover;
		this.p_FileName = p_FileName;
		this.p_Pdqty = p_Pdqty;
		this.p_Pdsum = p_Pdsum;
		this.p_Stock = p_Stock;
		this.p_Sdqty = p_Sdqty;
		this.p_Price = p_Price;
		this.p_Pic1 = p_Pic1;
		this.p_FileName1 = p_FileName1;
		this.p_Pic2 = p_Pic2;
		this.p_FileName2 = p_FileName2;
		this.p_Pic3 = p_Pic3;
		this.p_FileName3 = p_FileName3;
		this.p_Note = p_Note;
		this.p_CreateTime = p_CreateTime;
		this.p_UpdataTime = p_UpdataTime;
	}
	public ProductBean(){
		
	}
	public int getPid() {
		return p_Id;
	}
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public String getP_Category() {
		return p_Category;
	}
	public void setP_Category(String p_Category) {
		this.p_Category = p_Category;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public Blob getP_Cover() {
		return p_Cover;
	}
	public void setP_Cover(Blob p_Cover) {
		this.p_Cover = p_Cover;
	}
	public String getP_FileName() {
		return p_FileName;
	}
	public void setP_FileName(String p_FileName) {
		this.p_FileName = p_FileName;
	}
	public int getP_Pdqty() {
		return p_Pdqty;
	}
	public void setP_Pdqty(int p_Pdqty) {
		this.p_Pdqty = p_Pdqty;
	}
	public int getP_Pdsum() {
		return p_Pdsum;
	}
	public void setP_Pdsum(int p_Pdsum) {
		this.p_Pdsum = p_Pdsum;
	}
	public int getP_Stock() {
		return p_Stock;
	}
	public void setP_Stock(int p_Stock) {
		this.p_Stock = p_Stock;
	}
	public int getP_Sdqty() {
		return p_Sdqty;
	}
	public void setP_Sdqty(int p_Sdqty) {
		this.p_Sdqty = p_Sdqty;
	}
	public Double getP_Price() {
		return p_Price;
	}
	public void setP_Price(Double p_Price) {
		this.p_Price = p_Price;
	}
	public Blob getP_Pic1() {
		return p_Pic1;
	}
	public void setP_Pic1(Blob p_Pic1) {
		this.p_Pic1 = p_Pic1;
	}
	public String getP_FileName1() {
		return p_FileName1;
	}
	public void setP_FileName1(String p_FileName1) {
		this.p_FileName1 = p_FileName1;
	}
	public Blob getP_Pic2() {
		return p_Pic2;
	}
	public void setP_Pic2(Blob p_Pic2) {
		this.p_Pic2 = p_Pic2;
	}
	public String getP_FileName2() {
		return p_FileName2;
	}
	public void setP_FileName2(String p_FileName2) {
		this.p_FileName2 = p_FileName2;
	}
	public Blob getP_Pic3() {
		return p_Pic3;
	}
	public void setP_Pic3(Blob p_Pic3) {
		this.p_Pic3 = p_Pic3;
	}
	public String getP_FileName3() {
		return p_FileName3;
	}
	public void setP_FileName3(String p_FileName3) {
		this.p_FileName3 = p_FileName3;
	}
	public String getP_Note() {
		return p_Note;
	}
	public void setP_Note(String p_Note) {
		this.p_Note = p_Note;
	}
	
	public Timestamp getP_CreateTime() {
		return p_CreateTime;
	}
	public void setP_CreateTime(Timestamp p_CreateTime) {
		this.p_CreateTime = p_CreateTime;
	}
	public Timestamp getP_UpdataTime() {
		return p_UpdataTime;
	}
	public void setP_UpdataTime(Timestamp p_UpdataTime) {
		this.p_UpdataTime = p_UpdataTime;
	}
	public String getDescription() {
		return getP_Name()+ " "
				+ getP_Note().substring(0, Math.min(3, getP_Note().length()));
	}
}
