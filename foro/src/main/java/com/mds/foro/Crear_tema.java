package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iComun_privilegiados;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Crear_tema extends Crear_tema_ventana {

	iComun_privilegiados icp = new DB_Main();
	com.mds.database.Usuario usuario;
	com.mds.database.Secciones seccion;

	public Crear_tema(com.mds.database.Usuario usuario, com.mds.database.Secciones seccion) {
		this.usuario = usuario;
		this.seccion = seccion;
		crearTema.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				crearTema();
			}
		});
	}

	public void crearTema() {
		if (!tituloTema.getValue().isEmpty() && !contenidoTema.getValue().isEmpty())
			icp.Crear_tema(tituloTema.getValue(), contenidoTema.getValue(), usuario, seccion);
		else
			Notification.show("Ingrese un título y contenido del tema", "", Notification.TYPE_ERROR_MESSAGE);

		Page.getCurrent().reload();
	}
}