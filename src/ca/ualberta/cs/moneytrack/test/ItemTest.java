package ca.ualberta.cs.moneytrack.test;

import junit.framework.TestCase;
import ca.ualberta.cs.moneytrack.Item;

public class ItemTest extends TestCase {
	public void testItem(){
		//test construct with name and getItemName()
		String itemName="KTV SJW";
		Item item =new Item(itemName);
		assertTrue("Item Name is not Equal", itemName.equals(item.getItemName()));
		//test addItemDate() and getItemDate()
		int itemDate=20141222;
		item.addItemDate(itemDate);
		assertTrue("Item date is not equal",itemDate==item.getItemDate());
		//test addCategory() and getCategory()
		String category="YuLe";
		item.addCategory(category);
		assertTrue("Category is not equal",category.equals(item.getCategory()));
		//test addDescription() and getDescription()
		String description ="This KTV is good";
		item.addDescription(description);
		assertTrue("description is not equal",description.equals(item.getDescription()));
		//test addAmount() and getAmount()
		int amount=40;
		item.addAmount(amount);
		assertTrue("amount is not equal",amount==item.getAmount());
		//test addCurrency() and getCurrency()
		String currency="CAD";
		item.addCurrency(currency);
		assertTrue("currency is not equal",currency.equals(item.getCurrency()));
	}
	
	
}
