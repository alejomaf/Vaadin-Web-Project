package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Registrarse extends Registrarse_ventana {
	private TextField _nombreUsuarioTF;
	private Label _nombreUsuarioL;
	private Label _contrasenaL;
	private TextField _contrasenaTF;
	private TextField _nombreCompletoTF;
	private Label _nombreCompletoL;
	private TextField _descripcionTF;
	private Label _descripcionL;
	private Button _fotoPerfilB;
	private Label _fotoPerfilL;
	private Label _adjuntarImagenL;
	private Button _registrarseB;
	private Label _registrarseL;
	public Usuario_No_Registrado _unnamed_Usuario_No_Registrado_;
	

	iUsuario_No_Registrado iuno=new DB_Main();


	public Registrarse() {
		
		salir.addClickListener(new NativeButton.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_usuarios());
			}
		});
		registrarse.addClickListener(new NativeButton.ClickListener() {
			public void buttonClick(ClickEvent event) {
				if(contrasena.getValue().equals(contrasena2.getValue()))
				registrarse();
				else Notification.show("No coinciden las contraseñas","",Notification.TYPE_ERROR_MESSAGE);
			}
		});
	}
	
	public void registrarse() {
		
		String name= nombreUsuario.getValue();
		String pass= contrasena.getValue();
		String cname= nombreCompleto.getValue();
		String description= descripcion.getValue();
		String mail= email.getValue();
		
		
		iuno.registrarse(name, pass, cname, description, "https://ae01.alicdn.com/kf/U34ae24960b034dc0b73a195aeb8ad303T.jpg_50x50.jpg", mail);
	}
}