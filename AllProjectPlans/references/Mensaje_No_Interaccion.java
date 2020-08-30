package com.mds.foro;

import com.vaadin.ui.*;

public class Mensaje_No_Interaccion extends Mensaje{
	public Mensaje_No_Interaccion(com.mds.database.Mensaje men) {
		super(men);
		fotoMensaje.setVisible(false);
		citarMensaje.setVisible(false);
	}
}