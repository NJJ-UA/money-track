package ca.ualberta.cs.moneytrack;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * general serialUID for serial
	 */
	private static final long serialVersionUID = 1988849207220243065L;
	protected String itemName;
	protected String itemDate;
	protected String category;
	protected String description;
	protected int amount;
	protected String currency;
	
	public Item(String itemName) {
		// TODO Auto-generated constructor stub
		this.itemName=itemName;
	}

	public String getItemName() {
		// TODO Auto-generated method stub
		
		return this.itemName;
	}

	public void addItemDate(String itemDate) {
		// TODO Auto-generated method stub
		this.itemDate=itemDate;
		
	}

	public String getItemDate() {
		// TODO Auto-generated method stub
		return this.itemDate;
	}

	public void addCategory(String category) {
		// TODO Auto-generated method stub
		this.category=category;
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return this.category;
	}

	public void addDescription(String description) {
		// TODO Auto-generated method stub
		this.description=description;
		
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	public void addAmount(int amount) {
		// TODO Auto-generated method stub
		this.amount=amount;
	}

	public int getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	public void addCurrency(String currency) {
		// TODO Auto-generated method stub
		this.currency=currency;
	}

	public String getCurrency() {
		// TODO Auto-generated method stub
		return this.currency;
	}
	
	public String toString(){
		return this.itemName;		
	}

	public void changeName(String name) {
		// TODO Auto-generated method stub
		itemName=name;
	}

}
