/**
 * 
 */
package cn.tk.study.verifycode;

import java.util.Random;

/**

 * @ClassName: VerifyCode

 * @Description: TODO

 * @author xiedan11

 * @date 2016年7月19日 下午4:22:01

 *


 */
public class VerifyCode {
	public static  String VERIFY_CODES = "0123456789";
	public static  int verifySize = 4;
	
	/**
	 * 
	*
	使用系统默认字符源生成验证码
	* @return
	 */
	public static String generateVerifyCode()
	{
		return generateVerifyCode(VERIFY_CODES);
	}
	
	
	public static String generateVerifyCode(String sources)
	{
		if(sources == null || sources.length() == 0)
		{
			sources = VERIFY_CODES;
		}
		int codesLen = sources.length();
		Random rand = new Random(System.currentTimeMillis());
		StringBuilder verifyCode = new StringBuilder(verifySize);
		for(int i =0; i < verifySize; i++)
		{
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}
		return verifyCode.toString();
	}
	
	public static void main(String[] args) {
		String code = generateVerifyCode();
		System.out.println("code:::" + code);
	}

}
