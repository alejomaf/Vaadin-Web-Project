package com.mds.foro;

import com.vaadin.ui.Component.Event;

public class Mensaje_propio extends Mensaje {
	public Mensaje_propio(com.mds.database.Mensaje men) {
		super(men);
		this.setStyleName("cuadroPropio");
		borrarMensaje.setVisible(true);
	}
}