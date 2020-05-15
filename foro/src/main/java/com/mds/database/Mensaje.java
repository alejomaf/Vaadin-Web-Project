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
@Table(name="Mensaje")
public class Mensaje implements Serializable {
	public Mensaje() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_MENSAJE_TIENE) {
			return ORM_tiene;
		}
		else if (key == ORMConstants.KEY_MENSAJE_ES_GUSTADO) {
			return ORM_es_gustado;
		}
		else if (key == ORMConstants.KEY_MENSAJE_CONTIENE) {
			return ORM_contiene;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_MENSAJE_SON_DE) {
			this.son_de = (com.mds.database.Temas) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_ELIMINADO_POR) {
			this.eliminado_por = (com.mds.database.Moderador) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_PERTENECE_A) {
			this.pertenece_a = (com.mds.database.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_RESPUESTA_DE) {
			this.respuesta_de = (com.mds.database.Mensaje) owner;
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
	
	@Column(name="Id_mensaje", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_FORO_MENSAJE_ID_MENSAJE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_FORO_MENSAJE_ID_MENSAJE_GENERATOR", strategy="native")	
	private int id_mensaje;
	
	@ManyToOne(targetEntity=com.mds.database.Moderador.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioId_usuario2", referencedColumnName="Id_usuario", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje429317"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Moderador eliminado_por;
	
	@ManyToOne(targetEntity=com.mds.database.Mensaje.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="MensajeId_mensaje", referencedColumnName="Id_mensaje", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje78768"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Mensaje respuesta_de;
	
	@ManyToMany(targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Mensaje", joinColumns={ @JoinColumn(name="MensajeId_mensaje") }, inverseJoinColumns={ @JoinColumn(name="UsuarioId_usuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_gustado = new java.util.HashSet();
	
	@ManyToOne(targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TemasId_tema", referencedColumnName="Id_tema", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje369612"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas son_de;
	
	@Column(name="Num_likes", nullable=false, length=10)	
	private int num_likes;
	
	@Column(name="Contenido", nullable=true, length=255)	
	private String contenido;
	
	@Column(name="Privado", nullable=false, length=1)	
	private boolean privado;
	
	@OneToMany(mappedBy="respuesta_de", targetEntity=com.mds.database.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tiene = new java.util.HashSet();
	
	@ManyToOne(targetEntity=com.mds.database.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioId_usuario", referencedColumnName="Id_usuario", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje97513"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Usuario pertenece_a;
	
	@OneToMany(mappedBy="es_de", targetEntity=com.mds.database.Media.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_contiene = new java.util.HashSet();
	
	private void setId_mensaje(int value) {
		this.id_mensaje = value;
	}
	
	public int getId_mensaje() {
		return id_mensaje;
	}
	
	public int getORMID() {
		return getId_mensaje();
	}
	
	public void setNum_likes(int value) {
		this.num_likes = value;
	}
	
	public int getNum_likes() {
		return num_likes;
	}
	
	public void setContenido(String value) {
		this.contenido = value;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setPrivado(boolean value) {
		this.privado = value;
	}
	
	public boolean getPrivado() {
		return privado;
	}
	
	public void setSon_de(com.mds.database.Temas value) {
		if (son_de != null) {
			son_de.tiene.remove(this);
		}
		if (value != null) {
			value.tiene.add(this);
		}
	}
	
	public com.mds.database.Temas getSon_de() {
		return son_de;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Son_de(com.mds.database.Temas value) {
		this.son_de = value;
	}
	
	private com.mds.database.Temas getORM_Son_de() {
		return son_de;
	}
	
	private void setORM_Tiene(java.util.Set value) {
		this.ORM_tiene = value;
	}
	
	private java.util.Set getORM_Tiene() {
		return ORM_tiene;
	}
	
	@Transient	
	public final com.mds.database.MensajeSetCollection tiene = new com.mds.database.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_MENSAJE_TIENE, ORMConstants.KEY_MENSAJE_RESPUESTA_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setEliminado_por(com.mds.database.Moderador value) {
		if (eliminado_por != null) {
			eliminado_por.eliminaMod.remove(this);
		}
		if (value != null) {
			value.eliminaMod.add(this);
		}
	}
	
	public com.mds.database.Moderador getEliminado_por() {
		return eliminado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Eliminado_por(com.mds.database.Moderador value) {
		this.eliminado_por = value;
	}
	
	private com.mds.database.Moderador getORM_Eliminado_por() {
		return eliminado_por;
	}
	
	private void setORM_Es_gustado(java.util.Set value) {
		this.ORM_es_gustado = value;
	}
	
	private java.util.Set getORM_Es_gustado() {
		return ORM_es_gustado;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection es_gustado = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_MENSAJE_ES_GUSTADO, ORMConstants.KEY_USUARIO_GUSTAM, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setPertenece_a(com.mds.database.Usuario value) {
		if (pertenece_a != null) {
			pertenece_a.escribe.remove(this);
		}
		if (value != null) {
			value.escribe.add(this);
		}
	}
	
	public com.mds.database.Usuario getPertenece_a() {
		return pertenece_a;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece_a(com.mds.database.Usuario value) {
		this.pertenece_a = value;
	}
	
	private com.mds.database.Usuario getORM_Pertenece_a() {
		return pertenece_a;
	}
	
	private void setORM_Contiene(java.util.Set value) {
		this.ORM_contiene = value;
	}
	
	private java.util.Set getORM_Contiene() {
		return ORM_contiene;
	}
	
	@Transient	
	public final com.mds.database.MediaSetCollection contiene = new com.mds.database.MediaSetCollection(this, _ormAdapter, ORMConstants.KEY_MENSAJE_CONTIENE, ORMConstants.KEY_MEDIA_ES_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setRespuesta_de(com.mds.database.Mensaje value) {
		if (respuesta_de != null) {
			respuesta_de.tiene.remove(this);
		}
		if (value != null) {
			value.tiene.add(this);
		}
	}
	
	public com.mds.database.Mensaje getRespuesta_de() {
		return respuesta_de;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Respuesta_de(com.mds.database.Mensaje value) {
		this.respuesta_de = value;
	}
	
	private com.mds.database.Mensaje getORM_Respuesta_de() {
		return respuesta_de;
	}
	
	public String toString() {
		return String.valueOf(getId_mensaje());
	}
	
}
