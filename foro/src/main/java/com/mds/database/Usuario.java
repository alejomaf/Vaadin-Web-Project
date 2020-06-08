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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Usuario")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Usuario")
public class Usuario implements Serializable {
	public Usuario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USUARIO_CREAT) {
			return ORM_creaT;
		}
		else if (key == ORMConstants.KEY_USUARIO_ESCRIBE) {
			return ORM_escribe;
		}
		else if (key == ORMConstants.KEY_USUARIO_AMIGO_DE) {
			return ORM_amigo_de;
		}
		else if (key == ORMConstants.KEY_USUARIO_TIENE) {
			return ORM_tiene;
		}
		else if (key == ORMConstants.KEY_USUARIO_ES_AMIGO_DE) {
			return ORM_es_amigo_de;
		}
		else if (key == ORMConstants.KEY_USUARIO_GUSTAM) {
			return ORM_gustaM;
		}
		else if (key == ORMConstants.KEY_USUARIO_GUSTAT) {
			return ORM_gustaT;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Id_usuario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_DATABASE_USUARIO_ID_USUARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_DATABASE_USUARIO_ID_USUARIO_GENERATOR", strategy="native")	
	private int id_usuario;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Contrasena", nullable=true, length=255)	
	private String contrasena;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="Moderador", nullable=false, length=1)	
	private boolean moderador;
	
	@Column(name="Reportado", nullable=false, length=1)	
	private boolean reportado;
	
	@Column(name="Foto", nullable=true, length=255)	
	private String foto;
	
	@Column(name="Nombre_completo", nullable=true, length=255)	
	private String nombre_completo;
	
	@Column(name="Eliminado", nullable=false, length=1)	
	private boolean eliminado;
	
	@OneToMany(mappedBy="creado_por", targetEntity=com.mds.database.Temas.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_creaT = new java.util.HashSet();
	
	@OneToMany(mappedBy="pertenece_a", targetEntity=com.mds.database.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_escribe = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Usuario", joinColumns={ @JoinColumn(name="UsuarioId_usuario2") }, inverseJoinColumns={ @JoinColumn(name="UsuarioId_usuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_amigo_de = new java.util.HashSet();
	
	@OneToMany(mappedBy="de", targetEntity=com.mds.database.Notificaciones.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tiene = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_amigo_de", targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_amigo_de = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_es_gustado", targetEntity=com.mds.database.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_gustaM = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_leGustaTema", targetEntity=com.mds.database.Temas.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_gustaT = new java.util.HashSet();
	
	private void setId_usuario(int value) {
		this.id_usuario = value;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public int getORMID() {
		return getId_usuario();
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setContrasena(String value) {
		this.contrasena = value;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setModerador(boolean value) {
		this.moderador = value;
	}
	
	public boolean getModerador() {
		return moderador;
	}
	
	public void setReportado(boolean value) {
		this.reportado = value;
	}
	
	public boolean getReportado() {
		return reportado;
	}
	
	public void setFoto(String value) {
		this.foto = value;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setNombre_completo(String value) {
		this.nombre_completo = value;
	}
	
	public String getNombre_completo() {
		return nombre_completo;
	}
	
	public void setEliminado(boolean value) {
		this.eliminado = value;
	}
	
	public boolean getEliminado() {
		return eliminado;
	}
	
	private void setORM_CreaT(java.util.Set value) {
		this.ORM_creaT = value;
	}
	
	private java.util.Set getORM_CreaT() {
		return ORM_creaT;
	}
	
	@Transient	
	public final com.mds.database.TemasSetCollection creaT = new com.mds.database.TemasSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_CREAT, ORMConstants.KEY_TEMAS_CREADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Escribe(java.util.Set value) {
		this.ORM_escribe = value;
	}
	
	private java.util.Set getORM_Escribe() {
		return ORM_escribe;
	}
	
	@Transient	
	public final com.mds.database.MensajeSetCollection escribe = new com.mds.database.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ESCRIBE, ORMConstants.KEY_MENSAJE_PERTENECE_A, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Amigo_de(java.util.Set value) {
		this.ORM_amigo_de = value;
	}
	
	private java.util.Set getORM_Amigo_de() {
		return ORM_amigo_de;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection amigo_de = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_AMIGO_DE, ORMConstants.KEY_USUARIO_ES_AMIGO_DE, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Tiene(java.util.Set value) {
		this.ORM_tiene = value;
	}
	
	private java.util.Set getORM_Tiene() {
		return ORM_tiene;
	}
	
	@Transient	
	public final com.mds.database.NotificacionesSetCollection tiene = new com.mds.database.NotificacionesSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_TIENE, ORMConstants.KEY_NOTIFICACIONES_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Es_amigo_de(java.util.Set value) {
		this.ORM_es_amigo_de = value;
	}
	
	private java.util.Set getORM_Es_amigo_de() {
		return ORM_es_amigo_de;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection es_amigo_de = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ES_AMIGO_DE, ORMConstants.KEY_USUARIO_AMIGO_DE, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_GustaM(java.util.Set value) {
		this.ORM_gustaM = value;
	}
	
	private java.util.Set getORM_GustaM() {
		return ORM_gustaM;
	}
	
	@Transient	
	public final com.mds.database.MensajeSetCollection gustaM = new com.mds.database.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_GUSTAM, ORMConstants.KEY_MENSAJE_ES_GUSTADO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_GustaT(java.util.Set value) {
		this.ORM_gustaT = value;
	}
	
	private java.util.Set getORM_GustaT() {
		return ORM_gustaT;
	}
	
	@Transient	
	public final com.mds.database.TemasSetCollection gustaT = new com.mds.database.TemasSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_GUSTAT, ORMConstants.KEY_TEMAS_LEGUSTATEMA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_usuario());
	}
	
}
