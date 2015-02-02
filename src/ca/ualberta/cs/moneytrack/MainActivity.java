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
import java.util.Comparator;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * This is a activity class so nothing special :)
	 * Do almost everything through the ClaimListController
	 * Some explain comment are written before function.
	 * 
	 * As mainActivity, has response to initial the two static class
	 * ClaimlistController and ClaimListManager when open the app
	 * 
	 * Citation:
	 * 
	 * 
	 * https://www.youtube.com/playlist?list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O
	 * Author: Abram Hindle
	 * 2015/01/28
	 * 
	 * http://developer.android.com/guide/topics/ui/dialogs.html 
	 * Android Open Source Project 
	 * licensed under the Apache 2.0 license
	 * 2015/01/31	
	 * 
	 * 	 
	 *https://stackoverflow.com/questions/8284706/send-email-via-gmail 
	 * Author: Igor Popov
	 * Editor: xbakesx
	 * 2015/01/31
	 * 
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//try to initialize  ClaimListManager
		ClaimListManager.initClaimListManager(this.getApplicationContext());
		//set list view of claimlist
		ListView listView = (ListView) findViewById(R.id.claimListView);
		final ArrayList<Claim> list =ClaimListController.getClaimList().getClaimList();
		final ArrayAdapter<Claim> adapter=new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1,list);
		adapter.sort(sortClaim());
		listView.setAdapter(adapter);
		
		//every time call update in listner will sort the adapter first then notifychanged then save data to disk
		ClaimListController.getClaimList().addListener(new Listener(){
			public void update(){
				adapter.sort(sortClaim());			
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
				ClaimListController.setCurrentClaim(list.get(position));
				Intent intent =new Intent(MainActivity.this,ItemListAcitivity.class);
				startActivity(intent);
			}
		});
		
		//when longclick on a claim, action may depend on the status of the claim
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int position, long id) {
	
				// The case status of claim is in progress or return and you have three options
				if (list.get(position).getStatus().equals("In progress")||
						list.get(position).getStatus().equals("Returned")){
					/*http://developer.android.com/guide/topics/ui/dialogs.html 
					 * Android Open Source Project 
					 * licensed under the Apache 2.0 license
					 * 2015/01/31				
					 */
					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setTitle(R.string.pick_action);
					builder.setItems(R.array.action_array, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
					    // The 'which' argument contains the index position
					    // of the selected item
							if (which==0){
								//option 1: edit this claim
								ClaimListController.setCurrentClaim(list.get(position));
								Intent intent =new Intent(MainActivity.this,EditClaimActivity.class);
								startActivity(intent);							
							}else if (which==1){
								//option2: change the status to subbmitted
								ClaimListController.setCurrentClaim(list.get(position));
								ClaimListController.getClaimList().changeStatus("Submitted");							
							}else if (which==2){
								//option3: email this claim
								/*https://stackoverflow.com/questions/8284706/send-email-via-gmail 
								 * Author: Igor Popov
								 * Editor: xbakesx
								 * 2015/01/31
								 */
								ClaimListController.setCurrentClaim(list.get(position));
								Intent send = new Intent(Intent.ACTION_SENDTO);
								String uriText = "mailto:" + Uri.encode("") + 
								          "?subject=" + Uri.encode("Claim") + 
								          "&body=" + Uri.encode(ClaimListController.getCurrentClaim().email());
								Uri uri = Uri.parse(uriText);
								send.setData(uri);
								startActivity(Intent.createChooser(send, "Send mail..."));
							}				
					    }			      
					});
					builder.create();  
					builder.show();
					// The case status of claim is submitted and you have three options
				}else if (list.get(position).getStatus().equals("Submitted")){
					//http://developer.android.com/guide/topics/ui/dialogs.html 2015/01/31				
					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setTitle(R.string.pick_action);
					builder.setItems(R.array.action_array_sub, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
					    // The 'which' argument contains the index position
					    // of the selected item
							if (which==0){
								//option1: change the status to returned
								ClaimListController.setCurrentClaim(list.get(position));
								ClaimListController.getClaimList().changeStatus("Returned");
														
							}else if (which==1){
								//option2: change the status to approved
								ClaimListController.setCurrentClaim(list.get(position));
								ClaimListController.getClaimList().changeStatus("Approved");
														
							}else if (which==2){
								//option 3: email this claim
								/*https://stackoverflow.com/questions/8284706/send-email-via-gmail 
								 * Author: Igor Popov
								 * Editor: xbakesx
								 * 2015/01/31
								 */
								ClaimListController.setCurrentClaim(list.get(position));
								Intent send = new Intent(Intent.ACTION_SENDTO);
								String uriText = "mailto:" + Uri.encode("") + 
								          "?subject=" + Uri.encode("Claim") + 
								          "&body=" + Uri.encode(ClaimListController.getCurrentClaim().email());
								Uri uri = Uri.parse(uriText);
								send.setData(uri);
								startActivity(Intent.createChooser(send, "Send mail..."));														
							}	
					    }			      
					});
					builder.create();  
					builder.show();
					// The case status of claim is approved,no other choice but just email these claim
				} else if (list.get(position).getStatus().equals("Approved")){
					/*https://stackoverflow.com/questions/8284706/send-email-via-gmail 
					 * Author: Igor Popov
					 * Editor: xbakesx
					 * 2015/01/31
					 */
					ClaimListController.setCurrentClaim(list.get(position));
					Intent send = new Intent(Intent.ACTION_SENDTO);
					String uriText = "mailto:" + Uri.encode("") + 
					          "?subject=" + Uri.encode("Claim") + 
					          "&body=" + Uri.encode(ClaimListController.getCurrentClaim().email());
					Uri uri = Uri.parse(uriText);
					send.setData(uri);
					startActivity(Intent.createChooser(send, "Send mail..."));											
				}
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
	
	
	//used for sort adapter,the actual implements are in Claim class compare function
	public Comparator<? super Claim> sortClaim(){
		return new Comparator<Claim>() {
			
			@Override
			public int compare(Claim lhs, Claim rhs) {
				// TODO Auto-generated method stub
				return lhs.compare(rhs);			
			}
		};
	}

	public void addNewClaim(View v){
		Intent intent =new Intent(MainActivity.this,AddClaimAcitivity.class);
		startActivity(intent);
	}
}
