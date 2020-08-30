package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;

public class Iniciar_Sesion extends Iniciar_Sesion_ventana implements View {
	// public Usuario_No_Registrado _unnamed_Usuario_No_Registrado_;
	public Validar_sesion _unnamed_Validar_sesion_;
	public Recordar_contrasena _unnamed_Recordar_contrasena_;
	public int modo;
	public static String pagina="main";

	iUsuario_No_Registrado iuno = new DB_Main();
	iAdministrador iadm = new DB_Main();

	public Iniciar_Sesion() {
		salir.addClickListener(new NativeButton.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.navigator.navigateTo(pagina);

			}
		});
		iniciar.addClickListener(new NativeButton.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				com.mds.database.Usuario usu = iniciarSesion();
				if (usu != null)
					login(usu);
				else
					Notification.show("Usuario o contraseña incorrecto/s", "", Notification.TYPE_ERROR_MESSAGE);
			}
		});
		
		recordarContrasena.addClickListener(new NativeButton.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.navigator.navigateTo("recordarContrasena");

			}
		});
	}

	public com.mds.database.Usuario iniciarSesion() {
		return iuno.iniciarSesion(nombre.getValue(), contrasena.getValue());
	}

	public void login(com.mds.database.Usuario usu) {
		MyUI.sesionUsuario = usu;
		MyUI.navigator.navigateTo(pagina);
		Page.getCurrent().reload();
	}

}
