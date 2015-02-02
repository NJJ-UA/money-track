package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditClaimActivity extends Activity {
	/*
	 * 
	 * function is same as the name, edit a claim
	 * 
	 * *  This is a activity class so nothing special :)
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
		setContentView(R.layout.edit_claim_activity);
		EditText nameView=(EditText) findViewById(R.id.editClaimNameEditText);
		EditText beginView=(EditText) findViewById(R.id.editClaimBeginEditText);
		EditText endView=(EditText) findViewById(R.id.editClaimEndEditText);
		EditText descripView=(EditText) findViewById(R.id.editClaimDescriptionEditText);
		nameView.setText(ClaimListController.getCurrentClaim().getClaimName());
		beginView.setText(ClaimListController.getCurrentClaim().getBeginDate());
		endView.setText(ClaimListController.getCurrentClaim().getEndDate());
		descripView.setText(ClaimListController.getCurrentClaim().getDescript());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}
	
	public void finishEdit(View view){
		EditText nameView=(EditText) findViewById(R.id.editClaimNameEditText);
		EditText beginView=(EditText) findViewById(R.id.editClaimBeginEditText);
		EditText endView=(EditText) findViewById(R.id.editClaimEndEditText);
		EditText descripView=(EditText) findViewById(R.id.editClaimDescriptionEditText);
		try {
			ClaimListController.changeClaim(nameView.getText().toString(), beginView.getText().toString(), endView.getText().toString(),descripView.getText().toString());
		} catch (StatusException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "Submitted or Approved status not allowed edit or delete!", Toast.LENGTH_LONG).show();
		}catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(this, "Begin Date must follow format"+'\n'+ "YYYY-MM-DD !", Toast.LENGTH_LONG).show();
		}
		finish();
	}

}
