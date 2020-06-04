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

public class TemasCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_tema;
	public final CollectionExpression es_gustado;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final StringExpression nombre;
	public final IntegerExpression num__likes;
	public final BooleanExpression publico;
	public final IntegerExpression creado_porId;
	public final AssociationExpression creado_por;
	public final CollectionExpression tiene;
	
	public TemasCriteria(Criteria criteria) {
		super(criteria);
		id_tema = new IntegerExpression("id_tema", this);
		es_gustado = new CollectionExpression("ORM_es_gustado", this);
		pertenece_aId = new IntegerExpression("pertenece_a.id_secciones", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		nombre = new StringExpression("nombre", this);
		num__likes = new IntegerExpression("num__likes", this);
		publico = new BooleanExpression("publico", this);
		creado_porId = new IntegerExpression("creado_por.id_usuario", this);
		creado_por = new AssociationExpression("creado_por", this);
		tiene = new CollectionExpression("ORM_tiene", this);
	}
	
	public TemasCriteria(PersistentSession session) {
		this(session.createCriteria(Temas.class));
	}
	
	public TemasCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createEs_gustadoCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_es_gustado"));
	}
	
	public SeccionesCriteria createPertenece_aCriteria() {
		return new SeccionesCriteria(createCriteria("pertenece_a"));
	}
	
	public UsuarioCriteria createCreado_porCriteria() {
		return new UsuarioCriteria(createCriteria("creado_por"));
	}
	
	public MensajeCriteria createTieneCriteria() {
		return new MensajeCriteria(createCriteria("ORM_tiene"));
	}
	
	public Temas uniqueTemas() {
		return (Temas) super.uniqueResult();
	}
	
	public Temas[] listTemas() {
		java.util.List list = super.list();
		return (Temas[]) list.toArray(new Temas[list.size()]);
	}
}

