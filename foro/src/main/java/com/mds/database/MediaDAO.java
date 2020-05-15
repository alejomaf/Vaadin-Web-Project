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

public class MediaDAO {
	public static Media loadMediaByORMID(int id_media) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMediaByORMID(session, id_media);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media getMediaByORMID(int id_media) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getMediaByORMID(session, id_media);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByORMID(int id_media, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMediaByORMID(session, id_media, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media getMediaByORMID(int id_media, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return getMediaByORMID(session, id_media, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByORMID(PersistentSession session, int id_media) throws PersistentException {
		try {
			return (Media) session.load(com.mds.database.Media.class, new Integer(id_media));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media getMediaByORMID(PersistentSession session, int id_media) throws PersistentException {
		try {
			return (Media) session.get(com.mds.database.Media.class, new Integer(id_media));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByORMID(PersistentSession session, int id_media, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Media) session.load(com.mds.database.Media.class, new Integer(id_media), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media getMediaByORMID(PersistentSession session, int id_media, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Media) session.get(com.mds.database.Media.class, new Integer(id_media), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMedia(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryMedia(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMedia(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return queryMedia(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media[] listMediaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listMediaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media[] listMediaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return listMediaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMedia(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Media as Media");
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
	
	public static List queryMedia(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Media as Media");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Media", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media[] listMediaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMedia(session, condition, orderBy);
			return (Media[]) list.toArray(new Media[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media[] listMediaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMedia(session, condition, orderBy, lockMode);
			return (Media[]) list.toArray(new Media[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMediaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return loadMediaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Media[] medias = listMediaByQuery(session, condition, orderBy);
		if (medias != null && medias.length > 0)
			return medias[0];
		else
			return null;
	}
	
	public static Media loadMediaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Media[] medias = listMediaByQuery(session, condition, orderBy, lockMode);
		if (medias != null && medias.length > 0)
			return medias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMediaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateMediaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMediaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = CUPersistentManager.instance().getSession();
			return iterateMediaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMediaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Media as Media");
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
	
	public static java.util.Iterator iterateMediaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds.database.Media as Media");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Media", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media createMedia() {
		return new com.mds.database.Media();
	}
	
	public static boolean save(com.mds.database.Media media) throws PersistentException {
		try {
			CUPersistentManager.instance().saveObject(media);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mds.database.Media media) throws PersistentException {
		try {
			CUPersistentManager.instance().deleteObject(media);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Media media)throws PersistentException {
		if (media instanceof com.mds.database.Video) {
			return com.mds.database.VideoDAO.deleteAndDissociate((com.mds.database.Video) media);
		}
		
		if (media instanceof com.mds.database.Foto) {
			return com.mds.database.FotoDAO.deleteAndDissociate((com.mds.database.Foto) media);
		}
		
		try {
			if (media.getEs_de() != null) {
				media.getEs_de().contiene.remove(media);
			}
			
			return delete(media);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mds.database.Media media, org.orm.PersistentSession session)throws PersistentException {
		if (media instanceof com.mds.database.Video) {
			return com.mds.database.VideoDAO.deleteAndDissociate((com.mds.database.Video) media, session);
		}
		
		if (media instanceof com.mds.database.Foto) {
			return com.mds.database.FotoDAO.deleteAndDissociate((com.mds.database.Foto) media, session);
		}
		
		try {
			if (media.getEs_de() != null) {
				media.getEs_de().contiene.remove(media);
			}
			
			try {
				session.delete(media);
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
	
	public static boolean refresh(com.mds.database.Media media) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().refresh(media);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mds.database.Media media) throws PersistentException {
		try {
			CUPersistentManager.instance().getSession().evict(media);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Media loadMediaByCriteria(MediaCriteria mediaCriteria) {
		Media[] medias = listMediaByCriteria(mediaCriteria);
		if(medias == null || medias.length == 0) {
			return null;
		}
		return medias[0];
	}
	
	public static Media[] listMediaByCriteria(MediaCriteria mediaCriteria) {
		return mediaCriteria.listMedia();
	}
}
