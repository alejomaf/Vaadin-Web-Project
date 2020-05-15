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
		else if (key == ORMConstants.KEY_USUARIO_REPORTA_A) {
			return ORM_reporta_a;
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
		else if (key == ORMConstants.KEY_USUARIO_ES_REPORTADO_POR) {
			return ORM_es_reportado_por;
		}
		else if (key == ORMConstants.KEY_USUARIO_GUSTAT) {
			return ORM_gustaT;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USUARIO_ELIMINADO_POR) {
			this.eliminado_por = (com.mds.database.Administrador) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Id_usuario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_FORO_USUARIO_ID_USUARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_FORO_USUARIO_ID_USUARIO_GENERATOR", strategy="native")	
	private int id_usuario;
	
	@ManyToMany(targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Usuario2", joinColumns={ @JoinColumn(name="UsuarioId_usuario2") }, inverseJoinColumns={ @JoinColumn(name="UsuarioId_usuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_amigo_de = new java.util.HashSet();
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Contraseña", nullable=true, length=255)	
	private String contraseña;
	
	@Column(name="Nombre_usuario", nullable=true, length=255)	
	private String nombre_usuario;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="Moderador", nullable=false, length=1)	
	private boolean moderador;
	
	@Column(name="Reportado", nullable=false, length=1)	
	private boolean reportado;
	
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
	private java.util.Set ORM_reporta_a = new java.util.HashSet();
	
	@OneToMany(mappedBy="de", targetEntity=com.mds.database.Notificaciones.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tiene = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_amigo_de", targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_amigo_de = new java.util.HashSet();
	
	@ManyToOne(targetEntity=com.mds.database.Administrador.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioId_usuario", referencedColumnName="Id_usuario", nullable=false) }, foreignKey=@ForeignKey(name="FKUsuario250901"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Administrador eliminado_por;
	
	@ManyToMany(mappedBy="ORM_es_gustado", targetEntity=com.mds.database.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_gustaM = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_reporta_a", targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_reportado_por = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_es_gustado", targetEntity=com.mds.database.Temas.class)	
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
	
	public void setContraseña(String value) {
		this.contraseña = value;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setNombre_usuario(String value) {
		this.nombre_usuario = value;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
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
	
	private void setORM_Reporta_a(java.util.Set value) {
		this.ORM_reporta_a = value;
	}
	
	private java.util.Set getORM_Reporta_a() {
		return ORM_reporta_a;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection reporta_a = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REPORTA_A, ORMConstants.KEY_USUARIO_ES_REPORTADO_POR, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
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
	
	public void setEliminado_por(com.mds.database.Administrador value) {
		if (eliminado_por != null) {
			eliminado_por.elimina.remove(this);
		}
		if (value != null) {
			value.elimina.add(this);
		}
	}
	
	public com.mds.database.Administrador getEliminado_por() {
		return eliminado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Eliminado_por(com.mds.database.Administrador value) {
		this.eliminado_por = value;
	}
	
	private com.mds.database.Administrador getORM_Eliminado_por() {
		return eliminado_por;
	}
	
	private void setORM_GustaM(java.util.Set value) {
		this.ORM_gustaM = value;
	}
	
	private java.util.Set getORM_GustaM() {
		return ORM_gustaM;
	}
	
	@Transient	
	public final com.mds.database.MensajeSetCollection gustaM = new com.mds.database.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_GUSTAM, ORMConstants.KEY_MENSAJE_ES_GUSTADO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Es_reportado_por(java.util.Set value) {
		this.ORM_es_reportado_por = value;
	}
	
	private java.util.Set getORM_Es_reportado_por() {
		return ORM_es_reportado_por;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection es_reportado_por = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ES_REPORTADO_POR, ORMConstants.KEY_USUARIO_REPORTA_A, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_GustaT(java.util.Set value) {
		this.ORM_gustaT = value;
	}
	
	private java.util.Set getORM_GustaT() {
		return ORM_gustaT;
	}
	
	@Transient	
	public final com.mds.database.TemasSetCollection gustaT = new com.mds.database.TemasSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_GUSTAT, ORMConstants.KEY_TEMAS_ES_GUSTADO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_usuario());
	}
	
}
