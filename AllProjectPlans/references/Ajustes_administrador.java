package com.mds.foro;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Ajustes_administrador extends Ajustes_administrador_ventana{

	
	public Ajustes_administrador() {
		usuariosBaneados.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Ajustes.vis=5;
				Page.getCurrent().reload();
			}
		});
	}
}
