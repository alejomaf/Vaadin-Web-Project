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

public class ModeradorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_usuario;
	public final CollectionExpression amigo_de;
	public final StringExpression email;
	public final StringExpression contraseña;
	public final StringExpression nombre_usuario;
	public final StringExpression descripcion;
	public final BooleanExpression moderador;
	public final BooleanExpression reportado;
	public final StringExpression foto;
	public final StringExpression nombre_completo;
	public final BooleanExpression eliminado;
	public final CollectionExpression creaT;
	public final CollectionExpression escribe;
	public final CollectionExpression tiene;
	public final CollectionExpression es_amigo_de;
	public final CollectionExpression gustaM;
	public final CollectionExpression gustaT;
	public final CollectionExpression eliminaMod;
	
	public ModeradorCriteria(Criteria criteria) {
		super(criteria);
		id_usuario = new IntegerExpression("id_usuario", this);
		amigo_de = new CollectionExpression("ORM_amigo_de", this);
		email = new StringExpression("email", this);
		contraseña = new StringExpression("contraseña", this);
		nombre_usuario = new StringExpression("nombre_usuario", this);
		descripcion = new StringExpression("descripcion", this);
		moderador = new BooleanExpression("moderador", this);
		reportado = new BooleanExpression("reportado", this);
		foto = new StringExpression("foto", this);
		nombre_completo = new StringExpression("nombre_completo", this);
		eliminado = new BooleanExpression("eliminado", this);
		creaT = new CollectionExpression("ORM_creaT", this);
		escribe = new CollectionExpression("ORM_escribe", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this);
		gustaM = new CollectionExpression("ORM_gustaM", this);
		gustaT = new CollectionExpression("ORM_gustaT", this);
		eliminaMod = new CollectionExpression("ORM_eliminaMod", this);
	}
	
	public ModeradorCriteria(PersistentSession session) {
		this(session.createCriteria(Moderador.class));
	}
	
	public ModeradorCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public MensajeCriteria createEliminaModCriteria() {
		return new MensajeCriteria(createCriteria("ORM_eliminaMod"));
	}
	
	public UsuarioCriteria createAmigo_deCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_amigo_de"));
	}
	
	public TemasCriteria createCreaTCriteria() {
		return new TemasCriteria(createCriteria("ORM_creaT"));
	}
	
	public MensajeCriteria createEscribeCriteria() {
		return new MensajeCriteria(createCriteria("ORM_escribe"));
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
	
	public Moderador uniqueModerador() {
		return (Moderador) super.uniqueResult();
	}
	
	public Moderador[] listModerador() {
		java.util.List list = super.list();
		return (Moderador[]) list.toArray(new Moderador[list.size()]);
	}
}

