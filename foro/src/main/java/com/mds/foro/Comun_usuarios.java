package com.mds.foro;

import java.io.Serializable;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.ui.Notification;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class Comun_usuarios extends Comun_usuarios_ventana implements Serializable, View {
	public iComun_registrados _iComun_registrados;
	public Notificaciones _unnamed_Notificaciones_;

	com.mds.database.Usuario usu;
	com.mds.database.Secciones[] secciones;
	public int pagAct = 1;
	public int maxPag;
	public int secUlt;
	int primeraSeccion;
	iAdministrador iadm = new DB_Main();
	iComun_privilegiados icp = new DB_Main();

	public int modo;

	public Comun_usuarios() {
		usu = MyUI.sesionUsuario;

		if (usu == null) {
			usuarioNoRegistrado();
			tipoUsuario.addComponent(new Usuario_No_Registrado());
			return;
		}
		
		MyUI.navigator.addView("configuration", new Ajustes());
		nombreUsuario.setValue(usu.getEmail());

		if (usu.getORMID() == 1)
			cuadroSeccion.setVisible(true);

		inicializarBotones();
	}

	public void usuarioNoRegistrado() {
		cargarSecciones();
		cargarTemas();
		cargarMensajes();
		

		pagAdeSecciones.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAdelante();
			}
		});

		pagAtraSecciones.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAtras();
			}
		});
	}

	public void cargarTemas() {
		com.mds.database.Temas[] tem = iadm.cargarTemasRecientes();
		if (tem == null)
			return;

		if (tem.length >= 3) {
			cargarPartesTema(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado,
					numeroComentariosTema, numeroLikesTema, tem[0], tema1);
			cargarPartesTema(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1,
					numeroComentariosTema1, numeroLikesTema1, tem[1], tema2);
			cargarPartesTema(nombreTema2, usuarioCreadorTema2, borrarTema2, ultimoMensaje2, diaEnviado2,
					numeroComentariosTema2, numeroLikesTema2, tem[2], tema3);
		} else if (tem.length == 2) {
			cargarPartesTema(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado,
					numeroComentariosTema, numeroLikesTema, tem[0], tema1);
			cargarPartesTema(nombreTema1, usuarioCreadorTema1, borrarTema1, ultimoMensaje1, diaEnviado1,
					numeroComentariosTema1, numeroLikesTema1, tem[1], tema2);
		} else if (tem.length == 1) {
			cargarPartesTema(nombreTema, usuarioCreadorTema, borrarTema, ultimoMensaje, diaEnviado,
					numeroComentariosTema, numeroLikesTema, tem[0], tema1);
		} else {
		}
	}

	public void cargarMensajes() {
		com.mds.database.Mensaje[] men = iadm.cargarMensajesRecientes();
		if (men == null)
			return;

		if (men.length >= 3) {
			cargarPartesMensaje(contenidoInicial, usuarioCreadorMensaje, borrarMensaje, temaPerteneciente,
					horaYDiaMensaje, numLikesMensaje, men[0], mensaje1);
			cargarPartesMensaje(contenidoInicial1, usuarioCreadorMensaje1, borrarMensaje1, temaPerteneciente1,
					horaYDiaMensaje1, numLikesMensaje1, men[1], mensaje2);
			cargarPartesMensaje(contenidoInicial2, usuarioCreadorMensaje2, borrarMensaje2, temaPerteneciente2,
					horaYDiaMensaje2, numLikesMensaje2, men[2], mensaje3);
		} else if (men.length == 2) {
			cargarPartesMensaje(contenidoInicial, usuarioCreadorMensaje, borrarMensaje, temaPerteneciente,
					horaYDiaMensaje, numLikesMensaje, men[0], mensaje1);
			cargarPartesMensaje(contenidoInicial1, usuarioCreadorMensaje1, borrarMensaje1, temaPerteneciente1,
					horaYDiaMensaje1, numLikesMensaje1, men[1], mensaje2);
		} else if (men.length == 1) {
			cargarPartesMensaje(contenidoInicial, usuarioCreadorMensaje, borrarMensaje, temaPerteneciente,
					horaYDiaMensaje, numLikesMensaje, men[0], mensaje1);
		} else {

		}
	}

	public void cargarPartesTema(Label nomT, Label usuC, Button borrarT, Label ultMen, Label diaT, Label numCom,
			Label numLikes, com.mds.database.Temas tem, HorizontalLayout tema) {
		tema.setVisible(true);
		tema.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
//				setContent(new Tema(usu, tem.getPertenece_a(), tem));
			}
		});
		com.mds.database.Temas temaAux = tem;
		nomT.setValue(temaAux.getNombre());
		usuC.setValue(temaAux.getCreado_por().getNombre_completo());
		borrarT.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				icp.Eliminar_tema(temaAux.getORMID());
				MyUI.navigator.navigateTo("main");
			}
		});
		if (iadm.cargarMensajes(temaAux.getORMID()) != null) {
			ultMen.setValue(iadm.cargarMensajes(temaAux.getORMID())[0].getPertenece_a().getNombre_completo());
			numCom.setValue("" + iadm.cargarMensajes(temaAux.getORMID()).length);
			diaT.setValue("" + iadm.cargarMensajes(temaAux.getORMID())[0].getFechaMensaje());
		} else {
			ultMen.setValue("Nadie");
			numCom.setValue("" + 0);
			diaT.setVisible(false);
		}
		numLikes.setValue("" + temaAux.getNum__likes());
	}

	public void cargarPartesMensaje(Label contI, Label usuC, Button borrarMensaje, Label temaPertenece, Label diaM,
			Label numLikes, com.mds.database.Mensaje men, HorizontalLayout mensaje1) {
		mensaje1.setVisible(true);
		com.mds.database.Mensaje mensajeAux = men;

		if (mensajeAux.getContenido().length() >= 15)
			contI.setValue(mensajeAux.getContenido().substring(0, 15));
		else
			contI.setValue(mensajeAux.getContenido());

		usuC.setValue(mensajeAux.getPertenece_a().getNombre_completo());

		borrarMensaje.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				icp.Eliminar_mensaje(mensajeAux.getORMID());
				MyUI.navigator.navigateTo("main");
			}
		});
		temaPertenece.setValue(mensajeAux.getSon_de().getNombre());
		diaM.setValue("" + mensajeAux.getFechaMensaje());
		numLikes.setValue("" + mensajeAux.getNum_likes());
	}

	public void inicializarBotones() {

		usuarioNoRegistrado();
		
		Notificaciones auxNot = new Notificaciones(iadm.cargarNotificaciones(usu.getORMID()));
		Usuario_Registrado ur = new Usuario_Registrado();
		auxNot.barraBotones.addComponent(ur.ajustes);
		auxNot.barraBotones.addComponent(ur.cerrarSesion);

		tipoUsuario.addComponent(auxNot);

		crearSeccion.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				crearSeccion();
				Page.getCurrent().reload();
			}
		});


	}

	public void crearSeccion() {
		if (!nombreSeccion.getValue().isEmpty()) {
			
			iadm.crearSeccion(nombreSeccion.getValue());
			MyUI.cargarPaginas();
		}
		else
			Notification.show("Ingrese un título", "", Notification.TYPE_ERROR_MESSAGE);

	}

	public void cargarSecciones() {
		secciones = iadm.cargarSecciones();

		configuracionSec();

		if (secciones == null) {
			pagAdeSecciones.setVisible(false);
			return;
		}
		cargarPag();
	}

	public void configuracionSec() {
		if (secciones == null || secciones.length <= 3) {
			maxPag = 1;
			if (secciones == null)
				secUlt = 0;
			else
				secUlt = secciones.length;
		} else if (secciones.length % 3 == 0) {
			maxPag = (secciones.length / 3);
			secUlt = 3;
		} else {
			maxPag = ((secciones.length / 3) + 1);
			secUlt = secciones.length % 3;
		}
	}

	public void cargarPag() {
		listaDeSecciones.removeAllComponents();
		if (pagAct == maxPag) {
			escrituraSec(pagAct, secUlt);
			pagAdeSecciones.setVisible(false);
			if (pagAct != 1)
				pagAtraSecciones.setVisible(true);
		} else {
			if (pagAct != 1)
				pagAtraSecciones.setVisible(true);
			else
				pagAtraSecciones.setVisible(false);
			pagAdeSecciones.setVisible(true);
			escrituraSec(pagAct, 3);
		}
	}

	public void escrituraSec(int pag, int num) {
		// Formula optimizada para calcular la posicion de la seccion
		primeraSeccion = 3 * (pag - 1);

		for (int i = 0; i < num; i++) {
			asignarValores();
			primeraSeccion++;
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
		com.mds.database.Secciones secAux = secciones[primeraSeccion];
		
		listaDeSecciones.addComponent(new Seccion(secAux));
	}

}