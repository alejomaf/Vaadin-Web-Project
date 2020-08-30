package com.mds.foro;

import com.mds.interfaz.iUsuario_Registrado;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Usuario_Registrado extends Usuario_Registrado_ventana {
	public iUsuario_Registrado _iUsuario_Registrado;
	public Cerrar_sesion _cerrar_sesion;

	public Usuario_Registrado() {
		cerrarSesion.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Cerrar_sesion.cerrarSesion();
			}
		});

		ajustes.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.navigator.navigateTo("configuration");
			}
		});
	}
}