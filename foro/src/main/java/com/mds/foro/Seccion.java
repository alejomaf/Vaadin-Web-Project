package com.mds.foro;

import java.util.List;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;

public class Seccion extends Seccion_ventana{
	private Label _foroL;
	private Label _nombreSeccionL;
	private Label _ayudaL;
	private Button _ayudaB;
	private Label _notificacionesL;
	private Button _notificacionesB;
	private Label _ajustesL;
	private Button _ajustesB;
	private Label _cerrarSesionL;
	private Button _cerrarSesionB;
	private TextField _buscarTF;
	private Button _verMasB;
	private Label _verMasL;
	private List _temas;

	public iComun_registrados _iComun_registrados;
	public Notificaciones _unnamed_Notificaciones_;
	
	com.mds.database.Usuario usu;
	com.mds.database.Secciones sec;
	com.mds.database.Temas[] temas;
	public int pagAct=1;
	public int maxPag;
	public int secUlt;
	iAdministrador iadm=new DB_Main();
	iComun_privilegiados icp=new DB_Main();
	int primerTema;
	
	public int modo;
	
	public Seccion(com.mds.database.Usuario usu, com.mds.database.Secciones sec) {
		this.usu=usu;
		this.sec=sec;
		
		if(usu.getORMID()==1) modo=0;
		else if(usu.getModerador()==true) modo=1;
		else modo=2;
		
		nombreUsuario.setValue(usu.getEmail());		
		seccion.setValue(sec.getNombre());
		seccionLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				setContent(new Comun_registrados(usu));
			}
		});
		
		inicializarBotones();
		switch(modo) {
		
		case 0: 
			componentesAdministrador();
			break;
		}

		cargarTemas();
	}
	
	public void cerrarSesion() {
		throw new UnsupportedOperationException();
	}

	public void buscar(String aBusqueda) {
		throw new UnsupportedOperationException();
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
		crearTema.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				crearTema();
			}
		});
		
		pagAdeTema.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAdelante();
			}
		});
		
		pagAtrTema.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAtras();
			}
		});
	}
	
	public void componentesAdministrador() {
		
		ajustes.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes_administrador());
			}
		});
		
	}
	
	public void crearTema() {
		if(!tituloTema.getValue().isEmpty()&&!contenidoTema.getValue().isEmpty())	icp.Crear_tema(tituloTema.getValue(), contenidoTema.getValue(), usu, sec);
		else Notification.show("Ingrese un título y contenido del tema","",Notification.TYPE_ERROR_MESSAGE);

		cargarTemas();
	}
	
	public void cargarTemas() {
		temas = iadm.cargarTema(sec);
		
		configuracionTem();
		
		if(temas==null) {
			cargarPartes(0);
			pagAdeTema.setVisible(false);
			return;
		}
		cargarPag();
	}
	
	public void cargarPartes(int num) {
		switch(num) {
		case 0: 
			tema1.setVisible(false);
			tema2.setVisible(false);
			tema3.setVisible(false);
			tema4.setVisible(false);
			tema5.setVisible(false);
			break;
		case 1:
			tema1.setVisible(true);
			tema2.setVisible(false);
			tema3.setVisible(false);
			tema4.setVisible(false);
			tema5.setVisible(false);
			break;
		case 2:
			tema1.setVisible(true);
			tema2.setVisible(true);
			tema3.setVisible(false);
			tema4.setVisible(false);
			tema5.setVisible(false);
			break;
		case 3:
			tema1.setVisible(true);
			tema2.setVisible(true);
			tema3.setVisible(true);
			tema4.setVisible(false);
			tema5.setVisible(false);
			break;
		case 4:
			tema1.setVisible(true);
			tema2.setVisible(true);
			tema3.setVisible(true);
			tema4.setVisible(true);
			tema5.setVisible(false);
			break;
		case 5:
			tema1.setVisible(true);
			tema2.setVisible(true);
			tema3.setVisible(true);
			tema4.setVisible(true);
			tema5.setVisible(true);
			break;
		}
	}
	
	public void configuracionTem() {
		if(temas==null||temas.length<=5) {
			maxPag=1;
			if(temas==null) secUlt=0;
			else secUlt=temas.length;
		}
		else if(temas.length%5==0) {
			maxPag=(temas.length/5);
			secUlt=5;
		}else {
			maxPag=((temas.length/5)+1);
			secUlt=temas.length%5;
		}
	}
	
	public void cargarPag() {
		if(pagAct==maxPag) {
			cargarPartes(secUlt);
			escrituraSec(pagAct, secUlt);
			pagAdeTema.setVisible(false);
			if (pagAct!=1) pagAtrTema.setVisible(true);
		}
		else {
			if(pagAct!=1) pagAtrTema.setVisible(true);
			else pagAtrTema.setVisible(false);
			pagAdeTema.setVisible(true);
			cargarPartes(5);
			escrituraSec(pagAct, 5);
		}
	}
	
	public void escrituraSec(int pag, int num){
		//Formula optimizada para calcular la posicion de la seccion
		primerTema=5*(pag-1);
		if(num<5) {
			if(num==4) {
				asignarValores(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tema1);
				primerTema++;
				asignarValores(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1, numeroComentariosTema1, numeroLikesTema1, tema2);
				primerTema++;
				asignarValores(nombreTema2, usuarioCreadorTema2, borrarTema2, ultimoMensaje2, diaEnviado2, numeroComentariosTema2, numeroLikesTema2, tema3);
				primerTema++;
				asignarValores(nombreTema3, usuarioCreadorTema3, borrarTema3, ultimoMensaje3, diaEnviado3, numeroComentariosTema3, numeroLikesTema3, tema4);
			}
			else if (num==3){
				asignarValores(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tema1);
				primerTema++;
				asignarValores(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1, numeroComentariosTema1, numeroLikesTema1, tema2);
				primerTema++;
				asignarValores(nombreTema2, usuarioCreadorTema2, borrarTema2, ultimoMensaje2, diaEnviado2, numeroComentariosTema2, numeroLikesTema2, tema3);
			}
			else if (num==2) {
				asignarValores(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tema1);
				primerTema++;
				asignarValores(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1, numeroComentariosTema1, numeroLikesTema1, tema2);
			}
			else asignarValores(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tema1);
		}
		else {
			asignarValores(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado, numeroComentariosTema, numeroLikesTema, tema1);
			primerTema++;
			asignarValores(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1, numeroComentariosTema1, numeroLikesTema1, tema2);
			primerTema++;
			asignarValores(nombreTema2, usuarioCreadorTema2, borrarTema2, ultimoMensaje2, diaEnviado2, numeroComentariosTema2, numeroLikesTema2, tema3);
			primerTema++;
			asignarValores(nombreTema3, usuarioCreadorTema3, borrarTema3, ultimoMensaje3, diaEnviado3, numeroComentariosTema3, numeroLikesTema3, tema4);
			primerTema++;
			asignarValores(nombreTema4, usuarioCreadorTema4, borrarTema4, ultimoMensaje4, diaEnviado4, numeroComentariosTema4, numeroLikesTema4, tema5);
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
	
	public void borrarTema(int id) {
		icp.Eliminar_tema(id);
		setContent(new Seccion(usu, sec));
	}
	
	public void asignarValores(Label nombreS, Label usuC, Button borrarT, Label ultimoM, Label diaEnviado, Label numeroC, Label numeroL, HorizontalLayout tema) {
		com.mds.database.Temas tem=temas[primerTema];
		tema.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				setContent(new Tema());
			}
		});
		nombreS.setValue(tem.getNombre());
		usuC.setValue(tem.getCreado_por().getNombre_completo());
//		fechaC.setValue(FECHA DE CREACION tema);
		borrarT.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				borrarTema(tem.getORMID());}
		});
//		ultimoM.setValue(Coger el último mensaje);
//		diaEnviado.setValue(temas[primerTema].getFecha);
//		numeroC.setValue(numero de comentarios);
//		numeroL.setValue(numero de likes);
	}
}