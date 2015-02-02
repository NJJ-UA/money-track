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
