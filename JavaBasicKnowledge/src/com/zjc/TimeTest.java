package com.zjc;
import java.util.Date;
import java.text.*;

public class TimeTest 
{

	public static void main(String[] args) 
	{
		Date nowdate= new Date();
		//格式化日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(nowdate.toString());
		System.out.println("当前的日期为："+sdf.format(nowdate));
		

	}

}
