package com.gzepro.internal.query.base.id;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SgBPIdentifierGenerator implements IdentifierGenerator {

	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {

		return UUID.randomUUID().toString().replace("-", "");

	}

}
