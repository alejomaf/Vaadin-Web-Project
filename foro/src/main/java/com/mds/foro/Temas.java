package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Temas extends Temas_ventana implements View {
	public int pagActNot = 1;
	com.mds.database.Notificaciones[] notis;
	int primeraNotificacion;
	public int maxPagNot;
	public int secUltNot;

	public iComun_registrados _iComun_registrados;
	public Notificaciones _unnamed_Notificaciones_;

	com.mds.database.Usuario usu;
	com.mds.database.Secciones sec;
	com.mds.database.Temas[] temas;
	public int pagAct = 1;
	public int maxPag;
	public int secUlt;
	iAdministrador iadm = new DB_Main();
	iComun_privilegiados icp = new DB_Main();
	int primerTema;

	public Temas(com.mds.database.Secciones sec) {		
		this.usu = MyUI.sesionUsuario;
		this.sec = sec;

		if (usu == null) {
			usuarioNoRegistrado();
			tipoUsuario.addComponent(new Usuario_No_Registrado());
			return;
		}

		if (usu.getORMID() == 1 || usu.getModerador() == true)
			background.addComponent(new Crear_tema(usu, sec));

		inicializarBotones();
	}

	public void usuarioNoRegistrado() {

		foroLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				MyUI.navigator.navigateTo("main");
			}
		});
		seccion1.setValue(sec.getNombre());
		seccionLink.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				MyUI.navigator.navigateTo("main");
			}
		});

		cargarTemas();
	}

	public void inicializarBotones() {

		usuarioNoRegistrado();

		nombreUsuario.setValue(usu.getEmail());
		seccion.setValue(sec.getNombre());

		Notificaciones auxNot = new Notificaciones(iadm.cargarNotificaciones(usu.getORMID()));
		Usuario_Registrado ur = new Usuario_Registrado();
		auxNot.barraBotones.addComponent(ur.ajustes);
		auxNot.barraBotones.addComponent(ur.cerrarSesion);

		tipoUsuario.addComponent(auxNot);

		pagAdeTema.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAdelante();
			}
		});

		pagAtrTema.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAtras();
			}
		});
	}

	public void cargarTemas() {
		temas = iadm.cargarTema(sec);

		if (temas == null) {
			pagAdeTema.setVisible(false);
			return;
		}
		
		configuracionTem();

		cargarPag();
	}

	public void configuracionTem() {
		if (temas == null || temas.length <= 5) {
			maxPag = 1;
			if (temas == null)
				secUlt = 0;
			else
				secUlt = temas.length;
		} else if (temas.length % 5 == 0) {
			maxPag = (temas.length / 5);
			secUlt = 5;
		} else {
			maxPag = ((temas.length / 5) + 1);
			secUlt = temas.length % 5;
		}
	}

	public void cargarPag() {
		if (pagAct == maxPag) {
			escrituraSec(pagAct, secUlt);
			pagAdeTema.setVisible(false);
			if (pagAct != 1)
				pagAtrTema.setVisible(true);
		} else {
			if (pagAct != 1)
				pagAtrTema.setVisible(true);
			else
				pagAtrTema.setVisible(false);
			pagAdeTema.setVisible(true);
			escrituraSec(pagAct, 5);
		}
	}

	public void escrituraSec(int pag, int num) {
		// Formula optimizada para calcular la posicion de la seccion
		primerTema = 5 * (pag - 1);
		
		for (int i = 0; i < num; i++) {
			asignarValores();
			primerTema++;
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
		com.mds.database.Temas tem = temas[primerTema];
		Tema tema = new Tema(tem);

		listaTemas.addComponent(tema);
	}

}