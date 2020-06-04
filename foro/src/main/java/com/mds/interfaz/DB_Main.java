package com.mds.interfaz;
import com.mds.database.*;
import com.mds.database.Administrador;
import com.mds.database.Moderador;
import com.mds.database.Usuario;

import java.io.Serializable;

import org.orm.PersistentException;

import com.mds.foro.*;
public class DB_Main implements iCorreo, iAdministrador, iUsuario_Registrado, iComun_usuarios, iUsuario_No_Registrado, iUsuario_propietario_mensaje, iModerador, iComun_privilegiados, iComun_registrados, Serializable {

	BD_Usuarios usu=new BD_Usuarios();
	BD_Secciones sec=new BD_Secciones();
	BD_Temas tem= new BD_Temas();
	
	public void Conceder_privilegios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Retirar_privilegios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Privatizar_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Banear(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Desbanear(int aID) {
		throw new UnsupportedOperationException();
	}

	public com.mds.database.Secciones[] cargarSecciones() {
		try {
			return sec.cargarSecciones();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void cargarNotificaciones() {
		throw new UnsupportedOperationException();
	}

	public void cargarMensajes(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cargarAmigos(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cargarUsuariosReportados(int aID) {
		throw new UnsupportedOperationException();
	}

	public boolean modificarContrasena(int aID, String aContrasenaAntigua, String aContrasenaNueva) {
		throw new UnsupportedOperationException();
	}

	public void modificarPerfil(String aNombreCompleto, String aDescripcion, String aImagen) {
		throw new UnsupportedOperationException();
	}

	public void Enviar_solicitud_amistad(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_amigos(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_notificacion(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Dar_me_gusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_mensaje(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearMensaje(int aID, String aMensaje) {
		throw new UnsupportedOperationException();
	}

	public void Dar_me_gusta_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Crear_tema(String titulo, String contenido, Usuario usu, Secciones sec) {
		try {
			tem.Crear_tema(titulo, contenido, usu, sec);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void buscarSeccion(String aBusqueda) {
		throw new UnsupportedOperationException();
	}

	public com.mds.database.Usuario iniciarSesion(String aUsuario, String aContrasena) {
		try {
			return usu.iniciarSesion(aUsuario, aContrasena);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Desmarcar(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Marcar(int aID) {
		throw new UnsupportedOperationException();
	}

	public Correo get_Correo() {
		throw new UnsupportedOperationException();
	}

	public Administrador get_Administrador() {
		throw new UnsupportedOperationException();
	}

	public Usuario_Registrado get_Usuario_Registrado() {
		throw new UnsupportedOperationException();
	}

	public Comun_usuarios get_Comun_usuarios() {
		throw new UnsupportedOperationException();
	}

	public Usuario_propietario_mensaje get_Usuario_propietario_mensaje() {
		throw new UnsupportedOperationException();
	}

	public Comun_registrados get_Comun_registrados() {
		throw new UnsupportedOperationException();
	}

	public Comun_privilegiados get_Comun_privilegiados() {
		throw new UnsupportedOperationException();
	}

	public Usuario_No_Registrado get_Usuario_No_Registrado() {
		throw new UnsupportedOperationException();
	}

	public Moderador get_Moderador() {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aNombreUsuario, String aContrasena, String aNombreCompleto, String aDescripcion,
			String aFotoPerfil, String email) {
		try {
		usu.registrarse(aNombreUsuario, aContrasena, aNombreCompleto, aDescripcion, aFotoPerfil, email);
		}catch(PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void crearSeccion(String titulo) {
		try {
			sec.crearSeccion(titulo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void borrarSeccion(int aID) {
		try {
			sec.borrarSecion(aID);;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public com.mds.database.Temas[] cargarTema(Secciones sec) {
		try {
			return tem.cargarTema(sec);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}