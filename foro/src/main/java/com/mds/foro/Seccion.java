package com.mds.foro;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class Seccion {
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
	public Secciones _secciones;

	public void cerrarSesion() {
		throw new UnsupportedOperationException();
	}

	public void buscar(String aBusqueda) {
		throw new UnsupportedOperationException();
	}
}