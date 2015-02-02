package ca.ualberta.cs.moneytrack;

import java.io.Serializable;

public class Item implements Serializable{
	/*
	 This is a model class
	 just contain information about item and nothing special	  
	 */
	/**
	 * general serialUID for serial
	 */
	private static final long serialVersionUID = 1988849207220243065L;
	private String itemName;
	private String itemDate;
	private String category;
	private String description;
	private int amount=0;
	private String currency;
	
	public Item(String itemName) {	
		this.itemName=itemName;
	}
	
	public void changeName(String name) {
		itemName=name;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void addItemDate(String itemDate) {
		this.itemDate=itemDate;	
	}

	public String getItemDate() {
		return this.itemDate;
	}

	public void addCategory(String category) {
		this.category=category;
	}

	public String getCategory() {
		return this.category;
	}

	public void addDescription(String description) {
		this.description=description;	
	}

	public String getDescription() {
		return this.description;
	}

	public void addAmount(int amount) {
		this.amount=amount;
	}

	public int getAmount() {
		return this.amount;
	}

	public void addCurrency(String currency) {
		this.currency=currency;
	}

	public String getCurrency() {
		return this.currency;
	}
	
	public String toString(){
		return this.itemName;		
	}
	
	//just return a string contain all information about this item
	public String email(){
		return '\n'+"Item Name:"+itemName+'\n'+"Date:"+itemDate+'\n'+"Category:"+category+'\n'+"Description:"+description+'\n'+amount+currency+'\n';
	}

}
