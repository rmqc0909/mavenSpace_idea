package cn.tk.study.encode;

import java.io.UnsupportedEncodingException;
/**
 * 

* @ClassName: CommonCode

* @Description: 中文在常见编码中所占字节数		utf-8：中文3个字节		gbk,gb2312: 中文2个字节	ISO8859-1: 中文1个字节

* @author xiedan11

* @date 2016年7月22日 上午11:20:30

*
 */

public class CommonCode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("utf-8编码所占字节数: " + "哈哈".getBytes("utf-8").length);
		System.out.println("utf-16编码所占字节数: " + "哈哈".getBytes("utf-16").length);
		System.out.println("GBK编码所占字节数: " + "哈哈".getBytes("GBK").length);
		System.out.println("GB2312编码所占字节数: " + "哈哈".getBytes("GB2312").length);
		System.out.println("ISO8859-1编码所占字节数: " + "哈哈".getBytes("ISO8859-1").length);
	}

}
