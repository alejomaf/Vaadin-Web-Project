package com.mds.foro;

import java.awt.List;
import java.util.Vector;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Ver_ultimos_mensajes extends Ver_ultimos_mensajes_ventana{
	
	iComun_privilegiados icp = new DB_Main();
	
	public Ver_ultimos_mensajes(com.mds.database.Usuario usu) {
		
		com.mds.database.Mensaje[] men=icp.Cargar_mensajes_usuario(usu.getORMID());
		
		cambiarNMensajes.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Modificar_numero_mensajes modAux=new Modificar_numero_mensajes();
				cambiarNMensajes.setEnabled(false);
				modAux.cerrar.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						removeComponent(modAux);
						cambiarNMensajes.setEnabled(true);
					}
				});
				
				addComponent(modAux);
			}
		});
		if(men==null) return;
		
		if(men.length>=Modificar_numero_mensajes.numMensajes) {
			for(int i=0; i<5;i++) {
				Mensaje_No_Interaccion compMen=new Mensaje_No_Interaccion(men[Modificar_numero_mensajes.numMensajes-i]);
				mensajes.addComponent(compMen);
			}
		}else {
			for(com.mds.database.Mensaje menAux: men) {
				Mensaje_No_Interaccion compMen=new Mensaje_No_Interaccion(menAux);
				mensajes.addComponent(compMen);
			}
		}
		
	}
}