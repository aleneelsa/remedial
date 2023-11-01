/*
 * File         :  freq.java
 * Description  :  check frequency of a character in a string 
 * Author       :  Alene Elsa 
 * Version      :  1.0
 * Date         :  29/09/23                                                                   
 */    

import java.util.Scanner;
public class freq{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String input=sc.next();
		System.out.println("enter the character to be searched");
		char checkMe=sc.next().charAt(0);
		int CharCount=CheckFreq(input,checkMe);
		System.out.println(" frequency of given character is:" +CharCount);
		
	}
	/*function receives string as input
	 * return frequency of the character
	 */
	static int CheckFreq (String input,char checkMe) {
		char[]charArray=input.toCharArray();
		int CharCount=0;
		for(int i=0;i<input.length();i++) {
			if (charArray[i]==checkMe) {
				CharCount++;
			}
		}
		return CharCount;
	}
}
		

		
