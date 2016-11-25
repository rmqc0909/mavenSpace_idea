package cn.tk.study.initandloading;
/**
 * 

* @ClassName: ArraysOfPrimitives

* @Description: java中可以将一个数组赋值到另一个数组，真正做的其实是复制了一个引用

* @author xiedan11

* @date 2016年9月5日 上午10:22:00

*
 */
public class ArraysOfPrimitives {
	
	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 4, 5, 6, };
		int[] a2;
		ArraysOfPrimitives[] a3 = {new ArraysOfPrimitives("s1"), new ArraysOfPrimitives("s2"), new ArraysOfPrimitives("s3")};
		a2 = a1;
		for(int i = 0; i < a2.length; i++)
			a2[i] = a1[i] + 1;
		for(int x : a1) {
			System.out.println("a1中元素值：" + x);
		}
	}

	public ArraysOfPrimitives(String str) {
		System.out.println("构造器入参：" + str);
	}

}
