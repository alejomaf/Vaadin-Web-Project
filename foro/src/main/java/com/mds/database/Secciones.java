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
@Table(name="Secciones")
public class Secciones implements Serializable {
	public Secciones() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_SECCIONES_TIENE) {
			return ORM_tiene;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Id_secciones", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_DATABASE_SECCIONES_ID_SECCIONES_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_DATABASE_SECCIONES_ID_SECCIONES_GENERATOR", strategy="native")	
	private int id_secciones;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="FechaSeccion", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaSeccion;
	
	@OneToMany(mappedBy="pertenece_a", targetEntity=com.mds.database.Temas.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tiene = new java.util.HashSet();
	
	private void setId_secciones(int value) {
		this.id_secciones = value;
	}
	
	public int getId_secciones() {
		return id_secciones;
	}
	
	public int getORMID() {
		return getId_secciones();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setFechaSeccion(java.util.Date value) {
		this.fechaSeccion = value;
	}
	
	public java.util.Date getFechaSeccion() {
		return fechaSeccion;
	}
	
	private void setORM_Tiene(java.util.Set value) {
		this.ORM_tiene = value;
	}
	
	private java.util.Set getORM_Tiene() {
		return ORM_tiene;
	}
	
	@Transient	
	public final com.mds.database.TemasSetCollection tiene = new com.mds.database.TemasSetCollection(this, _ormAdapter, ORMConstants.KEY_SECCIONES_TIENE, ORMConstants.KEY_TEMAS_PERTENECE_A, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_secciones());
	}
	
}
