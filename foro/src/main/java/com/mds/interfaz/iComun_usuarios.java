package com.mds.interfaz;

public interface iComun_usuarios {

	public boolean modificarContrasena(int aID);

	public void modificarPerfil(String aNombreCompleto, String aDescripcion, String aImagen);

	public void Enviar_solicitud_amistad(int aID);

	public void Eliminar_amigos(int aID);

	public void Eliminar_notificacion(int aID);
}