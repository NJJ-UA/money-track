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
