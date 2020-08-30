package com.mds.foro;

import com.mds.interfaz.iUsuario_propietario_mensaje;

public class Usuario_propietario_mensaje {
	public iUsuario_propietario_mensaje _iUsuario_propietario_mensaje;
	public Mensajes_propios _mensajes_propios;
	
	public static boolean isPropietario(com.mds.database.Usuario usu, com.mds.database.Mensaje men) {
		return men.getPertenece_a().getORMID()==usu.getORMID();
	}
}