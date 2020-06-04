package com.mds.foro;

import com.mds.database.Usuario;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.Button;

import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.declarative.Design;

public class Iniciar_Sesion extends Iniciar_Sesion_ventana {
	private Label _iniciarSesionL;
	private Label _descripcion;
	private Label _nombreUsuarioL;
	private TextField _nombreUsuarioTF;
	private Label _contrasenaL;
	private TextField _contrasenaTF;
	private Button _registrarseB;
	private Label _registrarseL;
	private Button _entrarB;
	private Label _entrarL;
	private Label _recordarContrasenaL;
	private Button _recordarContrasenaB;
	//public Usuario_No_Registrado _unnamed_Usuario_No_Registrado_;
	public Validar_sesion _unnamed_Validar_sesion_;
	public Recordar_contrasena _unnamed_Recordar_contrasena_;
	public int modo;
	
	iUsuario_No_Registrado iuno=new DB_Main();
	iAdministrador iadm=new DB_Main();
	
	
	public Iniciar_Sesion() {
		salir.addClickListener(new NativeButton.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_usuarios());
			}
		});
		iniciar.addClickListener(new NativeButton.ClickListener() {
			public void buttonClick(ClickEvent event) {
				com.mds.database.Usuario usu=iniciarSesion();
				if(usu!=null) login(usu);
				else Notification.show("Usuario o contraseña incorrecto/s","",Notification.TYPE_ERROR_MESSAGE);
			}
		});
	}

	public com.mds.database.Usuario iniciarSesion() {
		return  iuno.iniciarSesion(nombre.getValue(), contrasena.getValue());
	}

	public void recordarContrasena() {
		throw new UnsupportedOperationException();
	}
	
	public void login(com.mds.database.Usuario usu) {
		Comun_registrados ur=new Comun_registrados(usu);
		
		setContent(ur);
	}
	
	
	
	

}
