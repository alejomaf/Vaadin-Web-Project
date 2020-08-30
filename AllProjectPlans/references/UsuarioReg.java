package com.mds.foro;

import com.mds.database.Usuario;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_usuarios;
import com.mds.interfaz.iModerador;
import com.mds.interfaz.iUsuario_Registrado;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component.Event;

public class UsuarioReg extends UsuarioReg_ventana {
	private Event _enviar_solicitud_amistad;
	public UsuariosReg _usuariosReg;
	iUsuario_Registrado iure = new DB_Main();
	com.mds.database.Usuario usuario;
	iModerador imo = new DB_Main();
	iAdministrador iadm = new DB_Main();
	

	public UsuarioReg(Usuario usu, int i) {
		correoUsuario.setValue(usu.getEmail());
		usuario=MyUI.sesionUsuario;
		
		switch(i) {
		
		case 1:
			anadirAmigo.setVisible(true);
			anadirAmigo(usu);
			break;
		case 2:
			banear(usu);
			break;
		case 3:
			desbanear(usu);
			break;
		case 4:
			eliminarAmigo(usu);
			break;
		
		}
		
		configurarFila(usu);
	}

	public void eliminarAmigo(Usuario usu) {
		eliminarAmigo.setDisableOnClick(true);
		eliminarAmigo.setVisible(true);
		eliminarAmigo.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Amigo.eliminarAmigo(usuario, usu);
			}
		});	
	}
	
	public void desbanear(Usuario usu) {
		desbanear.setDisableOnClick(true);
		desbanear.setVisible(true);
		desbanear.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				iadm.Desbanear(usu.getORMID());
			}
		});
	}

	private void banear(Usuario usu) {
		
		if (usuario.getModerador()) {
			banear.setVisible(false);
			quitarReporte.setVisible(true);
			quitarReporte.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					imo.Desmarcar(usu.getORMID());
				}
			});
		} else {
			banear.setVisible(true);
			quitarReporte.setVisible(false);
			banear.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					iadm.Banear(usu.getORMID());
				}
			});
		}
	}

	private void anadirAmigo(Usuario usu) {
		anadirAmigo.setVisible(true);
		anadirAmigo.isDisableOnClick();
		anadirAmigo.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				iure.anadirAmigo(MyUI.sesionUsuario, usu);
			}
		});
	}
	
	private void configurarFila(com.mds.database.Usuario usu) {
		
		com.mds.foro.Ver_perfil usuAux=new com.mds.foro.Ver_perfil(usu, 1);
		
		usuAux.cerrarVista.setVisible(true);
		
		usuAux.cerrarVista.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				cargaUsuario.removeComponent(usuAux);
			}
		});
		
		this.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				cargaUsuario.addComponent(usuAux);
			}
		});
		
	}

}