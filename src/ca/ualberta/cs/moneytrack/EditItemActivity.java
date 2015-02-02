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

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditItemActivity extends Activity {
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * function is same as the name, edit a item
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
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_item_activity);
		EditText nameView=(EditText) findViewById(R.id.editItemNameEditText);
		EditText dateView=(EditText) findViewById(R.id.editItemDateEditText);
		EditText categoryView=(EditText) findViewById(R.id.editItemCategoryEditText);
		EditText descriptionView=(EditText) findViewById(R.id.editItemDescriptionEditText);
		EditText amountView=(EditText) findViewById(R.id.editItemAmountEditText);
		/*http://developer.android.com/guide/topics/ui/controls/spinner.html
		 * Android Open Source Project 
		 * licensed under the Apache 2.0 license
		 * 2015/01/30				
		 */
		Spinner sp=(Spinner) findViewById(R.id.editCurrencySpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency, 
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		sp.setSelection(getCurrencyPosition(ClaimListController.getCurrentItem().getCurrency()));
		

		nameView.setText(ClaimListController.getCurrentItem().getItemName());
		dateView.setText(ClaimListController.getCurrentItem().getItemDate());
		categoryView.setText(ClaimListController.getCurrentItem().getCategory());
		descriptionView.setText(ClaimListController.getCurrentItem().getDescription());
		amountView.setText(String.valueOf(ClaimListController.getCurrentItem().getAmount()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_detail, menu);
		return true;
	}
	
	
	//used to check the int  position of the input currency
	public int getCurrencyPosition(String currency){
		String [] list={"CAD","USD", "EUR", "GBP"};
		for (int i=0;i<4;i++){
			if (list[i].equals(currency)){
				return i;
			}
		}
		return 0;
	}
	
	public void finishEdit(View view){
		EditText nameView=(EditText) findViewById(R.id.editItemNameEditText);
		EditText dateView=(EditText) findViewById(R.id.editItemDateEditText);
		EditText categoryView=(EditText) findViewById(R.id.editItemCategoryEditText);
		EditText descriptionView=(EditText) findViewById(R.id.editItemDescriptionEditText);
		EditText amountView=(EditText) findViewById(R.id.editItemAmountEditText);
		Spinner sp=(Spinner) findViewById(R.id.editCurrencySpinner);
		try{
			ClaimListController.eidtItem(nameView.getText().toString(),dateView.getText().toString(),
					categoryView.getText().toString(),descriptionView.getText().toString(),
					Integer.parseInt(amountView.getText().toString()),sp.getSelectedItem().toString());
		} catch (NumberFormatException e) {
			try {
				ClaimListController.eidtItem(nameView.getText().toString(),dateView.getText().toString(),
						categoryView.getText().toString(),descriptionView.getText().toString(),0,
						sp.getSelectedItem().toString());
			} catch (StatusException e1) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "Submitted or Approved status not allowed edit or delete!", Toast.LENGTH_LONG).show();
			}			
		} catch (StatusException e1) {
			Toast.makeText(this, "Submitted or Approved status not allowed edit or delete!", Toast.LENGTH_LONG).show();
		}
		
		try {
			ClaimListManager.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}

}
