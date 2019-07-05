package com.sort;
import java.util.Arrays;
/**
 * @author JCZhou 
 * <p>Description: </p>  
 * <p>analyze:  </p>  
 * @date 2019年7月2日  
 */
public class Sort_Algorithm 
{
	/**
	 * <p>Title: HeapAdjust</p>  
	 * <p>Description:大顶堆排序调整 </p>  
	 * @param arr 待调整的数组
	 * @param i  待调整的位置
	 * @param length 待调整数组的长度
	 */
	public static void HeapAdjust(int arr[], int i, int length)
	{
		int max = i;
		int lchild = i * 2 + 1;
		int rchild = i * 2 + 2;
		if(lchild < length && arr[lchild] > arr[max])
		{
			max = lchild;
		}
		if(rchild < length && arr[rchild] > arr[max])
		{
			max = rchild;
		}
		//判断该位置值是否比左右孩子小,则进行位置交换，并向下递归调整
		if(max != i)
		{
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			HeapAdjust(arr, max, length);
		}
	}
	/**
	 * <p>Title: HeapSort</p>  
	 * <p>Description:堆排序 </p>  
	 * @param arr
	 * @param length
	 */
	public static void HeapSort(int arr[], int length)
	{
		for(int i = length/2 - 1; i>=0; i--)
		{
			HeapAdjust(arr, i, length);
		}
		for(int i=length-1; i>=0; i-- ) 
		{
			int temp;
			temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			HeapAdjust(arr, 0, i);
		}
	}
	
	/**
	 * <p>Title: BubbleSort</p>  
	 * <p>Description: 冒泡排序</p>
	 */
	public static void BubbleSort(int [] arr, int length)
	{
		if(length > 1)
		{
			for(int i = 0; i < length; i++)
			{
				for(int j = 0; j < length - i -1; j++)
				{
					if(arr[j] > arr[j+1])
					{
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
		}		
	}
	
	/**
	 * <p>Title: SelectionSort</p>  
	 * <p>Description:选择排序 </p>
	 */
	public static void SelectionSort(int []arr, int length)
	{
	    for(int i = 0; i < length; i++)
		{
	    	int minIndex = i;
			for(int j = i; j < length; j++)
			{
				if(arr[j] < arr[minIndex])
				{
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	/**
	 * <p>Title: InsertionSort</p>  
	 * <p>Description: 插入排序</p> 
	 * 第二种方法使用了两个游标 
	 */
	public static void InsertionSortI(int []arr, int length)
	{
		for(int i = 1; i < length; i++)
		{
			for(int j = i; j > 0; j-- )
			{
				if(arr[j] < arr[j-1])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j - 1] = temp;
				}
			}
		}
	}
	public static void InsertionSortII(int []arr, int length)
	{
		int current;
		for(int i = 0; i < length - 1; i++)
		{
			int preIndex = i;
			current = arr[i+1];
			while(preIndex >= 0 && arr[preIndex] > current)
			{
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;//插入合适的位置
		}
	}
	
	/**
	 * 
	 * <p>Title: ShellSort</p>  
	 * <p>Description:希尔排序 （缩小增量排序），对插入排序进行了改进</p>  
	 * @param arr
	 * @param length
	 */
	public static void ShellSort(int []arr, int length)
	{
		int temp, gap = length / 2;
		while(gap > 0)        //外循环，进行几轮
		{
			for(int i = gap; i < length; i++)
			{
				//每轮中各组交替进行插入排序
				temp = arr[i];
				int preIndex = i - gap;
				while(preIndex >= 0 && arr[preIndex] > temp)
				{
					arr[preIndex + gap] = arr[preIndex];
					preIndex -=gap;
				}
				arr[preIndex + gap] = temp;//插入合适的位置
			}
			gap /= 2;
		}	
	}
	
	/**
	 * 
	 * <p>Title: QuickSort</p>  
	 * <p>Description: 快速排序</p>  
	 * @param arr
	 * @param length
	 */
	public static void  QuickSort(int []arr, int low, int high)
	{
		int i = low;
		int j = high;
		if(low > high)
			return;
		int standard = arr[low];
		while(i < j)
		{
			while(standard <= arr[j] && i < j)
				j--;
			while(standard >= arr[i] && i < j)
				i++;
			if(i < j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[low] = arr[i];
		arr[i] = standard;
		QuickSort(arr, low, j - 1);
		QuickSort(arr, j + 1, high);
	}

	/**
	 * 
	 * <p>Title: MergeSort</p>  
	 * <p>Description:归并排序（2路）,先递归拆分到只包含单个元素的子数组，再两两合并 </p>  
	 * @param arr
	 * @return
	 */
	public static int [] MergeSort(int [] arr) 
	{
		if(arr.length < 2)
			return arr;
		int mid = arr.length / 2;
		int [] left = Arrays.copyOfRange(arr, 0, mid);
		int [] right = Arrays.copyOfRange(arr, mid, arr.length);
		return Merge(MergeSort(left), MergeSort(right));
	}
	//将两段排序好的数组合并成一个数组
	public static int [] Merge(int [] left, int [] right)
	{
		int [] result = new int [left.length + right.length];
		for(int index = 0,  i =0, j = 0; index < result.length; index++ )
		{
			if(i >= left.length)
				result[index] = right[j++];
			else if (j >= right.length)
				result[index] = left[i++];
			else if (left[i] > right [j])
				result[index] = right[j++];
			else
				result[index] = left[i++];		
		}
		return result;
	}
	public static void main(String[] args)
	{
		int arr[] = {4,2,8,0,11,10,5,2,3,1};
		//堆排序
		//HeapSort(arr, arr.length);
		
		//冒泡排序
		//BubbleSort(arr, arr.length);
		
		//选择排序
		//SelectionSort(arr, arr.length);
		
		//插入排序
		//InsertionSortII(arr, arr.length);
		
		//希尔排序
		//ShellSort(arr, arr.length);
		
		//快速排序
		//QuickSort(arr, 0, arr.length - 1);
		
		//归并排序
		int []  result = MergeSort(arr);
		
		for(int i = 0; i <= result.length - 1; i++)
		{
			System.out.print(result[i]+" ");
		}
		//System.out.println(" length: "+arr.length);
    }
}
