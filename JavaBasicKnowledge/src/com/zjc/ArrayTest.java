package com.zjc;
import java.util.Arrays;

/************
 * 有空实现一下冒泡排序和选择排序
 * @author doomedyy
 *2018-11-26
 */
public class ArrayTest 
{

	public static void main(String[] args) 
	{
		int size=10,test;
		boolean booltest;
		//数组的定义和声明
		int []myList=new int[size];
		for(int i=0;i<10;i++)
		{
			myList[i]=i;
		}
		double total=0;
		for(int j=0;j<myList.length;j++)
		{
			total+=myList[j];
		}
		test=Arrays.binarySearch(myList, 2);
		booltest=Arrays.equals(myList, myList);
		System.out.println("数组数据总和为："+total);
		System.out.println(test);
		System.out.println(booltest);
		
		

	}

}
