package cn.tk.study.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * 

* @ClassName: ExceptionTryTest

* @Description: TODO

* @author xiedan11

* @date 2016年7月18日 上午10:35:39

*程序中显式的声明异常，则在抛出异常时，系统不会显示异常的出处（FileNotFoundException）
*无论如何,finally总会执行
*
*	java.io.FileNotFoundException: D:\exceptionTest1.txt (系统找不到指定的文件。)
 */
public class ExceptionDeclarationTest {
	public static void main(String[] args) {
        String file = "D:\\exceptionTest1.txt";
        FileReader reader;
        try {
            reader = new FileReader(file);
            Scanner in = new Scanner(reader);  
            String string = in.next();  
            System.out.println(string + "不知道我有幸能够执行到不.....");
        } 
        catch (FileNotFoundException e) 
        {
           e.printStackTrace();
           System.out.println("对不起,你执行不到...");
        }  
        finally{
            System.out.println("finally 在执行...");
        }
    }

}
