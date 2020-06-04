package com.mds.foro;


import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Button.ClickEvent;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.Component;
import com.vaadin.ui.declarative.Design;

//import basededatos.iComun_usuarios;

public class Comun_usuarios extends Comun_usuarios_ventana{

	//public iComun_usuarios _iComun_usuarios;
	public Logo _unnamed_Logo_;

	public Comun_usuarios() {
		 
        registrar.addClickListener(new NativeButton.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Registrarse());
			}
		});
        iniciar.addClickListener(new NativeButton.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Iniciar_Sesion());
			}
		});
	}
}