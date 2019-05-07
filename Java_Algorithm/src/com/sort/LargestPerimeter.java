/**
 * <p>Title: LargestPerimeter.java</p>  
 * <p>Description:leetcode 976 
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长
 * 如果不能形成任何面积不为零的三角形，返回 0</p>    
 * @author JCZhou   
 * @date 2019年4月30日  
 * @version 1.0  
 */
package com.sort;
import java.util.Arrays;
/**
 * @author JCZhou 
 * <p>Description: </p>  
 * <p>analyze: 首先对数组进行排序，用Arrays代替冒泡，再依次检测最大的三个数是否满足三角形条件 </p>  
 * @date 2019年4月30日  
 */
public class LargestPerimeter 
{
    public static int largestperimeter(int [] A)
    {
    	//冒泡排序超出了时间限制
    	/*int change=0;
    	for(int i=0;i<A.length;i++)
    	{
    		for(int j=0;j<A.length-i-1;j++)
    		{
    			if(A[j]>A[j+1])
    			{
    				change=A[j+1];
    				A[j+1]=A[j];
    				A[j]=change;	
    			}
    		}
    	}*/
    	Arrays.sort(A);
    	for(int i=A.length-1;i>=2;i--)
    	{
    		if(A[i-1]+A[i-2]>A[i])
    		{
    			return A[i-1]+A[i-2]+A[i];	
    		}
    	}
    	return 0;
    }
	public static void main(String[] args) 
	{
		int [] A= {3,2,3,4};
		int largestperimeter=0;
		largestperimeter=largestperimeter(A);
		System.out.println("最大周长为："+largestperimeter);
	}
}
