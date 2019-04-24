package com.cognizant.Dao;

import java.util.ArrayList;
import java.util.List;

public class StorePhyId {

	static List<Integer> phyList=new ArrayList<Integer>();
	public static void addId(int id)
	{
		phyList.add(0,id);
	}
	public static int getId()
	{
		return phyList.get(0);
	}
}
