package ca.ualberta.cs.moneytrack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Claim implements Serializable {
	/**
	 * gerneral serial UID for serial
	 */
	private static final long serialVersionUID = 1954300208436592429L;
	protected String claimName;
	protected String beginDate;
	protected String endDate;
	protected String descript;
	public ArrayList<Item> itemList;
	public transient Listener listener;
	public Item currentItem;

	
	public Claim(String claimName) {
		// TODO Auto-generated constructor stub
		this.claimName=claimName;
		itemList=new ArrayList<Item>();
	}
	public String getClaimName() {
		// TODO Auto-generated method stub
		return this.claimName;
	}
	public void addBeginDate(String beginDate) {
		// TODO Auto-generated method stub
		this.beginDate=beginDate;
		if (listener!=null){
			listener.update();
		}
	}
	public String getBeginDate() {
		// TODO Auto-generated method stub
		return this.beginDate;
	}
	public void addEndDate(String endDate) {
		// TODO Auto-generated method stub
		this.endDate=endDate;
		if (listener!=null){
			listener.update();
		}
	}
	public String getEndDate() {
		// TODO Auto-generated method stub
		return this.endDate;
	}
	public void addDescript(String descript) {
		// TODO Auto-generated method stub
		this.descript=descript;
		if (listener!=null){
			listener.update();
		}
	}
	public Object getDescript() {
		// TODO Auto-generated method stub
		return this.descript;
	}
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		itemList.add(item);
		if (listener!=null){
			listener.update();
		}
	}
	public void deleteItem(Item item) {
		// TODO Auto-generated method stub
		itemList.remove(item);
		if (listener!=null){
			listener.update();
		}
	}
	
	public String toString(){
		return claimName+'\n'+'('+beginDate+" to "+endDate+')';
	}
	public ArrayList<Item> getItemList() {
		// TODO Auto-generated method stub
		return itemList;
	}
	
	public void addListener(Listener l){		
		listener=l;
	}
	public void changeCurrentItem(Item item) {
		// TODO Auto-generated method stub
		currentItem=item;
	}
	public Item getCurrentItem() {
		// TODO Auto-generated method stub
		return currentItem;
		
	}
	public void changeClaimName(String string) {
		// TODO Auto-generated method stub
		claimName=string;
		if (listener!=null){
			listener.update();
		}
	}
	
	


}
