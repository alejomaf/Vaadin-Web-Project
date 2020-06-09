package com.mds.foro;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

import org.orm.PersistentException;

import com.mds.database.SeccionesDAO;
import com.mds.database.TemasDAO;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.mds.interfaz.iComun_registrados;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
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
	int primeraSeccion;
	iAdministrador iadm=new DB_Main();
	iComun_privilegiados icp=new DB_Main();
	public int pagActNot=1;
	com.mds.database.Notificaciones[] notis;
	int primeraNotificacion;
	public int maxPagNot;
	public int secUltNot;
	
	public int modo;
	
	public Comun_registrados(com.mds.database.Usuario usu) {
		
		this.usu=usu;
		if(usu==null) {
			usuarioNoRegistrado(); 
			cargarSecciones();
			cargarTemas();
			cargarMensajes();
			return;
			}
		if(usu.getORMID()==1) modo=0;
		else if(usu.getModerador()==true) modo=1;
		else modo=2;
		
		nombreUsuario.setValue(usu.getEmail());
		switch(modo) {
		
		case 0:
			inicializarBotones();
			break;
		case 1:
			inicializarBotones();
			componentesUsuario();
			break;
		case 2:
			inicializarBotones();
			componentesUsuario();
			break;
		}

		cargarSecciones();
		cargarTemas();
		cargarMensajes();
	}
	
	public void usuarioNoRegistrado() {
		componentesUsuario();
		notificaciones.setVisible(false);
		cerrarSesion.setVisible(false);
		ajustes.setVisible(false);
		iniciarSesion.setVisible(true);
		registrarse.setVisible(true);
		
		iniciarSesion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Iniciar_Sesion());
			}
		});
		registrarse.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Registrarse());
			}
		});
	}
	
	public void cargarTemas() {
		com.mds.database.Temas[] tem=iadm.cargarTemasRecientes();
		if(tem==null) return;
		
		if(tem.length>=3) {
			cargarPartesTema(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tem[0], tema1);
			cargarPartesTema(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1, numeroComentariosTema1, numeroLikesTema1, tem[1], tema2);
			cargarPartesTema(nombreTema2, usuarioCreadorTema2, borrarTema2, ultimoMensaje2, diaEnviado2, numeroComentariosTema2, numeroLikesTema2, tem[2], tema3);
		}else if (tem.length==2){
			cargarPartesTema(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tem[0], tema1);
			cargarPartesTema(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1, numeroComentariosTema1, numeroLikesTema1, tem[1], tema2);
		}else if(tem.length==1) {
			cargarPartesTema(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tem[0], tema1);
		}else {
		}
	}
	
	public void cargarMensajes() {
		com.mds.database.Mensaje[] men=iadm.cargarMensajesRecientes();
		if(men==null) return;
		
		if(men.length>=3) {
			cargarPartesMensaje(contenidoInicial, usuarioCreadorMensaje, borrarMensaje, temaPerteneciente, horaYDiaMensaje, numLikesMensaje, men[0], mensaje1);
			cargarPartesMensaje(contenidoInicial1, usuarioCreadorMensaje1, borrarMensaje1, temaPerteneciente1, horaYDiaMensaje1, numLikesMensaje1, men[1], mensaje2);
			cargarPartesMensaje(contenidoInicial2, usuarioCreadorMensaje2, borrarMensaje2, temaPerteneciente2, horaYDiaMensaje2, numLikesMensaje2, men[2], mensaje3);
		}else if(men.length==2) {
			cargarPartesMensaje(contenidoInicial, usuarioCreadorMensaje, borrarMensaje, temaPerteneciente, horaYDiaMensaje, numLikesMensaje, men[0], mensaje1);
			cargarPartesMensaje(contenidoInicial1, usuarioCreadorMensaje1, borrarMensaje1, temaPerteneciente1, horaYDiaMensaje1, numLikesMensaje1, men[1], mensaje2);
		}else if(men.length==1) {
			cargarPartesMensaje(contenidoInicial, usuarioCreadorMensaje, borrarMensaje, temaPerteneciente, horaYDiaMensaje, numLikesMensaje, men[0], mensaje1);
		}else {
			
		}
	}
	
	public void cargarPartesTema(Label nomT, Label usuC, Button borrarT, Label ultMen, Label diaT, Label numCom, Label numLikes, com.mds.database.Temas tem, HorizontalLayout tema) {
		tema.setVisible(true);
		tema.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				setContent(new Tema(usu, tem.getPertenece_a(), tem));
			}
		});
		com.mds.database.Temas temaAux=tem;
		nomT.setValue(temaAux.getNombre());
		usuC.setValue(temaAux.getCreado_por().getNombre_completo());
		borrarT.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				icp.Eliminar_tema(temaAux.getORMID());
				setContent(new Comun_registrados(usu));
			}
		});
		if(iadm.cargarMensajes(temaAux.getORMID())!=null) {
			ultMen.setValue(iadm.cargarMensajes(temaAux.getORMID())[0].getPertenece_a().getNombre_completo());
			numCom.setValue(""+iadm.cargarMensajes(temaAux.getORMID()).length);
			diaT.setValue(""+iadm.cargarMensajes(temaAux.getORMID())[0].getFechaMensaje());
		}
		else {
			ultMen.setValue("Nadie");
			numCom.setValue(""+0);
			diaT.setVisible(false);
		}
		numLikes.setValue(""+temaAux.getNum__likes());
	}
	
	public void cargarPartesMensaje(Label contI, Label usuC, Button borrarMensaje, Label temaPertenece, Label diaM, Label numLikes, com.mds.database.Mensaje men, HorizontalLayout mensaje1) {
		mensaje1.setVisible(true);
		com.mds.database.Mensaje mensajeAux=men;
		
		if(mensajeAux.getContenido().length()>=15) contI.setValue(mensajeAux.getContenido().substring(0, 15));
		else contI.setValue(mensajeAux.getContenido());
		
		usuC.setValue(mensajeAux.getPertenece_a().getNombre_completo());
		
		borrarMensaje.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				icp.Eliminar_mensaje(mensajeAux.getORMID());
				setContent(new Comun_registrados(usu));
			}
		});
		temaPertenece.setValue(mensajeAux.getSon_de().getNombre());
		diaM.setValue(""+mensajeAux.getFechaMensaje());
		numLikes.setValue(""+mensajeAux.getNum_likes());
	}

	public void inicializarBotones() {
		cerrarSesion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_registrados(null));
			}
		});
		notificaciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargaNotificaciones();
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
		ajustes.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu, 1));
			}
		});
		
		notificacionAdelante.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAdelanteNot();
			}
		});
		
		notificacionAtras.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAtrasNot();
			}
		});
	}
	public void componentesUsuario() {
		cuadroSeccion.setVisible(false);
		
		borrarSeccion.setVisible(false);
		borrarSeccion1.setVisible(false);
		borrarSeccion2.setVisible(false);
		
		borrarTema.setVisible(false);
		borrarTema1.setVisible(false);
		borrarTema2.setVisible(false);
		
		borrarMensaje.setVisible(false);
		borrarMensaje1.setVisible(false);
		borrarMensaje2.setVisible(false);
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
				asignarValores(nombreSeccion1, fechaCreacionSeccion, borrarSeccion, numeroTemas, seccion1);		
				primeraSeccion++;
				asignarValores(nombreSeccion2, fechaCreacionSeccion1, borrarSeccion1, numeroTemas1, seccion2);
			}
			else asignarValores(nombreSeccion1, fechaCreacionSeccion, borrarSeccion, numeroTemas, seccion1);
		}
		else {
			asignarValores(nombreSeccion1, fechaCreacionSeccion, borrarSeccion, numeroTemas, seccion1);	
			primeraSeccion++;	
			asignarValores(nombreSeccion2, fechaCreacionSeccion1, borrarSeccion1, numeroTemas1, seccion2);
			primeraSeccion++;
			asignarValores(nombreSeccion3, fechaCreacionSeccion2, borrarSeccion2, numeroTemas2, seccion3);
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
	
	public void asignarValores(Label nombreS, Label fechaC, Button borrarS, Label numeroT, HorizontalLayout seccion) {
		com.mds.database.Secciones secAux=secciones[primeraSeccion];
		seccion.addLayoutClickListener(new LayoutClickListener() {
			public void layoutClick(LayoutClickEvent event) {
					setContent(new Seccion(usu,secAux));
			}
		});
		nombreS.setValue(secAux.getNombre());
		fechaC.setValue("Creado el: "+secAux.getFechaSeccion());
		borrarS.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				borrarSeccion();				}
		});
		if(iadm.cargarTema(secAux)==null) numeroT.setValue(""+0);
		else numeroT.setValue(""+iadm.cargarTema(secAux).length);
		
	}
	
	public void cargaNotificaciones() {
		notis=iadm.cargarNotificaciones(usu.getORMID());
		if(listaNotificaciones.isVisible()) {
			listaNotificaciones.setVisible(false);
		}else {
			if(notis==null) return;
			listaNotificaciones.setVisible(true);
			cargarListaNotificaciones();
		}
	}
	public void cargarListaNotificaciones() {
		configuracionNot();
		cargarPagNot();
	}
	
	public void cargarPartesNotificaciones(int num) {
		notificacion1.setVisible(false);
		notificacion2.setVisible(false);
		notificacion3.setVisible(false);
		switch(num) {
		case 0: 
			break;
		case 1:
			notificacion1.setVisible(true);
			break;
		case 2:
			notificacion1.setVisible(true);
			notificacion2.setVisible(true);
			break;
		case 3:
			notificacion1.setVisible(true);
			notificacion2.setVisible(true);
			notificacion3.setVisible(true);
			break;
		}
	}
	
	public void configuracionNot() {
		if(notis==null||notis.length<=3) {
			maxPagNot=1;
			if(notis==null) secUltNot=0;
			else secUltNot=notis.length;
		}
		else if(notis.length%3==0) {
			maxPagNot=(notis.length/3);
			secUltNot=3;
		}else {
			maxPagNot=((notis.length/3)+1);
			secUltNot=notis.length%3;
		}
	}
	
	public void cargarPagNot() {
		if(pagActNot==maxPagNot) {
			cargarPartesNotificaciones(secUltNot);
			escrituraNot(pagActNot, secUltNot);
			notificacionAdelante.setVisible(false);
			if (pagActNot!=1) notificacionAtras.setVisible(true);
		}
		else {
			if(pagActNot!=1) notificacionAtras.setVisible(true);
			else notificacionAtras.setVisible(false);
			notificacionAdelante.setVisible(true);
			cargarPartesNotificaciones(3);
			escrituraNot(pagActNot, 3);
		}
	}
	
	public void escrituraNot(int pag, int num){
		//Formula optimizada para calcular la posicion de la seccion
		primeraNotificacion=3*(pag-1);
		
		if(num<3) {
			if(num==2) {
				asignarValoresNotificaciones(tituloNotificacion, eliminarNotificacion, aceptarNotificacion, visualizarNotificacion, notificacion1);		
				primeraNotificacion++;
				asignarValoresNotificaciones(tituloNotificacion1, eliminarNotificacion1, aceptarNotificacion1, visualizarNotificacion1, notificacion2);	
			}	
			else asignarValoresNotificaciones(tituloNotificacion, eliminarNotificacion, aceptarNotificacion, visualizarNotificacion, notificacion1);	
		}
		else {
			asignarValoresNotificaciones(tituloNotificacion, eliminarNotificacion, aceptarNotificacion, visualizarNotificacion, notificacion1);		
			primeraNotificacion++;
			asignarValoresNotificaciones(tituloNotificacion1, eliminarNotificacion1, aceptarNotificacion1, visualizarNotificacion1, notificacion2);
			primeraNotificacion++;
			asignarValoresNotificaciones(tituloNotificacion2, eliminarNotificacion2, aceptarNotificacion2, visualizarNotificacion2, notificacion3);		
		}
		
	}
	
	public void pagAdelanteNot() {
		pagActNot++;
		cargarPagNot();
	}
	
	public void pagAtrasNot() {
		pagActNot--;
		cargarPagNot();
	}
	
	public void asignarValoresNotificaciones(Label tituloN, Button elimN, Button acepN, Button visuN, HorizontalLayout barra) {
		com.mds.database.Notificaciones not=notis[primeraNotificacion];
		barra.setVisible(true);
		
		String[] descom=not.getTitulo().split(",");
		
		if(not.getEnlace().equals("amistad")) {
			tituloN.setValue(descom[0]);
			elimN.setVisible(true);
			elimN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					iadm.borrarNotificacion(not.getORMID());
					cargaNotificaciones();
				}
			});
			acepN.setVisible(true);
			acepN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					iadm.aceptarSolicitud(usu.getORMID(), Integer.parseInt(descom[1]));
					cargaNotificaciones();
				}
			});
		}else {
			tituloN.setValue(descom[0]+" en: "+iadm.cargarTema(Integer.parseInt(descom[1])).getNombre());
			elimN.setVisible(true);
			elimN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					iadm.borrarNotificacion(not.getORMID());
					cargarListaNotificaciones();
				}
			});
			visuN.setVisible(true);
			visuN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					setContent(new Tema(usu, iadm.cargarTema(Integer.parseInt(descom[1])).getPertenece_a() , iadm.cargarTema(Integer.parseInt(descom[1]))));
					iadm.borrarNotificacion(not.getORMID());
				}
			});
		}
		
	}
	
}