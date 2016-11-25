package cn.tk.study.initandloading;

/**

 * @ClassName: Constructor

 * @Description: TODO

 * @author xiedan11

 * @date 2016年8月30日 上午10:52:06

 *


 */
public class Constructor {
	int total;
	
	
	public Constructor(int total) {
		this.total = total;
		System.out.println("Constructor int args only, total = " + total);
	}
	
	public Constructor() {
		this(3);
	}

	public void test1() {
		this.test2();
		test2();
		System.out.println("test1... ");
	}
	public void test2() {
		System.out.println("test2... ");
	}
	/**
	 *
	
	 * @param args
	
	 */
	public static void main(String[] args) {
		Constructor constructor = new Constructor();
		constructor.test1();
	}

}
