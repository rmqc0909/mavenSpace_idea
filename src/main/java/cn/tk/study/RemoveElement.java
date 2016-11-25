package cn.tk.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import cn.tk.study.xor.XOR;
/**
 * 

* @ClassName: RemoveElement

* @Description: 该程序用于删除集合A中包含在集合B中的元素，例如删除soruce中blackNameList中的元素

* @author xiedan11

* @date 2016年8月10日 上午10:22:26

*
 */
public class RemoveElement {
	
	private static List<String> source = new ArrayList<String>();
	private static List<String> blackNameList = new ArrayList<String>();
	static
	{
		source.add("111");
		source.add("222");
		source.add("333");
		source.add("444");
		source.add("555");
		
		blackNameList.add("111");
		blackNameList.add("222");
	}
	public static void main(String[] args) 
	{
		byte a[] = {1, 2, 4, 3, 2, 4, 7, 2};
		System.out.println((byte)(-1) >>> 1);
		System.out.println(Integer.signum(-1));
		System.out.println((byte)(-1) >> 1);
		int b = Arrays.binarySearch(a, (byte)2);
		System.out.println(b);
		//RemoveElement removeElement = new RemoveElement();
		//removeElement.screenBlackNameList();
		RemoveElement removeElement = new RemoveElement();
		removeElement.screenBlackNameList();
	}
	
	private void screenBlackNameList()
	{
		System.out.println("删除前::" + source.size());
		//correctDeal();
		//errorDeal1();
		errorDeal2();
		System.out.println("删除后::" + source.size());

	}
	/**
	 * 错误2的做法
	 */
	private void errorDeal2()
	{
		for(String tmpSharedBoardSmsWrapper:source){
		       
	        for(String tmpBlackNameListModel:blackNameList){
	            if(tmpSharedBoardSmsWrapper.equals(tmpBlackNameListModel)){
	               source.remove(tmpSharedBoardSmsWrapper);
	               break;
	            }
	           
	        }
	    }
	}
	
	/**
	 * 错误1的做法
	 */
	private void errorDeal1()
	{
		for(int i=0;i<source.size();i++)
		{
	        String tmpSharedBoardSmsWrapper=source.get(i);
	        for(int j=0;j<blackNameList.size();j++)
	        {
	            String tmpBlackNameListModel=blackNameList.get(j);
	            if(tmpSharedBoardSmsWrapper.equals(tmpBlackNameListModel))
	            {
	               source.remove(tmpSharedBoardSmsWrapper);
	               break;
	            }
	        }
	    }
	}
	
	
	/**
	 * 正确的处理方法
	 */
	private void correctDeal()
	{
		Iterator<String> sourceIt = source.iterator();
		while(sourceIt.hasNext())
		{
			String tmpSharedBoardSmsWrapper = sourceIt.next();
			Iterator<String> blackNameListIt = blackNameList.iterator();
			while(blackNameListIt.hasNext())
			{
				String tmpBlackNameListModel = blackNameListIt.next();
				if(tmpSharedBoardSmsWrapper.equals(tmpBlackNameListModel))
				{
					sourceIt.remove();
					break;
				}
			}
		}
	}
}

	
