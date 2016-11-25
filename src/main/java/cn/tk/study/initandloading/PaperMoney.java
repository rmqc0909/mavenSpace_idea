package cn.tk.study.initandloading;


public class PaperMoney {
	private enum FaceValue {
		ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
	}
	static FaceValue face_value;
	public PaperMoney(FaceValue face_value) {
		this.face_value = face_value;
	}
	public void describe() {
		switch(face_value) {
		case ONE:		System.out.println("one yuan!");
						break;
		case FIVE:		System.out.println("five yuan！");
						break;
		case TEN:		System.out.println("ten yuan!");
						break;
		case TWENTY:	System.out.println("twenty yuan!");
						break;
		case FIFTY: 	System.out.println("fifty yuan!");
						break;
		case HUNDRED:	System.out.println("hundred yuan!");
						break;
		default:		System.out.println("default!!!");
		}
	}
	public static void main(String[] args) {
		for(FaceValue x : FaceValue.values()) {
			System.out.println(x + ", ordinal: " + x.ordinal());
		}
		PaperMoney paper_value = new PaperMoney(FaceValue.ONE);
		paper_value.describe();
	}
}
