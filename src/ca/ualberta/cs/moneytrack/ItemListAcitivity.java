package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class ItemListAcitivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_list_activity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_list_acitivity, menu);
		return true;
	}

	public void deleteClaim(View view){
		ClaimListController.getClaimList().deleteClaim(ClaimListController.getClaimList().getCurrentClaim());
		finish();
	}
}
