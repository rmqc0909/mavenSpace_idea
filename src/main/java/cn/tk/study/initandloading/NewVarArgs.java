package cn.tk.study.initandloading;

/**
 * 

* @ClassName: NewVarArgs

* @Description: 可变参数列表

* @author xiedan11

* @date 2016年9月5日 下午2:21:20

*
 */
public class NewVarArgs {
	private static void printArray(Object... args) {
		for(Object obj : args) 
			System.out.print(obj + "  ");
		System.out.println();
	}
	
	private static void f(Character...characters) {
		System.out.print(characters.getClass());
		System.out.println(characters.length);
	}
	
	public static void main(String[] args) {
		printArray(new Integer(47), new Float(3.14), new Double(11.11));
		printArray("aaa", "bbb", "ccc");
		printArray("aaa", "bbb", "ccc", "ddd");
		printArray(new A(), new A(), new A());
		printArray();
		f('a');
	}

}
