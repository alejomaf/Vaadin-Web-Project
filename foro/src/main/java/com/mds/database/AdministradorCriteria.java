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

public class AdministradorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_usuario;
	public final CollectionExpression amigo_de;
	public final StringExpression email;
	public final StringExpression contraseña;
	public final StringExpression nombre_usuario;
	public final StringExpression descripcion;
	public final BooleanExpression moderador;
	public final BooleanExpression reportado;
	public final CollectionExpression creaT;
	public final CollectionExpression escribe;
	public final CollectionExpression reporta_a;
	public final CollectionExpression tiene;
	public final CollectionExpression es_amigo_de;
	public final IntegerExpression eliminado_porId;
	public final AssociationExpression eliminado_por;
	public final CollectionExpression gustaM;
	public final CollectionExpression es_reportado_por;
	public final CollectionExpression gustaT;
	public final CollectionExpression eliminaMod;
	public final CollectionExpression creaS;
	public final CollectionExpression elimina;
	
	public AdministradorCriteria(Criteria criteria) {
		super(criteria);
		id_usuario = new IntegerExpression("id_usuario", this);
		amigo_de = new CollectionExpression("ORM_amigo_de", this);
		email = new StringExpression("email", this);
		contraseña = new StringExpression("contraseña", this);
		nombre_usuario = new StringExpression("nombre_usuario", this);
		descripcion = new StringExpression("descripcion", this);
		moderador = new BooleanExpression("moderador", this);
		reportado = new BooleanExpression("reportado", this);
		creaT = new CollectionExpression("ORM_creaT", this);
		escribe = new CollectionExpression("ORM_escribe", this);
		reporta_a = new CollectionExpression("ORM_reporta_a", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this);
		eliminado_porId = new IntegerExpression("eliminado_por.id_usuario", this);
		eliminado_por = new AssociationExpression("eliminado_por", this);
		gustaM = new CollectionExpression("ORM_gustaM", this);
		es_reportado_por = new CollectionExpression("ORM_es_reportado_por", this);
		gustaT = new CollectionExpression("ORM_gustaT", this);
		eliminaMod = new CollectionExpression("ORM_eliminaMod", this);
		creaS = new CollectionExpression("ORM_creaS", this);
		elimina = new CollectionExpression("ORM_elimina", this);
	}
	
	public AdministradorCriteria(PersistentSession session) {
		this(session.createCriteria(Administrador.class));
	}
	
	public AdministradorCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public SeccionesCriteria createCreaSCriteria() {
		return new SeccionesCriteria(createCriteria("ORM_creaS"));
	}
	
	public UsuarioCriteria createEliminaCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_elimina"));
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
	
	public UsuarioCriteria createReporta_aCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_reporta_a"));
	}
	
	public NotificacionesCriteria createTieneCriteria() {
		return new NotificacionesCriteria(createCriteria("ORM_tiene"));
	}
	
	public UsuarioCriteria createEs_amigo_deCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_es_amigo_de"));
	}
	
	public AdministradorCriteria createEliminado_porCriteria() {
		return new AdministradorCriteria(createCriteria("eliminado_por"));
	}
	
	public MensajeCriteria createGustaMCriteria() {
		return new MensajeCriteria(createCriteria("ORM_gustaM"));
	}
	
	public UsuarioCriteria createEs_reportado_porCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_es_reportado_por"));
	}
	
	public TemasCriteria createGustaTCriteria() {
		return new TemasCriteria(createCriteria("ORM_gustaT"));
	}
	
	public Administrador uniqueAdministrador() {
		return (Administrador) super.uniqueResult();
	}
	
	public Administrador[] listAdministrador() {
		java.util.List list = super.list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

