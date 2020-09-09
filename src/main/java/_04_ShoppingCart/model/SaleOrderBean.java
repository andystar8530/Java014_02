package _04_ShoppingCart.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
// 本類別存放訂單資料
public class SaleOrderBean {
	Integer s_OrderNo;
	Integer 	s_M_Id;
	Double	s_OrderSum;
	String	s_M_Address; 
	String  s_M_Name;
	String  s_M_Phone;
	Integer s_Status;
	Date  s_OrderDate;
	Date  shippingDate;
	Set<SaleOrderItemBean> items = new LinkedHashSet<>();
	
	public SaleOrderBean() {
		
	}

	public SaleOrderBean(Integer s_OrderNo, Integer s_M_Id, Double s_OrderSum, String s_M_Address, String s_M_Name,
			String s_M_Phone, Integer s_Status, Date s_OrderDate, Date shippingDate, Set<SaleOrderItemBean> items) {
		super();
		this.s_OrderNo = s_OrderNo;
		this.s_M_Id = s_M_Id;
		this.s_OrderSum = s_OrderSum;
		this.s_M_Address = s_M_Address;
		this.s_M_Name = s_M_Name;
		this.s_M_Phone = s_M_Phone;
		this.s_Status = s_Status;
		this.s_OrderDate = s_OrderDate;
		this.shippingDate = shippingDate;
		this.items = items;
	}

	public int getS_OrderNo() {
		return s_OrderNo;
	}

	public void setS_OrderNo(Integer s_OrderNo) {
		this.s_OrderNo = s_OrderNo;
	}

	public int getS_M_Id() {
		return s_M_Id;
	}

	public void setS_M_Id(Integer s_M_Id) {
		this.s_M_Id = s_M_Id;
	}

	public Double getS_OrderSum() {
		return s_OrderSum;
	}

	public void setS_OrderSum(Double s_OrderSum) {
		this.s_OrderSum = s_OrderSum;
	}

	public String getS_M_Address() {
		return s_M_Address;
	}

	public void setS_M_Address(String s_M_Address) {
		this.s_M_Address = s_M_Address;
	}

	public String getS_M_Name() {
		return s_M_Name;
	}

	public void setS_M_Name(String s_M_Name) {
		this.s_M_Name = s_M_Name;
	}

	public String getS_M_Phone() {
		return s_M_Phone;
	}

	public void setS_M_Phone(String s_M_Phone) {
		this.s_M_Phone = s_M_Phone;
	}

	public int getS_Status() {
		return s_Status;
	}

	public void setS_Status(Integer s_Status) {
		this.s_Status = s_Status;
	}

	public Date getS_OrderDate() {
		return s_OrderDate;
	}

	public void setS_OrderDate(Date s_OrderDate) {
		this.s_OrderDate = s_OrderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Set<SaleOrderItemBean> getItems() {
		return items;
	}

	public void setItems(Set<SaleOrderItemBean> items) {
		this.items = items;
	}

	
}
