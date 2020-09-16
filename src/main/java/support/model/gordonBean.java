package support.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

public class gordonBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int P_ID;
	private String P_CATEGORY;
	private String P_NAME;
	private Blob P_COVER;
	private String P_FILENAME;
	private int P_PDQTY;
	private int P_PDSUM;
	private int P_STOCK;
	private int P_SDQTY;
	private Double P_PRICE;
	private Blob P_PIC1;
	private String P_FILENAME1;
	private Blob P_PIC2;
	private String P_FILENAME2;
	private Blob P_PIC3;
	private String P_FILENAME3;
	
	
	
	public int getP_ID() {
		return P_ID;
	}
	public gordonBean() {
	super();
}
	public gordonBean(int p_ID, String p_CATEGORY, String p_NAME, Blob p_COVER, String p_FILENAME, int p_PDQTY,
			int p_PDSUM, int p_STOCK, int p_SDQTY, Double p_PRICE, Blob p_PIC1, String p_FILENAME1, Blob p_PIC2,
			String p_FILENAME2, Blob p_PIC3, String p_FILENAME3) {
		super();
		P_ID = p_ID;
		P_CATEGORY = p_CATEGORY;
		P_NAME = p_NAME;
		P_COVER = p_COVER;
		P_FILENAME = p_FILENAME;
		P_PDQTY = p_PDQTY;
		P_PDSUM = p_PDSUM;
		P_STOCK = p_STOCK;
		P_SDQTY = p_SDQTY;
		P_PRICE = p_PRICE;
		P_PIC1 = p_PIC1;
		P_FILENAME1 = p_FILENAME1;
		P_PIC2 = p_PIC2;
		P_FILENAME2 = p_FILENAME2;
		P_PIC3 = p_PIC3;
		P_FILENAME3 = p_FILENAME3;
	}
	public void setP_ID(int p_ID) {
		P_ID = p_ID;
	}
	public String getP_CATEGORY() {
		return P_CATEGORY;
	}
	public void setP_CATEGORY(String p_CATEGORY) {
		P_CATEGORY = p_CATEGORY;
	}
	public String getP_NAME() {
		return P_NAME;
	}
	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}
	public Blob getP_COVER() {
		return P_COVER;
	}
	public void setP_COVER(Blob p_COVER) {
		P_COVER = p_COVER;
	}
	public String getP_FILENAME() {
		return P_FILENAME;
	}
	public void setP_FILENAME(String p_FILENAME) {
		P_FILENAME = p_FILENAME;
	}
	public int getP_PDQTY() {
		return P_PDQTY;
	}
	public void setP_PDQTY(int p_PDQTY) {
		P_PDQTY = p_PDQTY;
	}
	public int getP_PDSUM() {
		return P_PDSUM;
	}
	public void setP_PDSUM(int p_PDSUM) {
		P_PDSUM = p_PDSUM;
	}
	public int getP_STOCK() {
		return P_STOCK;
	}
	public void setP_STOCK(int p_STOCK) {
		P_STOCK = p_STOCK;
	}
	public int getP_SDQTY() {
		return P_SDQTY;
	}
	public void setP_SDQTY(int p_SDQTY) {
		P_SDQTY = p_SDQTY;
	}
	public Double getP_PRICE() {
		return P_PRICE;
	}
	public void setP_PRICE(Double p_PRICE) {
		P_PRICE = p_PRICE;
	}
	public Blob getP_PIC1() {
		return P_PIC1;
	}
	public void setP_PIC1(Blob p_PIC1) {
		P_PIC1 = p_PIC1;
	}
	public String getP_FILENAME1() {
		return P_FILENAME1;
	}
	public void setP_FILENAME1(String p_FILENAME1) {
		P_FILENAME1 = p_FILENAME1;
	}
	public Blob getP_PIC2() {
		return P_PIC2;
	}
	public void setP_PIC2(Blob p_PIC2) {
		P_PIC2 = p_PIC2;
	}
	public String getP_FILENAME2() {
		return P_FILENAME2;
	}
	public void setP_FILENAME2(String p_FILENAME2) {
		P_FILENAME2 = p_FILENAME2;
	}
	public Blob getP_PIC3() {
		return P_PIC3;
	}
	public void setP_PIC3(Blob p_PIC3) {
		P_PIC3 = p_PIC3;
	}
	public String getP_FILENAME3() {
		return P_FILENAME3;
	}
	public void setP_FILENAME3(String p_FILENAME3) {
		P_FILENAME3 = p_FILENAME3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	


}
