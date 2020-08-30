package com.mds.foro;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Comun_registrados extends Comun_registrados_ventana {

	
	public Comun_registrados() {
		inicio.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.navigator.navigateTo("main");
			}
		});
	}
}