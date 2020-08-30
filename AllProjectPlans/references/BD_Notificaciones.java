package com.mds.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentManager;
import org.orm.PersistentTransaction;

import com.mds.database.Notificaciones;

public class BD_Notificaciones implements Serializable{
	public BD_Pincipal _bD_Pincipal;
	public Vector<Notificaciones> _unnamed_Notificaciones_ = new Vector<Notificaciones>();


	public Notificaciones[] cargarNotificaciones(int aID) throws PersistentException{
		com.mds.database.Notificaciones[] not=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			not = NotificacionesDAO.listNotificacionesByQuery("UsuarioId_usuario = \'"+aID+"\'", null);
			if(not.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return not;
	}

	public void anadirAmigo(Usuario usu, Usuario usu2) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Notificaciones not=NotificacionesDAO.createNotificaciones();
			not.setDe(UsuarioDAO.loadUsuarioByORMID(usu2.getORMID()));
			not.setEnlace("amistad");
			not.setFecha(new Date(0));
			not.setTitulo(usu.getNombre_completo()+" te ha enviado una solicitud de amistad,"+usu.getORMID());
			NotificacionesDAO.save(not);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void borrarNotificacion(int aID) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Notificaciones not=NotificacionesDAO.loadNotificacionesByORMID(aID);
			NotificacionesDAO.delete(not);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void aceptarSolicitud(int usu, int aID) throws PersistentException{
		PersistentTransaction t=CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usuario=UsuarioDAO.loadUsuarioByORMID(usu);
			com.mds.database.Usuario usuario2=UsuarioDAO.loadUsuarioByORMID(aID);
			usuario.amigo_de.add(usuario2);
			usuario2.amigo_de.add(usuario);
			UsuarioDAO.save(usuario);
			UsuarioDAO.save(usuario2);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void notificacionMensajeEnviado(int aIDU, int aIDT) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Notificaciones not=NotificacionesDAO.createNotificaciones();
			not.setDe(UsuarioDAO.loadUsuarioByORMID(aIDU));
			not.setEnlace("mensaje");
			not.setFecha(new java.util.Date());
			not.setTitulo("Han escrito un mensaje,"+aIDT);
			NotificacionesDAO.save(not);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
}