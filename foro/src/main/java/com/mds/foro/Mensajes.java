package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import java.io.File;

public class Mensajes extends Mensajes_ventana implements View {
	public Temas_Usuario_No_Registrado _unnamed_Temas_Usuario_No_Registrado_;

	com.mds.database.Usuario usu;
	com.mds.database.Secciones sec;
	com.mds.database.Temas tem;
	com.mds.database.Mensaje[] mensajes;
	public int pagAct = 1;
	public int maxPag;
	public int secUlt;
	iAdministrador iadm = new DB_Main();
	iComun_privilegiados icp = new DB_Main();
	iComun_registrados icr = new DB_Main();
	int primerMensaje;
	public static int idRespuesta;

	public int modo;

	public Mensajes(com.mds.database.Secciones sec, com.mds.database.Temas tem) {
		idRespuesta=1;
		this.usu = MyUI.sesionUsuario;
		this.sec = sec;
		this.tem = tem;

		if (usu == null) {
			tipoUsuario.addComponent(new Usuario_No_Registrado());
			likeTema.setVisible(false);
			usuarioNoRegistrado();
			borrarTema.setVisible(false);
			likeTema.setVisible(true);
			likeTema.setEnabled(false);
			return;
		}
		
		if(usu.getModerador()==true||usu.getORMID()==1) borrarTema.setVisible(true);
		else borrarTema.setVisible(false);
		likeTema.setVisible(true);
		background.addComponent(new Crear_mensaje(usu, sec, tem));

		//Inicio las notificaciones
		Notificaciones auxNot = new Notificaciones(iadm.cargarNotificaciones(usu.getORMID()));
		Usuario_Registrado ur = new Usuario_Registrado();
		auxNot.barraBotones.addComponent(ur.ajustes);
		auxNot.barraBotones.addComponent(ur.cerrarSesion);
		tipoUsuario.addComponent(auxNot);
		
		usuarioNoRegistrado();
		
		//Cargo el nombre de usuario
		nombreUsuario.setValue(usu.getEmail());
	}
	
	public void cargarTema() {
		/*
		 * Charging the own theme of the page
		 */
		FileResource resource = new FileResource(new File(tem.getCreado_por().getFoto()));
		fotoTema.setSource(resource);
		usuarioTema.setValue(tem.getCreado_por().getNombre_completo());
		tituloTema.setValue(tem.getNombre());
		contenidoTema.setValue(tem.getContenido());
		fechaTema.setValue("el " + tem.getFechaTema());
		numLikesTema.setValue("" + tem.getNum__likes());

		if (usu != null)
			if (icr.leGustaTema(tem.getORMID(), usu.getORMID()))
				likeTema.setEnabled(false);
			else {
				likeTema.setDisableOnClick(true);
				likeTema.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						icr.Dar_me_gusta_tema(tem.getId_tema(), usu.getId_usuario());
						numLikesTema.setValue("" + (Integer.parseInt(numLikesTema.getValue()) + 1));
					}
				});
			}
	}

	public void usuarioNoRegistrado() {
		cargarMensajes();
		cargarTema();
		
		seccion.setValue(sec.getNombre());
		tema.setValue(tem.getNombre());
		foroLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				MyUI.navigator.navigateTo("main");
			}
		});
		seccionLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				MyUI.navigator.navigateTo("seccion/"+sec.getORMID());
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
	}

	public void cargarMensajes() {
		mensajes = iadm.cargarMensajes(tem.getORMID());

		configuracionMen();

		if (mensajes == null) {
			pagAdeMensaje.setVisible(false);
			return;
		}

		numComentariosTema.setValue("" + mensajes.length);
		cargarPag();
	}


	public void configuracionMen() {
		if (mensajes == null || mensajes.length <= 5) {
			maxPag = 1;
			if (mensajes == null)
				secUlt = 0;
			else
				secUlt = mensajes.length;
		} else if (mensajes.length % 5 == 0) {
			maxPag = (mensajes.length / 5);
			secUlt = 5;
		} else {
			maxPag = ((mensajes.length / 5) + 1);
			secUlt = mensajes.length % 5;
		}
	}

	public void cargarPag() {
		if (pagAct == maxPag) {
			escrituraSec(pagAct, secUlt);
			pagAdeMensaje.setVisible(false);
			if (pagAct != 1)
				pagAtrMensaje.setVisible(true);
		} else {
			if (pagAct != 1)
				pagAtrMensaje.setVisible(true);
			else
				pagAtrMensaje.setVisible(false);
			pagAdeMensaje.setVisible(true);
			escrituraSec(pagAct, 5);
		}
	}

	public void escrituraSec(int pag, int num) {
		listaMensajes.removeAllComponents();
		// Formula optimizada para calcular la posicion de la seccion
		primerMensaje = 5 * (pag - 1);
		
		for (int i = 0; i < num; i++) {
			asignarValores();
			primerMensaje++;
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

	public void asignarValores() {
		Mensaje mensaje=null;
		com.mds.database.Mensaje men = mensajes[primerMensaje];
		
		if(usu!=null) {
		if(men.getPertenece_a().getORMID()==usu.getORMID()) mensaje=new Mensaje_propio(men);
		else mensaje=new Mensaje(men);}
		else mensaje=new Mensaje(men);
		listaMensajes.addComponent(mensaje);
	}

}