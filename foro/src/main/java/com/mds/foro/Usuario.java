package com.mds.foro;

import java.io.File;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iModerador;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Usuario extends Usuario_ventana {

	public String correo;
	public String pass;
	public String desc;
	public boolean isMod;
	public boolean isRep;
	public String photo;
	public String fullName;
	public boolean del;
	iModerador imo = new DB_Main();
	iAdministrador iadm = new DB_Main();

	public Usuario(com.mds.database.Usuario usu, int i) {

		correo = usu.getEmail();
		pass = usu.getContrasena();
		desc = usu.getDescripcion();
		isMod = usu.getModerador();
		isRep = usu.getReportado();
		photo = usu.getFoto();
		fullName = usu.getNombre_completo();
		del = usu.getEliminado();

		inicializarComponentes(usu);
		
		if (i==1) configurarBotones(usu);
		else configurarUsuario();
	}

	private void configurarUsuario() {

		configuracionUsuario.setVisible(true);
		/*
		 * Método modificar contraseña
		 */
		modificarContrasena.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Modificar_contrasena modCont = new Modificar_contrasena();
				
				modCont.salir.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						datosPerfil.setVisible(true);
						componentes.removeComponent(modCont);
						configuracionUsuario.setVisible(true);
					}
				});
				componentes.addComponent(modCont);
				datosPerfil.setVisible(false);
				configuracionUsuario.setVisible(false);
			}
		});

		/*
		 * Método modificar perfil
		 */
		modificarPerfil.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Modificar_perfil mp = new Modificar_perfil();
				mp.salir.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						datosPerfil.setVisible(true);
						componentes.removeComponent(mp);
						configuracionUsuario.setVisible(true);
					}
				});
				componentes.addComponent(mp);
				datosPerfil.setVisible(false);
				configuracionUsuario.setVisible(false);
			}
		});
	}

	public void inicializarComponentes(com.mds.database.Usuario usu) {

		nombreCompleto.setValue(fullName);
		email.setValue(correo);
		descripcion.setValue(desc);
		
		FileResource resource = new FileResource(new File(usu.getFoto()));
		fotoUsuario.setSource(resource);
		
	}

	private void configurarBotones(com.mds.database.Usuario usu) {
		
		com.mds.database.Usuario usuario = MyUI.sesionUsuario;
		
		if (usuario.getORMID() == 1) {
			if (usu.getEliminado()) {
				desbanear.setVisible(true);
				desbanear.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						iadm.Desbanear(usu.getORMID());
						cerrarVista.click();
					}
				});
			} else {
				banear.setVisible(true);
				banear.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						iadm.Banear(usu.getORMID());
						cerrarVista.click();
					}
				});
			}
			if (usu.getModerador()) {
				quitarModerador.setVisible(true);
				quitarModerador.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						iadm.Retirar_privilegios(usu.getORMID());
						cerrarVista.click();
					}
				});
			} else {
				hacerModerador.setVisible(true);
				hacerModerador.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						iadm.Conceder_privilegios(usu.getORMID());
						cerrarVista.click();
					}
				});
			}
		} else if (usuario.getModerador()) {
			if (usuario.getReportado()) {
				quitarReporte.setVisible(true);
				quitarReporte.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						imo.Desmarcar(usu.getORMID());
						cerrarVista.click();
					}
				});
			} else {
				reportar.setVisible(true);
				reportar.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						imo.Marcar(usu.getORMID());
						cerrarVista.click();
					}
				});
			}
		}
	}
}