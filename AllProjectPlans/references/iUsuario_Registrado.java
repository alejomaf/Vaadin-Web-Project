package com.mds.interfaz;

import com.mds.database.Usuario;

public interface iUsuario_Registrado extends iComun_usuarios, iUsuario_propietario_mensaje, iComun_registrados {
	
	public void anadirAmigo(Usuario usu, Usuario usu2);

	public void aceptarSolicitud(int usu, int aID);
}