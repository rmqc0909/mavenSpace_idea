package cn.tk.study.xor;

/**
 *

* @ClassName: XOR

* @Description: TODO

* @author xiedan11

* @date 2016年7月20日 下午1:22:26

*不利用临时变量来交换两个变量的值
*利用异或符号交换两个变量
*
*按位异或的特点：
*1）0^0=0,0^1=1; 0异或任何数=任何数
*2）1^0=1,1^1=0; 1异或任何数=任何数取反
*3）任何数异或自身=将自己置零
 * 4)异或运算是可交换的,例如:A^B=B^A;
*
 *
 */
public class XOR {
	public static void main(String[] args) 
	{
		/**
		 * 交换两个数
		 */
		XOR xor = new XOR();
		byte a = 5;
		byte b = 10;
		a = (byte) (a^b);
		b = (byte) (a^b);
		a = (byte) (a^b);
		System.out.println("交换后的a=" + a + ",b=" + b);
		boolean c = xor.testEqual(44,44);
		System.out.println("两个数是否相等:" + c);
		xor.testEncry();
	}
	/**
	 * 快速判断两个数是否相等
	 */
	public boolean testEqual(int a, int b)
	{
		return ((a^b) == 0);
	}
	/**
	 * 用于加解密
	 */
	public void testEncry()
	{
		char  a1=' ' ,  a2=' ' ,  a3=' ' ,  a4=' ' ;
		char secret='9' ; 
		a1=(char) (a1^secret); 
		a2=(char) (a2^secret); 
		a3=(char) (a3^secret); 
		a4=(char) (a4^secret); 
		System.out.println("密文:"+a1+a2+a3+a4); 
		a1=(char) (a1^secret); 
		a2=(char) (a2^secret); 
		a3=(char) (a3^secret); 
		a4=(char) (a4^secret); 
		System.out.println("原文:"+a1+a2+a3+a4); 
	}
}
