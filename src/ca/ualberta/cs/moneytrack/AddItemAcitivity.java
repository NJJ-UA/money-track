package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemAcitivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_item_acitivity);
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
		EditText currencyView= (EditText) findViewById(R.id.createItemCurrencyEditText);
		ClaimListController.addItem(nameView.getText().toString(),dateView.getText().toString(),categoryView.getText().toString(),descriptionView.getText().toString(),Integer.parseInt(amountView.getText().toString()),currencyView.getText().toString());
		Toast.makeText(this, "finish add", Toast.LENGTH_SHORT).show();
		finish();
	}

}
