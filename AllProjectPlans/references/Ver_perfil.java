package com.mds.foro;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Ver_perfil extends Usuario {
	
	
	
	public Ver_perfil(com.mds.database.Usuario usu, int i) {
		super(usu, i);
		com.mds.database.Usuario usuario = MyUI.sesionUsuario;
		
			verUltimosMensajes.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					verUltimosMensajes.setEnabled(false);
					Ver_ultimos_mensajes verUlt= new Ver_ultimos_mensajes(usu);
					if(!Comun_privilegiados.isPrivilegiado(usuario)) verUlt.cambiarNMensajes.setVisible(false);
					verUlt.cerrar.addClickListener(new Button.ClickListener() {
						@Override
						public void buttonClick(ClickEvent event) {
							componentes.removeComponent(verUlt);
							verUltimosMensajes.setEnabled(true);
						}
					});
					componentes.addComponent(verUlt);
				}
			});
			
			if(!Administrador.isAdministrador(usu)) verUltimosMensajes.setVisible(true);
		
		
		if (Administrador.isAdministrador(usuario)) {
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
			if (Moderador.isModerador(usu)) {
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
		} else if (Moderador.isModerador(usu)) {
			
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