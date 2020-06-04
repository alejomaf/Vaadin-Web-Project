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

public class NotificacionesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_notificaciones;
	public final IntegerExpression deId;
	public final AssociationExpression de;
	public final DateExpression fecha;
	public final StringExpression enlace;
	public final StringExpression titulo;
	
	public NotificacionesDetachedCriteria() {
		super(com.mds.database.Notificaciones.class, com.mds.database.NotificacionesCriteria.class);
		id_notificaciones = new IntegerExpression("id_notificaciones", this.getDetachedCriteria());
		deId = new IntegerExpression("de.id_usuario", this.getDetachedCriteria());
		de = new AssociationExpression("de", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		enlace = new StringExpression("enlace", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
	}
	
	public NotificacionesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.NotificacionesCriteria.class);
		id_notificaciones = new IntegerExpression("id_notificaciones", this.getDetachedCriteria());
		deId = new IntegerExpression("de.id_usuario", this.getDetachedCriteria());
		de = new AssociationExpression("de", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		enlace = new StringExpression("enlace", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createDeCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("de"));
	}
	
	public Notificaciones uniqueNotificaciones(PersistentSession session) {
		return (Notificaciones) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notificaciones[] listNotificaciones(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notificaciones[]) list.toArray(new Notificaciones[list.size()]);
	}
}

