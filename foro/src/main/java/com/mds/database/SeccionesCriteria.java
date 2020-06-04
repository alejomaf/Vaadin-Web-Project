/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Alejo Martín Arias Filippo(University of Almeria)
 * License Type: Academic
 */
package com.mds.database;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class SeccionesCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_secciones;
	public final StringExpression nombre;
	public final CollectionExpression tiene;
	
	public SeccionesCriteria(Criteria criteria) {
		super(criteria);
		id_secciones = new IntegerExpression("id_secciones", this);
		nombre = new StringExpression("nombre", this);
		tiene = new CollectionExpression("ORM_tiene", this);
	}
	
	public SeccionesCriteria(PersistentSession session) {
		this(session.createCriteria(Secciones.class));
	}
	
	public SeccionesCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public TemasCriteria createTieneCriteria() {
		return new TemasCriteria(createCriteria("ORM_tiene"));
	}
	
	public Secciones uniqueSecciones() {
		return (Secciones) super.uniqueResult();
	}
	
	public Secciones[] listSecciones() {
		java.util.List list = super.list();
		return (Secciones[]) list.toArray(new Secciones[list.size()]);
	}
}

