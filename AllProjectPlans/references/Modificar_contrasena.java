package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iComun_usuarios;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class Modificar_contrasena extends Modificar_contrasena_ventana {
	iComun_usuarios icu = new DB_Main();
	iUsuario_No_Registrado iuno = new DB_Main();
	
	
	public Modificar_contrasena() {
		
		com.mds.database.Usuario usu=MyUI.sesionUsuario;
		
		modificar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (contrasenaAntigua.getValue().equals(usu.getContrasena())) {
					if (contrasenaNueva.getValue().equals(contrasenaNueva2.getValue())) {
						icu.modificarContrasena(usu.getORMID(), contrasenaNueva.getValue());
						MyUI.sesionUsuario.setContrasena(contrasenaNueva.getValue());
						salir.click();
					} else
						Notification.show("Sus contraseñas nuevas no coinciden", "",
								Notification.TYPE_ERROR_MESSAGE);
				} else
					Notification.show("Su contraseña antigua es incorrecta", "",
							Notification.TYPE_ERROR_MESSAGE);
			}
		});
	}
}