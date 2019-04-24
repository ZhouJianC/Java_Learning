package com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IntersectionOfArrays 
{
	//暴力解法，时间复杂度N*N
	private static int resultArrayLength;
	public static int[] intersectionOfTwoArrays(int []num1,int []num2)
	{
		List<Integer>arraylist=new ArrayList<Integer>();
		for(int i=0;i<num1.length;i++)
		{
			for(int j=0;j<num2.length;j++)
			{
				if(num1[i]==num2[j])
					arraylist.add(num1[i]);
			}
		}
		int length=arraylist.size();
		resultArrayLength=length;
		int temp[]=new int[length];
		for(int i=0;i<length;i++)
		{
			temp[i]=arraylist.get(i);
		}
		//使用Set集合，其内部不保存重复数据，可经过set集合筛选一遍
		Set<Integer>set=new TreeSet<Integer>();
		for(int i:temp)
		{
			set.add(i);
		}
		Integer [] temp2=set.toArray(new Integer[0]);
		int []result=new int[temp2.length];
		for(int i=0;i<result.length;i++)
		{
			result[i]=temp2[i];
		}
		
		return result;
		
		
		
		
	}
	
	public  static void main(String []args)
	{
		
		
		int []testarray1= {1,5,7,8,2,1,5};
		int []testarray2= {2,5,7,5,2};
		intersectionOfTwoArrays(testarray1,testarray2);
		int resultArray[]=new int[resultArrayLength];
		resultArray=intersectionOfTwoArrays(testarray1,testarray2);
		for(int j=0;j<resultArray.length;j++)
		{
			System.out.print(resultArray[j]+" ");
		}

	}

}
