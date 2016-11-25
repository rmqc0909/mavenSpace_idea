package cn.tk.study.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**

 * @ClassName: ExceptionTest2

 * @Description: TODO

 * @author xiedan11

 * @date 2016年7月18日 下午1:51:09

 *	异常链之在抛出新的异常时不记录原来的异常踪迹，在程序中,去掉e，也就是：throw new MyException("文件没有找到--02");


 */
public class ExceptionChainTest2 {


	public void display(int i) throws MyException
	{
		if(i == 0)
		{
			throw new MyException("值不能为0。。。。");
		}
		else
		{
			System.out.println("i/2=" + i/2);
		}
	}
	public static void main(String[] args) {
		ExceptionChainTest2 exceptionTest = new ExceptionChainTest2();
		try 
		{
			//exceptionTest.display(0);
			System.out.println("-----------------------------");
			exceptionTest.g();
		} 
		catch (MyException e) 
		{
			e.printStackTrace();
		}
	}
	public void f() throws MyException
	{
		String file = "D:\\exceptionTest1.txt";
		try 
		{
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);
			System.out.println(in.next());
		} 
		catch (FileNotFoundException e) 
		{
			throw new MyException("文件没有找到--01");
			//e.printStackTrace();
		}
	}
	public void g() throws MyException
	{
		try 
		{
			f();
		} 
		catch (MyException e) 
		{
			throw new MyException("文件没有找到--02");
			//e.printStackTrace();
		}
	}

}
