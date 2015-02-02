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
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddItemAcitivity extends Activity {
	/*
	 * 
	 *  * 
	 * function is same as the name, add a item
	 * 
	 * 
	 *  This is a activity class so nothing special :)
	 * Do almost everything through the ClaimListController
	 * Some explain comment are written before function.
	 * 
	 * Citation:
	 * 
	 * http://developer.android.com/guide/topics/ui/controls/spinner.html
	 * Android Open Source Project 
	 * licensed under the Apache 2.0 license
	 * 2015/01/30
	 * 
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_item_acitivity);
		/*http://developer.android.com/guide/topics/ui/controls/spinner.html
		 * Android Open Source Project 
		 * licensed under the Apache 2.0 license
		 * 2015/01/30				
		 */
		Spinner sp=(Spinner) findViewById(R.id.createCurrencySpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency, 
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item_acitivity, menu);
		return true;
	}
	
	public void finishAddItem(View v){			
		EditText nameView= (EditText) findViewById(R.id.createItemNameEditText);	
		EditText dateView= (EditText) findViewById(R.id.createItemDateEditText);
		EditText categoryView= (EditText) findViewById(R.id.createItemCategoryEditText);
		EditText descriptionView= (EditText) findViewById(R.id.createItemDescriptionEditText);
		EditText amountView= (EditText) findViewById(R.id.createItemAmountEditText);
		Spinner sp=(Spinner) findViewById(R.id.createCurrencySpinner);
		try {
			ClaimListController.addItem(nameView.getText().toString(),dateView.getText().toString(),
					categoryView.getText().toString(),descriptionView.getText().toString(),
					Integer.parseInt(amountView.getText().toString()),sp.getSelectedItem().toString());
		} catch (StatusException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "Submitted or Approved status not allowed edit or delete!", Toast.LENGTH_LONG).show();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			try {
				ClaimListController.addItem(nameView.getText().toString(),dateView.getText().toString(),
						categoryView.getText().toString(),descriptionView.getText().toString(),0,sp.getSelectedItem().toString());
			} catch (StatusException e1) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "Submitted or Approved status not allowed edit or delete!", Toast.LENGTH_LONG).show();
			}
		}

		finish();
	}

}
