package com.mds.foro;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Ajustes_moderador extends Ajustes_moderador_ventana{

	
	public Ajustes_moderador() {
		usuariosReportados.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Ajustes.vis=4;
				Page.getCurrent().reload();
			}
		});
	}
}
