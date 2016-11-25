package cn.tk.study.foreach;



public class ForEachTest {

	
	
	public static void main(String[] args) {
		CustomerCollection<String> myCollection = new CustomerCollection<String>();
		myCollection.add("java");
		myCollection.add("python");
		myCollection.add("c++");
		System.out.println("集合大小：" + myCollection.size());
		for(int i = 0; i < myCollection.size(); i++) {
			System.out.println("集合元素：" + myCollection.value(i));		
			}
		for(String x : myCollection) {
			System.out.println("x:" + x);
		}		//运行时会抛出空指针异常
	}
}
