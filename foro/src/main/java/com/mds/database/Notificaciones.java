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
import java.sql.Date;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Notificaciones")
public class Notificaciones implements Serializable {
	public Notificaciones() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_NOTIFICACIONES_DE) {
			this.de = (com.mds.database.Usuario) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Id_notificaciones", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_DATABASE_NOTIFICACIONES_ID_NOTIFICACIONES_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_DATABASE_NOTIFICACIONES_ID_NOTIFICACIONES_GENERATOR", strategy="native")	
	private int id_notificaciones;
	
	@ManyToOne(targetEntity=com.mds.database.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioId_usuario", referencedColumnName="Id_usuario", nullable=false) }, foreignKey=@ForeignKey(name="FKNotificaci489941"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Usuario de;
	
	@Column(name="Fecha", nullable=true)	
	private Date fecha;
	
	@Column(name="Enlace", nullable=true, length=255)	
	private String enlace;
	
	@Column(name="Titulo", nullable=true, length=255)	
	private String titulo;
	
	private void setId_notificaciones(int value) {
		this.id_notificaciones = value;
	}
	
	public int getId_notificaciones() {
		return id_notificaciones;
	}
	
	public int getORMID() {
		return getId_notificaciones();
	}
	
	public void setFecha(Date value) {
		this.fecha = value;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setEnlace(String value) {
		this.enlace = value;
	}
	
	public String getEnlace() {
		return enlace;
	}
	
	public void setTitulo(String value) {
		this.titulo = value;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setDe(com.mds.database.Usuario value) {
		if (de != null) {
			de.tiene.remove(this);
		}
		if (value != null) {
			value.tiene.add(this);
		}
	}
	
	public com.mds.database.Usuario getDe() {
		return de;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_De(com.mds.database.Usuario value) {
		this.de = value;
	}
	
	private com.mds.database.Usuario getORM_De() {
		return de;
	}
	
	public String toString() {
		return String.valueOf(getId_notificaciones());
	}
	
}
