package com.cognizant.Dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.controller.AdminController;

public class StorePatId {
	
	static List<Integer> patList=new ArrayList<Integer>();
	public static void addId(int id)
	{
		patList.add(0,id);
	}
	public static int getId()
	{
		return patList.get(0);
	}

}
