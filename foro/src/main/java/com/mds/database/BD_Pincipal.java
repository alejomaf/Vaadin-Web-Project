package com.mds.database;
import java.util.Vector;

public class BD_Pincipal {
	public BD_Imagenes _bD_Imagenes;
	public BD_Videos _bD_Videos;
	public BD_Mensajes _bD_Mensajes;
	public BD_Temas _bD_Temas;
	public BD_Secciones _bD_Secciones;
	public BD_Usuarios _bD_Usuarios;
	public Vector<BD_Administradores> _bD_Administradores = new Vector<BD_Administradores>();
	public BD_Moderadores _bD_Moderadores;
	public BD_Notificaciones _bD_Notificaciones;

	public void iniciarSesion(String aUsuario, String aContrasena) {
		throw new UnsupportedOperationException();
	}
}