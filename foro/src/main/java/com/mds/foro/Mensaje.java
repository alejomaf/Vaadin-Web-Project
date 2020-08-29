package com.mds.foro;

import java.io.File;

import org.orm.PersistentException;

import com.mds.database.UsuarioDAO;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_registrados;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class Mensaje extends Mensaje_ventana{
	com.mds.database.Mensaje men;
	com.mds.database.Usuario usu=null;
	iAdministrador iadm = new DB_Main();
	iComun_registrados icr = new DB_Main();

	public Mensaje(com.mds.database.Mensaje men) {
		this.men=men;
		usu=MyUI.sesionUsuario;
		if(usu==null) borrarMensaje.setVisible(false);
		else if(usu.getModerador()==false&&usu.getORMID()!=1) borrarMensaje.setVisible(false);
		
		FileResource resource = new FileResource(new File(men.getPertenece_a().getFoto()));
		fotoMensaje.setSource(resource);
		try {
			usuarioMensaje.setValue(UsuarioDAO.getUsuarioByORMID(men.getPertenece_a().getORMID()).getNombre_completo());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		if (men.getRespuesta_de().getORMID() != 1) {
			com.mds.database.Mensaje mensajeCitado = iadm.getMensaje(men.getRespuesta_de().getORMID());
			String cita = "[Escrito por: [" + mensajeCitado.getPertenece_a().getNombre_completo() + "]\n ";
			cita += mensajeCitado.getContenido() + "] Responde: ";
			contenidoMensaje.setValue(cita + men.getContenido());
		} else
			contenidoMensaje.setValue(men.getContenido());
		fechaMensaje.setValue("" + men.getFechaMensaje());
		borrarMensaje.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Eliminar_mensaje(men.getORMID());
			}
		});
		citarMensaje.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Mensajes.idRespuesta= men.getORMID();
			}
		});
		if (usu != null) {
			if (icr.leGustaMensaje(men.getORMID(), usu.getORMID()))
				likeMensaje.setEnabled(false);
			else {
				likeMensaje.setDisableOnClick(true);
				likeMensaje.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						Dar_me_gusta();
					}
				});
			}
		}else {
			likeMensaje.setEnabled(false);
			citarMensaje.setEnabled(false);
		}
		numLikesMensaje.setValue("" + men.getNum_likes());
	}
	public void Dar_me_gusta() {
		icr.Dar_me_gusta(men.getORMID(), usu.getORMID());
		numLikesMensaje.setValue("" + (Integer.parseInt(numLikesMensaje.getValue()) + 1));
	}

	public void Eliminar_mensaje(int id) {
			icr.Eliminar_mensaje(id);
			Page.getCurrent().reload();
	}
}