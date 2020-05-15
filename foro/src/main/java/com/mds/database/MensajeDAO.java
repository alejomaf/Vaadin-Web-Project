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

public class MensajeDAO {
	public static Mensaje loadMensajeByORMID(int id_mensaje) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMensajeByORMID(session, id_mensaje);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje getMensajeByORMID(int id_mensaje) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getMensajeByORMID(session, id_mensaje);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByORMID(int id_mensaje, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMensajeByORMID(session, id_mensaje, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje getMensajeByORMID(int id_mensaje, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getMensajeByORMID(session, id_mensaje, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByORMID(PersistentSession session, int id_mensaje) throws PersistentException {
		try {
			return (Mensaje) session.load(com.mds.database.Mensaje.class, new Integer(id_mensaje));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje getMensajeByORMID(PersistentSession session, int id_mensaje) throws PersistentException {
		try {
			return (Mensaje) session.get(com.mds.database.Mensaje.class, new Integer(id_mensaje));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByORMID(PersistentSession session, int id_mensaje, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Mensaje) session.load(com.mds.database.Mensaje.class, new Integer(id_mensaje), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje getMensajeByORMID(PersistentSession session, int id_mensaje, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Mensaje) session.get(com.mds.database.Mensaje.class, new Integer(id_mensaje), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMensaje(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryMensaje(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMensaje(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryMensaje(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje[] listMensajeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listMensajeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje[] listMensajeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listMensajeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMensaje(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Mensaje as Mensaje");
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
	
	public static List queryMensaje(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Mensaje as Mensaje");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Mensaje", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje[] listMensajeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMensaje(session, condition, orderBy);
			return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje[] listMensajeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMensaje(session, condition, orderBy, lockMode);
			return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMensajeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMensajeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Mensaje[] mensajes = listMensajeByQuery(session, condition, orderBy);
		if (mensajes != null && mensajes.length > 0)
			return mensajes[0];
		else
			return null;
	}
	
	public static Mensaje loadMensajeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Mensaje[] mensajes = listMensajeByQuery(session, condition, orderBy, lockMode);
		if (mensajes != null && mensajes.length > 0)
			return mensajes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMensajeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateMensajeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMensajeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateMensajeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMensajeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Mensaje as Mensaje");
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
	
	public static java.util.Iterator iterateMensajeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Mensaje as Mensaje");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Mensaje", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje createMensaje() {
		return new com.mds.database.Mensaje();
	}
	
	public static boolean save(com.mds.database.Mensaje mensaje) throws PersistentException {
		try {
			CUPersistentManager.instance().saveObject(mensaje);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mds.database.Mensaje mensaje) throws PersistentException {
		try {
			CUPersistentManager.instance().deleteObject(mensaje);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Mensaje mensaje)throws PersistentException {
		try {
			if (mensaje.getEliminado_por() != null) {
				mensaje.getEliminado_por().eliminaMod.remove(mensaje);
			}
			
			if (mensaje.getRespuesta_de() != null) {
				mensaje.getRespuesta_de().tiene.remove(mensaje);
			}
			
			com.mds.database.Usuario[] lEs_gustados = mensaje.es_gustado.toArray();
			for(int i = 0; i < lEs_gustados.length; i++) {
				lEs_gustados[i].gustaM.remove(mensaje);
			}
			if (mensaje.getSon_de() != null) {
				mensaje.getSon_de().tiene.remove(mensaje);
			}
			
			com.mds.database.Mensaje[] lTienes = mensaje.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setRespuesta_de(null);
			}
			if (mensaje.getPertenece_a() != null) {
				mensaje.getPertenece_a().escribe.remove(mensaje);
			}
			
			com.mds.database.Media[] lContienes = mensaje.contiene.toArray();
			for(int i = 0; i < lContienes.length; i++) {
				lContienes[i].setEs_de(null);
			}
			return delete(mensaje);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Mensaje mensaje, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (mensaje.getEliminado_por() != null) {
				mensaje.getEliminado_por().eliminaMod.remove(mensaje);
			}
			
			if (mensaje.getRespuesta_de() != null) {
				mensaje.getRespuesta_de().tiene.remove(mensaje);
			}
			
			com.mds.database.Usuario[] lEs_gustados = mensaje.es_gustado.toArray();
			for(int i = 0; i < lEs_gustados.length; i++) {
				lEs_gustados[i].gustaM.remove(mensaje);
			}
			if (mensaje.getSon_de() != null) {
				mensaje.getSon_de().tiene.remove(mensaje);
			}
			
			com.mds.database.Mensaje[] lTienes = mensaje.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setRespuesta_de(null);
			}
			if (mensaje.getPertenece_a() != null) {
				mensaje.getPertenece_a().escribe.remove(mensaje);
			}
			
			com.mds.database.Media[] lContienes = mensaje.contiene.toArray();
			for(int i = 0; i < lContienes.length; i++) {
				lContienes[i].setEs_de(null);
			}
			try {
				session.delete(mensaje);
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
	
	public static boolean refresh(com.mds.database.Mensaje mensaje) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().refresh(mensaje);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mds.database.Mensaje mensaje) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().evict(mensaje);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mensaje loadMensajeByCriteria(MensajeCriteria mensajeCriteria) {
		Mensaje[] mensajes = listMensajeByCriteria(mensajeCriteria);
		if(mensajes == null || mensajes.length == 0) {
			return null;
		}
		return mensajes[0];
	}
	
	public static Mensaje[] listMensajeByCriteria(MensajeCriteria mensajeCriteria) {
		return mensajeCriteria.listMensaje();
	}
}
