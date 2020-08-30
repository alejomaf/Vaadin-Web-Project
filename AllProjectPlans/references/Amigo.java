package com.mds.foro;

import com.mds.database.Usuario;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iComun_usuarios;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component.Event;

public class Amigo {
	static iComun_usuarios icu = new DB_Main();
	
	public static void eliminarAmigo(Usuario usuario, Usuario usu) {
				icu.Eliminar_amigos(usuario.getORMID(), usu.getORMID());
			}
}