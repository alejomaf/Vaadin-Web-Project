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

	public void Eliminar_amigo(int aID) {
		throw new UnsupportedOperationException();
	}

	public boolean modificarContrasena(int aID, String aContrasenaAntigua, String aContrasenaNueva) {
		throw new UnsupportedOperationException();
	}

	public void Conceder_privilegios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Retirar_privilegios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Desmarcar(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Marcar(int aID) {
		throw new UnsupportedOperationException();
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


	public void Banear(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Desbanear(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cargarAmigos(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cargarUsuariosReportados(int aID) {
		throw new UnsupportedOperationException();
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
}