package _04_ShoppingCart.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
public class ShoppingCart {   
	
	private Map<Integer, SaleOrderItemBean> cart = new LinkedHashMap< >();
	
	public ShoppingCart() {
	}
	
	public Map<Integer, SaleOrderItemBean>  getContent() { // ${ShoppingCart.content}
		return cart;
	}
	public void addToCart(int p_Id, SaleOrderItemBean  oib) {
		if (oib.getSoiQty() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(p_Id) == null ) {
		    cart.put(p_Id, oib);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			SaleOrderItemBean oiBean = cart.get(p_Id);
			// 加購的數量：bean.getQuantity()
			// 原有的數量：oBean.getQuantity()			
			oiBean.setSoiQty(oib.getSoiQty() + oiBean.getSoiQty());
		}
	}

	public boolean modifyQty(int p_Id, int newQty) {
		if ( cart.get(p_Id) != null ) {
			SaleOrderItemBean  bean = cart.get(p_Id);
		   bean.setSoiQty(newQty);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteBook(int p_Id) {
		if ( cart.get(p_Id) != null ) {
	       cart.remove(p_Id);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){   // ShoppingCart.itemNumber
		return cart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		double subTotal = 0 ;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			SaleOrderItemBean oib = cart.get(n);
			double price    = oib.getSoiPrice();
//			double discount = oib.getSoiSub();
			int qty      = oib.getSoiQty();
//			subTotal +=  price * discount * qty;
			subTotal +=  price * qty;
		}
		return subTotal;
	}
}
