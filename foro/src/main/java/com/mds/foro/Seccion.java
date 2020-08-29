package com.mds.foro;

import java.io.Serializable;
import com.mds.database.Secciones;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Seccion extends Seccion_ventana implements Serializable {
	com.mds.database.Usuario usu=MyUI.sesionUsuario;
	iAdministrador iadm = new DB_Main();
	Secciones seccion;

	public Seccion(com.mds.database.Secciones sec) {

		Iniciar_Sesion.pagina="seccion/"+sec.getORMID();
		
		if(usu==null) borrarSeccion.setVisible(false);
		else if(usu.getORMID()!=1) borrarSeccion.setVisible(false);
		
		seccion = sec;

		this.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				MyUI.navigator.navigateTo("seccion/"+sec.getORMID());
			}
		});
		
		nombreSeccion1.setValue(sec.getNombre());
		fechaCreacionSeccion.setValue("Creado el: " + sec.getFechaSeccion());
		borrarSeccion.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				borrarSeccion();
			}
		});
		if (iadm.cargarTema(sec) == null)
			numeroTemas.setValue("" + 0);
		else
			numeroTemas.setValue("" + iadm.cargarTema(sec).length);

	}

	public void borrarSeccion() {
		iadm.borrarSeccion(seccion.getORMID());
	}
}