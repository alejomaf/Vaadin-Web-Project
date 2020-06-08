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

public class UsuarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_usuario;
	public final StringExpression email;
	public final StringExpression contrasena;
	public final StringExpression descripcion;
	public final BooleanExpression moderador;
	public final BooleanExpression reportado;
	public final StringExpression foto;
	public final StringExpression nombre_completo;
	public final BooleanExpression eliminado;
	public final CollectionExpression creaT;
	public final CollectionExpression escribe;
	public final CollectionExpression amigo_de;
	public final CollectionExpression tiene;
	public final CollectionExpression es_amigo_de;
	public final CollectionExpression gustaM;
	public final CollectionExpression gustaT;
	
	public UsuarioCriteria(Criteria criteria) {
		super(criteria);
		id_usuario = new IntegerExpression("id_usuario", this);
		email = new StringExpression("email", this);
		contrasena = new StringExpression("contrasena", this);
		descripcion = new StringExpression("descripcion", this);
		moderador = new BooleanExpression("moderador", this);
		reportado = new BooleanExpression("reportado", this);
		foto = new StringExpression("foto", this);
		nombre_completo = new StringExpression("nombre_completo", this);
		eliminado = new BooleanExpression("eliminado", this);
		creaT = new CollectionExpression("ORM_creaT", this);
		escribe = new CollectionExpression("ORM_escribe", this);
		amigo_de = new CollectionExpression("ORM_amigo_de", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this);
		gustaM = new CollectionExpression("ORM_gustaM", this);
		gustaT = new CollectionExpression("ORM_gustaT", this);
	}
	
	public UsuarioCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario.class));
	}
	
	public UsuarioCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public TemasCriteria createCreaTCriteria() {
		return new TemasCriteria(createCriteria("ORM_creaT"));
	}
	
	public MensajeCriteria createEscribeCriteria() {
		return new MensajeCriteria(createCriteria("ORM_escribe"));
	}
	
	public UsuarioCriteria createAmigo_deCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_amigo_de"));
	}
	
	public NotificacionesCriteria createTieneCriteria() {
		return new NotificacionesCriteria(createCriteria("ORM_tiene"));
	}
	
	public UsuarioCriteria createEs_amigo_deCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_es_amigo_de"));
	}
	
	public MensajeCriteria createGustaMCriteria() {
		return new MensajeCriteria(createCriteria("ORM_gustaM"));
	}
	
	public TemasCriteria createGustaTCriteria() {
		return new TemasCriteria(createCriteria("ORM_gustaT"));
	}
	
	public Usuario uniqueUsuario() {
		return (Usuario) super.uniqueResult();
	}
	
	public Usuario[] listUsuario() {
		java.util.List list = super.list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}

