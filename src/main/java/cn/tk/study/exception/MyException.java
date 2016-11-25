/**
 * 
 */
package cn.tk.study.exception;

/**

 * @ClassName: MyException

 * @Description: TODO

 * @author xiedan11

 * @date 2016年7月18日 上午11:10:03

 *自定义的异常，继承Exception类


 */
public class MyException extends Exception {


	public MyException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
