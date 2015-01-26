package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddClaimAcitivity extends Activity {

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
		ClaimListController clc=new ClaimListController();
		EditText nameView= (EditText) findViewById(R.id.createClaimNameEditText);		
		clc.addClaim(nameView.getText().toString());
		finish();
	}

}
