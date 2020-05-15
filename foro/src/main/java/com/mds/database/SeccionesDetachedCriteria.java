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

public class SeccionesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_secciones;
	public final IntegerExpression es_creada_porId;
	public final AssociationExpression es_creada_por;
	public final StringExpression nombre;
	public final CollectionExpression tiene;
	
	public SeccionesDetachedCriteria() {
		super(com.mds.database.Secciones.class, com.mds.database.SeccionesCriteria.class);
		id_secciones = new IntegerExpression("id_secciones", this.getDetachedCriteria());
		es_creada_porId = new IntegerExpression("es_creada_por.id_usuario", this.getDetachedCriteria());
		es_creada_por = new AssociationExpression("es_creada_por", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
	}
	
	public SeccionesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.SeccionesCriteria.class);
		id_secciones = new IntegerExpression("id_secciones", this.getDetachedCriteria());
		es_creada_porId = new IntegerExpression("es_creada_por.id_usuario", this.getDetachedCriteria());
		es_creada_por = new AssociationExpression("es_creada_por", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria createEs_creada_porCriteria() {
		return new AdministradorDetachedCriteria(createCriteria("es_creada_por"));
	}
	
	public TemasDetachedCriteria createTieneCriteria() {
		return new TemasDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public Secciones uniqueSecciones(PersistentSession session) {
		return (Secciones) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Secciones[] listSecciones(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Secciones[]) list.toArray(new Secciones[list.size()]);
	}
}

