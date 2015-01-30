package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_claim_activity);
		EditText nameView=(EditText) findViewById(R.id.editClaimNameEditText);
		EditText beginView=(EditText) findViewById(R.id.editClaimBeginEditText);
		EditText endView=(EditText) findViewById(R.id.editClaimEndEditText);
		nameView.setText(ClaimListController.getCurrentClaim().getClaimName());
		beginView.setText(ClaimListController.getCurrentClaim().getBeginDate());
		endView.setText(ClaimListController.getCurrentClaim().getEndDate());
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
		ClaimListController.changeClaim(nameView.getText().toString(), beginView.getText().toString(), endView.getText().toString());
		finish();
	}

}
