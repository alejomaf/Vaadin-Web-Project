package com.mds.foro;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

import org.orm.PersistentException;

import com.mds.database.SeccionesDAO;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_registrados;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.declarative.Design;

public class Comun_registrados extends Comun_registrados_ventana implements Serializable{
	public iComun_registrados _iComun_registrados;
	public Notificaciones _unnamed_Notificaciones_;
	
	com.mds.database.Usuario usu;
	com.mds.database.Secciones[] secciones;
	public int pagAct=1;
	public int maxPag;
	public int secUlt;
	iAdministrador iadm=new DB_Main();
	int primeraSeccion;
	
	public int modo;
	
	public Comun_registrados(com.mds.database.Usuario usu) {
		
		this.usu=usu;
		if(usu.getORMID()==1) modo=0;
		else if(usu.getModerador()==true) modo=1;
		else modo=2;
		
		nombreUsuario.setValue(usu.getEmail());		
		inicializarBotones();
		switch(modo) {
		
		case 0: 
			componentesAdministrador();
			break;
		}

		cargarSecciones();

	}
	
	public void inicializarBotones() {
		cerrarSesion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_usuarios());
			}
		});
		notificaciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
			}
		});
		crearSeccion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				crearSeccion();
			}
		});
		
		pagAdeSecciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAdelante();
			}
		});
		
		pagAtraSecciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAtras();
			}
		});
	}
	
	public void componentesAdministrador() {
		
		ajustes.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cuadroPrincipal.addComponent(new Ajustes_administrador());
			}
		});
		
	}
	
	public void crearSeccion() {
		if(!nombreSeccion.getValue().isEmpty())	iadm.crearSeccion(nombreSeccion.getValue());
		else Notification.show("Ingrese un título","",Notification.TYPE_ERROR_MESSAGE);

		cargarSecciones();
	}
	
	public void cargarSecciones() {
		secciones = iadm.cargarSecciones();
		
		configuracionSec();
		
		if(secciones==null) {
			cargarPartes(0);
			pagAdeSecciones.setVisible(false);
			return;
		}
		cargarPag();
	}
	
	public void cargarPartes(int num) {
		switch(num) {
		case 0: 
			seccion1.setVisible(false);
			seccion2.setVisible(false);
			seccion3.setVisible(false);
			break;
		case 1:
			seccion1.setVisible(true);
			seccion2.setVisible(false);
			seccion3.setVisible(false);
			break;
		case 2:
			seccion1.setVisible(true);
			seccion2.setVisible(true);
			seccion3.setVisible(false);
			break;
		case 3:
			seccion1.setVisible(true);
			seccion2.setVisible(true);
			seccion3.setVisible(true);
			break;
		}
	}
	
	public void configuracionSec() {
		if(secciones==null||secciones.length<=3) {
			maxPag=1;
			if(secciones==null) secUlt=0;
			else secUlt=secciones.length;
		}
		else if(secciones.length%3==0) {
			maxPag=(secciones.length/3);
			secUlt=3;
		}else {
			maxPag=((secciones.length/3)+1);
			secUlt=secciones.length%3;
		}
	}
	
	public void cargarPag() {
		if(pagAct==maxPag) {
			cargarPartes(secUlt);
			escrituraSec(pagAct, secUlt);
			pagAdeSecciones.setVisible(false);
			if (pagAct!=1) pagAtraSecciones.setVisible(true);
		}
		else {
			if(pagAct!=1) pagAtraSecciones.setVisible(true);
			else pagAtraSecciones.setVisible(false);
			pagAdeSecciones.setVisible(true);
			cargarPartes(3);
			escrituraSec(pagAct, 3);
		}
	}
	
	public void escrituraSec(int pag, int num){
		//Formula optimizada para calcular la posicion de la seccion
		primeraSeccion=3*(pag-1);
		
		if(num<3) {
			if(num==2) {
				asignarValores(nombreSeccion1, fechaCreacionSeccion, borrarSeccion, numeroTemas, numeroMensajesEnSeccion, seccion1);		
				primeraSeccion++;
				asignarValores(nombreSeccion2, fechaCreacionSeccion1, borrarSeccion1, numeroTemas1, numeroMensajesEnSeccion1, seccion2);
			}
			else asignarValores(nombreSeccion1, fechaCreacionSeccion, borrarSeccion, numeroTemas, numeroMensajesEnSeccion, seccion1);
		}
		else {
			asignarValores(nombreSeccion1, fechaCreacionSeccion, borrarSeccion, numeroTemas, numeroMensajesEnSeccion, seccion1);	
			primeraSeccion++;	
			asignarValores(nombreSeccion2, fechaCreacionSeccion1, borrarSeccion1, numeroTemas1, numeroMensajesEnSeccion1, seccion2);
			primeraSeccion++;
			asignarValores(nombreSeccion3, fechaCreacionSeccion2, borrarSeccion2, numeroTemas2, numeroMensajesEnSeccion2, seccion3);
		}
		
	}
	
	public void pagAdelante() {
		pagAct++;
		cargarPag();
	}
	
	public void pagAtras() {
		pagAct--;
		cargarPag();
	}
	
	public void borrarSeccion() {
		iadm.borrarSeccion(secciones[primeraSeccion].getORMID());
		setContent(new Comun_registrados(usu));
	}
	
	public void asignarValores(Label nombreS, Label fechaC, Button borrarS, Label numeroT, Label numeroM, HorizontalLayout seccion) {
		com.mds.database.Secciones secAux=secciones[primeraSeccion];
		seccion.addLayoutClickListener(new LayoutClickListener() {
			public void layoutClick(LayoutClickEvent event) {
					setContent(new Seccion(usu,secAux));
			}
		});
		nombreS.setValue(secAux.getNombre());
//		fechaC.setValue(secciones[primeraSeccion].cogerFecha);
		borrarS.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				borrarSeccion();				}
		});
//		numeroT.setValue(Metodo para cargar numero de temas);
//		numeroM.setValue(Metodo para cargar numero de mensajes);
	}
	
}