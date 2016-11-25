package cn.tk.study.initandloading;

class A {
	
}
/**
 * 

* @ClassName: VarArgs

* @Description: 可变参数列表

* @author xiedan11

* @date 2016年9月5日 下午2:20:55

*
 */
public class VarArgs {

	private static void printArray(Object[] args) {
		for(Object obj : args) 
			System.out.print(obj + "  ");
			System.out.println();
	}
	
	public static void main(String[] args) {
		printArray(new Object[] {new Integer(12), new Float(3.14), new Double(11.11)});
		printArray(new Object[] {new String("aaa"), new String("bbb"), new String("ccc")});
		printArray(new Object[] {new A(), new A(), new A()});
	}

}
