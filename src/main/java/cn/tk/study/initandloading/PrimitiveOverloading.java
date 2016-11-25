package cn.tk.study.initandloading;

/**
 * 

* @ClassName: PrimitiveOverloading

* @Description: 
* 字符型
* char: 2个字节	
* 整型
* byte: 1个字节	 
* short: 2个字节
* int: 4个字节
* long: 8个字节
* 浮点型
* float: 4个字节
* double: 8个字节

* @author xiedan11

* @date 2016年8月29日 下午2:06:35

*
 */
public class PrimitiveOverloading {

	void f1(char x) {
		System.out.println("f1(char): ");
	}
	void f1(byte x) {
		System.out.println("f1(byte): ");
	}
	void f1(short x) {
		System.out.println("f1(short): ");
	}
	void f1(int x) {
		System.out.println("f1(int): ");
	}
	void f1(long x) {
		System.out.println("f1(long): ");
	}
	void f1(double x) {
		System.out.println("f1(double): ");
	}
	void f1(float x) {
		System.out.println("f1(float): ");
	}
	
	void f2(byte x) {
		System.out.println("f2(byte): ");
	}
	void f2(short x) {
		System.out.println("f2(short): ");
	}
	void f2(int x) {
		System.out.println("f2(int): ");
	}
	void f2(long x) {
		System.out.println("f2(long): ");
	}
	void f2(double x) {
		System.out.println("f2(double): ");
	}
	void f2(float x) {
		System.out.println("f2(float): ");
	}
	
	void f3(short x) {
		System.out.println("f3(short): ");
	}
	void f3(int x) {
		System.out.println("f3(int): ");
	}
	void f3(long x) {
		System.out.println("f3(long): ");
	}
	void f3(double x) {
		System.out.println("f3(double): ");
	}
	void f3(float x) {
		System.out.println("f3(float): ");
	}
	
	void f4(int x) {
		System.out.println("f4(int): ");
	}
	void f4(long x) {
		System.out.println("f4(long): ");
	}
	void f4(double x) {
		System.out.println("f4(double): ");
	}
	void f4(float x) {
		System.out.println("f4(float): ");
	}
	
	void f5(long x) {
		System.out.println("f5(long): ");
	}
	void f5(double x) {
		System.out.println("f5(double): ");
	}
	void f5(float x) {
		System.out.println("f5(float): ");
	}
	
	void f6(double x) {
		System.out.println("f6(double): ");
	}
	void f6(float x) {
		System.out.println("f6(float): ");
	}
	
	void f7(double x) {
		System.out.println("f7(double): ");
	}
	
	void testConsval() {
		System.out.println("5: ");
		f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5);
	}
	
	void testChar() {
		char x = 'x';
		System.out.println("char: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testByte() {
		byte x = 1;
		System.out.println("byte: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testShort() {
		short x = 3;
		System.out.println("short: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testInt() {
		int x = 2;
		System.out.println("int: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testLong() {
		long x = 4;
		System.out.println("long: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testFloat() {
		float x = 5;
		System.out.println("float: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testDouble() {
		double x = 6;
		System.out.println("double: ");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	
	
	
	/**
	 * 
	*
	如果传入的数据类型小于方法中声明的形式参数类型，实际数据类型会提升。
	char型略有不同，如果无法找到恰好接受char参数的方法，就会把char直接提升至int型
	* @param args
	 */
	public static void main(String[] args) {
		PrimitiveOverloading primitiveOverloading = new PrimitiveOverloading();
		primitiveOverloading.testConsval();
		primitiveOverloading.testChar();
		primitiveOverloading.testByte();
		primitiveOverloading.testInt();
		primitiveOverloading.testShort();
		primitiveOverloading.testFloat();
		primitiveOverloading.testDouble();
	}

}
