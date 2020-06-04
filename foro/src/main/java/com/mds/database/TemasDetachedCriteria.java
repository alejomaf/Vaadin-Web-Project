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

public class TemasDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_tema;
	public final CollectionExpression leGustaTema;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final StringExpression nombre;
	public final IntegerExpression num__likes;
	public final BooleanExpression publico;
	public final StringExpression contenido;
	public final DateExpression fechaTema;
	public final IntegerExpression creado_porId;
	public final AssociationExpression creado_por;
	public final CollectionExpression tiene;
	
	public TemasDetachedCriteria() {
		super(com.mds.database.Temas.class, com.mds.database.TemasCriteria.class);
		id_tema = new IntegerExpression("id_tema", this.getDetachedCriteria());
		leGustaTema = new CollectionExpression("ORM_leGustaTema", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.id_secciones", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		num__likes = new IntegerExpression("num__likes", this.getDetachedCriteria());
		publico = new BooleanExpression("publico", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		fechaTema = new DateExpression("fechaTema", this.getDetachedCriteria());
		creado_porId = new IntegerExpression("creado_por.id_usuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
	}
	
	public TemasDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.TemasCriteria.class);
		id_tema = new IntegerExpression("id_tema", this.getDetachedCriteria());
		leGustaTema = new CollectionExpression("ORM_leGustaTema", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.id_secciones", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		num__likes = new IntegerExpression("num__likes", this.getDetachedCriteria());
		publico = new BooleanExpression("publico", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		fechaTema = new DateExpression("fechaTema", this.getDetachedCriteria());
		creado_porId = new IntegerExpression("creado_por.id_usuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createLeGustaTemaCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_leGustaTema"));
	}
	
	public SeccionesDetachedCriteria createPertenece_aCriteria() {
		return new SeccionesDetachedCriteria(createCriteria("pertenece_a"));
	}
	
	public UsuarioDetachedCriteria createCreado_porCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("creado_por"));
	}
	
	public MensajeDetachedCriteria createTieneCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public Temas uniqueTemas(PersistentSession session) {
		return (Temas) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Temas[] listTemas(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Temas[]) list.toArray(new Temas[list.size()]);
	}
}

