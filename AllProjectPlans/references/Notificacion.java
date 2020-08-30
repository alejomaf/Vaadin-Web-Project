package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Notificacion extends Notificacion_ventana {


	iAdministrador iadm = new DB_Main();
	
	public Notificacion(com.mds.database.Notificaciones not) {
		
		String[] descom = not.getTitulo().split(",");

		if (not.getEnlace().equals("amistad")) {
			tituloNotificacion.setValue(descom[0]);
			
			aceptarNotificacion.setVisible(true);
			aceptarNotificacion.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					iadm.aceptarSolicitud(MyUI.sesionUsuario.getORMID(), Integer.parseInt(descom[1]));
					iadm.borrarNotificacion(not.getORMID());
					Page.getCurrent().reload();
				}
			});
		} else {
			tituloNotificacion
					.setValue(descom[0] + " en: " + iadm.cargarTema(Integer.parseInt(descom[1])).getNombre());
			visualizarNotificacion.setVisible(true);
			visualizarNotificacion.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					MyUI.navigator.navigateTo("seccion/"+iadm.cargarTema(Integer.parseInt(descom[1])).getPertenece_a().getORMID()+"/tema/"+iadm.cargarTema(Integer.parseInt(descom[1])));
					iadm.borrarNotificacion(not.getORMID());
					Page.getCurrent().reload();
				}
			});
		}

	}
}