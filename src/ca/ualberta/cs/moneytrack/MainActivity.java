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

import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ClaimListManager.initClaimListManager(this.getApplicationContext());
		ListView listView = (ListView) findViewById(R.id.claimListView);
		final ArrayList<Claim> list =ClaimListController.getClaimList().getClaimList();
		final ArrayAdapter<Claim> adapter=new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1,list);
		
		listView.setAdapter(adapter);		
		ClaimListController.getClaimList().addListener(new Listener(){
			public void update(){
				adapter.notifyDataSetChanged();
				Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
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
				ClaimListController.setCurrentClaim(list.get(position));
				Intent intent =new Intent(MainActivity.this,ItemListAcitivity.class);
				startActivity(intent);
			}
		});
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				ClaimListController.setCurrentClaim(list.get(position));
				Intent intent =new Intent(MainActivity.this,EditClaimActivity.class);
				startActivity(intent);
				return false;
			}
			
		
		});
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void addNewClaim(View v){
		Intent intent =new Intent(MainActivity.this,AddClaimAcitivity.class);
		startActivity(intent);
	}

}
