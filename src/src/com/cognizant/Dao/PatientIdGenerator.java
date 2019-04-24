package com.cognizant.Dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class PatientIdGenerator extends SequenceStyleGenerator
{
	public Serializable generate(SessionImplementor arg0,Object arg1)
	throws HibernateException{
		return "pat"+StorePatId.getId();
	}

}
