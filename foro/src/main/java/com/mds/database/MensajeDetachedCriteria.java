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

public class MensajeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_mensaje;
	public final IntegerExpression respuesta_deId;
	public final AssociationExpression respuesta_de;
	public final CollectionExpression es_gustado;
	public final IntegerExpression son_deId;
	public final AssociationExpression son_de;
	public final IntegerExpression num_likes;
	public final StringExpression contenido;
	public final DateExpression fechaMensaje;
	public final CollectionExpression tiene;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final CollectionExpression contiene;
	
	public MensajeDetachedCriteria() {
		super(com.mds.database.Mensaje.class, com.mds.database.MensajeCriteria.class);
		id_mensaje = new IntegerExpression("id_mensaje", this.getDetachedCriteria());
		respuesta_deId = new IntegerExpression("respuesta_de.id_mensaje", this.getDetachedCriteria());
		respuesta_de = new AssociationExpression("respuesta_de", this.getDetachedCriteria());
		es_gustado = new CollectionExpression("ORM_es_gustado", this.getDetachedCriteria());
		son_deId = new IntegerExpression("son_de.id_tema", this.getDetachedCriteria());
		son_de = new AssociationExpression("son_de", this.getDetachedCriteria());
		num_likes = new IntegerExpression("num_likes", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		fechaMensaje = new DateExpression("fechaMensaje", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.id_usuario", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.MensajeCriteria.class);
		id_mensaje = new IntegerExpression("id_mensaje", this.getDetachedCriteria());
		respuesta_deId = new IntegerExpression("respuesta_de.id_mensaje", this.getDetachedCriteria());
		respuesta_de = new AssociationExpression("respuesta_de", this.getDetachedCriteria());
		es_gustado = new CollectionExpression("ORM_es_gustado", this.getDetachedCriteria());
		son_deId = new IntegerExpression("son_de.id_tema", this.getDetachedCriteria());
		son_de = new AssociationExpression("son_de", this.getDetachedCriteria());
		num_likes = new IntegerExpression("num_likes", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		fechaMensaje = new DateExpression("fechaMensaje", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.id_usuario", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria createRespuesta_deCriteria() {
		return new MensajeDetachedCriteria(createCriteria("respuesta_de"));
	}
	
	public UsuarioDetachedCriteria createEs_gustadoCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_es_gustado"));
	}
	
	public TemasDetachedCriteria createSon_deCriteria() {
		return new TemasDetachedCriteria(createCriteria("son_de"));
	}
	
	public MensajeDetachedCriteria createTieneCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public UsuarioDetachedCriteria createPertenece_aCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("pertenece_a"));
	}
	
	public MediaDetachedCriteria createContieneCriteria() {
		return new MediaDetachedCriteria(createCriteria("ORM_contiene"));
	}
	
	public Mensaje uniqueMensaje(PersistentSession session) {
		return (Mensaje) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Mensaje[] listMensaje(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}

