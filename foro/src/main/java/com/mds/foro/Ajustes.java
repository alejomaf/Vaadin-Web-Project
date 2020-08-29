package com.mds.foro;

import java.io.File;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_registrados;
import com.mds.interfaz.iComun_usuarios;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Ajustes extends Ajustes_ventana implements View {

	iAdministrador iadm = new DB_Main();
	public iComun_usuarios icu = new DB_Main();
	iUsuario_No_Registrado iuno = new DB_Main();
	public com.mds.database.Usuario[] usuarios;
	public com.mds.database.Usuario usu;
	public int modo;
	public static int vis=1;
	public int pagAct = 1;
	public int maxPag;
	public int numEleUltPos;
	public int tipoLista;

	public Ajustes() {
		this.usu = MyUI.sesionUsuario;

		nombreUsuario.setValue(usu.getEmail());

		inicializarBotones();

		switch (vis) {

		case 1:
			perfil();
			break;
		case 2:
			listaUsuarios();
			break;
		case 3:
			amigos();
			break;
		case 4:
			usuariosReportados();
			break;
		case 5:
			usuariosBaneados();
			break;
		}
	}

	public void inicializarBotones() {
		
		//Barra lateral de ajustes
		Ajustes_registrado areg=new Ajustes_registrado();
		
		if(usu.getORMID()==1) {
			areg.addComponent((new Ajustes_moderador()).usuariosReportados);
			areg.addComponent((new Administrador()).usuariosBaneados);
		}else if(usu.getModerador()) areg.addComponent((new Ajustes_moderador()).usuariosReportados);

		tipoAjuste.addComponent(areg);
		
		//Barra superior
		Notificaciones auxNot = new Notificaciones(iadm.cargarNotificaciones(usu.getORMID()));
		Usuario_Registrado ur = new Usuario_Registrado();
		Comun_registrados cr=new Comun_registrados();
		auxNot.barraBotones.addComponent(cr.inicio);
		auxNot.barraBotones.addComponent(ur.cerrarSesion);
		
		tipoUsuario.addComponent(auxNot);
		
		pagAdeUsu.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAde();
				cargarPagina();
			}
		});

		pagAntUsu.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAtr();
				cargarPagina();
			}
		});
	}

	public void perfil() {
		
		pagAdeUsu.setVisible(false);
		pagAntUsu.setVisible(false);
		

		Usuario usuAux=new Usuario(usu,0);
		
		datos.addComponent(usuAux);

	}

	public void listaUsuarios() {
		movimientoPaginas.setVisible(true);

		pagAct = 1;
		cargarUsuarios(1);
	}

	public void amigos() {
		movimientoPaginas.setVisible(true);

		pagAct = 1;
		cargarUsuarios(2);
	}

	public void usuariosReportados() {
		movimientoPaginas.setVisible(true);

		pagAct = 1;
		cargarUsuarios(3);
	}

	public void usuariosBaneados() {
		movimientoPaginas.setVisible(true);

		pagAct = 1;
		cargarUsuarios(4);
	}

	public void pagAde() {
		pagAct++;
		pagAntUsu.setVisible(true);
		if (pagAct == maxPag)
			pagAdeUsu.setVisible(false);
	}

	public void pagAtr() {
		pagAct--;
		pagAdeUsu.setVisible(true);
		if (pagAct == 1)
			pagAntUsu.setVisible(false);
	}

	public void cargarUsuarios(int a) {
		
		datos.removeAllComponents();
		
		tipoLista = a;
		switch (a) {
		case 1:
			usuarios = iadm.cargarUsuarios(usu.getORMID());
			break;
		case 2:
			usuarios = iadm.cargarAmigos(usu.getORMID());
			break;
		case 3:
			usuarios = iadm.cargarUsuariosReportados();
			break;
		case 4:
			usuarios = iadm.cargarUsuariosBaneados();
			break;
		}

		if (usuarios == null) {

		} else if (usuarios.length > 10) {
			maxPag = usuarios.length / 10;
			numEleUltPos = usuarios.length % 10;
			pagAdeUsu.setVisible(true);
		} else {
			maxPag = 1;
			numEleUltPos = usuarios.length;
		}
		cargarPagina();
	}

	public void cargarPagina() {
		int numV = 0;
		int posI = 0;

		if (maxPag == pagAct) {
			numV = numEleUltPos;
			posI = 10 * (pagAct - 1);
		} else {
			numV = 10;
			posI = 10 * (pagAct - 1);
		}

		switch (tipoLista) {
		case 1:
			datos.addComponent(new UsuariosReg(numV, posI, usuarios));
			break;
		case 2:
			datos.addComponent(new Amigos(numV, posI, usuarios));
			break;
		case 3:
			datos.addComponent(new Usuarios_Para_Revision(numV, posI, usuarios));
			break;
		case 4:
			datos.addComponent(new UsuariosAdm(numV, posI, usuarios));
			break;
		}
	}


}