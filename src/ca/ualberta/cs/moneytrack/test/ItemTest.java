package ca.ualberta.cs.moneytrack.test;

import junit.framework.TestCase;
import ca.ualberta.cs.moneytrack.Item;

public class ItemTest extends TestCase {
	public void testItem(){
		String itemName="KTV SJW";
		Item item =new Item(itemName);
		assertTrue("Item Name is not Equal", itemName.equals(item.getItemName()));
	}
}
