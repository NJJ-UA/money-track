package ca.ualberta.cs.moneytrack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

public class ClaimListController {
	private static ClaimList claimList=null;

	
	public static ClaimList getClaimList(){
		if (claimList==null){
			try {
				claimList=ClaimListManager.load();
			} catch (OptionalDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("load fail,ODE");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("load fail,CNF");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("load fail,IOE");
			}
		}
		return claimList;
	}
	

	public static void addClaim(String claimName, String begin, String end){
		Claim claim=new Claim(claimName);
		claimList.addClaim(claim);
		claim.addBeginDate(begin);
		claim.addEndDate(end);	
	}
	
	public static void changeClaim(String name,String begin, String end){
		claimList.changeClaim(name, begin, end);
	}

	public static void deleteClaim() {
		// TODO Auto-generated method stub
		claimList.deleteClaim(claimList.getCurrentClaim());

	}

	public static void setCurrentClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimList.changeCurrentClaim(claim);
	}


	public static void addItem(String name, String date, String category, String description, int amount, String currency) {
		// TODO Auto-generated method stub
		Item item=new Item(name);
		item.addItemDate(date);
		item.addCategory(category);
		item.addDescription(description);
		item.addAmount(amount);
		item.addCurrency(currency);
		claimList.getCurrentClaim().addItem(item);
	}


	public static ArrayList<Item> getItemList() {
		// TODO Auto-generated method stub
		return claimList.getCurrentClaim().getItemList();
	}


	public static void setCurrentItem(Item item) {
		// TODO Auto-generated method stub
		claimList.getCurrentClaim().changeCurrentItem(item);
	}


	public static void deleteItem() {
		// TODO Auto-generated method stub
		claimList.getCurrentClaim().deleteItem(claimList.getCurrentClaim().getCurrentItem());
	}


	public static Claim getCurrentClaim() {
		// TODO Auto-generated method stub
		return claimList.getCurrentClaim();
	}


	public static Item getCurrentItem() {
		// TODO Auto-generated method stub
		return getCurrentClaim().getCurrentItem();
	}


	public static void eidtItem(String name, String date, String category, String description, int amount, String currency) {
		// TODO Auto-generated method stub
		getCurrentItem().changeName(name);
		getCurrentItem().addItemDate(date);
		getCurrentItem().addCategory(category);
		getCurrentItem().addDescription(description);
		getCurrentItem().addAmount(amount);
		getCurrentItem().addCurrency(currency);
		
	}
	
	



}
