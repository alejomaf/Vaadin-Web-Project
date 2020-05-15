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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class VideoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_media;
	public final IntegerExpression es_deId;
	public final AssociationExpression es_de;
	public final StringExpression enlace;
	
	public VideoDetachedCriteria() {
		super(com.mds.database.Video.class, com.mds.database.VideoCriteria.class);
		id_media = new IntegerExpression("id_media", this.getDetachedCriteria());
		es_deId = new IntegerExpression("es_de.id_mensaje", this.getDetachedCriteria());
		es_de = new AssociationExpression("es_de", this.getDetachedCriteria());
		enlace = new StringExpression("enlace", this.getDetachedCriteria());
	}
	
	public VideoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.VideoCriteria.class);
		id_media = new IntegerExpression("id_media", this.getDetachedCriteria());
		es_deId = new IntegerExpression("es_de.id_mensaje", this.getDetachedCriteria());
		es_de = new AssociationExpression("es_de", this.getDetachedCriteria());
		enlace = new StringExpression("enlace", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria createEs_deCriteria() {
		return new MensajeDetachedCriteria(createCriteria("es_de"));
	}
	
	public Video uniqueVideo(PersistentSession session) {
		return (Video) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Video[] listVideo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}

