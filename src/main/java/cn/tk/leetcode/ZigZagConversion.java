package cn.tk.leetcode;

public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		String ret = zigZagConversion(s, 3);
		System.out.println("PAHNAPLSIIGYIR");
		System.out.println(ret);
	}

	/**
	*
	* P   A   H   N
	  A P L S I I G
	  Y   I   R
	* 
	* convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	* @param s
	* @param numRows
	* @return
	
	*/
	private static String zigZagConversion(String s, int numRows) {
		if(numRows <= 1) return s;
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer("");
        }
        int incre = 1;
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if(index == 0) incre = 1;				//第一行，步数：1
            if(index == numRows - 1) incre = -1;	//最后一行，步数： -1
            index += incre;
        }
        String res = "";
        for(int i = 0; i < sb.length; i++) {
            res += sb[i];
        }
        return res.toString();
	}

}
