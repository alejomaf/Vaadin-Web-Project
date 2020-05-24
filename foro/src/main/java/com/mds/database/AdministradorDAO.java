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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AdministradorDAO {
	public static Administrador loadAdministradorByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadAdministradorByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getAdministradorByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadAdministradorByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getAdministradorByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Administrador) session.load(com.mds.database.Administrador.class, new Integer(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Administrador) session.get(com.mds.database.Administrador.class, new Integer(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Administrador) session.load(com.mds.database.Administrador.class, new Integer(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Administrador) session.get(com.mds.database.Administrador.class, new Integer(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryAdministrador(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryAdministrador(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listAdministradorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listAdministradorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Administrador as Administrador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Administrador as Administrador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Administrador", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAdministrador(session, condition, orderBy);
			return (Administrador[]) list.toArray(new Administrador[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAdministrador(session, condition, orderBy, lockMode);
			return (Administrador[]) list.toArray(new Administrador[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadAdministradorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadAdministradorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Administrador[] administradors = listAdministradorByQuery(session, condition, orderBy);
		if (administradors != null && administradors.length > 0)
			return administradors[0];
		else
			return null;
	}
	
	public static Administrador loadAdministradorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Administrador[] administradors = listAdministradorByQuery(session, condition, orderBy, lockMode);
		if (administradors != null && administradors.length > 0)
			return administradors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateAdministradorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateAdministradorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Administrador as Administrador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Administrador as Administrador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Administrador", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador createAdministrador() {
		return new com.mds.database.Administrador();
	}
	
	public static boolean save(com.mds.database.Administrador administrador) throws PersistentException {
		try {
			CUPersistentManager.instance().saveObject(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mds.database.Administrador administrador) throws PersistentException {
		try {
			CUPersistentManager.instance().deleteObject(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Administrador administrador)throws PersistentException {
		try {
			com.mds.database.Secciones[] lCreaSs = administrador.creaS.toArray();
			for(int i = 0; i < lCreaSs.length; i++) {
				lCreaSs[i].setEs_creada_por(null);
			}
			com.mds.database.Usuario[] lEliminas = administrador.elimina.toArray();
			for(int i = 0; i < lEliminas.length; i++) {
				lEliminas[i].setEliminado_por(null);
			}
			com.mds.database.Mensaje[] lEliminaMods = administrador.eliminaMod.toArray();
			for(int i = 0; i < lEliminaMods.length; i++) {
				lEliminaMods[i].setEliminado_por(null);
			}
			com.mds.database.Usuario[] lAmigo_des = administrador.amigo_de.toArray();
			for(int i = 0; i < lAmigo_des.length; i++) {
				lAmigo_des[i].es_amigo_de.remove(administrador);
			}
			com.mds.database.Temas[] lCreaTs = administrador.creaT.toArray();
			for(int i = 0; i < lCreaTs.length; i++) {
				lCreaTs[i].setCreado_por(null);
			}
			com.mds.database.Mensaje[] lEscribes = administrador.escribe.toArray();
			for(int i = 0; i < lEscribes.length; i++) {
				lEscribes[i].setPertenece_a(null);
			}
			com.mds.database.Usuario[] lReporta_as = administrador.reporta_a.toArray();
			for(int i = 0; i < lReporta_as.length; i++) {
				lReporta_as[i].es_reportado_por.remove(administrador);
			}
			com.mds.database.Notificaciones[] lTienes = administrador.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setDe(null);
			}
			com.mds.database.Usuario[] lEs_amigo_des = administrador.es_amigo_de.toArray();
			for(int i = 0; i < lEs_amigo_des.length; i++) {
				lEs_amigo_des[i].amigo_de.remove(administrador);
			}
			if (administrador.getEliminado_por() != null) {
				administrador.getEliminado_por().elimina.remove(administrador);
			}
			
			com.mds.database.Mensaje[] lGustaMs = administrador.gustaM.toArray();
			for(int i = 0; i < lGustaMs.length; i++) {
				lGustaMs[i].es_gustado.remove(administrador);
			}
			com.mds.database.Usuario[] lEs_reportado_pors = administrador.es_reportado_por.toArray();
			for(int i = 0; i < lEs_reportado_pors.length; i++) {
				lEs_reportado_pors[i].reporta_a.remove(administrador);
			}
			com.mds.database.Temas[] lGustaTs = administrador.gustaT.toArray();
			for(int i = 0; i < lGustaTs.length; i++) {
				lGustaTs[i].es_gustado.remove(administrador);
			}
			return delete(administrador);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Administrador administrador, org.orm.PersistentSession session)throws PersistentException {
		try {
			com.mds.database.Secciones[] lCreaSs = administrador.creaS.toArray();
			for(int i = 0; i < lCreaSs.length; i++) {
				lCreaSs[i].setEs_creada_por(null);
			}
			com.mds.database.Usuario[] lEliminas = administrador.elimina.toArray();
			for(int i = 0; i < lEliminas.length; i++) {
				lEliminas[i].setEliminado_por(null);
			}
			com.mds.database.Mensaje[] lEliminaMods = administrador.eliminaMod.toArray();
			for(int i = 0; i < lEliminaMods.length; i++) {
				lEliminaMods[i].setEliminado_por(null);
			}
			com.mds.database.Usuario[] lAmigo_des = administrador.amigo_de.toArray();
			for(int i = 0; i < lAmigo_des.length; i++) {
				lAmigo_des[i].es_amigo_de.remove(administrador);
			}
			com.mds.database.Temas[] lCreaTs = administrador.creaT.toArray();
			for(int i = 0; i < lCreaTs.length; i++) {
				lCreaTs[i].setCreado_por(null);
			}
			com.mds.database.Mensaje[] lEscribes = administrador.escribe.toArray();
			for(int i = 0; i < lEscribes.length; i++) {
				lEscribes[i].setPertenece_a(null);
			}
			com.mds.database.Usuario[] lReporta_as = administrador.reporta_a.toArray();
			for(int i = 0; i < lReporta_as.length; i++) {
				lReporta_as[i].es_reportado_por.remove(administrador);
			}
			com.mds.database.Notificaciones[] lTienes = administrador.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setDe(null);
			}
			com.mds.database.Usuario[] lEs_amigo_des = administrador.es_amigo_de.toArray();
			for(int i = 0; i < lEs_amigo_des.length; i++) {
				lEs_amigo_des[i].amigo_de.remove(administrador);
			}
			if (administrador.getEliminado_por() != null) {
				administrador.getEliminado_por().elimina.remove(administrador);
			}
			
			com.mds.database.Mensaje[] lGustaMs = administrador.gustaM.toArray();
			for(int i = 0; i < lGustaMs.length; i++) {
				lGustaMs[i].es_gustado.remove(administrador);
			}
			com.mds.database.Usuario[] lEs_reportado_pors = administrador.es_reportado_por.toArray();
			for(int i = 0; i < lEs_reportado_pors.length; i++) {
				lEs_reportado_pors[i].reporta_a.remove(administrador);
			}
			com.mds.database.Temas[] lGustaTs = administrador.gustaT.toArray();
			for(int i = 0; i < lGustaTs.length; i++) {
				lGustaTs[i].es_gustado.remove(administrador);
			}
			try {
				session.delete(administrador);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(com.mds.database.Administrador administrador) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().refresh(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mds.database.Administrador administrador) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().evict(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByCriteria(AdministradorCriteria administradorCriteria) {
		Administrador[] administradors = listAdministradorByCriteria(administradorCriteria);
		if(administradors == null || administradors.length == 0) {
			return null;
		}
		return administradors[0];
	}
	
	public static Administrador[] listAdministradorByCriteria(AdministradorCriteria administradorCriteria) {
		return administradorCriteria.listAdministrador();
	}
}
