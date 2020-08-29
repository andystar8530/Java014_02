package _03_listProducts.model;

import java.io.Serializable;
import java.sql.Blob;

public class ProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private String pcategory;
	private String pname;
	private Blob pcover;
	private String fileName;
	private String ppdqty;
	private String ppdsum;
	private String pstock;
	private String psdqty;
	private Double pprice;
	private Blob ppic1;
	private Blob ppic2;
	private Blob ppic3;
	private String pnote;

	public ProductBean(Integer pid, String pcategory, String pname, Blob pcover, String fileName, String ppdqty, String ppdsum,
			String pstock, String psdqty, Double pprice, Blob ppic1, Blob ppic2, Blob ppic3, String pnote) {
		super();
		this.pid = pid;
		this.pcategory = pcategory;
		this.pname = pname;
		this.pcover = pcover;
		this.fileName=fileName;
		this.ppdqty = ppdqty;
		this.ppdsum = ppdsum;
		this.pstock = pstock;
		this.psdqty = psdqty;
		this.pprice = pprice;
		this.ppic1 = ppic1;
		this.ppic2 = ppic2;
		this.ppic3 = ppic3;
		this.pnote = pnote;
	}
	
	public ProductBean(){
		
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Blob getPcover() {
		return pcover;
	}
	public void setPcover(Blob pcover) {
		this.pcover = pcover;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPpdqty() {
		return ppdqty;
	}
	public void setPpdqty(String ppdqty) {
		this.ppdqty = ppdqty;
	}
	public String getPpdsum() {
		return ppdsum;
	}
	public void setPpdsum(String ppdsum) {
		this.ppdsum = ppdsum;
	}
	public String getPstock() {
		return pstock;
	}
	public void setPstock(String pstock) {
		this.pstock = pstock;
	}
	public String getPsdqty() {
		return psdqty;
	}
	public void setPsdqty(String psdqty) {
		this.psdqty = psdqty;
	}
	public Double getPprice() {
		return pprice;
	}
	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}
	public Blob getPpic1() {
		return ppic1;
	}
	public void setPpic1(Blob ppic1) {
		this.ppic1 = ppic1;
	}
	public Blob getPpic2() {
		return ppic2;
	}
	public void setPpic2(Blob ppic2) {
		this.ppic2 = ppic2;
	}
	public Blob getPpic3() {
		return ppic3;
	}
	public void setPpic3(Blob ppic3) {
		this.ppic3 = ppic3;
	}
	public String getPnote() {
		return pnote;
	}
	public void setPnote(String pnote) {
		this.pnote = pnote;
	}
	
}
