package ca.ualberta.cs.moneytrack.test;

import ca.ualberta.cs.moneytrack.Claim;
import ca.ualberta.cs.moneytrack.ClaimList;
import ca.ualberta.cs.moneytrack.Listener;
import junit.framework.TestCase;

public class ClaimListTest extends TestCase {
	public void testClaimList(){
		// test Constructor, addClaim and deleteClaim
		ClaimList claimList=new ClaimList();
		Claim claim1 =new Claim("claim1111");
		Claim claim2 =new Claim("claim2222");
		Claim claim3 =new Claim("claim3333");
		claimList.addClaim(claim1);
		claimList.addClaim(claim2);
		claimList.addClaim(claim3);
		assertTrue("claim1 added fail",claimList.claimList.contains(claim1));
		assertTrue("claim2 added fail",claimList.claimList.contains(claim2));
		assertTrue("claim3 added fail",claimList.claimList.contains(claim3));
		claimList.deleteClaim(claim2);
		assertTrue("claim1 accident deleted",claimList.claimList.contains(claim1));
		assertFalse("claim2 has not be delete",claimList.claimList.contains(claim2));
		assertTrue("claim3 accident deleted",claimList.claimList.contains(claim3));
		//test getClaimList()
		assertTrue("claimlist not equal",claimList.claimList.equals(claimList.getClaimList()));
	}
	
	// test for listener /update
	public Boolean bool = false;
	
	public void testListener(){
		
		ClaimList claimList=new ClaimList();
		claimList.addListener(new Listener(){
			public void update(){
				bool=true;
			}
		});
		claimList.addClaim(new Claim("7823"));
		assertTrue("didnot update",bool);
	}
}
