package cn.tedu.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
