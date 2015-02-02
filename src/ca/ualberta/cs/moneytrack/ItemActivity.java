/*
    Money Track: Android travel expense tracking Application. UA CMPUT 301 Assignment 1
    Copyright (C) 2015  Jingjiao Ni jni1@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity {
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * 
	 * function is same as the name, show the detail information of a item
	 * 
	 * 
	 *  This is a activity class so nothing special :)
	 * Do almost everything through the ClaimListController
	 * Some explain comment are written before function.
	 * 
	 * 
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_activity);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}
	
	public void onResume(){
		super.onResume();
		TextView nameView=(TextView) findViewById(R.id.itemNameVTextView);
		TextView dateView=(TextView) findViewById(R.id.itemDateVTextView);
		TextView categoryView=(TextView) findViewById(R.id.itemCategoryVTextView);
		TextView descriptionView=(TextView) findViewById(R.id.itemDescriptionVTextView);
		TextView amountView=(TextView) findViewById(R.id.itemAmountVTextView);
		TextView currencyView=(TextView) findViewById(R.id.itemCurrencyVTextView);
		nameView.setText(ClaimListController.getCurrentItem().getItemName());
		dateView.setText(ClaimListController.getCurrentItem().getItemDate());
		categoryView.setText(ClaimListController.getCurrentItem().getCategory());
		descriptionView.setText(ClaimListController.getCurrentItem().getDescription());
		amountView.setText(String.valueOf(ClaimListController.getCurrentItem().getAmount()));
		currencyView.setText(ClaimListController.getCurrentItem().getCurrency());
	}
	
	public void deleteItem(View view){
		try {
			ClaimListController.deleteItem();
		} catch (StatusException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "Submitted or Approved status not allowed edit or delete!", Toast.LENGTH_LONG).show();
		}
		finish();
	}
	
	public void editItem(View view){
		Intent intent =new Intent(ItemActivity.this,EditItemActivity.class);
		startActivity(intent);		
	}

}
