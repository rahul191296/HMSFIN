package com.cognizant.Dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class PhysicianIdGenerator extends SequenceStyleGenerator{
	
	public Serializable generate(SessionImplementor arg0,Object arg1)
			throws HibernateException{
				return "PHY"+StorePhyId.getId();
			}

}
