package cn.tk.study.system;

class Tank {
	int level;
}


class Operator {
	float number;
}
/**
 * 

* @ClassName: AssignmentOperator

* @Description: TODO 针对对象及普通类型的赋值操作

* @author xiedan11

* @date 2016年8月4日 下午4:37:50

*
 */
public class AssignmentOperator {

	public void f(Operator op)
	{
		op.number = 1111;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12;
		int b = 34;
		System.out.println("1: a = " + a + ", b = " + b);
		a = b;
		System.out.println("2: a = " + a + ", b = " + b);
		a = 56;
		System.out.println("3: a = " + a + ", b = " + b);
		
		Tank  t1 = new Tank();
		Tank  t2 = new Tank();
		t1.level = 4;
		t2.level = 8;
		System.out.println("1: t1 = " + t1.level + ", t2 = " + t2.level);
		//t1 = t2;		为对象赋值，是将t2引用赋给t1，即t1和t2指向同一个对象。
		t1.level = t2.level;
		System.out.println("2: t1 = " + t1.level + ", t2 = " + t2.level);
		t1.level = 24;
		System.out.println("3: t1 = " + t1.level + ", t2 = " + t2.level);
		
		
		Operator op1 = new Operator();
		Operator op2 = new Operator();
		op1.number = 99;
		op2.number = 1015;
		System.out.println("1: op1 = " + op1.number + ", op2 = " + op2.number);
		op1 = op2;
		System.out.println("2: op1 = " + op1.number + ", op2 = " + op2.number);
		op1.number = 33;
		System.out.println("3: op1 = " + op1.number + ", op2 = " + op2.number);
		
		AssignmentOperator assignmentOperator = new AssignmentOperator();
		assignmentOperator.f(op1);
		System.out.println("4: op1 = " + op1.number);
		
		
		String cidno = "6101111993x";
		System.out.println("大写的身份证：" + cidno.toUpperCase());
		
	}

}
