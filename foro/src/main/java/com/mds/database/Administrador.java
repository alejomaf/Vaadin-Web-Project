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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Administrador")
public class Administrador extends com.mds.database.Moderador implements Serializable {
	public Administrador() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ADMINISTRADOR_CREAS) {
			return ORM_creaS;
		}
		else if (key == ORMConstants.KEY_ADMINISTRADOR_ELIMINA) {
			return ORM_elimina;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToMany(mappedBy="es_creada_por", targetEntity=com.mds.database.Secciones.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_creaS = new java.util.HashSet();
	
	@OneToMany(mappedBy="eliminado_por", targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_elimina = new java.util.HashSet();
	
	private void setORM_CreaS(java.util.Set value) {
		this.ORM_creaS = value;
	}
	
	private java.util.Set getORM_CreaS() {
		return ORM_creaS;
	}
	
	@Transient	
	public final com.mds.database.SeccionesSetCollection creaS = new com.mds.database.SeccionesSetCollection(this, _ormAdapter, ORMConstants.KEY_ADMINISTRADOR_CREAS, ORMConstants.KEY_SECCIONES_ES_CREADA_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Elimina(java.util.Set value) {
		this.ORM_elimina = value;
	}
	
	private java.util.Set getORM_Elimina() {
		return ORM_elimina;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection elimina = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_ADMINISTRADOR_ELIMINA, ORMConstants.KEY_USUARIO_ELIMINADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
