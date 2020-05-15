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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TemasCriteria extends AbstractORMCriteria {
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
	
	public TemasCriteria(Criteria criteria) {
		super(criteria);
		id_tema = new IntegerExpression("id_tema", this);
		es_gustado = new CollectionExpression("ORM_es_gustado", this);
		esId = new IntegerExpression("es.id_tema", this);
		es = new AssociationExpression("es", this);
		sonId = new IntegerExpression("son.id_tema", this);
		son = new AssociationExpression("son", this);
		pertenece_aId = new IntegerExpression("pertenece_a.id_secciones", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		temasId = new IntegerExpression("temas.id_tema", this);
		temas = new AssociationExpression("temas", this);
		nombre = new StringExpression("nombre", this);
		num__likes = new IntegerExpression("num__likes", this);
		creado_porId = new IntegerExpression("creado_por.id_usuario", this);
		creado_por = new AssociationExpression("creado_por", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		publicoId = new IntegerExpression("publico.id_tema", this);
		publico = new AssociationExpression("publico", this);
		privadosId = new IntegerExpression("privados.id_tema", this);
		privados = new AssociationExpression("privados", this);
		ocultosId = new IntegerExpression("ocultos.id_tema", this);
		ocultos = new AssociationExpression("ocultos", this);
	}
	
	public TemasCriteria(PersistentSession session) {
		this(session.createCriteria(Temas.class));
	}
	
	public TemasCriteria() throws PersistentException {
		this(CUPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createEs_gustadoCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_es_gustado"));
	}
	
	public TemasCriteria createEsCriteria() {
		return new TemasCriteria(createCriteria("es"));
	}
	
	public TemasCriteria createSonCriteria() {
		return new TemasCriteria(createCriteria("son"));
	}
	
	public SeccionesCriteria createPertenece_aCriteria() {
		return new SeccionesCriteria(createCriteria("pertenece_a"));
	}
	
	public TemasCriteria createTemasCriteria() {
		return new TemasCriteria(createCriteria("temas"));
	}
	
	public UsuarioCriteria createCreado_porCriteria() {
		return new UsuarioCriteria(createCriteria("creado_por"));
	}
	
	public MensajeCriteria createTieneCriteria() {
		return new MensajeCriteria(createCriteria("ORM_tiene"));
	}
	
	public TemasCriteria createPublicoCriteria() {
		return new TemasCriteria(createCriteria("publico"));
	}
	
	public TemasCriteria createPrivadosCriteria() {
		return new TemasCriteria(createCriteria("privados"));
	}
	
	public TemasCriteria createOcultosCriteria() {
		return new TemasCriteria(createCriteria("ocultos"));
	}
	
	public Temas uniqueTemas() {
		return (Temas) super.uniqueResult();
	}
	
	public Temas[] listTemas() {
		java.util.List list = super.list();
		return (Temas[]) list.toArray(new Temas[list.size()]);
	}
}

