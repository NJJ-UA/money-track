package ca.ualberta.cs.moneytrack;

import java.util.ArrayList;

public class Claim {
	protected String claimName;
	protected int beginDate;
	protected int endDate;
	protected String descript;
	public ArrayList<Item> itemList;

	
	public Claim(String claimName) {
		// TODO Auto-generated constructor stub
		this.claimName=claimName;
		itemList=new ArrayList<Item>();
	}
	public String getClaimName() {
		// TODO Auto-generated method stub
		return this.claimName;
	}
	public void addBeginDate(int beginDate) {
		// TODO Auto-generated method stub
		this.beginDate=beginDate;
	}
	public int getBeginDate() {
		// TODO Auto-generated method stub
		return this.beginDate;
	}
	public void addEndDate(int endDate) {
		// TODO Auto-generated method stub
		this.endDate=endDate;
	}
	public int getEndDate() {
		// TODO Auto-generated method stub
		return this.endDate;
	}
	public void addDescript(String descript) {
		// TODO Auto-generated method stub
		this.descript=descript;
	}
	public Object getDescript() {
		// TODO Auto-generated method stub
		return this.descript;
	}
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		itemList.add(item);
	}
	public void deleteItem(Item item) {
		// TODO Auto-generated method stub
		itemList.remove(item);
	}
	
	public String toString(){
		return claimName;
	}

}
