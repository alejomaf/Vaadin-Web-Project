package com.mds.foro;

import com.mds.interfaz.iAdministrador;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Administrador extends Ajustes_administrador_ventana {
	
	public static boolean isAdministrador(com.mds.database.Usuario usu) {
		if(usu==null) return false;
		return usu.getORMID()==1;
	}
}