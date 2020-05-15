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

public class MediaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_media;
	public final IntegerExpression es_deId;
	public final AssociationExpression es_de;
	
	public MediaCriteria(Criteria criteria) {
		super(criteria);
		id_media = new IntegerExpression("id_media", this);
		es_deId = new IntegerExpression("es_de.id_mensaje", this);
		es_de = new AssociationExpression("es_de", this);
	}
	
	public MediaCriteria(PersistentSession session) {
		this(session.createCriteria(Media.class));
	}
	
	public MediaCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public MensajeCriteria createEs_deCriteria() {
		return new MensajeCriteria(createCriteria("es_de"));
	}
	
	public Media uniqueMedia() {
		return (Media) super.uniqueResult();
	}
	
	public Media[] listMedia() {
		java.util.List list = super.list();
		return (Media[]) list.toArray(new Media[list.size()]);
	}
}

