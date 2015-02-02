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
import android.widget.EditText;
import android.widget.Toast;

public class AddClaimAcitivity extends Activity {
	
	/*
	 * 
	 *  * 
	 * function is same as the name, add a claim
	 * 
	 * 
	 *  This is a activity class so nothing special :)
	 * Do almost everything through the ClaimListController
	 * Some explain comment are written before function.
	 * 
	 * 
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim_acitivity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim_acitivity, menu);
		return true;
	}
	
	public void finishAddClaim(View v){	
		EditText nameView= (EditText) findViewById(R.id.createClaimNameEditText);
		EditText beginView=(EditText) findViewById(R.id.createClaimBeginEditText);
		EditText endView=(EditText) findViewById(R.id.createClaimEndEditText);
		EditText descripView=(EditText) findViewById(R.id.createClaimDescriptionEditText);
		try {
			ClaimListController.addClaim(nameView.getText().toString(),
					beginView.getText().toString(),endView.getText().toString(),descripView.getText().toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(this, "Begin Date must follow format"+'\n'+ "YYYY-MM-DD !", Toast.LENGTH_LONG).show();
		}
		
		
		finish();
	}

}
