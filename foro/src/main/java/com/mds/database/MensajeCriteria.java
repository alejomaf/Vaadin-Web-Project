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

public class MensajeCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_mensaje;
	public final IntegerExpression eliminado_porId;
	public final AssociationExpression eliminado_por;
	public final IntegerExpression respuesta_deId;
	public final AssociationExpression respuesta_de;
	public final CollectionExpression es_gustado;
	public final IntegerExpression son_deId;
	public final AssociationExpression son_de;
	public final IntegerExpression num_likes;
	public final StringExpression contenido;
	public final BooleanExpression privado;
	public final CollectionExpression tiene;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final CollectionExpression contiene;
	
	public MensajeCriteria(Criteria criteria) {
		super(criteria);
		id_mensaje = new IntegerExpression("id_mensaje", this);
		eliminado_porId = new IntegerExpression("eliminado_por.id_usuario", this);
		eliminado_por = new AssociationExpression("eliminado_por", this);
		respuesta_deId = new IntegerExpression("respuesta_de.id_mensaje", this);
		respuesta_de = new AssociationExpression("respuesta_de", this);
		es_gustado = new CollectionExpression("ORM_es_gustado", this);
		son_deId = new IntegerExpression("son_de.id_tema", this);
		son_de = new AssociationExpression("son_de", this);
		num_likes = new IntegerExpression("num_likes", this);
		contenido = new StringExpression("contenido", this);
		privado = new BooleanExpression("privado", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		pertenece_aId = new IntegerExpression("pertenece_a.id_usuario", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		contiene = new CollectionExpression("ORM_contiene", this);
	}
	
	public MensajeCriteria(PersistentSession session) {
		this(session.createCriteria(Mensaje.class));
	}
	
	public MensajeCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public ModeradorCriteria createEliminado_porCriteria() {
		return new ModeradorCriteria(createCriteria("eliminado_por"));
	}
	
	public MensajeCriteria createRespuesta_deCriteria() {
		return new MensajeCriteria(createCriteria("respuesta_de"));
	}
	
	public UsuarioCriteria createEs_gustadoCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_es_gustado"));
	}
	
	public TemasCriteria createSon_deCriteria() {
		return new TemasCriteria(createCriteria("son_de"));
	}
	
	public MensajeCriteria createTieneCriteria() {
		return new MensajeCriteria(createCriteria("ORM_tiene"));
	}
	
	public UsuarioCriteria createPertenece_aCriteria() {
		return new UsuarioCriteria(createCriteria("pertenece_a"));
	}
	
	public MediaCriteria createContieneCriteria() {
		return new MediaCriteria(createCriteria("ORM_contiene"));
	}
	
	public Mensaje uniqueMensaje() {
		return (Mensaje) super.uniqueResult();
	}
	
	public Mensaje[] listMensaje() {
		java.util.List list = super.list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}

