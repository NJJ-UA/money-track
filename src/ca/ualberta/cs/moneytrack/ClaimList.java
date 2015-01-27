package ca.ualberta.cs.moneytrack;

import java.util.ArrayList;

public class ClaimList {
	public ArrayList<Claim> claimList;
	public Listener listener;
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