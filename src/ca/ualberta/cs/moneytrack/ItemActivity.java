package ca.ualberta.cs.moneytrack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_activity);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}
	
	public void onResume(){
		super.onResume();
		TextView nameView=(TextView) findViewById(R.id.itemNameVTextView);
		TextView dateView=(TextView) findViewById(R.id.itemDateVTextView);
		TextView categoryView=(TextView) findViewById(R.id.itemCategoryVTextView);
		TextView descriptionView=(TextView) findViewById(R.id.itemDescriptionVTextView);
		TextView amountView=(TextView) findViewById(R.id.itemAmountVTextView);
		TextView currencyView=(TextView) findViewById(R.id.itemCurrencyVTextView);
		nameView.setText(ClaimListController.getCurrentItem().getItemName());
		dateView.setText(ClaimListController.getCurrentItem().getItemDate());
		categoryView.setText(ClaimListController.getCurrentItem().getCategory());
		descriptionView.setText(ClaimListController.getCurrentItem().getDescription());
		amountView.setText(String.valueOf(ClaimListController.getCurrentItem().getAmount()));
		currencyView.setText(ClaimListController.getCurrentItem().getCurrency());
	}
	
	public void deleteItem(View view){
		ClaimListController.deleteItem();
		finish();
	}
	
	public void editItem(View view){
		Intent intent =new Intent(ItemActivity.this,EditItemActivity.class);
		startActivity(intent);		
	}

}
