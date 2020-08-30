package com.mds.foro;

import com.mds.database.Temas;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_privilegiados;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import java.io.Serializable; 


public class Tema extends Tema_ventana implements Serializable{ 
	com.mds.database.Usuario usu=MyUI.sesionUsuario;
	com.mds.database.Temas tema; 
	iAdministrador iadm=new DB_Main(); 
	iComun_privilegiados icp=new DB_Main(); 
		
	public Tema(Temas tem) {

		this.tema=tem; 
		
		if(usu==null) borrarTema.setVisible(false);
		else if(!usu.getModerador()&&usu.getORMID()!=1) borrarTema.setVisible(false);
		
		this.addLayoutClickListener(new LayoutClickListener() { 
			@Override 
			public void layoutClick(LayoutClickEvent event) {
				MyUI.navigator.navigateTo("seccion/"+tem.getPertenece_a().getORMID()+"/tema/"+tem.getORMID());
				} }); 
		if(iadm.cargarMensajes(tema.getORMID())!=null) {
			
			ultimoMensaje.setValue(iadm.cargarMensajes(tema.getORMID())[0].getPertenece_a().getNombre_completo()); 
			numeroComentariosTema.setValue(""+iadm.cargarMensajes(tema.getORMID()).length); 
			diaEnviado.setValue(""+iadm.cargarMensajes(tema.getORMID())[0].getFechaMensaje()); 
			
		} else { 
			
			ultimoMensaje.setValue("Nadie"); numeroComentariosTema.setValue(""+0); diaEnviado.setVisible(false);
			
		} 
		nombreTema.setValue(tema.getNombre()); usuarioCreadorTema.setValue(tema.getCreado_por().getNombre_completo()); 
		borrarTema.addClickListener(new Button.ClickListener() { 
			
			@Override
			public void buttonClick(ClickEvent event) { 
				
			borrarTema(tema.getORMID());} }); 
			numeroLikesTema.setValue(""+tema.getNum__likes()); 
	}

	public void borrarTema(int id) {
		icp.Eliminar_tema(id); 
		Page.getCurrent().reload();
	}
}