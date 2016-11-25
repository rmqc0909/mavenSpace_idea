package cn.tk.study.initandloading;

class Bowl {
	Bowl(int maker) {
		System.out.println("Bowl(" + maker + ")");
	}
	void f1(int maker) {
		System.out.println("f1(" + maker + ")");
	}
}

class Table {
	static Bowl bowl1 = new Bowl(1);
	Table() {
		System.out.println("Table()");
		bowl2.f1(1);
	}
	void f2(int maker) {
		System.out.println("f2(" + maker + ")");
	}
	static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	Cupboard() {
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}
	void f3(int maker) {
		System.out.println("f3(" + maker + ")");
	}
	static Bowl bowl5 = new Bowl(5);
}

/**
 * 

* @ClassName: StaticInitialization

* @Description: 静态数据的初始化
* 0.在类的内部，变量定义的先后顺序决定了初始化的顺序。
* 即使变量定义散布于方法定义之间，它们仍旧会在任何方法（包括构造器）被调用之前得到初始化。
* 1.初始化的顺序：先静态对象，然后是“非静态”对象。
* 2.静态对象只初始化一次。

* @author xiedan11

* @date 2016年9月2日 下午3:27:39

*
 */
public class StaticInitialization {

	public static void main(String[] args) {
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();

}
