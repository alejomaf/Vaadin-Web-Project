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

public class AdministradorDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public AdministradorDetachedCriteria() {
		super(com.mds.database.Administrador.class, com.mds.database.AdministradorCriteria.class);
		id_usuario = new IntegerExpression("id_usuario", this.getDetachedCriteria());
		amigo_de = new CollectionExpression("ORM_amigo_de", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		contraseña = new StringExpression("contraseña", this.getDetachedCriteria());
		nombre_usuario = new StringExpression("nombre_usuario", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		moderador = new BooleanExpression("moderador", this.getDetachedCriteria());
		reportado = new BooleanExpression("reportado", this.getDetachedCriteria());
		creaT = new CollectionExpression("ORM_creaT", this.getDetachedCriteria());
		escribe = new CollectionExpression("ORM_escribe", this.getDetachedCriteria());
		reporta_a = new CollectionExpression("ORM_reporta_a", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this.getDetachedCriteria());
		eliminado_porId = new IntegerExpression("eliminado_por.id_usuario", this.getDetachedCriteria());
		eliminado_por = new AssociationExpression("eliminado_por", this.getDetachedCriteria());
		gustaM = new CollectionExpression("ORM_gustaM", this.getDetachedCriteria());
		es_reportado_por = new CollectionExpression("ORM_es_reportado_por", this.getDetachedCriteria());
		gustaT = new CollectionExpression("ORM_gustaT", this.getDetachedCriteria());
		eliminaMod = new CollectionExpression("ORM_eliminaMod", this.getDetachedCriteria());
		creaS = new CollectionExpression("ORM_creaS", this.getDetachedCriteria());
		elimina = new CollectionExpression("ORM_elimina", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.AdministradorCriteria.class);
		id_usuario = new IntegerExpression("id_usuario", this.getDetachedCriteria());
		amigo_de = new CollectionExpression("ORM_amigo_de", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		contraseña = new StringExpression("contraseña", this.getDetachedCriteria());
		nombre_usuario = new StringExpression("nombre_usuario", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		moderador = new BooleanExpression("moderador", this.getDetachedCriteria());
		reportado = new BooleanExpression("reportado", this.getDetachedCriteria());
		creaT = new CollectionExpression("ORM_creaT", this.getDetachedCriteria());
		escribe = new CollectionExpression("ORM_escribe", this.getDetachedCriteria());
		reporta_a = new CollectionExpression("ORM_reporta_a", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this.getDetachedCriteria());
		eliminado_porId = new IntegerExpression("eliminado_por.id_usuario", this.getDetachedCriteria());
		eliminado_por = new AssociationExpression("eliminado_por", this.getDetachedCriteria());
		gustaM = new CollectionExpression("ORM_gustaM", this.getDetachedCriteria());
		es_reportado_por = new CollectionExpression("ORM_es_reportado_por", this.getDetachedCriteria());
		gustaT = new CollectionExpression("ORM_gustaT", this.getDetachedCriteria());
		eliminaMod = new CollectionExpression("ORM_eliminaMod", this.getDetachedCriteria());
		creaS = new CollectionExpression("ORM_creaS", this.getDetachedCriteria());
		elimina = new CollectionExpression("ORM_elimina", this.getDetachedCriteria());
	}
	
	public SeccionesDetachedCriteria createCreaSCriteria() {
		return new SeccionesDetachedCriteria(createCriteria("ORM_creaS"));
	}
	
	public UsuarioDetachedCriteria createEliminaCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_elimina"));
	}
	
	public MensajeDetachedCriteria createEliminaModCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_eliminaMod"));
	}
	
	public UsuarioDetachedCriteria createAmigo_deCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_amigo_de"));
	}
	
	public TemasDetachedCriteria createCreaTCriteria() {
		return new TemasDetachedCriteria(createCriteria("ORM_creaT"));
	}
	
	public MensajeDetachedCriteria createEscribeCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_escribe"));
	}
	
	public UsuarioDetachedCriteria createReporta_aCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_reporta_a"));
	}
	
	public NotificacionesDetachedCriteria createTieneCriteria() {
		return new NotificacionesDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public UsuarioDetachedCriteria createEs_amigo_deCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_es_amigo_de"));
	}
	
	public AdministradorDetachedCriteria createEliminado_porCriteria() {
		return new AdministradorDetachedCriteria(createCriteria("eliminado_por"));
	}
	
	public MensajeDetachedCriteria createGustaMCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_gustaM"));
	}
	
	public UsuarioDetachedCriteria createEs_reportado_porCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_es_reportado_por"));
	}
	
	public TemasDetachedCriteria createGustaTCriteria() {
		return new TemasDetachedCriteria(createCriteria("ORM_gustaT"));
	}
	
	public Administrador uniqueAdministrador(PersistentSession session) {
		return (Administrador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Administrador[] listAdministrador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

