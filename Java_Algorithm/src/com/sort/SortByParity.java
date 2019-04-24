package com.sort;
/**
 * @author JCZhou 
 * <p>Description: 力扣 922.按奇偶排序数组
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。 
 * 输入样例：[4,2,5,7]
 * 输出样例：[4,5,2,7]，满足条件即可
 * </p>
 * <p>analyze:额外建立两个数组，分别放奇数偶数，再插入原来数组</p>       
 * @date 2019年4月24日  
 */
public class SortByParity 
{
	public static int [] SortArrayByParityII(int []A)
	{
		int []odd=new int[A.length /2];
		int []even=new int[A.length/2];
		int odd_index=0,even_index=0;
		int odd_index_result=0,even_index_result=0;
		for(int index=0;index<A.length;index++)
		{
			if(A[index]%2==0)
			{
				even[even_index++]=A[index];
			}
			else
			{
				odd[odd_index++]=A[index];
			}
		}
		for(int index=0;index<A.length;index++)
		{
			if(index%2==0)
			{
				A[index]=even[even_index_result++];
			}
			else
			{
				A[index]=odd[odd_index_result++];
			}
		}

		return A;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int []A= {4,2,5,7};
		int []result=SortArrayByParityII(A);
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i]+",");
		}
		
		

	}

}
