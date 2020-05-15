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
@DiscriminatorValue("Moderador")
public class Moderador extends com.mds.database.Usuario implements Serializable {
	public Moderador() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_MODERADOR_ELIMINAMOD) {
			return ORM_eliminaMod;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToMany(mappedBy="eliminado_por", targetEntity=com.mds.database.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_eliminaMod = new java.util.HashSet();
	
	private void setORM_EliminaMod(java.util.Set value) {
		this.ORM_eliminaMod = value;
	}
	
	private java.util.Set getORM_EliminaMod() {
		return ORM_eliminaMod;
	}
	
	@Transient	
	public final com.mds.database.MensajeSetCollection eliminaMod = new com.mds.database.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_MODERADOR_ELIMINAMOD, ORMConstants.KEY_MENSAJE_ELIMINADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
