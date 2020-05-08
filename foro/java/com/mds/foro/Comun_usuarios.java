package com.mds.foro;

import com.vaadin.ui.declarative.Design;

//import basededatos.iComun_usuarios;

public class Comun_usuarios extends Comun_usuarios_ventana{
	//public iComun_usuarios _iComun_usuarios;
	public Logo _unnamed_Logo_;
	public Secciones _unnamed_Secciones_;
	
	public Comun_usuarios() {
			Secciones sec=new Secciones();
			cuadroPrincipal.addComponent(sec);
			this.setContent(cuadroPrincipal);
			Design.read(this);
	}
}