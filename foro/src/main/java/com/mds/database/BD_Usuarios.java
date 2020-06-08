package com.mds.database;

import java.io.Serializable;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Usuarios implements Serializable {
	public BD_Pincipal _bD_Pincipal;
	public Vector<Usuario> _unnamed_Usuario_ = new Vector<Usuario>();

	public void Enviar_solicitud_amistad(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_amigo(int aID, int aID2) throws PersistentException{
		PersistentTransaction t=UsuarioDAO.loadUsuarioByORMID(aID).amigo_de.getPersistentManager().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usuario=UsuarioDAO.loadUsuarioByORMID(aID);
			usuario.amigo_de.remove(UsuarioDAO.loadUsuarioByORMID(aID2));
			usuario.es_amigo_de.remove(UsuarioDAO.loadUsuarioByORMID(aID2));
			UsuarioDAO.save(usuario);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();

		PersistentTransaction t2=UsuarioDAO.loadUsuarioByORMID(aID2).amigo_de.getPersistentManager().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usuario2=UsuarioDAO.loadUsuarioByORMID(aID2);
			usuario2.amigo_de.remove(UsuarioDAO.loadUsuarioByORMID(aID));
			usuario2.es_amigo_de.remove(UsuarioDAO.loadUsuarioByORMID(aID));
			UsuarioDAO.save(usuario2);
			t2.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public boolean modificarContrasena(int aID, String aContrasenaNueva) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setContrasena(aContrasenaNueva);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
			return false;
		}
		CUPersistentManager.instance().disposePersistentManager();
		return true;
	}

	public void Conceder_privilegios(int aID) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setModerador(true);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Retirar_privilegios(int aID) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setModerador(false);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Desmarcar(int aID) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setReportado(false);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Marcar(int aID) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setReportado(true);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void registrarse(String aContrasena, String aNombreCompleto, String aDescripcion, String aFotoPerfil, String email)throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu = UsuarioDAO.createUsuario();
			
			usu.setReportado(false);
			usu.setEmail(email);
			usu.setModerador(false);
			usu.setContrasena(aContrasena);
			usu.setDescripcion(aDescripcion);
			usu.setNombre_completo(aNombreCompleto);
			usu.setFoto(aFotoPerfil);
			
			
			UsuarioDAO.save(usu);
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}


	public void Banear(int aID) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setEliminado(true);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Desbanear(int aID) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			usu.setEliminado(false);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public Usuario[] cargarAmigos(int aID) throws PersistentException{
		com.mds.database.Usuario[] usu=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			usu = UsuarioDAO.loadUsuarioByORMID(aID).amigo_de.toArray();
			if(usu.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return usu;
	}

	public Usuario[] cargarUsuariosReportados() throws PersistentException{
		com.mds.database.Usuario[] usu=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			usu = UsuarioDAO.listUsuarioByQuery("Reportado = \'"+1+"\'", null);
			if(usu.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return usu;
	}

	public Usuario[] cargarUsuariosBaneados() throws PersistentException{
		com.mds.database.Usuario[] usu=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			usu = UsuarioDAO.listUsuarioByQuery("Eliminado = \'"+1+"\'", null);
			if(usu.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return usu;
	}

	public com.mds.database.Usuario iniciarSesion(String aUsuario, String aContrasena) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario[] usu = UsuarioDAO.listUsuarioByQuery("Email = \'"+aUsuario+"\'", null);
			if(usu.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
			if (usu[0].getContrasena().equals(aContrasena)) return usu[0];
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return null;
	}

	public void modificarPerfil(int aID, String nombreCompleto, String descripcion) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aID);
			if(nombreCompleto!=null) usu.setNombre_completo(nombreCompleto);
			if(descripcion!=null) usu.setDescripcion(descripcion);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public Usuario[] cargarUsuarios(int aID) throws PersistentException {
		com.mds.database.Usuario[] usu=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			usu = UsuarioDAO.listUsuarioByQuery("Id_usuario != \'"+aID+"\'", null);
			if(usu.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return usu;
	}
}