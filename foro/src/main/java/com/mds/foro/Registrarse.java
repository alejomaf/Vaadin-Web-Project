package com.mds.foro;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class Registrarse extends Registrarse_ventana {
	public Usuario_No_Registrado _unnamed_Usuario_No_Registrado_;
	

	iUsuario_No_Registrado iuno=new DB_Main();


	public Registrarse() {
		
		salir.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_registrados(null));
			}
		});
		registrarse.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				if(contrasena.getValue().equals(contrasena2.getValue()))
				registrarse();
				else Notification.show("No coinciden las contraseñas","",Notification.TYPE_ERROR_MESSAGE);
			}
		});
	}
	
	public void registrarse() {
		
		String pass= contrasena.getValue();
		String cname= nombreCompleto.getValue();
		String description= descripcion.getValue();
		String mail= email.getValue();
		String foto= linkFoto.getValue();
		
		
		if(pass.isEmpty()||cname.isEmpty()||description.isEmpty()||mail.isEmpty()||foto.isEmpty()) {
			Notification.show("Rellena todos los campos","",Notification.TYPE_ERROR_MESSAGE);
			return;
		}
		
		if(iuno.existeUsuario(mail)) {
			Notification.show("El usuario registrado con ese email ya existe","",Notification.TYPE_ERROR_MESSAGE);
			return;
		}
		iuno.registrarse(pass, cname, description, foto, mail);
		setContent(new Comun_registrados(iuno.iniciarSesion(mail, pass)));
	}
}