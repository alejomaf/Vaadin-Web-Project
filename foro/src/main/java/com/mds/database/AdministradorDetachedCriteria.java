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
		foto = new StringExpression("foto", this.getDetachedCriteria());
		nombre_completo = new StringExpression("nombre_completo", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		creaT = new CollectionExpression("ORM_creaT", this.getDetachedCriteria());
		escribe = new CollectionExpression("ORM_escribe", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this.getDetachedCriteria());
		gustaM = new CollectionExpression("ORM_gustaM", this.getDetachedCriteria());
		gustaT = new CollectionExpression("ORM_gustaT", this.getDetachedCriteria());
		eliminaMod = new CollectionExpression("ORM_eliminaMod", this.getDetachedCriteria());
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
		foto = new StringExpression("foto", this.getDetachedCriteria());
		nombre_completo = new StringExpression("nombre_completo", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		creaT = new CollectionExpression("ORM_creaT", this.getDetachedCriteria());
		escribe = new CollectionExpression("ORM_escribe", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		es_amigo_de = new CollectionExpression("ORM_es_amigo_de", this.getDetachedCriteria());
		gustaM = new CollectionExpression("ORM_gustaM", this.getDetachedCriteria());
		gustaT = new CollectionExpression("ORM_gustaT", this.getDetachedCriteria());
		eliminaMod = new CollectionExpression("ORM_eliminaMod", this.getDetachedCriteria());
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
	
	public NotificacionesDetachedCriteria createTieneCriteria() {
		return new NotificacionesDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public UsuarioDetachedCriteria createEs_amigo_deCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_es_amigo_de"));
	}
	
	public MensajeDetachedCriteria createGustaMCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_gustaM"));
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

