package ca.ualberta.cs.moneytrack;

import java.util.ArrayList;

public class ClaimListController {
	private static ClaimList claimList=null;
	
	public static ClaimList getClaimList(){
		if (claimList==null){
			claimList=new ClaimList();
		}
		return claimList;	
	}
	
	public void addClaim(String claimName){
		Claim claim=new Claim(claimName);
		claimList.addClaim(claim);
		
	}
	
	
	

}
