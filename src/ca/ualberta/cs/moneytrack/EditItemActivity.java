package ca.ualberta.cs.moneytrack;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_item_activity);
		EditText nameView=(EditText) findViewById(R.id.editItemNameEditText);
		EditText dateView=(EditText) findViewById(R.id.editItemDateEditText);
		EditText categoryView=(EditText) findViewById(R.id.editItemCategoryEditText);
		EditText descriptionView=(EditText) findViewById(R.id.editItemDescriptionEditText);
		EditText amountView=(EditText) findViewById(R.id.editItemAmountEditText);
		EditText currencyView=(EditText) findViewById(R.id.editItemCurrencyEditText);

		nameView.setText(ClaimListController.getCurrentItem().getItemName());
		dateView.setText(ClaimListController.getCurrentItem().getItemDate());
		categoryView.setText(ClaimListController.getCurrentItem().getCategory());
		descriptionView.setText(ClaimListController.getCurrentItem().getDescription());
		amountView.setText(String.valueOf(ClaimListController.getCurrentItem().getAmount()));
		currencyView.setText(ClaimListController.getCurrentItem().getCurrency());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_detail, menu);
		return true;
	}
	
	public void finishEdit(View view){
		EditText nameView=(EditText) findViewById(R.id.editItemNameEditText);
		EditText dateView=(EditText) findViewById(R.id.editItemDateEditText);
		EditText categoryView=(EditText) findViewById(R.id.editItemCategoryEditText);
		EditText descriptionView=(EditText) findViewById(R.id.editItemDescriptionEditText);
		EditText amountView=(EditText) findViewById(R.id.editItemAmountEditText);
		EditText currencyView=(EditText) findViewById(R.id.editItemCurrencyEditText);
		
		ClaimListController.eidtItem(nameView.getText().toString(),dateView.getText().toString(),categoryView.getText().toString(),descriptionView.getText().toString(),Integer.parseInt(amountView.getText().toString()),currencyView.getText().toString());
		try {
			ClaimListManager.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}

}
