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

public class TemasDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_tema;
	public final CollectionExpression es_gustado;
	public final IntegerExpression esId;
	public final AssociationExpression es;
	public final IntegerExpression sonId;
	public final AssociationExpression son;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final IntegerExpression temasId;
	public final AssociationExpression temas;
	public final StringExpression nombre;
	public final IntegerExpression num__likes;
	public final IntegerExpression creado_porId;
	public final AssociationExpression creado_por;
	public final CollectionExpression tiene;
	public final IntegerExpression publicoId;
	public final AssociationExpression publico;
	public final IntegerExpression privadosId;
	public final AssociationExpression privados;
	public final IntegerExpression ocultosId;
	public final AssociationExpression ocultos;
	
	public TemasDetachedCriteria() {
		super(com.mds.database.Temas.class, com.mds.database.TemasCriteria.class);
		id_tema = new IntegerExpression("id_tema", this.getDetachedCriteria());
		es_gustado = new CollectionExpression("ORM_es_gustado", this.getDetachedCriteria());
		esId = new IntegerExpression("es.id_tema", this.getDetachedCriteria());
		es = new AssociationExpression("es", this.getDetachedCriteria());
		sonId = new IntegerExpression("son.id_tema", this.getDetachedCriteria());
		son = new AssociationExpression("son", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.id_secciones", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		temasId = new IntegerExpression("temas.id_tema", this.getDetachedCriteria());
		temas = new AssociationExpression("temas", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		num__likes = new IntegerExpression("num__likes", this.getDetachedCriteria());
		creado_porId = new IntegerExpression("creado_por.id_usuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		publicoId = new IntegerExpression("publico.id_tema", this.getDetachedCriteria());
		publico = new AssociationExpression("publico", this.getDetachedCriteria());
		privadosId = new IntegerExpression("privados.id_tema", this.getDetachedCriteria());
		privados = new AssociationExpression("privados", this.getDetachedCriteria());
		ocultosId = new IntegerExpression("ocultos.id_tema", this.getDetachedCriteria());
		ocultos = new AssociationExpression("ocultos", this.getDetachedCriteria());
	}
	
	public TemasDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds.database.TemasCriteria.class);
		id_tema = new IntegerExpression("id_tema", this.getDetachedCriteria());
		es_gustado = new CollectionExpression("ORM_es_gustado", this.getDetachedCriteria());
		esId = new IntegerExpression("es.id_tema", this.getDetachedCriteria());
		es = new AssociationExpression("es", this.getDetachedCriteria());
		sonId = new IntegerExpression("son.id_tema", this.getDetachedCriteria());
		son = new AssociationExpression("son", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.id_secciones", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		temasId = new IntegerExpression("temas.id_tema", this.getDetachedCriteria());
		temas = new AssociationExpression("temas", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		num__likes = new IntegerExpression("num__likes", this.getDetachedCriteria());
		creado_porId = new IntegerExpression("creado_por.id_usuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		publicoId = new IntegerExpression("publico.id_tema", this.getDetachedCriteria());
		publico = new AssociationExpression("publico", this.getDetachedCriteria());
		privadosId = new IntegerExpression("privados.id_tema", this.getDetachedCriteria());
		privados = new AssociationExpression("privados", this.getDetachedCriteria());
		ocultosId = new IntegerExpression("ocultos.id_tema", this.getDetachedCriteria());
		ocultos = new AssociationExpression("ocultos", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createEs_gustadoCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_es_gustado"));
	}
	
	public TemasDetachedCriteria createEsCriteria() {
		return new TemasDetachedCriteria(createCriteria("es"));
	}
	
	public TemasDetachedCriteria createSonCriteria() {
		return new TemasDetachedCriteria(createCriteria("son"));
	}
	
	public SeccionesDetachedCriteria createPertenece_aCriteria() {
		return new SeccionesDetachedCriteria(createCriteria("pertenece_a"));
	}
	
	public TemasDetachedCriteria createTemasCriteria() {
		return new TemasDetachedCriteria(createCriteria("temas"));
	}
	
	public UsuarioDetachedCriteria createCreado_porCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("creado_por"));
	}
	
	public MensajeDetachedCriteria createTieneCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public TemasDetachedCriteria createPublicoCriteria() {
		return new TemasDetachedCriteria(createCriteria("publico"));
	}
	
	public TemasDetachedCriteria createPrivadosCriteria() {
		return new TemasDetachedCriteria(createCriteria("privados"));
	}
	
	public TemasDetachedCriteria createOcultosCriteria() {
		return new TemasDetachedCriteria(createCriteria("ocultos"));
	}
	
	public Temas uniqueTemas(PersistentSession session) {
		return (Temas) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Temas[] listTemas(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Temas[]) list.toArray(new Temas[list.size()]);
	}
}

