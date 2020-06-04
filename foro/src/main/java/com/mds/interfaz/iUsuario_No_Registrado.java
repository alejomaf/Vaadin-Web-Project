package com.mds.interfaz;

public interface iUsuario_No_Registrado extends iComun_usuarios {

	public void buscarSeccion(String aBusqueda);

	public void registrarse(String aNombreUsuario, String aContrasena, String aNombreCompleto, String aDescripcion, String aFotoPerfil, String email);

	public com.mds.database.Usuario iniciarSesion(String aUsuario, String aContrasena);
}