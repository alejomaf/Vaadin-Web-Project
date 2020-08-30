package com.mds.foro;

import java.io.Serializable;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Notificaciones extends Notificaciones_ventana implements Serializable {

	/**
	 * @implNote Initialitation of position values
	 */
	public int pagActNot = 1;
	com.mds.database.Notificaciones[] notis;
	int primeraNotificacion;
	public int maxPagNot;
	public int secUltNot;

	iAdministrador iadm = new DB_Main();

	public Notificaciones(com.mds.database.Notificaciones[] notis) {

		this.notis = notis;

		inicializarBotones();

	}

	public void inicializarBotones() {

		notificacionAdelante.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAdelanteNot();
			}
		});

		notificacionAtras.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pagAtrasNot();
			}
		});

		notificaciones.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				cargaNotificaciones();
			}
		});
	}

	public void pagAdelanteNot() {
		pagActNot++;
		cargarPagNot();
	}

	public void pagAtrasNot() {
		pagActNot--;
		cargarPagNot();
	}

	public void cargaNotificaciones() {

		if (listaNotificaciones.isVisible()) {
			listaNotificaciones.setVisible(false);
		} else {
			if (notis == null)
				return;
			listaNotificaciones.setVisible(true);
			cargarListaNotificaciones();
		}

	}

	public void cargarListaNotificaciones() {
		configuracionNot();
		cargarPagNot();
	}

	public void configuracionNot() {
		if (notis == null || notis.length <= 3) {
			maxPagNot = 1;
			if (notis == null)
				secUltNot = 0;
			else
				secUltNot = notis.length;
		} else if (notis.length % 3 == 0) {
			maxPagNot = (notis.length / 3);
			secUltNot = 3;
		} else {
			maxPagNot = ((notis.length / 3) + 1);
			secUltNot = notis.length % 3;
		}
	}

	public void cargarPagNot() {
		if (pagActNot == maxPagNot) {
			escrituraNot(pagActNot, secUltNot);
			notificacionAdelante.setVisible(false);
			if (pagActNot != 1)
				notificacionAtras.setVisible(true);
		} else {
			if (pagActNot != 1)
				notificacionAtras.setVisible(true);
			else
				notificacionAtras.setVisible(false);
			notificacionAdelante.setVisible(true);
			escrituraNot(pagActNot, 3);
		}
	}

	public void escrituraNot(int pag, int num) {

		listaNotificaciones.removeAllComponents();
		// Formula optimizada para calcular la posicion de la seccion
		primeraNotificacion = 3 * (pag - 1);

		for (int i = 0; i < num; i++) {
			asignarValoresNotificaciones();
			primeraNotificacion++;
		}
	}

	public void asignarValoresNotificaciones() {

		com.mds.database.Notificaciones not = notis[primeraNotificacion];

		Notificacion auxN = new Notificacion(not);

		auxN.eliminarNotificacion.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				iadm.borrarNotificacion(not.getORMID());
				listaNotificaciones.removeComponent(auxN);
			}
		});
		
		listaNotificaciones.addComponent(auxN);

	}
}