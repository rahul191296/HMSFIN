package com.cognizant.Dao;

import java.util.ArrayList;
import java.util.List;

public class StoreAdminId {

	static List<Integer> admList=new ArrayList<Integer>();
	static List<String>  admList1=new ArrayList<String>();
	static char arr[]=new char[10];
	static int generatedId;
	static int ch=65;
	
	public static void addId(int id)
	{
		admList.add(0,id);
		generatedId=id;
	}
	public static String getId()
	{ int len=arr.length;
	for(int x=0;x<len;x++)
	{
	arr[x]=(char)ch;
	if(ch<90)
	{
		ch++;
	}
	else{
		ch=65;
}
	}
ch=65;
int x=generatedId;
String str="";
int temp=x;
while(temp!=0)
{
	int d=temp%10;
	char ch=arr[d];
	str=ch+str;
	temp=temp/10;
}
    admList1.add(0,str);
	return admList1.get(0);
}

	
}
