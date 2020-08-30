package com.mds.foro;

import com.mds.interfaz.iComun_privilegiados;

public class Comun_privilegiados {
	
	
	public static boolean isPrivilegiado(com.mds.database.Usuario usu) {
		if(usu==null) return false;
		return Administrador.isAdministrador(usu)||Moderador.isModerador(usu);
	}
}