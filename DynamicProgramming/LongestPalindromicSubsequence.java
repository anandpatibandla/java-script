/*
 *  In the given Example we take the input of the two strings s1 and s2 and we find out the length of the 
 *  Longest Palindromic Subsequence
 */

package DynamicProgramming;

import java.lang.*;
import java.util.*;
import java.io.*;
/*
@Author : Amit Thakur
*/

public class LongestPalindromicSubsequence 
{
	public static int LCS(String s1,String s2)
	{
		int i=0,j=0,row=0,col=0;
		
		int dp[][];
		dp=new int [s1.length()+1][s2.length()+1];
		
		row=s1.length();
		col=s2.length();
		System.out.println(dp.length+" "+dp[0].length);
		for(i=0;i<row+1;i++)
		{
			for(j=0;j<col+1;j++)
			{
				if(i==0 || j==0)
				{
					dp[i][j]=0;
				}
			}
		}
		
		for(i=1;i<row+1;i++)
		{
			for(j=1;j<col+1;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return(dp[row][col]);
	}
	
	public static int util(String s1,String s2)
	{
		int i=0,ret=0;
		
		String reverseS="";
		
		StringBuffer sb=new StringBuffer();
		
		for(i=0;i<s2.length();i++)
		{

			sb.append(s2.charAt(i));
		}
		
		reverseS=sb.reverse().toString();
		
		ret=LCS(s1,reverseS);
		
		return(ret);
	}

	public static void main(String[] args) 
	{
		String s1="BBABCBCAB";
		String s2="BABCBAB";
		
		int ret=0;
		
		ret=util(s1,s2);
		
		System.out.println("The Length of the Longest Palindromic Subsequence of the above Two Strings is:-");
		System.out.println(ret);

	}

}
