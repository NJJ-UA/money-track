package ca.ualberta.cs.moneytrack;

import java.io.Serializable;
import java.util.ArrayList;

public class ClaimList implements Serializable {
	/**
	 * 
	 * general serial UID for serial
	 * 
	 */
	private static final long serialVersionUID = -2621638153440416550L;
	public ArrayList<Claim> claimList;
	public transient Listener listener;
	public Claim currentClaim;
	
	public ClaimList(){
		claimList=new ArrayList<Claim>();	
	}
	
	public void addClaim(Claim claim){
		claimList.add(claim);
		if (listener!=null){
			listener.update();
		}
	}

	public void deleteClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimList.remove(claim);
		if (listener!=null){
			listener.update();
		}
	}
	
	public void changeClaim(String name,String begin, String end){
		currentClaim.changeClaimName(name);
		currentClaim.addBeginDate(begin);
		currentClaim.addEndDate(end);
		if (listener!=null){
			listener.update();
		}		
	}
	
	public ArrayList<Claim> getClaimList(){
		return claimList;
	}
	
	public void addListener(Listener l){		
		listener=l;
	}
	
	public void changeCurrentClaim(Claim claim){
		currentClaim=claim;
	}
	
	public Claim getCurrentClaim(){
		return currentClaim;
	}

}
