package com.mds.foro;

import java.io.File;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iModerador;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.mds.interfaz.iUsuario_Registrado;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

;

public class UsuariosReg extends UsuariosReg_ventana {

	iModerador imo = new DB_Main();
	iAdministrador iadm = new DB_Main();
	iUsuario_No_Registrado iuno = new DB_Main();
	iUsuario_Registrado iure = new DB_Main();
	com.mds.database.Usuario[] lista;

	public UsuariosReg(int numU, int posI, com.mds.database.Usuario[] lista) {
		this.lista=lista;
		if (lista != null) prepararLista(numU, posI);
	}

	public void prepararLista(int numU, int posI) {
		int pos = posI;
		
		for(int i=0;i<numU;i++) {
			configurarUsuario(lista[pos]);
			pos++;
		}
	}

	public void configurarUsuario(com.mds.database.Usuario usu) {
		
		UsuarioReg usuAux=new UsuarioReg(usu,1);
		
		listaUsuarios.addComponent(usuAux);
	}
}