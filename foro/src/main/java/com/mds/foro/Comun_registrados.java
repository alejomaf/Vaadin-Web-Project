package com.mds.foro;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_registrados;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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
		
		nombreUsuario.setValue(usu.getNombre_usuario());		
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
				nombreSeccion1.setValue(secciones[primeraSeccion].getNombre());
				nombreSeccion1.add
				nombreSeccion1.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						borrarSeccion();					}
				});
//				fechaCreacionSeccion.setValue(secciones[primeraSeccion].cogerFecha);
				borrarSeccion.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						borrarSeccion();					}
				});
//				numeroTemas.setValue(Metodo para cargar numero de temas);
//				numeroMensajesEnSeccion.setValue(Metodo para cargar numero de mensajes);
				
				primeraSeccion++;
				
				nombreSeccion2.setValue(secciones[primeraSeccion].getNombre());
//				fechaCreacionSeccion1.setValue(secciones[primeraSeccion].cogerFecha);
				borrarSeccion1.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						borrarSeccion();					}
				});
//				numeroTemas1.setValue(Metodo para cargar numero de temas);
//				numeroMensajesEnSeccion1.setValue(Metodo para cargar numero de mensajes);
			}
			else{
				nombreSeccion1.setValue(secciones[primeraSeccion].getNombre());
//				fechaCreacionSeccion.setValue(secciones[primeraSeccion].cogerFecha);
				borrarSeccion.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						borrarSeccion();					}
				});
//				numeroTemas.setValue(Metodo para cargar numero de temas);
//				numeroMensajesEnSeccion.setValue(Metodo para cargar numero de mensajes);
			}
		}
		else {
			nombreSeccion1.setValue(secciones[primeraSeccion].getNombre());
//			fechaCreacionSeccion.setValue(secciones[primeraSeccion].cogerFecha);
			borrarSeccion.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					borrarSeccion();
				}
			});
//			numeroTemas.setValue(Metodo para cargar numero de temas);
//			numeroMensajesEnSeccion.setValue(Metodo para cargar numero de mensajes);
			
			primeraSeccion++;
			
			nombreSeccion2.setValue(secciones[primeraSeccion].getNombre());
//			fechaCreacionSeccion1.setValue(secciones[primeraSeccion].cogerFecha);
			borrarSeccion1.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					borrarSeccion();
				}
			});
//			numeroTemas1.setValue(Metodo para cargar numero de temas);
//			numeroMensajesEnSeccion1.setValue(Metodo para cargar numero de mensajes);
			
			primeraSeccion++;
			
			nombreSeccion3.setValue(secciones[primeraSeccion].getNombre());
//			fechaCreacionSeccion2.setValue(secciones[primeraSeccion].cogerFecha);
			borrarSeccion2.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					borrarSeccion();				}
			});
//			numeroTemas2.setValue(Metodo para cargar numero de temas);
//			numeroMensajesEnSeccion2.setValue(Metodo para cargar numero de mensajes);
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
	
}