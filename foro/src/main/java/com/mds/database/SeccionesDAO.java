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

public class SeccionesDAO {
	public static Secciones loadSeccionesByORMID(int id_secciones) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadSeccionesByORMID(session, id_secciones);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones getSeccionesByORMID(int id_secciones) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getSeccionesByORMID(session, id_secciones);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByORMID(int id_secciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadSeccionesByORMID(session, id_secciones, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones getSeccionesByORMID(int id_secciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getSeccionesByORMID(session, id_secciones, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByORMID(PersistentSession session, int id_secciones) throws PersistentException {
		try {
			return (Secciones) session.load(com.mds.database.Secciones.class, new Integer(id_secciones));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones getSeccionesByORMID(PersistentSession session, int id_secciones) throws PersistentException {
		try {
			return (Secciones) session.get(com.mds.database.Secciones.class, new Integer(id_secciones));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByORMID(PersistentSession session, int id_secciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Secciones) session.load(com.mds.database.Secciones.class, new Integer(id_secciones), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones getSeccionesByORMID(PersistentSession session, int id_secciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Secciones) session.get(com.mds.database.Secciones.class, new Integer(id_secciones), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySecciones(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return querySecciones(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySecciones(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return querySecciones(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones[] listSeccionesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listSeccionesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones[] listSeccionesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listSeccionesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySecciones(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Secciones as Secciones");
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
	
	public static List querySecciones(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Secciones as Secciones");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Secciones", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones[] listSeccionesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySecciones(session, condition, orderBy);
			return (Secciones[]) list.toArray(new Secciones[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones[] listSeccionesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySecciones(session, condition, orderBy, lockMode);
			return (Secciones[]) list.toArray(new Secciones[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadSeccionesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadSeccionesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Secciones[] seccioneses = listSeccionesByQuery(session, condition, orderBy);
		if (seccioneses != null && seccioneses.length > 0)
			return seccioneses[0];
		else
			return null;
	}
	
	public static Secciones loadSeccionesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Secciones[] seccioneses = listSeccionesByQuery(session, condition, orderBy, lockMode);
		if (seccioneses != null && seccioneses.length > 0)
			return seccioneses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSeccionesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateSeccionesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSeccionesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateSeccionesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSeccionesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Secciones as Secciones");
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
	
	public static java.util.Iterator iterateSeccionesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Secciones as Secciones");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Secciones", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones createSecciones() {
		return new com.mds.database.Secciones();
	}
	
	public static boolean save(com.mds.database.Secciones secciones) throws PersistentException {
		try {
			CUPersistentManager.instance().saveObject(secciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mds.database.Secciones secciones) throws PersistentException {
		try {
			CUPersistentManager.instance().deleteObject(secciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Secciones secciones)throws PersistentException {
		try {
			if (secciones.getEs_creada_por() != null) {
				secciones.getEs_creada_por().creaS.remove(secciones);
			}
			
			com.mds.database.Temas[] lTienes = secciones.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setPertenece_a(null);
			}
			return delete(secciones);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Secciones secciones, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (secciones.getEs_creada_por() != null) {
				secciones.getEs_creada_por().creaS.remove(secciones);
			}
			
			com.mds.database.Temas[] lTienes = secciones.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setPertenece_a(null);
			}
			try {
				session.delete(secciones);
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
	
	public static boolean refresh(com.mds.database.Secciones secciones) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().refresh(secciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mds.database.Secciones secciones) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().evict(secciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secciones loadSeccionesByCriteria(SeccionesCriteria seccionesCriteria) {
		Secciones[] seccioneses = listSeccionesByCriteria(seccionesCriteria);
		if(seccioneses == null || seccioneses.length == 0) {
			return null;
		}
		return seccioneses[0];
	}
	
	public static Secciones[] listSeccionesByCriteria(SeccionesCriteria seccionesCriteria) {
		return seccionesCriteria.listSecciones();
	}
}
