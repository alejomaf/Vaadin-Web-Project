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
@Table(name="Temas")
public class Temas implements Serializable {
	public Temas() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_TEMAS_ES_GUSTADO) {
			return ORM_es_gustado;
		}
		else if (key == ORMConstants.KEY_TEMAS_TIENE) {
			return ORM_tiene;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_TEMAS_PERTENECE_A) {
			this.pertenece_a = (com.mds.database.Secciones) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_ES) {
			this.es = (com.mds.database.Temas) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_SON) {
			this.son = (com.mds.database.Temas) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_TEMAS) {
			this.temas = (com.mds.database.Temas) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_CREADO_POR) {
			this.creado_por = (com.mds.database.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_PUBLICO) {
			this.publico = (com.mds.database.Temas) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_PRIVADOS) {
			this.privados = (com.mds.database.Temas) owner;
		}
		
		else if (key == ORMConstants.KEY_TEMAS_OCULTOS) {
			this.ocultos = (com.mds.database.Temas) owner;
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
	
	@Column(name="Id_tema", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_MDS_FORO_TEMAS_ID_TEMA_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_MDS_FORO_TEMAS_ID_TEMA_GENERATOR", strategy="native")	
	private int id_tema;
	
	@ManyToMany(targetEntity=com.mds.database.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Temas", joinColumns={ @JoinColumn(name="TemasId_tema") }, inverseJoinColumns={ @JoinColumn(name="UsuarioId_usuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_gustado = new java.util.HashSet();
	
	@OneToOne(targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TemasId_tema3", referencedColumnName="Id_tema", nullable=false) }, foreignKey=@ForeignKey(name="FKTemas486236"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas es;
	
	@OneToOne(targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TemasId_tema2", referencedColumnName="Id_tema", nullable=false) }, foreignKey=@ForeignKey(name="FKTemas486237"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas son;
	
	@ManyToOne(targetEntity=com.mds.database.Secciones.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="SeccionesId_secciones", referencedColumnName="Id_secciones", nullable=false) }, foreignKey=@ForeignKey(name="FKTemas577037"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Secciones pertenece_a;
	
	@OneToOne(targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TemasId_tema", referencedColumnName="Id_tema", nullable=false) }, foreignKey=@ForeignKey(name="FKTemas901226"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas temas;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="`Num_ likes`", nullable=false, length=10)	
	private int num__likes;
	
	@ManyToOne(targetEntity=com.mds.database.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioId_usuario", referencedColumnName="Id_usuario", nullable=false) }, foreignKey=@ForeignKey(name="FKTemas603238"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Usuario creado_por;
	
	@OneToMany(mappedBy="son_de", targetEntity=com.mds.database.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tiene = new java.util.HashSet();
	
	@OneToOne(mappedBy="es", targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas publico;
	
	@OneToOne(mappedBy="son", targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas privados;
	
	@OneToOne(mappedBy="temas", targetEntity=com.mds.database.Temas.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private com.mds.database.Temas ocultos;
	
	private void setId_tema(int value) {
		this.id_tema = value;
	}
	
	public int getId_tema() {
		return id_tema;
	}
	
	public int getORMID() {
		return getId_tema();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNum__likes(int value) {
		this.num__likes = value;
	}
	
	public int getNum__likes() {
		return num__likes;
	}
	
	public void setPertenece_a(com.mds.database.Secciones value) {
		if (pertenece_a != null) {
			pertenece_a.tiene.remove(this);
		}
		if (value != null) {
			value.tiene.add(this);
		}
	}
	
	public com.mds.database.Secciones getPertenece_a() {
		return pertenece_a;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece_a(com.mds.database.Secciones value) {
		this.pertenece_a = value;
	}
	
	private com.mds.database.Secciones getORM_Pertenece_a() {
		return pertenece_a;
	}
	
	private void setORM_Es_gustado(java.util.Set value) {
		this.ORM_es_gustado = value;
	}
	
	private java.util.Set getORM_Es_gustado() {
		return ORM_es_gustado;
	}
	
	@Transient	
	public final com.mds.database.UsuarioSetCollection es_gustado = new com.mds.database.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_TEMAS_ES_GUSTADO, ORMConstants.KEY_USUARIO_GUSTAT, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setEs(com.mds.database.Temas value) {
		if (this.es != value) {
			com.mds.database.Temas les = this.es;
			this.es = value;
			if (value != null) {
				es.setPublico(this);
			}
			if (les != null && les.getPublico() == this) {
				les.setPublico(null);
			}
		}
	}
	
	public com.mds.database.Temas getEs() {
		return es;
	}
	
	public void setSon(com.mds.database.Temas value) {
		if (this.son != value) {
			com.mds.database.Temas lson = this.son;
			this.son = value;
			if (value != null) {
				son.setPrivados(this);
			}
			if (lson != null && lson.getPrivados() == this) {
				lson.setPrivados(null);
			}
		}
	}
	
	public com.mds.database.Temas getSon() {
		return son;
	}
	
	public void setTemas(com.mds.database.Temas value) {
		if (this.temas != value) {
			com.mds.database.Temas ltemas = this.temas;
			this.temas = value;
			if (value != null) {
				temas.setOcultos(this);
			}
			if (ltemas != null && ltemas.getOcultos() == this) {
				ltemas.setOcultos(null);
			}
		}
	}
	
	public com.mds.database.Temas getTemas() {
		return temas;
	}
	
	public void setCreado_por(com.mds.database.Usuario value) {
		if (creado_por != null) {
			creado_por.creaT.remove(this);
		}
		if (value != null) {
			value.creaT.add(this);
		}
	}
	
	public com.mds.database.Usuario getCreado_por() {
		return creado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Creado_por(com.mds.database.Usuario value) {
		this.creado_por = value;
	}
	
	private com.mds.database.Usuario getORM_Creado_por() {
		return creado_por;
	}
	
	private void setORM_Tiene(java.util.Set value) {
		this.ORM_tiene = value;
	}
	
	private java.util.Set getORM_Tiene() {
		return ORM_tiene;
	}
	
	@Transient	
	public final com.mds.database.MensajeSetCollection tiene = new com.mds.database.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_TEMAS_TIENE, ORMConstants.KEY_MENSAJE_SON_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPublico(com.mds.database.Temas value) {
		if (this.publico != value) {
			com.mds.database.Temas lpublico = this.publico;
			this.publico = value;
			if (value != null) {
				publico.setEs(this);
			}
			if (lpublico != null && lpublico.getEs() == this) {
				lpublico.setEs(null);
			}
		}
	}
	
	public com.mds.database.Temas getPublico() {
		return publico;
	}
	
	public void setPrivados(com.mds.database.Temas value) {
		if (this.privados != value) {
			com.mds.database.Temas lprivados = this.privados;
			this.privados = value;
			if (value != null) {
				privados.setSon(this);
			}
			if (lprivados != null && lprivados.getSon() == this) {
				lprivados.setSon(null);
			}
		}
	}
	
	public com.mds.database.Temas getPrivados() {
		return privados;
	}
	
	public void setOcultos(com.mds.database.Temas value) {
		if (this.ocultos != value) {
			com.mds.database.Temas locultos = this.ocultos;
			this.ocultos = value;
			if (value != null) {
				ocultos.setTemas(this);
			}
			if (locultos != null && locultos.getTemas() == this) {
				locultos.setTemas(null);
			}
		}
	}
	
	public com.mds.database.Temas getOcultos() {
		return ocultos;
	}
	
	public String toString() {
		return String.valueOf(getId_tema());
	}
	
}
