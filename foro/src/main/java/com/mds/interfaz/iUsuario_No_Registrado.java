package com.mds.interfaz;

import com.mds.database.Secciones;

public interface iUsuario_No_Registrado extends iComun_usuarios {

	public Secciones[] buscarSeccion(String aBusqueda);

	public void registrarse(String aContrasena, String aNombreCompleto, String aDescripcion, String aFotoPerfil, String email);

	public com.mds.database.Usuario iniciarSesion(String aUsuario, String aContrasena);
	
	public boolean existeUsuario(String aUsuario);
}