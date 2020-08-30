package com.mds.foro;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Modificar_numero_mensajes extends Modificar_numero_mensajes_ventana{

public static int numMensajes=5;

	public Modificar_numero_mensajes() {
		cambiar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				modificar(Integer.parseInt(numeroM.getValue()));
			}
		});
	}

	protected void modificar(int numM) {
		numMensajes=numM;
		Page.getCurrent().reload();
	}
	

}