package cn.tk.study.initandloading;

class Tank {
	boolean isEmpty = false;
	
	public Tank(boolean empty) {
		isEmpty = empty;
	}

	protected void finalize() {
		if(isEmpty) {
			System.out.println("Tank is Empty !");
		}
		System.out.println("Rest in Peace!");
	}
}

public class TerminationCondition2 {
	
	public static void main(String[] args) {
		new Tank(true);
		Tank tank = new Tank(true);
		System.gc();
	}

}
