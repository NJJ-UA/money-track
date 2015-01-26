package ca.ualberta.cs.moneytrack.test;

import ca.ualberta.cs.moneytrack.Claim;
import ca.ualberta.cs.moneytrack.Item;
import junit.framework.TestCase;

public class ClaimTest extends TestCase {
	public void testClaim(){
		//test claim constructor and getClaimName()
		String claimName="1st term trip";
		Claim claim =new Claim(claimName);
		assertTrue("claim name not match",claimName.equals(claim.getClaimName()));
		//addBeginDate() and getBeginDate()
		int beginDate=20140112;
		claim.addBeginDate(beginDate);
		assertTrue("beginDate not match",beginDate==claim.getBeginDate());
		//addEndDate() and getEndDate()
		int endDate=20141220;
		claim.addEndDate(endDate);
		assertTrue("endDate not match",endDate==claim.getEndDate());
		//addDescript() and getDescript()
		String descript="trip is good";
		claim.addDescript(descript);
		assertTrue("descript not match",descript.equals(claim.getDescript()));
		//test addItem() and deleteItem()
		Item item1 =new Item("11111");
		Item item2 =new Item("222222");
		Item item3 =new Item("333333");		
		claim.addItem(item1);
		claim.addItem(item2);
		claim.addItem(item3);
		assertTrue("item1 added fail",claim.itemList.contains(item1));
		assertTrue("item2 added fail",claim.itemList.contains(item2));
		assertTrue("item3 added fail",claim.itemList.contains(item3));
		claim.deleteItem(item2);
		assertTrue("item1 accident deleted",claim.itemList.contains(item1));
		assertFalse("item2 has not be delete",claim.itemList.contains(item2));
		assertTrue("item3 accident deleted",claim.itemList.contains(item3));
	}

}
