package com.sort;
import java.util.Arrays;
import java.util.Comparator;
/**
 * @author JCZhou 
 * <p>Leetcode_1030. 距离顺序排列矩阵单元格
 * Description:给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，
 * 满足 0 <= r < R 且 0 <= c < C。另外，我们在该矩阵中给出了一个坐标为 
 * (r0, c0) 的单元格。返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离
 * 从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是
 * 曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。） </p>  
 * <p>analyze：  </p>  
 * @date 2019年5月13日  
 */
class Point
{
	public int x;
	public int y;
	public int d;
	public Point(int x,int y,int d) 
	{
		this.x=x;
		this.y=y;
		this.d=d;
	}
}
public class AllCellsDistOrder 
{
	public static int[][] allcellsDistOrder(int R,int C,int r0,int c0)
	{
		int[][] resultArrays=new int[R*C][2];
		Point []points=new Point[R*C];
		int index=0;
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
			{
				points[index]=new Point(i,j, Math.abs(i-r0)+Math.abs(j-c0));
				index++;
			}
		Arrays.sort(points, new Comparator<Point>(){
			public int compare(Point a,Point b)
			{
				return a.d-b.d;
			}});
		for(int i=0;i<R*C;i++)
		{
			resultArrays[i][0]=points[i].x;
			resultArrays[i][1]=points[i].y;
		}
	    return resultArrays;	
	}
	public static void  main(String[] args) 
	{
		int[][] Result =allcellsDistOrder(3, 4, 1, 1);
		System.out.println(Arrays.deepToString(Result));

	}

}
