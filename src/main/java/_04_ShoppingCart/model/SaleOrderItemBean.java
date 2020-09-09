package _04_ShoppingCart.model;

//本類別封裝單筆訂單資料
public class SaleOrderItemBean {

	Integer soiNo;
	Integer soi_S_OrderNo;
	Integer soi_P_Id;
	String soiDescription;
	Integer soiQty;
	Double soiPrice;
	Double soiSub;
	
	public SaleOrderItemBean(Integer soiNo, Integer soi_S_OrderNo, Integer soi_P_Id, String soiDescription,
			Integer soiQty, Double soiPrice, Double soiSub) {
		super();
		this.soiNo = soiNo;
		this.soi_S_OrderNo = soi_S_OrderNo;
		this.soi_P_Id = soi_P_Id;
		this.soiDescription = soiDescription;
		this.soiQty = soiQty;
		this.soiPrice = soiPrice;
		this.soiSub = soiSub;
	}
	public Integer getSoiNo() {
		return soiNo;
	}
	public void setSoiNo(Integer soiNo) {
		this.soiNo = soiNo;
	}
	public Integer getSoi_S_OrderNo() {
		return soi_S_OrderNo;
	}
	public void setSoi_S_OrderNo(Integer soi_S_OrderNo) {
		this.soi_S_OrderNo = soi_S_OrderNo;
	}
	public Integer getSoi_P_Id() {
		return soi_P_Id;
	}
	public void setSoi_P_Id(Integer soi_P_Id) {
		this.soi_P_Id = soi_P_Id;
	}
	public String getSoiDescription() {
		return soiDescription;
	}
	public void setSoiDescription(String soiDescription) {
		this.soiDescription = soiDescription;
	}
	public Integer getSoiQty() {
		return soiQty;
	}
	public void setSoiQty(Integer soiQty) {
		this.soiQty = soiQty;
	}
	public Double getSoiPrice() {
		return soiPrice;
	}
	public void setSoiPrice(Double soiPrice) {
		this.soiPrice = soiPrice;
	}
	public Double getSoiSub() {
		return soiSub;
	}
	public void setSoiSub(Double soiSub) {
		this.soiSub = soiSub;
	}
	
}