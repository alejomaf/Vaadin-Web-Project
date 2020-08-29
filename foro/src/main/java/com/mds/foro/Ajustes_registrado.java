package com.mds.foro;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Ajustes_registrado extends Ajustes_registrado_ventana{
	public UsuariosReg _unnamed_UsuariosReg_;
	
	public Ajustes_registrado() {
		perfil.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Ajustes.vis=1;
				Page.getCurrent().reload();
			}
		});
		usuariosB.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Ajustes.vis=2;
				Page.getCurrent().reload();
			}
		});
		amigos.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Ajustes.vis=3;
				Page.getCurrent().reload();
			}
		});
	}
}