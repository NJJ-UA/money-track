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

public class StatusException extends Exception {

	/*
	 * If the claim's status is subbmitted or approved
	 * and user try to modify that claim
	 * this exception will occur
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 4800271784175569255L;

	public StatusException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public StatusException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public StatusException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public StatusException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
