package com.mds.interfaz;

import com.mds.database.Notificaciones;
import com.mds.database.Secciones;
import com.mds.foro.Tema;

public interface iAdministrador extends iUsuario_Registrado, iComun_privilegiados, iComun_registrados {

	public void Conceder_privilegios(int aID);

	public void Retirar_privilegios(int aID);

	public void Privatizar_tema(int aID);

	public void Banear(int aID);

	public void Desbanear(int aID);

	public com.mds.database.Secciones[] cargarSecciones();

	public Notificaciones[] cargarNotificaciones(int aID);

	public com.mds.database.Mensaje[] cargarMensajes(int aID);

	public com.mds.database.Usuario[] cargarAmigos(int aID);

	public com.mds.database.Usuario[] cargarUsuariosReportados();
	
	public com.mds.database.Usuario[] cargarUsuariosBaneados();
	
	public void crearSeccion(String titulo);
	
	public void borrarSeccion(int aID);
	
	public com.mds.database.Temas[] cargarTema(Secciones sec);
	
	public com.mds.database.Usuario[] cargarUsuarios(int aID);
	
	public void borrarNotificacion(int aID);
	
	public com.mds.database.Temas cargarTema(int aID);
	
	public com.mds.database.Temas[] cargarTodosLosTemas(int aID);
	
	public com.mds.database.Temas[] cargarTemasRecientes();
	
	public com.mds.database.Mensaje[] cargarMensajesRecientes();
	
	public void notificacionMensajeEnviado(int aIDU, int aIDT);
	
	public com.mds.database.Mensaje getMensaje(int aIDU);
	
	public com.mds.database.Media getMedia(com.mds.database.Mensaje men);
	
	public com.mds.database.Foto getFoto(com.mds.database.Media medAux);
	
	public com.mds.database.Video getVideo(com.mds.database.Media medAux);
}