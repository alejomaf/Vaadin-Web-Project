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

public class UsuarioDAO {
	public static Usuario loadUsuarioByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getUsuarioByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getUsuarioByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Usuario) session.load(com.mds.database.Usuario.class, new Integer(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Usuario) session.get(com.mds.database.Usuario.class, new Integer(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario) session.load(com.mds.database.Usuario.class, new Integer(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario) session.get(com.mds.database.Usuario.class, new Integer(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Usuario as Usuario");
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
	
	public static List queryUsuario(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy, lockMode);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}
	
	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy, lockMode);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Usuario as Usuario");
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
	
	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario createUsuario() {
		return new com.mds.database.Usuario();
	}
	
	public static boolean save(com.mds.database.Usuario usuario) throws PersistentException {
		try {
			CUPersistentManager.instance().saveObject(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mds.database.Usuario usuario) throws PersistentException {
		try {
			CUPersistentManager.instance().deleteObject(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Usuario usuario)throws PersistentException {
		if (usuario instanceof com.mds.database.Moderador) {
			return com.mds.database.ModeradorDAO.deleteAndDissociate((com.mds.database.Moderador) usuario);
		}
		
		try {
			com.mds.database.Usuario[] lAmigo_des = usuario.amigo_de.toArray();
			for(int i = 0; i < lAmigo_des.length; i++) {
				lAmigo_des[i].es_amigo_de.remove(usuario);
			}
			com.mds.database.Temas[] lCreaTs = usuario.creaT.toArray();
			for(int i = 0; i < lCreaTs.length; i++) {
				lCreaTs[i].setCreado_por(null);
			}
			com.mds.database.Mensaje[] lEscribes = usuario.escribe.toArray();
			for(int i = 0; i < lEscribes.length; i++) {
				lEscribes[i].setPertenece_a(null);
			}
			com.mds.database.Usuario[] lReporta_as = usuario.reporta_a.toArray();
			for(int i = 0; i < lReporta_as.length; i++) {
				lReporta_as[i].es_reportado_por.remove(usuario);
			}
			com.mds.database.Notificaciones[] lTienes = usuario.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setDe(null);
			}
			com.mds.database.Usuario[] lEs_amigo_des = usuario.es_amigo_de.toArray();
			for(int i = 0; i < lEs_amigo_des.length; i++) {
				lEs_amigo_des[i].amigo_de.remove(usuario);
			}
			if (usuario.getEliminado_por() != null) {
				usuario.getEliminado_por().elimina.remove(usuario);
			}
			
			com.mds.database.Mensaje[] lGustaMs = usuario.gustaM.toArray();
			for(int i = 0; i < lGustaMs.length; i++) {
				lGustaMs[i].es_gustado.remove(usuario);
			}
			com.mds.database.Usuario[] lEs_reportado_pors = usuario.es_reportado_por.toArray();
			for(int i = 0; i < lEs_reportado_pors.length; i++) {
				lEs_reportado_pors[i].reporta_a.remove(usuario);
			}
			com.mds.database.Temas[] lGustaTs = usuario.gustaT.toArray();
			for(int i = 0; i < lGustaTs.length; i++) {
				lGustaTs[i].es_gustado.remove(usuario);
			}
			return delete(usuario);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Usuario usuario, org.orm.PersistentSession session)throws PersistentException {
		if (usuario instanceof com.mds.database.Moderador) {
			return com.mds.database.ModeradorDAO.deleteAndDissociate((com.mds.database.Moderador) usuario, session);
		}
		
		try {
			com.mds.database.Usuario[] lAmigo_des = usuario.amigo_de.toArray();
			for(int i = 0; i < lAmigo_des.length; i++) {
				lAmigo_des[i].es_amigo_de.remove(usuario);
			}
			com.mds.database.Temas[] lCreaTs = usuario.creaT.toArray();
			for(int i = 0; i < lCreaTs.length; i++) {
				lCreaTs[i].setCreado_por(null);
			}
			com.mds.database.Mensaje[] lEscribes = usuario.escribe.toArray();
			for(int i = 0; i < lEscribes.length; i++) {
				lEscribes[i].setPertenece_a(null);
			}
			com.mds.database.Usuario[] lReporta_as = usuario.reporta_a.toArray();
			for(int i = 0; i < lReporta_as.length; i++) {
				lReporta_as[i].es_reportado_por.remove(usuario);
			}
			com.mds.database.Notificaciones[] lTienes = usuario.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setDe(null);
			}
			com.mds.database.Usuario[] lEs_amigo_des = usuario.es_amigo_de.toArray();
			for(int i = 0; i < lEs_amigo_des.length; i++) {
				lEs_amigo_des[i].amigo_de.remove(usuario);
			}
			if (usuario.getEliminado_por() != null) {
				usuario.getEliminado_por().elimina.remove(usuario);
			}
			
			com.mds.database.Mensaje[] lGustaMs = usuario.gustaM.toArray();
			for(int i = 0; i < lGustaMs.length; i++) {
				lGustaMs[i].es_gustado.remove(usuario);
			}
			com.mds.database.Usuario[] lEs_reportado_pors = usuario.es_reportado_por.toArray();
			for(int i = 0; i < lEs_reportado_pors.length; i++) {
				lEs_reportado_pors[i].reporta_a.remove(usuario);
			}
			com.mds.database.Temas[] lGustaTs = usuario.gustaT.toArray();
			for(int i = 0; i < lGustaTs.length; i++) {
				lGustaTs[i].es_gustado.remove(usuario);
			}
			try {
				session.delete(usuario);
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
	
	public static boolean refresh(com.mds.database.Usuario usuario) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().refresh(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mds.database.Usuario usuario) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().evict(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		Usuario[] usuarios = listUsuarioByCriteria(usuarioCriteria);
		if(usuarios == null || usuarios.length == 0) {
			return null;
		}
		return usuarios[0];
	}
	
	public static Usuario[] listUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		return usuarioCriteria.listUsuario();
	}
}
