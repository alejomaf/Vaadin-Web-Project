package com.mds.foro;

import com.vaadin.server.Page;

public class Cerrar_sesion {
	public Usuario_Registrado _unnamed_Usuario_Registrado_;

	public static void cerrarSesion() {
		MyUI.sesionUsuario = null;
		Ajustes.vis=1;
		MyUI.navigator.removeView("main");
		MyUI.navigator.addView("main", new Comun_usuarios());
		MyUI.navigator.navigateTo("main");
		Page.getCurrent().reload();
	}
}