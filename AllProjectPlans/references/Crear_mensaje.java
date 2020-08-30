package com.mds.foro;

import java.util.ArrayList;
import java.util.Arrays;

import com.mds.database.Secciones;
import com.mds.database.Temas;
import com.mds.database.Usuario;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Crear_mensaje extends Crear_mensaje_ventana {

	iAdministrador iadm = new DB_Main();
	
	public Crear_mensaje(Usuario usu, Secciones sec, Temas tem) {
		enviarComentario.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				enviarMensaje(usu,sec,tem);
			}
		});
	}
	
	public void enviarMensaje(Usuario usu, Secciones sec, Temas tem) {

		int idRespuesta=Mensajes.idRespuesta;
		
		if (!contenidoComentario.getValue().isEmpty()) {
			if(!(!(adjuntarImagen.isEmpty())&&!(adjuntarVideo.isEmpty()))) {
			if (iadm.cargarMensajes(tem.getORMID()) != null) {
				ArrayList<com.mds.database.Mensaje> lista = new ArrayList<com.mds.database.Mensaje>(
						Arrays.asList(iadm.cargarMensajes(tem.getORMID())));
				ArrayList<com.mds.database.Usuario> usuarios = new ArrayList<com.mds.database.Usuario>();

				for (com.mds.database.Mensaje menAux : lista)
					if (!usuarios.contains(menAux.getPertenece_a()))
						usuarios.add(menAux.getPertenece_a());
				for (com.mds.database.Usuario usAux : usuarios) {
					iadm.notificacionMensajeEnviado(usAux.getORMID(), tem.getORMID());
				}
			}
			String video=null;
			String foto=null;
			if(!adjuntarImagen.isEmpty()) foto=adjuntarImagen.getValue();
			if(!adjuntarVideo.isEmpty()) video=adjuntarVideo.getValue();
			Responder.responder(usu.getORMID(), idRespuesta, tem.getORMID(), contenidoComentario.getValue(), foto, video);
			Page.getCurrent().reload();
			}else {
				Notification.show("Solo se puede añadir o un vídeo o una imagen", "", Notification.TYPE_ERROR_MESSAGE);
			}
		} else
			Notification.show("Ingrese un contenido en el mensaje", "", Notification.TYPE_ERROR_MESSAGE);

	}
}