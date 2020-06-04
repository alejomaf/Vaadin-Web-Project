package com.mds.interfaz;

import com.mds.database.Secciones;

public interface iAdministrador extends iUsuario_Registrado, iComun_privilegiados, iComun_registrados {

	public void Conceder_privilegios(int aID);

	public void Retirar_privilegios(int aID);

	public void Privatizar_tema(int aID);

	public void Banear(int aID);

	public void Desbanear(int aID);

	public com.mds.database.Secciones[] cargarSecciones();

	public void cargarNotificaciones();

	public void cargarMensajes(int aID);

	public void cargarAmigos(int aID);

	public void cargarUsuariosReportados(int aID);
	
	public void crearSeccion(String titulo);
	
	public void borrarSeccion(int aID);
	
	public com.mds.database.Temas[] cargarTema(Secciones sec);
}