package cn.tk.study.initandloading;

/**

 * @ClassName: ExplicitStatic

 * @Description: TODO

 * @author xiedan11

 * @date 2016年9月2日 下午4:12:34

 *


 */
class Cup {
	Cup(int maker) {
		System.out.println("Cup(" + maker + ")");
	}
	void f(int maker) {
		System.out.println("f(" + maker + ")");
	}
}
class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	
}
public class ExplicitStatic {

	public static void main(String[] args) {
		Cups.cup1.f(99);
	}
	static Cups cups1 = new Cups();


}
