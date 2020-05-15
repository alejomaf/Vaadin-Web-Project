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

public class NotificacionesDAO {
	public static Notificaciones loadNotificacionesByORMID(int id_notificaciones) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadNotificacionesByORMID(session, id_notificaciones);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones getNotificacionesByORMID(int id_notificaciones) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getNotificacionesByORMID(session, id_notificaciones);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByORMID(int id_notificaciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadNotificacionesByORMID(session, id_notificaciones, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones getNotificacionesByORMID(int id_notificaciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getNotificacionesByORMID(session, id_notificaciones, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByORMID(PersistentSession session, int id_notificaciones) throws PersistentException {
		try {
			return (Notificaciones) session.load(com.mds.database.Notificaciones.class, new Integer(id_notificaciones));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones getNotificacionesByORMID(PersistentSession session, int id_notificaciones) throws PersistentException {
		try {
			return (Notificaciones) session.get(com.mds.database.Notificaciones.class, new Integer(id_notificaciones));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByORMID(PersistentSession session, int id_notificaciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificaciones) session.load(com.mds.database.Notificaciones.class, new Integer(id_notificaciones), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones getNotificacionesByORMID(PersistentSession session, int id_notificaciones, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificaciones) session.get(com.mds.database.Notificaciones.class, new Integer(id_notificaciones), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificaciones(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryNotificaciones(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificaciones(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryNotificaciones(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones[] listNotificacionesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listNotificacionesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones[] listNotificacionesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listNotificacionesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificaciones(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Notificaciones as Notificaciones");
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
	
	public static List queryNotificaciones(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Notificaciones as Notificaciones");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificaciones", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones[] listNotificacionesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryNotificaciones(session, condition, orderBy);
			return (Notificaciones[]) list.toArray(new Notificaciones[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones[] listNotificacionesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryNotificaciones(session, condition, orderBy, lockMode);
			return (Notificaciones[]) list.toArray(new Notificaciones[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadNotificacionesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadNotificacionesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Notificaciones[] notificacioneses = listNotificacionesByQuery(session, condition, orderBy);
		if (notificacioneses != null && notificacioneses.length > 0)
			return notificacioneses[0];
		else
			return null;
	}
	
	public static Notificaciones loadNotificacionesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Notificaciones[] notificacioneses = listNotificacionesByQuery(session, condition, orderBy, lockMode);
		if (notificacioneses != null && notificacioneses.length > 0)
			return notificacioneses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateNotificacionesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateNotificacionesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNotificacionesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateNotificacionesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNotificacionesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Notificaciones as Notificaciones");
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
	
	public static java.util.Iterator iterateNotificacionesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Notificaciones as Notificaciones");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificaciones", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones createNotificaciones() {
		return new com.mds.database.Notificaciones();
	}
	
	public static boolean save(com.mds.database.Notificaciones notificaciones) throws PersistentException {
		try {
			CUPersistentManager.instance().saveObject(notificaciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mds.database.Notificaciones notificaciones) throws PersistentException {
		try {
			CUPersistentManager.instance().deleteObject(notificaciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Notificaciones notificaciones)throws PersistentException {
		try {
			if (notificaciones.getDe() != null) {
				notificaciones.getDe().tiene.remove(notificaciones);
			}
			
			return delete(notificaciones);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Notificaciones notificaciones, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (notificaciones.getDe() != null) {
				notificaciones.getDe().tiene.remove(notificaciones);
			}
			
			try {
				session.delete(notificaciones);
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
	
	public static boolean refresh(com.mds.database.Notificaciones notificaciones) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().refresh(notificaciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mds.database.Notificaciones notificaciones) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().evict(notificaciones);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificaciones loadNotificacionesByCriteria(NotificacionesCriteria notificacionesCriteria) {
		Notificaciones[] notificacioneses = listNotificacionesByCriteria(notificacionesCriteria);
		if(notificacioneses == null || notificacioneses.length == 0) {
			return null;
		}
		return notificacioneses[0];
	}
	
	public static Notificaciones[] listNotificacionesByCriteria(NotificacionesCriteria notificacionesCriteria) {
		return notificacionesCriteria.listNotificaciones();
	}
}
