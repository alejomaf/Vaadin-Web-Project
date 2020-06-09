package com.mds.interfaz;
import com.mds.database.*;
import com.mds.database.Administrador;
import com.mds.database.Mensaje;
import com.mds.database.Moderador;
import com.mds.database.Notificaciones;
import com.mds.database.Usuario;

import java.io.Serializable;

import org.orm.PersistentException;

import com.mds.foro.*;
public class DB_Main implements iCorreo, iAdministrador, iUsuario_Registrado, iComun_usuarios, iUsuario_No_Registrado, iUsuario_propietario_mensaje, iModerador, iComun_privilegiados, iComun_registrados, Serializable {

	BD_Usuarios usu=new BD_Usuarios();
	BD_Secciones sec=new BD_Secciones();
	BD_Temas tem= new BD_Temas();
	BD_Mensajes men= new BD_Mensajes();
	BD_Notificaciones not= new BD_Notificaciones();
	
	public void Conceder_privilegios(int aID) {
		try {
			usu.Conceder_privilegios(aID);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Retirar_privilegios(int aID) {
		try {
			usu.Retirar_privilegios(aID);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Privatizar_tema(int aID) {
		try {
			tem.Privatizar_tema(aID);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Banear(int aID) {
		try {
			usu.Banear(aID);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Desbanear(int aID) {
		try {
			usu.Desbanear(aID);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public com.mds.database.Secciones[] cargarSecciones() {
		try {
			return sec.cargarSecciones();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Notificaciones[] cargarNotificaciones(int aID) {
		try {
			return not.cargarNotificaciones(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public com.mds.database.Mensaje[] cargarMensajes(int aID){
		try {
			return men.cargarMensajes(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario[] cargarAmigos(int aID) {
		try {
			return usu.cargarAmigos(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario[] cargarUsuariosReportados() {
		try {
			return usu.cargarUsuariosReportados();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario[] cargarUsuariosBaneados() {
		try {
			return usu.cargarUsuariosBaneados();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean modificarContrasena(int aID, String aContrasenaNueva) {
		try {
			return usu.modificarContrasena(aID, aContrasenaNueva);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void modificarPerfil(int aID, String nombreCompleto, String descripcion) {
		try {
			usu.modificarPerfil(aID, nombreCompleto, descripcion);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Enviar_solicitud_amistad(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_amigos(int aID, int aID2) {
		try {
			usu.Eliminar_amigo(aID, aID2);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Dar_me_gusta(int aID, int aIDU) {
		try {
			men.Dar_me_gusta(aID, aIDU);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Eliminar_mensaje(int aID) {
		try {
			men.Eliminar_mensaje(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void crearMensaje(int aID, int idR, int idT, String aMensaje) {
		try {
			men.crearMensaje(aID, idR, idT, aMensaje);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Dar_me_gusta_tema(int aID, int aIDU) {
		try {
			tem.Dar_me_gusta(aID, aIDU);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Eliminar_tema(int aID) {
		try {
			tem.Eliminar_tema(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Crear_tema(String titulo, String contenido, Usuario usu, Secciones sec) {
		try {
			tem.Crear_tema(titulo, contenido, usu, sec);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Secciones[] buscarSeccion(String aBusqueda) {
		try {
			return sec.buscarSeccion(aBusqueda);
		}catch(PersistentException e) {
			e.printStackTrace();
		}
		return null;
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
		try {
			usu.Desmarcar(aID);
		}catch(PersistentException e) {
			e.printStackTrace();
		}
	}

	public void Marcar(int aID) {
		try {
			usu.Marcar(aID);
		}catch(PersistentException e) {
			e.printStackTrace();
		}
	}

	public void registrarse(String aContrasena, String aNombreCompleto, String aDescripcion,
			String aFotoPerfil, String email) {
		try {
		usu.registrarse(aContrasena, aNombreCompleto, aDescripcion, aFotoPerfil, email);
		}catch(PersistentException e) {
			e.printStackTrace();
		}
	}

	public void crearSeccion(String titulo) {
		try {
			sec.crearSeccion(titulo);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void borrarSeccion(int aID) {
		try {
			sec.borrarSecion(aID);;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public com.mds.database.Temas[] cargarTema(Secciones sec) {
		try {
			return tem.cargarTema(sec);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void modificarFoto(int aID, String foto) {
		try {
			usu.modificarFoto(aID, foto);
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void anadirAmigo(Usuario usu, Usuario usu2) {
		try {
			not.anadirAmigo(usu, usu2);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Usuario[] cargarUsuarios(int aID) {
				try {
					return usu.cargarUsuarios(aID);
				} catch (PersistentException e) {
					e.printStackTrace();
				}
				return null;
	}
	
	public void borrarNotificacion(int aID) {
		try {
			not.borrarNotificacion(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void aceptarSolicitud(int usu, int aID) {
		try {
			not.aceptarSolicitud(usu, aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public Temas cargarTema(int aID) {
		try {
			return tem.cargarUnTema(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean leGustaTema(int aID, int aIDU) {
		try {
			return tem.leGustaTema(aID, aIDU);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean leGustaMensaje(int aID, int aIDU) {
		try {
			return men.leGustaMensaje(aID, aIDU);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Temas[] cargarTemasRecientes() {
		try {
			return tem.cargarTemasRecientes();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Mensaje[] cargarMensajesRecientes() {
		try {
			return men.cargarMensajesRecientes();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean existeUsuario(String aUsuario) {
		try {
			return usu.existeUsuario(aUsuario);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void notificacionMensajeEnviado(int aIDU, int aIDT) {
		try {
			not.notificacionMensajeEnviado(aIDU, aIDT);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Mensaje getMensaje(int aIDU) {
		try {
			return men.getMensaje(aIDU);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

}