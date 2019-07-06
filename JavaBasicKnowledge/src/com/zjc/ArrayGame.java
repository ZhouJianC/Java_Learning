package com.zjc;
import java.util.Scanner;
/*******************************
 * @author doomedyy
 * 2018-11-26
 *程序随机产生5个按一定顺序排列的字符，作为猜测结果
 *玩家可以猜测多次，每猜一次，若猜测的完全正确则游戏结束，并计算玩家的游戏得分并输出。
 *若没有猜对，则提示猜测结果，如猜对了几个字符，以及猜对了几个字符的位置信息，
 *并提示玩家游戏继续。若中途输入EXIT，则游戏提前结束
 */

public class ArrayGame 
{
	private static Scanner scan;
    // 主方法
    public static void main(String[] args) 
    {
        scan = new Scanner(System.in);
        char[] chs = generate();
        System.out.println(chs);
        int count = 0; // 猜错的次数
        while (true) { // 自造死循环
            System.out.println("猜吧!");
            String str = scan.next().toUpperCase(); // 获取用户输入的字符串
            if (str.equals("EXIT")) 
            { // 判断字符串内容相等
                System.out.println("下次再来吧!");
                break;
            }
            char[] input = str.toCharArray(); // 将字符串转换为字符数组
            int[] result = check(chs, input);
            if (result[0] == chs.length) 
            { // 对
            	int score = 100 * chs.length - 10 * count;
                System.out.println("恭喜你，猜对了!得分为:" + score);
                break;
            } 
            else 
            {
                count++;
                System.out.println("字符对个数为:" + result[1] + "，位置对个数为:" + result[0]);
            }
        }
    }
    // 生成随机字符数组chs
    public static char[] generate() 
    {
        char[] chs = new char[5];
        char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z' };
        boolean[] flags = new boolean[letters.length];
        for (int i = 0; i < chs.length; i++)
        {
            int index;
            do 
            {
                index = (int) (Math.random() * letters.length);
            } while (flags[index] == true);
            chs[i] = letters[index];
            flags[index] = true;
        }
        // i=0 index=0 chs[0]='A' flags[0]=true
        // i=1 index=25 chs[1]='Z' flags[25]=true
        // i=2 index=0/25/0/25/1 chs[2]='B' flags[1]=true
        return chs;
    }

    // 对比:随机字符数组chs与用户输入的字符数组input
    public static int[] check(char[] chs, char[] input) 
    {
        int[] result = new int[2]; // (0,0)
        for (int i = 0; i < chs.length; i++) 
        {
            for (int j = 0; j < input.length; j++) 
            {
                if (chs[i] == input[j]) 
                {
                    result[1]++;
                    if (i == j) 
                    	result[0]++;
                    break;
                }
            }
        }
        return result;
    }
}
           
