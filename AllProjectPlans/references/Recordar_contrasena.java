package com.mds.foro;

import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Recordar_contrasena extends Recordar_contrasena_ventana implements View{
	private Label _recuperarContrasenaL;
	private Label _descripcionL;
	private TextField _correo;
	private Label _iniciarSesionL;
	private Button _iniciarSesionB;
	private Label _recuperarL;
	private Button _recuperarB;
	public Correo _unnamed_Correo_;
	public Iniciar_Sesion _unnamed_Iniciar_Sesion_;

	
	public Recordar_contrasena(){
		iniciarSesion.addClickListener(new NativeButton.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.navigator.navigateTo("login");

			}
		});
	}
	
	public void recuperarContrasena(String aCorreo) {
		throw new UnsupportedOperationException();
	}
}