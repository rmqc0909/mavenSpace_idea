package cn.tk.study.initandloading;

class Book {
	boolean checkedOut = false;
	Book(boolean checkOut) {
		checkedOut = checkOut;
	}
	protected void finalize() {
		if(checkedOut) {
			System.out.println("Error: check out! ");
		}
	}
	public void checkIn() {
		if(checkedOut) {
			checkedOut = false;
		}
	}
}

public class TerminationCondition {

	
	public static void main(String[] args) {
		Book book = new Book(true);
		book.checkIn();
		new Book(true);
		System.gc();
	}

}
