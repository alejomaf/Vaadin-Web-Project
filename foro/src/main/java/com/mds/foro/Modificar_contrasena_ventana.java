package com.mds.foro;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.declarative.Design;

/**
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed, e.g
 * class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Modificar_contrasena_ventana extends Panel {
	protected PasswordField contrasenaAntigua;
	protected PasswordField contrasenaNueva;
	protected PasswordField contrasenaNueva2;
	protected Button salir;
	protected Button modificar;

	public Modificar_contrasena_ventana() {
		Design.read(this);
	}
}
