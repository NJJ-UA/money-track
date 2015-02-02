/*
    Money Track: Android travel expense tracking Application. UA CMPUT 301 Assignment 1
    Copyright (C) 2015  Jingjiao Ni jni1@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
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
