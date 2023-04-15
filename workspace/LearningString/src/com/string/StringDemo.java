package com.string;

public class StringDemo {
	public static void duplicateChar(String s) {
		System.out.println("Input: "+s);
		s=s.toLowerCase();
		int arr[]=new int[26];
		for(int i=0;i<26;i++) arr[i]=0;
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-'a']+=1;
		}
		System.out.print("Duplicate characters are: ");
		for(int i=0;i<26;i++) {
			if(arr[i]>1) {
				int charconst=i+'a';
				char ch=(char) charconst;
				
				System.out.print(ch+" ");
			}
		}
	}
	public static void charOccurence(String s) {
		System.out.println("Input: "+s);
		s=s.toLowerCase();
		int arr[]=new int[26];
		for(int i=0;i<26;i++) arr[i]=0;
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-'a']+=1;
		}
		System.out.println("character: Occurence");
		for(int i=0;i<26;i++) {
			if(arr[i]>0) {
				int charconst=i+'a';
				char ch=(char) charconst;
				
				System.out.println("   "+ch+": 		"+arr[i]);
			}
		}
	}
	public static void isAnagram(String s1,String s2) {
		System.out.println("Input: "+s1+" "+s2);
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		int arr1[]=new int[26];
		int arr2[]=new int[26];
		for(int i=0;i<26;i++) {
			arr1[i]=0;
			arr2[i]=0;
		}
		for(int i=0;i<s1.length();i++) {
			arr1[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<s2.length();i++) {
			arr2[s2.charAt(i)-'a']++;
		}
		boolean flag=true;
		for(int i=0;i<26;i++) {
			if(arr1[i]!=arr2[i]) {
				flag=false;
				break;
			}
		}
		if(flag) {
			System.out.println("Anagram");
		}else {
			System.out.println("Not Anagram");
		}
	}
	public static String reverseString(String s) {
		System.out.println("Input: "+s);
		StringBuffer reversed=new StringBuffer("");
		for(int i=s.length()-1;i>=0;i--) {
			reversed.append(s.charAt(i));
		}
		s=reversed.toString();
		System.out.println("Reversed String: "+s);
		return s;
	}
	public static void isPalindrome(String s) {
		System.out.println("Input: "+s);
		String reversed=reverseString(s);
		if(s.equals(reversed)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
	}
	public static void addNumber(String s1,String s2) {
		System.out.println("Input: "+s1+" "+s2);
		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		System.out.println("Result: "+(a+b));
	}
	public static void removeChar(String s,char ch) {
		StringBuffer newString=new StringBuffer("");
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=ch) {
				newString.append(s.charAt(i));
			}
		}
		s=newString.toString();
		System.out.println("Result: "+s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1="Java";
//		StringBuffer s2=new StringBuffer("Java");
//		s2.append("Buffer");
//		StringBuilder s3=new StringBuilder("Java");
//		s3.append("builder");
//		String s4=new String("Java");
//		System.out.println(s1==s4);
//		String s3=new String("Java");
//		System.out.println(s1.hashCode()+" "+s2.hashCode()+" "+s3.hashCode());
//		System.out.println(s1+s2+s3);
//		
//		String s4= new String("Java").intern();
//		System.out.println("Java"+(2+4));
		
//		String s="abc";
//		charOccurence(s);
//		isAnagram("Java", "Ajav");
//		reverseString("Java");
//		duplicateChar("Java");
//		isPalindrome("121");
//		isPalindrome("122");
//		removeChar("Java", 'J');
		char ch='a';
		System.out.println(Character.SIZE);
		String s1=new String("Java");
		String s2=new String("Java");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		StringBuffer bf1=new StringBuffer("Java");
		StringBuffer bf2=new StringBuffer("Java");
		System.out.println(bf1==bf2);
		System.out.println(bf1.equals(bf2));
		
	}

}
