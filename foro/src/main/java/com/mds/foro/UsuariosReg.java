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

public class UsuariosReg extends UsuariosReg_ventana{
	
	iModerador imo=new DB_Main();
	iAdministrador iadm=new DB_Main();
	iUsuario_No_Registrado iuno=new DB_Main();
	iUsuario_Registrado iure=new DB_Main();
	com.mds.database.Usuario usuario;
	
	public UsuariosReg(com.mds.database.Usuario usu, int i, int posI, com.mds.database.Usuario[] lista) {
		usuario=usu;
		if(lista!=null) prepararLista(i, posI, lista);
	}
	
	public void prepararLista(int i, int posI, com.mds.database.Usuario[] lista) {
		int pos=posI;
		if(i>=1) {
			configurarFila(filaUsuario, lista[pos]);
			correoUsuario(correoUsuario, lista[pos]);
			anadirAmigo(anadirAmigo, lista[pos]);
		}
		pos++;
		if(i>=2) {
			configurarFila(filaUsuario1, lista[pos]);
			correoUsuario(correoUsuario1, lista[pos]);
			anadirAmigo(anadirAmigo1, lista[pos]);
		}
		pos++;
		if(i>=3) {
			configurarFila(filaUsuario2, lista[pos]);
			correoUsuario(correoUsuario2, lista[pos]);
			anadirAmigo(anadirAmigo2, lista[pos]);
		}
		pos++;
		if(i>=4) {
			configurarFila(filaUsuario3, lista[pos]);
			correoUsuario(correoUsuario3, lista[pos]);
			anadirAmigo(anadirAmigo3, lista[pos]);
		}
		pos++;
		if(i>=5) {
			configurarFila(filaUsuario4, lista[pos]);
			correoUsuario(correoUsuario4, lista[pos]);
			anadirAmigo(anadirAmigo4, lista[pos]);
		}
		pos++;
		if(i>=6) {
			configurarFila(filaUsuario5, lista[pos]);
			correoUsuario(correoUsuario5, lista[pos]);
			anadirAmigo(anadirAmigo5, lista[pos]);
		}
		pos++;
		if(i>=7) {
			configurarFila(filaUsuario6, lista[pos]);
			correoUsuario(correoUsuario6, lista[pos]);
			anadirAmigo(anadirAmigo6, lista[pos]);
		}
		pos++;
		if(i>=8) {
			configurarFila(filaUsuario7, lista[pos]);
			correoUsuario(correoUsuario7, lista[pos]);
			anadirAmigo(anadirAmigo7, lista[pos]);
		}
		pos++;
		if(i>=9) {
			configurarFila(filaUsuario8, lista[pos]);
			correoUsuario(correoUsuario8, lista[pos]);
			anadirAmigo(anadirAmigo8, lista[pos]);
		}
		pos++;
		if(i>=10) {
			configurarFila(filaUsuario9, lista[pos]);
			correoUsuario(correoUsuario9, lista[pos]);
			anadirAmigo(anadirAmigo9, lista[pos]);
		}
	}
	
	public void configurarFila(HorizontalLayout fil, com.mds.database.Usuario usu) {
		fil.setVisible(true);
		cerrarVista.setVisible(false);
		fil.addLayoutClickListener(new LayoutClickListener(){
			@Override
			public void layoutClick(LayoutClickEvent event) {
				cargarUsuario(usu);
	}});
	}
	
	public void cargarUsuario(com.mds.database.Usuario usu) {
		cerrarVista.setVisible(true);
		VerticalLayout vl=new VerticalLayout();
		Ajustes_ventana vlAux=new Ajustes_ventana();
		
		vlAux.nombreCompleto.setValue(usu.getNombre_completo());
		vlAux.descripcion.setValue(usu.getDescripcion());
		vlAux.email.setValue(usu.getEmail());
		FileResource resource = new FileResource(new File(usu.getFoto()));
		vlAux.fotoUsuario.setSource(resource);
		vl.addComponent(vlAux.informacionUsuario);
		
		configurarBoton(usu);
		
		cargaUsuario.removeAllComponents();
		cargaUsuario.addComponent(vl);
		cerrarVista.setVisible(true);
		cerrarVista.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargaUsuario.removeAllComponents();
				cerrarVista.setVisible(false);
				desbanear.setVisible(false);
				banear.setVisible(false);
				reportar.setVisible(false);
				quitarReporte.setVisible(false);
				hacerModerador.setVisible(false);
				quitarModerador.setVisible(false);
			}
		});
	}
	
	public void configurarBoton(com.mds.database.Usuario usu) {
		desbanear.setVisible(false);
		banear.setVisible(false);
		reportar.setVisible(false);
		quitarReporte.setVisible(false);
		hacerModerador.setVisible(false);
		quitarModerador.setVisible(false);
		
		if (usuario.getORMID()==1) {
			if(usu.getEliminado()) {
				desbanear.setVisible(true);
				desbanear.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						iadm.Desbanear(usu.getORMID());
						recargarUsuario(usu);
					}
				});
			}else {
				banear.setVisible(true);
				banear.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						iadm.Banear(usu.getORMID());
						recargarUsuario(usu);
					}
				});
			}
			if(usu.getModerador()) {
				quitarModerador.setVisible(true);
				quitarModerador.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						iadm.Retirar_privilegios(usu.getORMID());
						recargarUsuario(usu);
					}
				});
			}else {
				hacerModerador.setVisible(true);
				hacerModerador.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						iadm.Conceder_privilegios(usu.getORMID());
						recargarUsuario(usu);
					}
				});
			}
		}else if(usuario.getModerador()) {
			if(usuario.getReportado()) {
				quitarReporte.setVisible(true);
				quitarReporte.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						imo.Desmarcar(usu.getORMID());
						recargarUsuario(usu);
					}
				});
			}else {
				reportar.setVisible(true);
				reportar.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						imo.Marcar(usu.getORMID());
						recargarUsuario(usu);
					}
				});
			}
		}
	}
	
	public void recargarUsuario(com.mds.database.Usuario usu) {
				cargaUsuario.removeAllComponents();
				cargarUsuario(iuno.iniciarSesion(usu.getEmail(), usu.getContrasena()));
	}
		
	public void correoUsuario(Label lab, com.mds.database.Usuario usu) {
		lab.setValue(usu.getEmail());
	}
	
	public void anadirAmigo(Button but, com.mds.database.Usuario usu) {
		
		but.isDisableOnClick();
		but.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				iure.anadirAmigo(usuario, usu);
			}});
	}
}