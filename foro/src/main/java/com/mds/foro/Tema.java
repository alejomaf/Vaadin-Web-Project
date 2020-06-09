package com.mds.foro;

import com.mds.foro.Temas_Usuario_No_Registrado;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.sass.internal.parser.function.DarkenFunctionGenerator;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import com.mds.database.UsuarioDAO;
import com.mds.foro.Mensajes;

public class Tema extends Tema_ventana{
	public Temas_Usuario_No_Registrado _unnamed_Temas_Usuario_No_Registrado_;
	public Mensajes _unnamed_Mensajes_;
	
	com.mds.database.Usuario usu;
	com.mds.database.Secciones sec;
	com.mds.database.Temas tem;
	com.mds.database.Mensaje[] mensajes;
	public int pagAct=1;
	public int maxPag;
	public int secUlt;
	iAdministrador iadm=new DB_Main();
	iComun_privilegiados icp=new DB_Main();
	iComun_registrados icr=new DB_Main();
	int primerMensaje;
	int idRespuesta;
	
	public int modo;
	
	public Tema(com.mds.database.Usuario usu, com.mds.database.Secciones sec, com.mds.database.Temas tem) {
		this.usu=usu;
		this.sec=sec;
		this.tem=tem;
		
		idRespuesta=0;
		
		if(usu!=null)
		if(usu.getORMID()==1) modo=0;
		else if(usu.getModerador()==true) modo=1;
		else modo=2;
		
		/*
		 * Adding configuration to the header
		 */
		componentesPrincipales();
		
		
		switch(modo) {
		
		case 0: 
			inicializarBotones();
			break;
		case 1:
			inicializarBotones();
			break;
		case 2:
			inicializarBotones();
			componentesUsuario();
		}

		cargarMensajes();
		if(usu==null) usuarioNoRegistrado();
	}
	
	
	
	
	public void componentesPrincipales() {
		if(usu!=null)
		nombreUsuario.setValue(usu.getEmail());		
		seccion.setValue(sec.getNombre());
		tema.setValue(tem.getNombre());
		
		foroLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				setContent(new Comun_registrados(usu));
			}
		});
		seccionLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				setContent(new Seccion(usu, sec));
			}
		});
		
		/*
		 *  Charging the own theme of the page
		 */
		
		FileResource resource = new FileResource(new File(tem.getCreado_por().getFoto()));
		fotoTema.setSource(resource);
		usuarioTema.setValue(tem.getCreado_por().getNombre_completo());
		tituloTema.setValue(tem.getNombre());
		contenidoTema.setValue(tem.getContenido());
		fechaTema.setValue("el "+tem.getFechaTema());
		numLikesTema.setValue(""+tem.getNum__likes());
		
		
		if(usu!=null)
		if(icr.leGustaTema(tem.getORMID(), usu.getORMID())) likeTema.setEnabled(false);
		else {
			likeTema.setDisableOnClick(true);
		likeTema.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				icr.Dar_me_gusta_tema(tem.getId_tema(), usu.getId_usuario());
				numLikesTema.setValue(""+(Integer.parseInt(numLikesTema.getValue())+1));
			}
		});
		}
	}
	
	public void componentesUsuario() {
		borrarTema.setVisible(false);
		borrarMensaje.setVisible(false);
		borrarMensaje1.setVisible(false);
		borrarMensaje2.setVisible(false);
		borrarMensaje3.setVisible(false);
		borrarMensaje4.setVisible(false);
	}
	
	public void usuarioNoRegistrado() {
		likeTema.setEnabled(false);
		citarMensaje.setVisible(false);
		citarMensaje1.setVisible(false);
		citarMensaje2.setVisible(false);
		citarMensaje3.setVisible(false);
		citarMensaje4.setVisible(false);
		likeMensaje.setEnabled(false);
		likeMensaje1.setEnabled(false);
		likeMensaje2.setEnabled(false);
		likeMensaje3.setEnabled(false);
		likeMensaje4.setEnabled(false);
		componentesUsuario();
		cuadroMensaje.setVisible(false);
		notificaciones.setVisible(false);
		cerrarSesion.setVisible(false);
		ajustes.setVisible(false);
		iniciarSesion.setVisible(true);
		registrarse.setVisible(true);
		cargarMensajes();
		
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
	
	
	public void inicializarBotones() {
		cerrarSesion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_registrados(null));
			}
		});
		notificaciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
			}
		});
		enviarComentario.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				crearMensaje();
			}
		});
		
		pagAdeMensaje.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAdelante();
			}
		});
		
		pagAtrMensaje.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAtras();
			}
		});
		
		ajustes.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu, 1));
			}
		});
	}
	
	
	public void crearMensaje() {
		if(!contenidoComentario.getValue().isEmpty())	{
			if(iadm.cargarMensajes(tem.getORMID())!=null) {
				ArrayList<com.mds.database.Mensaje> lista=new ArrayList<com.mds.database.Mensaje>(Arrays.asList(iadm.cargarMensajes(tem.getORMID())));
				ArrayList<com.mds.database.Usuario> usuarios=new ArrayList<com.mds.database.Usuario>();
				
				for(com.mds.database.Mensaje menAux: lista) if(!usuarios.contains(menAux.getPertenece_a())) usuarios.add(menAux.getPertenece_a());
				for(com.mds.database.Usuario usAux: usuarios) {
					iadm.notificacionMensajeEnviado(usAux.getORMID(), tem.getORMID());
				}
			}
			icr.crearMensaje(usu.getORMID(), idRespuesta, tem.getORMID(), contenidoComentario.getValue());
		}
		else Notification.show("Ingrese un título y contenido del tema","",Notification.TYPE_ERROR_MESSAGE);

		cargarMensajes();
	}
	
	public void cargarMensajes() {
		mensajes = iadm.cargarMensajes(tem.getORMID());
		
		configuracionMen();
		
		if(mensajes==null) {
			cargarPartes(0);
			pagAdeMensaje.setVisible(false);
			return;
		}

		numComentariosTema.setValue(""+mensajes.length);
		cargarPag();
	}
	
	public void cargarPartes(int num) {
		switch(num) {
		case 0: 
			mensaje.setVisible(false);
			mensaje1.setVisible(false);
			mensaje2.setVisible(false);
			mensaje3.setVisible(false);
			mensaje4.setVisible(false);
			break;
		case 1:
			mensaje.setVisible(true);
			mensaje1.setVisible(false);
			mensaje2.setVisible(false);
			mensaje3.setVisible(false);
			mensaje4.setVisible(false);
			break;
		case 2:
			mensaje.setVisible(true);
			mensaje1.setVisible(true);
			mensaje2.setVisible(false);
			mensaje3.setVisible(false);
			mensaje4.setVisible(false);
			break;
		case 3:
			mensaje.setVisible(true);
			mensaje1.setVisible(true);
			mensaje2.setVisible(true);
			mensaje3.setVisible(false);
			mensaje4.setVisible(false);
			break;
		case 4:
			mensaje.setVisible(true);
			mensaje1.setVisible(true);
			mensaje2.setVisible(true);
			mensaje3.setVisible(true);
			mensaje4.setVisible(false);
			break;
		case 5:
			mensaje.setVisible(true);
			mensaje1.setVisible(true);
			mensaje2.setVisible(true);
			mensaje3.setVisible(true);
			mensaje4.setVisible(true);
			break;
		}
	}
	
	public void configuracionMen() {
		if(mensajes==null||mensajes.length<=5) {
			maxPag=1;
			if(mensajes==null) secUlt=0;
			else secUlt=mensajes.length;
		}
		else if(mensajes.length%5==0) {
			maxPag=(mensajes.length/5);
			secUlt=5;
		}else {
			maxPag=((mensajes.length/5)+1);
			secUlt=mensajes.length%5;
		}
	}
	
	public void cargarPag() {
		if(pagAct==maxPag) {
			cargarPartes(secUlt);
			escrituraSec(pagAct, secUlt);
			pagAdeMensaje.setVisible(false);
			if (pagAct!=1) pagAtrMensaje.setVisible(true);
		}
		else {
			if(pagAct!=1) pagAtrMensaje.setVisible(true);
			else pagAtrMensaje.setVisible(false);
			pagAdeMensaje.setVisible(true);
			cargarPartes(5);
			escrituraSec(pagAct, 5);
		}
	}
	
	public void escrituraSec(int pag, int num){
		//Formula optimizada para calcular la posicion de la seccion
		primerMensaje=5*(pag-1);
		if(num<5) {
			if(num==4) {
				asignarValores(fotoMensaje, usuarioMensaje, contenidoMensaje, fechaMensaje, borrarMensaje, citarMensaje, numLikesMensaje, likeMensaje);
				primerMensaje++;
				asignarValores(fotoMensaje1, usuarioMensaje1, contenidoMensaje1, fechaMensaje1, borrarMensaje1, citarMensaje1, numLikesMensaje1, likeMensaje1);
				primerMensaje++;
				asignarValores(fotoMensaje2, usuarioMensaje2, contenidoMensaje2, fechaMensaje2, borrarMensaje2, citarMensaje2, numLikesMensaje2, likeMensaje2);
				primerMensaje++;
				asignarValores(fotoMensaje3, usuarioMensaje3, contenidoMensaje3, fechaMensaje3, borrarMensaje3, citarMensaje3, numLikesMensaje3, likeMensaje3);
			}
			else if (num==3){
				asignarValores(fotoMensaje, usuarioMensaje, contenidoMensaje, fechaMensaje, borrarMensaje, citarMensaje, numLikesMensaje, likeMensaje);
				primerMensaje++;
				asignarValores(fotoMensaje1, usuarioMensaje1, contenidoMensaje1, fechaMensaje1, borrarMensaje1, citarMensaje1, numLikesMensaje1, likeMensaje1);
				primerMensaje++;
				asignarValores(fotoMensaje2, usuarioMensaje2, contenidoMensaje2, fechaMensaje2, borrarMensaje2, citarMensaje2, numLikesMensaje2, likeMensaje2);
			}
			else if (num==2) {
				asignarValores(fotoMensaje, usuarioMensaje, contenidoMensaje, fechaMensaje, borrarMensaje, citarMensaje, numLikesMensaje, likeMensaje);
				primerMensaje++;
				asignarValores(fotoMensaje1, usuarioMensaje1, contenidoMensaje1, fechaMensaje1, borrarMensaje1, citarMensaje1, numLikesMensaje1, likeMensaje1);
			}
			else asignarValores(fotoMensaje, usuarioMensaje, contenidoMensaje, fechaMensaje, borrarMensaje, citarMensaje, numLikesMensaje, likeMensaje);
		}
		else {
			asignarValores(fotoMensaje, usuarioMensaje, contenidoMensaje, fechaMensaje, borrarMensaje, citarMensaje, numLikesMensaje, likeMensaje);
			primerMensaje++;
			asignarValores(fotoMensaje1, usuarioMensaje1, contenidoMensaje1, fechaMensaje1, borrarMensaje1, citarMensaje1, numLikesMensaje1, likeMensaje1);
			primerMensaje++;
			asignarValores(fotoMensaje2, usuarioMensaje2, contenidoMensaje2, fechaMensaje2, borrarMensaje2, citarMensaje2, numLikesMensaje2, likeMensaje2);
			primerMensaje++;
			asignarValores(fotoMensaje3, usuarioMensaje3, contenidoMensaje3, fechaMensaje3, borrarMensaje3, citarMensaje3, numLikesMensaje3, likeMensaje3);
			primerMensaje++;
			asignarValores(fotoMensaje4, usuarioMensaje4, contenidoMensaje4, fechaMensaje4, borrarMensaje4, citarMensaje4, numLikesMensaje4, likeMensaje4);
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
	
	public void borrarMensaje(int id) {
		icr.Eliminar_mensaje(id);
		setContent(new Tema(usu, sec, tem));
	}
	
	public void asignarValores(Image fotoM, Label usuM, Label conM, Label fechaM, Button borrarM, Button citarM, Label numL, Button likeM) {
		com.mds.database.Mensaje men=mensajes[primerMensaje];
		FileResource resource = new FileResource(new File(men.getPertenece_a().getFoto()));
		fotoM.setSource(resource);
		try {
			usuM.setValue(UsuarioDAO.getUsuarioByORMID(men.getPertenece_a().getORMID()).getNombre_completo());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conM.setValue(men.getContenido());
		fechaM.setValue(""+men.getFechaMensaje());
		borrarM.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				borrarMensaje(men.getORMID());}
		});
		citarM.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				idRespuesta=men.getORMID();}
		});
		if(usu!=null)
		if(icr.leGustaMensaje(men.getORMID(), usu.getORMID())) likeM.setEnabled(false);
		else {
			likeM.setDisableOnClick(true);
		likeM.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				icr.Dar_me_gusta(men.getORMID(), usu.getORMID());
				numL.setValue(""+(Integer.parseInt(numL.getValue())+1));
			}
		});
		}
		numL.setValue(""+men.getNum_likes());
	}
}