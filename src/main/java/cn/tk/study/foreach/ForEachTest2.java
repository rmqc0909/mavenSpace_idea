package cn.tk.study.foreach;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * 

* @ClassName: ForEachTest2

* @Description: 
* 1.list删除元素必须使用iterator的remove()方法，不能使用list自身的remove()[不要将该删除方法用于循环中]；

* @author xiedan11

* @date 2016年9月8日 下午2:30:34

*
 */
public class ForEachTest2 {

	public static void main(String[] args) {
		Collection<String> list = new ArrayList<String>();
		list.add("java");
		list.add("c++");
		list.add("python");
		Iterator<String> itr = list.iterator();
		//以下两种方式均会抛出ConcurrentModificationException异常
		while(itr.hasNext()) {
			String lang = itr.next();
			list.remove(lang);
			//itr.remove();		//正确的删除方法
		}
		for(String x : list) {
			list.remove(x);
		}
		for(String x : list) {
			System.out.println("list中的元素：" + x);
		}
	}

}
