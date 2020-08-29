package com.mds.foro;

import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Usuario_No_Registrado extends Usuario_No_Registrado_ventana {
	public iUsuario_No_Registrado _iUsuario_No_Registrado;
	public Iniciar_Sesion _iniciar_Sesion;
	public Registrarse _registrarse;

	public Usuario_No_Registrado() {

		iniciarSesion.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Iniciar_Sesion.pagina=MyUI.navigator.getCurrentNavigationState();
				MyUI.navigator.navigateTo("login");
			}
		});
		registrarse.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Iniciar_Sesion.pagina=MyUI.navigator.getCurrentNavigationState();
				MyUI.navigator.navigateTo("register");
			}
		});
	}
}