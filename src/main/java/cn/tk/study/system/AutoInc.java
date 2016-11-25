package cn.tk.study.system;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AutoInc {

	
	
	
	public static void main(String[] args) {
		
		DecimalFormat df =new  DecimalFormat("######0.00");  
		double   f   =   0.00;  
		BigDecimal   b   =   new   BigDecimal(f);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		System.out.println("f1:::" + f1);
		String dff = df.format(f);
		System.out.println("f1:::" + dff);
		
		
		byte a = 11;
		switch(a){// C
		case 11 : System.out.println(" 11 "); break;
		case (byte) 225 : System.out.println(" 11 "); break;// D
		}
		
		
		
		
	}
}
