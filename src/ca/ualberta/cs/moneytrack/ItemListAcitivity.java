package ca.ualberta.cs.moneytrack;

import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ItemListAcitivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_list_activity);
		ListView listView = (ListView) findViewById(R.id.itemListView);
		final ArrayList<Item> list =ClaimListController.getItemList();
		final ArrayAdapter<Item> adapter=new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1,list);
		listView.setAdapter(adapter);		
		ClaimListController.getClaimList().getCurrentClaim().addListener(new Listener(){
			public void update(){
				adapter.notifyDataSetChanged();
				try {
					ClaimListManager.save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("save failed");
				}
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position,
					long id) {
				// TODO Auto-generated method stub 
				ClaimListController.setCurrentItem(list.get(position));
				Intent intent =new Intent(ItemListAcitivity.this,ItemActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_list_acitivity, menu);
		return true;
	}

	public void deleteClaim(View view){
		ClaimListController.deleteClaim();
		finish();
	}
	
	public void addItem(View view){
		Intent intent =new Intent(ItemListAcitivity.this,AddItemAcitivity.class);
		startActivity(intent);
		
	}
}
