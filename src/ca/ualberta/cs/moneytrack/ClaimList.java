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

import java.io.Serializable;
import java.util.ArrayList;

public class ClaimList implements Serializable {
	/*
	This is a model class
	ClaimList will contain some Claim
	and nothing special 
	 */
	/**
	 * 
	 * general serial UID for serial
	 * 
	 */
	private static final long serialVersionUID = -2621638153440416550L;
	private ArrayList<Claim> claimList;
	private Claim currentClaim;
	public transient Listener listener;
	
	public ClaimList(){
		claimList=new ArrayList<Claim>();	
	}
	
	public void addClaim(Claim claim){
		claimList.add(claim);
	}

	public void deleteClaim(Claim claim) throws StatusException {
		if(claim.getStatus().equals("Submitted") ||claim.getStatus().equals("Approved")){
			throw new StatusException("Submitted or Approved status not allowed edit or delete!");					
		}
		claimList.remove(claim);	
	}
	
	public void changeClaim(String name,String begin, String end, String descript) throws StatusException{
		currentClaim.changeClaimName(name);
		currentClaim.addBeginDate(begin);
		currentClaim.addEndDate(end);
		currentClaim.addDescript(descript);	
	}
	
	public ArrayList<Claim> getClaimList(){
		return claimList;
	}
	
	public void addListener(Listener l){		
		listener=l;
	}
	
	public void changeCurrentClaim(Claim claim){
		currentClaim=claim;
	}
	
	public Claim getCurrentClaim(){
		return currentClaim;
	}
	
	public void changeStatus(String status){
		currentClaim.changeStatus(status);
		listener.update();	
	}
	
	public void update(){
		listener.update();		
	}

}
