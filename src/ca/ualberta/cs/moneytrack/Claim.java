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
import java.util.ArrayList;

public class Claim implements Serializable {
	/*
	This is a model class
	Claim will contain some Items
	and also have its own attributes.
	Some explain comment are written before function.
	You can find the explain of  StatusException in
	the comment in StatusException.java
	*/
	/**
	 * gerneral serial UID for serial
	 */
	private static final long serialVersionUID = 1954300208436592429L;
	private String claimName;
	private String beginDate;
	private String endDate;
	private String descript;
	private Item currentItem;
	private String status="In progress";
	private ArrayList<Item> itemList;
	public transient Listener listener;
	
	public Claim(String claimName) {
		this.claimName=claimName;
		itemList=new ArrayList<Item>();
	}
	
	public void changeClaimName(String string) throws StatusException {
		if(status.equals("Submitted") ||status.equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		claimName=string;	
	}
	
	public String getClaimName() {
		return this.claimName;
	}
	
	public void addBeginDate(String beginDate) throws StatusException {
		if(status.equals("Submitted") ||status.equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		this.beginDate=beginDate;
	}
	
	public String getBeginDate() {
		return this.beginDate;
	}
	
	public void addEndDate(String endDate) throws StatusException {
		if(status.equals("Submitted") ||status.equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		this.endDate=endDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public void addDescript(String descript) throws StatusException {
		if(status.equals("Submitted") ||status.equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		this.descript=descript;
	}
	
	public String getDescript() {
		return descript;
	}
	
	public void addItem(Item item) throws StatusException {
		if(status.equals("Submitted") ||status.equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		itemList.add(item);
	}
	
	public void deleteItem(Item item) throws StatusException {
		if(status.equals("Submitted") ||status.equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		itemList.remove(item);	
	}
	
	public String toString(){
		return claimName+'\n'+'('+beginDate+" to "+endDate+')'
				+'\n'+"CAD:"+getCAD()+'\n'+"USD:"+getUSD()+'\n'+"EUR:"+getEUR()+'\n'+"GBP:"+getGBP()+'\n'+status;
	}
	
	//this just return all the information of the claim, including all the information of item
	public String email(){
		String email=new String("Claim Name:"+claimName+'\n'+'('+beginDate+" to "+endDate+')'
				+'\n'+"CAD:"+getCAD()+'\n'+"USD:"+getUSD()+'\n'+"EUR:"+getEUR()+'\n'+"GBP:"+getGBP()+'\n'+status+'\n'+"Description:"+descript+'\n');	
		for (Item item:itemList){
			email+=item.email();			
		}
		return email;		
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	public void addListener(Listener l){		
		listener=l;
	}
	public void changeCurrentItem(Item item) {
		currentItem=item;
	}
	public Item getCurrentItem() {
		return currentItem;	
	}
	
	//just return the total amount of CAD in this whole claim
	public int getCAD(){
		int total=0;
		if (itemList!=null){
			for (Item item:itemList){
				if(item.getCurrency().equals("CAD")){
					total+=item.getAmount();
				}		
			}
		}
		return total;
	}
	
	//similiar with getCAD
	public int getUSD(){
		int total=0;
		if (itemList!=null){
			for (Item item:itemList){
				if(item.getCurrency().equals("USD")){
					total+=item.getAmount();
				}		
			}
		}
		return total;
	}
	
	//similiar with getCAD
	public int getEUR(){
		int total=0;
		if (itemList!=null){
			for (Item item:itemList){
				if(item.getCurrency().equals("EUR")){
					total+=item.getAmount();
				}		
			}
		}
		return total;
	}
	
	//similiar with getCAD
	public int getGBP(){
		int total=0;
		if (itemList!=null){
			for (Item item:itemList){
				if(item.getCurrency().equals("GBP")){
					total+=item.getAmount();
				}		
			}
		}
		return total;
	}
	
	
	public String getStatus(){
		return status;	
	}
	
	public void changeStatus(String status){
		this.status=status;	
	}
	
	//compare with another Claim based on the Begin Date,use to sort adapter
	public int compare(Claim rhs) {
		String [] l=beginDate.trim().split("-");
		String [] r=rhs.getBeginDate().trim().split("-");
		int lh=Integer.valueOf(l[0])*10000+Integer.valueOf(l[1])*100+Integer.valueOf(l[2]);
		int rh=Integer.valueOf(r[0])*10000+Integer.valueOf(r[1])*100+Integer.valueOf(r[2]);
		if(lh<rh){
			return -1;
		}
		return 1;
	}
	
	public void update(){
		listener.update();	
	}
}
