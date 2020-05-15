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

public class NotificacionesCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_notificaciones;
	public final IntegerExpression deId;
	public final AssociationExpression de;
	public final StringExpression enlace;
	public final StringExpression titulo;
	
	public NotificacionesCriteria(Criteria criteria) {
		super(criteria);
		id_notificaciones = new IntegerExpression("id_notificaciones", this);
		deId = new IntegerExpression("de.id_usuario", this);
		de = new AssociationExpression("de", this);
		enlace = new StringExpression("enlace", this);
		titulo = new StringExpression("titulo", this);
	}
	
	public NotificacionesCriteria(PersistentSession session) {
		this(session.createCriteria(Notificaciones.class));
	}
	
	public NotificacionesCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createDeCriteria() {
		return new UsuarioCriteria(createCriteria("de"));
	}
	
	public Notificaciones uniqueNotificaciones() {
		return (Notificaciones) super.uniqueResult();
	}
	
	public Notificaciones[] listNotificaciones() {
		java.util.List list = super.list();
		return (Notificaciones[]) list.toArray(new Notificaciones[list.size()]);
	}
}

