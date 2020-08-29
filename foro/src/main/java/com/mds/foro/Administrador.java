package com.mds.foro;

import com.mds.interfaz.iAdministrador;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Administrador extends Administrador_ventana {
	
	public Administrador() {
		usuariosBaneados.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Ajustes.vis=5;
				Page.getCurrent().reload();
			}
		});
	}
}