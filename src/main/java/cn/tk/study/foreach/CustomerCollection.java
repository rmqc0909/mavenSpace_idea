/**
 * 
 */
package cn.tk.study.foreach;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

/**

 * @ClassName: CustomerCollection

 * @Description: 
 * 1.该集合类没有实现Iterable接口时，在用foreach遍历时会出现编译错误；
 * 2.foreach其实内部运用了Iterable来遍历Collection，该类没有具体的方法实现，所以再使用forach遍历该集合时会抛出空指针异常；

 * @author xiedan11
 * @param <T>

 * @date 2016年9月8日 上午9:38:42

 *


 */
public class CustomerCollection<T> extends AbstractCollection<T>{
	private ArrayList<T> bucket;

	/**
	*
	
	* @param string
	
	*/
	public boolean add(T e) {
		return bucket.add(e);
	}

	public CustomerCollection() {
		super();
		bucket = new ArrayList<T>();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return bucket.size();
	}

	/**
	*
	
	* @param i
	
	*/
	public T value(int i) {
		return bucket.get(i);
	}
	
}
