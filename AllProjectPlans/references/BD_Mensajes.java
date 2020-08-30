package com.mds.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mds.database.Mensaje;

public class BD_Mensajes implements Serializable{
	public BD_Pincipal _bD_Pincipal;
	public Vector<Mensaje> _unnamed_Mensaje_ = new Vector<Mensaje>();

	public void Dar_me_gusta(int aID, int aIDU) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Mensaje men = MensajeDAO.loadMensajeByORMID(aID);
			com.mds.database.Usuario usu= UsuarioDAO.loadUsuarioByORMID(aIDU);
			usu.gustaM.add(men);
			men.setNum_likes(men.getNum_likes()+1);
			UsuarioDAO.save(usu);
			MensajeDAO.save(men);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Eliminar_mensaje(int aID) throws PersistentException{		
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Mensaje men = MensajeDAO.loadMensajeByORMID(aID);
			MensajeDAO.delete(men);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void crearMensaje(int aID, int idR, int idT, String aMensaje) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Mensaje men = MensajeDAO.createMensaje();
			men.setContenido(aMensaje);
			men.setFechaMensaje(new java.util.Date());
			men.setNum_likes(0);
			men.setPertenece_a(UsuarioDAO.loadUsuarioByORMID(aID));
			if(idR!=0) men.setRespuesta_de(MensajeDAO.loadMensajeByORMID(idR));
			else men.setRespuesta_de(MensajeDAO.loadMensajeByORMID(1));
			men.setSon_de(TemasDAO.loadTemasByORMID(idT));
			
			MensajeDAO.save(men);
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public com.mds.database.Mensaje[] cargarMensajes(int aID)  throws PersistentException {
		com.mds.database.Mensaje[] men=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			men = MensajeDAO.listMensajeByQuery("TemasId_tema = \'"+TemasDAO.getTemasByORMID(aID).getId_tema()+"\'", null);
			if(men.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return men;
	}

	public boolean leGustaMensaje(int aID, int aIDU) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Mensaje men= MensajeDAO.loadMensajeByORMID(aID);
			if(men.es_gustado.contains(UsuarioDAO.loadUsuarioByORMID(aIDU))) return true;
		}catch (Exception e) {
			t.rollback();
			return false;
		}
		CUPersistentManager.instance().disposePersistentManager();
		return false;
	}

	public Mensaje[] cargarMensajesRecientes()throws PersistentException{
		com.mds.database.Mensaje[] men=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			men = MensajeDAO.listMensajeByQuery("Id_mensaje != \'"+1+"\'", null);
			if(men.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		if(men.length>3) return Arrays.copyOfRange(men, 0, 2);
		return men;
	}

	public Mensaje getMensaje(int aIDU) throws PersistentException {
		com.mds.database.Mensaje men=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			men = MensajeDAO.loadMensajeByORMID(aIDU);
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return men;
	}

	public Mensaje[] getMensajesUsuarios(int aID) throws PersistentException {
		com.mds.database.Mensaje[] men=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			men = MensajeDAO.listMensajeByQuery("UsuarioId_usuario = \'"+aID+"\'", null);
			if(men.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return men;
	}

	public com.mds.database.Mensaje cogerUltimoMensaje() throws PersistentException{
		com.mds.database.Mensaje[] men=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			men = MensajeDAO.listMensajeByQuery(null, null);
			if(men.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return men[men.length-1];
	}
	
	public void crearFoto(com.mds.database.Mensaje menAux, String foto) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Foto fotoAux=FotoDAO.createFoto();
			fotoAux.setEs_de(MensajeDAO.getMensajeByORMID(menAux.getORMID()));
			fotoAux.setEnlace(foto);
			FotoDAO.save(fotoAux);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
	public void crearVideo(com.mds.database.Mensaje menAux, String video) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Video videoAux=VideoDAO.createVideo();
			videoAux.setEs_de(MensajeDAO.getMensajeByORMID(menAux.getORMID()));
			videoAux.setEnlace(video);
			VideoDAO.save(videoAux);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public Media cogerMedia(Mensaje menAux) throws PersistentException{
		com.mds.database.Media[] med=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			med = MediaDAO.listMediaByQuery("MensajeId_mensaje = \'"+menAux.getORMID()+"\'", null);
			if(med.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return med[0];
	}

	public Foto cogerFoto(Media medAux) throws PersistentException{
		com.mds.database.Foto[] fot=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			fot = FotoDAO.listFotoByQuery("MediaId_media = \'"+medAux.getORMID()+"\'", null);
			if(fot.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return fot[0];
	}

	public Video cogerVideo(Media medAux) throws PersistentException{
		com.mds.database.Video[] vid=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			vid = VideoDAO.listVideoByQuery("MediaId_media = \'"+medAux.getORMID()+"\'", null);
			if(vid.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return vid[0];
	}
	
	public void eliminarMedia(Media medAux) throws PersistentException{
			PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
			try {
				com.mds.database.Media media= MediaDAO.loadMediaByORMID(medAux.getORMID());
				MediaDAO.delete(media);
				t.commit();
			}catch (Exception e) {
				t.rollback();
			}
			CUPersistentManager.instance().disposePersistentManager();
	
	}
	
	public void eliminarFoto(Foto fot) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			FotoDAO.delete(fot);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
	
	public void eliminarVideo(Video vid) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			
			VideoDAO.delete(vid);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
}