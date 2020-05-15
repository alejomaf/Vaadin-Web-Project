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

public class VideoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_media;
	public final IntegerExpression es_deId;
	public final AssociationExpression es_de;
	public final StringExpression enlace;
	
	public VideoCriteria(Criteria criteria) {
		super(criteria);
		id_media = new IntegerExpression("id_media", this);
		es_deId = new IntegerExpression("es_de.id_mensaje", this);
		es_de = new AssociationExpression("es_de", this);
		enlace = new StringExpression("enlace", this);
	}
	
	public VideoCriteria(PersistentSession session) {
		this(session.createCriteria(Video.class));
	}
	
	public VideoCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public MensajeCriteria createEs_deCriteria() {
		return new MensajeCriteria(createCriteria("es_de"));
	}
	
	public Video uniqueVideo() {
		return (Video) super.uniqueResult();
	}
	
	public Video[] listVideo() {
		java.util.List list = super.list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}

