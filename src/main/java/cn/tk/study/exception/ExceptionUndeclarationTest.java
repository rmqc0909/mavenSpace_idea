/**
 * 
 */
package cn.tk.study.exception;

/**

 * @ClassName: ExceptionNotTryTest

 * @Description: TODO

 * @author xiedan11

 * @date 2016年7月18日 上午10:31:49

 *程序中没有显式的声明异常，则在抛出异常时，系统会显示异常的出处（数组越界）
	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	at cn.tk.study.exception.ExceptionUndeclarationTest.main(ExceptionUndeclarationTest.java:23)

 */
public class ExceptionUndeclarationTest {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
	    System.out.println(a[4]);
	    System.out.println("我执行了吗???");
	}

}
