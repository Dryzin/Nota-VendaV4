package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	
	private List<SaleItem> items = new ArrayList<>();
	
	private PaymentMethod paymentMethod;
	
	public void setPaymentMethod(String payment) {
		paymentMethod = DataBase.selectPayment(payment);
	}
	
	public String getPaymentMethod() {
		return paymentMethod.toString();
	}
	
	public void createSaleItem(String code, int quantity) {
		SaleItem item = new SaleItem();
		
		item.createProduct(code, quantity);
		
		items.add(item);
	}
	
	public double getTotal() {
		double total = 0;
		
		for (SaleItem saleItem : items) 
			total += saleItem.getSubtotal();
		
		return total;
	}
	
	public List<String> getItems() {
		List<String> itemsStr = new ArrayList<>();
		
		for (SaleItem saleItem : items)
			itemsStr.add(saleItem.toString());
		
		return itemsStr;
	}
	
	public double getFinalPrice() {
		return paymentMethod.calculate(getTotal());
	}
}
