package com.cognizant.Dao;

import java.util.ArrayList;
import java.util.List;

public class StoreDiagnosisId {

	static List<Integer> diagList=new ArrayList<Integer>();
	public static void addId(int id)
	{
		diagList.add(0,id);
	}
	public static int getId()
	{
		return diagList.get(0);
	}
}
