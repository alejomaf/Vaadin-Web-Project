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
}