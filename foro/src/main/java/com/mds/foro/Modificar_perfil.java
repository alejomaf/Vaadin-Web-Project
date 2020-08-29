package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iComun_usuarios;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Modificar_perfil extends Modificar_perfil_ventana {

	public iComun_usuarios icu = new DB_Main();
	iUsuario_No_Registrado iuno = new DB_Main();
	public com.mds.database.Usuario usu;
	public Ajustes _unnamed_Ajustes_;

	public Modificar_perfil() {
		usu=MyUI.sesionUsuario;
		// Relleno los parámatros para que sea más claro
		if (!usu.getDescripcion().isEmpty())
			descripcion.setValue(usu.getDescripcion());
		nombreCompleto.setValue(usu.getNombre_completo());

		modificar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (descripcion.getValue().isEmpty() || nombreCompleto.getValue().isEmpty())
					Notification.show("Faltan datos por añadir", "", Notification.TYPE_ERROR_MESSAGE);
				else if (descripcion.getValue().contentEquals(usu.getDescripcion())
						&& nombreCompleto.getValue().equals(usu.getNombre_completo()))
					Notification.show("No hay datos para cambiar", "", Notification.TYPE_ERROR_MESSAGE);
				else if (!descripcion.getValue().equals(usu.getDescripcion())
						&& !nombreCompleto.getValue().equals(usu.getNombre_completo()))
					icu.modificarPerfil(usu.getORMID(), nombreCompleto.getValue(),
							descripcion.getValue());
				else if (!descripcion.getValue().equals(usu.getDescripcion()))
					icu.modificarPerfil(usu.getORMID(), null, descripcion.getValue());
				else
					icu.modificarPerfil(usu.getORMID(), nombreCompleto.getValue(), null);
//				Page.getCurrent().reload();
			}
		});
	}

	public void modificarPerfil(String aNombreCompleto, String aDescripcion, String aImagen) {
		throw new UnsupportedOperationException();
	}
}