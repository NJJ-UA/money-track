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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

public class ClaimListManager {
	/*
	 * This class is used to load/ save data in disk
	 * This class is static so we can use save function everywhere
	 * It will be initialize when open the App(see in MainActivity onCreat() function)
	 * Some explain comment are written before function.
	 * 
	 * 
	 * Citation:
	 * 
	 * https://www.youtube.com/playlist?list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O
	 * Author: Abram Hindle
	 * 2015/01/28
	 * 
	 * 
	 */
	
	static Context context;
	static final String fileName="MTData";
	static final String prefName="mtdata";
	private static ClaimListManager clm = null;
	

	public ClaimListManager(Context context) {
		ClaimListManager.context=context;
	}
	
	public static void initClaimListManager(Context context){
		if (clm==null){
			clm=new ClaimListManager(context);
		}		
	}
	
	public static ClaimListManager getClaimListManager(){
		if (clm==null){
			throw new RuntimeException("CliamListManager not initialized");
		}
		return clm;
	}
	

	public static void save() throws IOException {
		// TODO Auto-generated method stub
		SharedPreferences setting=context.getSharedPreferences(fileName, 0);
		Editor editor=setting.edit();
		editor.putString(prefName,ListToString(ClaimListController.getClaimList()));
		editor.commit();
	}

	public static ClaimList load() throws OptionalDataException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		SharedPreferences setting=context.getSharedPreferences(fileName, 0);
		String s=setting.getString(prefName, "");
		// if there is no data saved before,just return a new claimlist
		if (s.equals("")){
			return new ClaimList();
		}else{
			return StringToList(s);
		}
	}
	
	public static  ClaimList StringToList(String string) throws OptionalDataException, ClassNotFoundException, IOException {
		ByteArrayInputStream bi=new ByteArrayInputStream(Base64.decode(string, Base64.DEFAULT));
		ObjectInputStream oi=new ObjectInputStream(bi);
		return (ClaimList) oi.readObject();
	}

	public static  String ListToString(ClaimList cl) throws IOException {
		ByteArrayOutputStream bo=new ByteArrayOutputStream();
		ObjectOutputStream oo=new ObjectOutputStream(bo);
		oo.writeObject(cl);
		return Base64.encodeToString(bo.toByteArray(),Base64.DEFAULT);
	}

}
