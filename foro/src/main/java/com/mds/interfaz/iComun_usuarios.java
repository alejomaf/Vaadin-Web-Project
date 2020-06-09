package com.mds.interfaz;

import com.mds.database.Usuario;

public interface iComun_usuarios {

	public boolean modificarContrasena(int aID, String aContrasenaNueva);

	public void modificarPerfil(int aID, String aNombreCompleto, String aDescripcion);
	
	public void modificarFoto(int aID, String foto);

	public void Enviar_solicitud_amistad(int aID);

	public void Eliminar_amigos(int aID, int aID2);
	
}