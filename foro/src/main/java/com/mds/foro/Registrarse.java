package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Registrarse extends Registrarse_ventana implements View {
	public Usuario_No_Registrado _unnamed_Usuario_No_Registrado_;

	iUsuario_No_Registrado iuno = new DB_Main();

	public Registrarse() {

		salir.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.navigator.navigateTo(Iniciar_Sesion.pagina);
			}
		});
		registrarse.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (contrasena.getValue().equals(contrasena2.getValue()))
					registrarse();
				else
					Notification.show("No coinciden las contraseñas", "", Notification.TYPE_ERROR_MESSAGE);
			}
		});
	}

	public void registrarse() {

		String pass = contrasena.getValue();
		String cname = nombreCompleto.getValue();
		String description = descripcion.getValue();
		String mail = email.getValue();
		String foto = linkFoto.getValue();

		if (pass.isEmpty() || cname.isEmpty() || description.isEmpty() || mail.isEmpty() || foto.isEmpty()) {
			Notification.show("Rellena todos los campos", "", Notification.TYPE_ERROR_MESSAGE);
			return;
		}

		if (iuno.existeUsuario(mail)) {
			Notification.show("El usuario registrado con ese email ya existe", "", Notification.TYPE_ERROR_MESSAGE);
			return;
		}
		iuno.registrarse(pass, cname, description, foto, mail);
		MyUI.sesionUsuario = iuno.iniciarSesion(mail, pass);
		MyUI.navigator.navigateTo("main");
	}
}