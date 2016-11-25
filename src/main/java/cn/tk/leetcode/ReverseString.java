package cn.tk.leetcode;

/**
 * 

* @ClassName: ReverseString

* @Description: 反转字符串

* @author xiedan11

* @date 2016年8月10日 上午11:04:12

*
 */
public class ReverseString {

	public static void main(String[] args) {
		String reverseString = reverse("hell0!");
		System.out.println("reverseString: " + reverseString);
	}
	
	public static String reverse(String s)
	{
		byte[] arr1 = s.getBytes();
		byte[] arr2 = new byte[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			arr2[s.length() -1 - i] = arr1[i];
		}
		String res = new String(arr2);
		return res;
	}
}
