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
@Table(name="Media")
@Inheritance(strategy=InheritanceType.JOINED)
public class Media implements Serializable {
	public Media() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_MEDIA_ES_DE) {
			this.es_de = (com.mds.database.Mensaje) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Id_media", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_DATABASE_MEDIA_ID_MEDIA_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_DATABASE_MEDIA_ID_MEDIA_GENERATOR", strategy="native")	
	private int id_media;
	
	@ManyToOne(targetEntity=com.mds.database.Mensaje.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="MensajeId_mensaje", referencedColumnName="Id_mensaje", nullable=false) }, foreignKey=@ForeignKey(name="FKMedia851088"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Mensaje es_de;
	
	private void setId_media(int value) {
		this.id_media = value;
	}
	
	public int getId_media() {
		return id_media;
	}
	
	public int getORMID() {
		return getId_media();
	}
	
	public void setEs_de(com.mds.database.Mensaje value) {
		if (es_de != null) {
			es_de.contiene.remove(this);
		}
		if (value != null) {
			value.contiene.add(this);
		}
	}
	
	public com.mds.database.Mensaje getEs_de() {
		return es_de;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_de(com.mds.database.Mensaje value) {
		this.es_de = value;
	}
	
	private com.mds.database.Mensaje getORM_Es_de() {
		return es_de;
	}
	
	public String toString() {
		return String.valueOf(getId_media());
	}
	
}
