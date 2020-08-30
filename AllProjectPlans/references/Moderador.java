package com.mds.foro;

import com.mds.interfaz.iModerador;

public class Moderador {
	
	public static boolean isModerador(com.mds.database.Usuario usu) {
		if(usu==null) return false;
		return usu.getModerador();
	}
}