package ca.ualberta.cs.moneytrack;

import java.io.IOException;
import java.io.OptionalDataException;
import java.util.ArrayList;

public class ClaimListController {
	/*
	 * This class is static so can use anywhere in app
	 * All the activities use this controller to modify the Models
	 * It will have and only have exactly one claimlist
	 * 	Some explain comment are written before function.
		You can find the explain of  StatusException in
		the comment in StatusException.java
	 */
	private static ClaimList claimList=null;

	
	//try to get the unique claimlist, if not exist,load from data
	public static ClaimList getClaimList(){
		if (claimList==null){
			try {
				claimList=ClaimListManager.load();
			} catch (OptionalDataException e) {
				e.printStackTrace();
				throw new RuntimeException("load fail,ODE");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("load fail,CNF");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("load fail,IOE");
			}
		}
		return claimList;
	}
	

	public static void addClaim(String claimName, String begin, String end, String descript) throws Exception{
		Claim claim=new Claim(claimName);
		// use to check if the input of begin date is correct format because we need to compare them
		String [] l=begin.trim().split("-");
		@SuppressWarnings("unused")
		int lh=Integer.valueOf(l[0])*10000+Integer.valueOf(l[1])*100+Integer.valueOf(l[2]);
		try {
			claim.addBeginDate(begin);
		} catch (StatusException e1) {
			//never reach here
		}
		try {
			claim.addEndDate(end);
		} catch (StatusException e) {
			//never reach here
		}	
		claim.addDescript(descript);
		claimList.addClaim(claim);
		claimList.update();
	}
	
	public static void changeClaim(String name,String begin, String end, String descript) throws StatusException, Exception{
		// use to check if the input of begin date is correct format because we need to compare them
		String [] l=begin.trim().split("-");
		@SuppressWarnings("unused")
		int lh=Integer.valueOf(l[0])*10000+Integer.valueOf(l[1])*100+Integer.valueOf(l[2]);
		claimList.changeClaim(name, begin, end,descript);
		claimList.update();
	}

	public static void deleteClaim() throws StatusException {
		claimList.deleteClaim(claimList.getCurrentClaim());
		claimList.update();
	}

	public static void setCurrentClaim(Claim claim) {
		claimList.changeCurrentClaim(claim);
	}


	public static void addItem(String name, String date, String category, String description, int amount, String currency) throws StatusException {
		Item item=new Item(name);
		item.addItemDate(date);
		item.addCategory(category);
		item.addDescription(description);
		item.addAmount(amount);
		item.addCurrency(currency);
		claimList.getCurrentClaim().addItem(item);
		claimList.getCurrentClaim().update();
		claimList.update();
	}


	public static ArrayList<Item> getItemList() {
		return claimList.getCurrentClaim().getItemList();
	}


	public static void setCurrentItem(Item item) {
		claimList.getCurrentClaim().changeCurrentItem(item);
	}


	public static void deleteItem() throws StatusException {
		claimList.getCurrentClaim().deleteItem(claimList.getCurrentClaim().getCurrentItem());
		claimList.getCurrentClaim().update();
		claimList.update();
	}


	public static Claim getCurrentClaim() {
		return claimList.getCurrentClaim();
	}

	public static Item getCurrentItem() {
		return getCurrentClaim().getCurrentItem();
	}


	public static void eidtItem(String name, String date, String category, String description, int amount, String currency) throws StatusException {
		if(getCurrentClaim().getStatus().equals("Submitted") ||getCurrentClaim().getStatus().equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		getCurrentItem().changeName(name);
		getCurrentItem().addItemDate(date);
		getCurrentItem().addCategory(category);
		getCurrentItem().addDescription(description);
		getCurrentItem().addAmount(amount);
		getCurrentItem().addCurrency(currency);
		claimList.update();	
	}


}
