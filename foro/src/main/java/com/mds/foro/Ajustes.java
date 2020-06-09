package com.mds.foro;

import java.io.File;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.mds.interfaz.iComun_registrados;
import com.mds.interfaz.iComun_usuarios;
import com.mds.interfaz.iUsuario_No_Registrado;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
public class Ajustes extends Ajustes_ventana{
	public Modificar_perfil _unnamed_Modificar_perfil_;
	public Modificar_contrasena _unnamed_Modificar_contrasena_;
	public Amigos _unnamed_Amigos_;

	iAdministrador iadm=new DB_Main();
	public iComun_usuarios icu=new DB_Main();
	iUsuario_No_Registrado iuno=new DB_Main();
	public com.mds.database.Usuario[] usuarios;
	public com.mds.database.Usuario usu;
	public int modo;
	public int vis;
	public int pagAct=1;
	public int maxPag;
	public int numEleUltPos;
	public int tipoLista;
	
	
	public Ajustes(com.mds.database.Usuario usu, int vis) {
		this.usu=usu;
		this.vis=vis;
		
		if(usu.getORMID()==1) modo=0;
		else if(usu.getModerador()==true) modo=1;
		else modo=2;
		
		nombreUsuario.setValue(usu.getEmail());
	
		inicializarBotones();
		
		switch(vis) {
			
		case 1:
			perfil();
			break;
		case 2:
			listaUsuarios();
			break;
		case 3:
			amigos();
			break;
		case 4:
			usuariosReportados();
			break;
		case 5:
			usuariosBaneados();
			break;
		}
		
		switch(modo) {
		
		case 0: 
			break;
		case 1:
			componentesModerador();
			break;
		case 2:
			componentesUsuario();
			break;
	}
}
	
	public void inicializarBotones() {
		inicio.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_registrados(usu));
			}
		});
		cerrarSesion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Comun_registrados(null));
			}
		});
		notificaciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
			}
		});
		
		pagAdeUsu.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAde();
				cargarPagina();
			}
		});
		
		pagAntUsu.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAtr();
				cargarPagina();
			}
		});
		
		perfil.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu,1));
			}
		});
		usuariosB.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu,2));
			}
		});
		amigos.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu,3));
			}
		});
		usuariosReportados.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu,4));
			}
		});
		usuariosBaneados.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				setContent(new Ajustes(usu,5));
			}
		});
	}
	
	public void componentesModerador() {
		usuariosBaneados.setVisible(false);
	}
	
	public void componentesUsuario() {
		usuariosBaneados.setVisible(false);
		usuariosReportados.setVisible(false);
	}
	
	public void perfil() {
		pagAdeUsu.setVisible(false);
		pagAntUsu.setVisible(false);
		listaUsuarios.setVisible(false);
		perfil.setEnabled(false);
		nombreCompleto.setValue(usu.getNombre_completo());
		if(usu.getDescripcion().isEmpty()) descripcion.setValue("No hay descripción");
		else descripcion.setValue(usu.getDescripcion());
		
		FileResource resource = new FileResource(new File(usu.getFoto()));
		fotoUsuario.setSource(resource);
		
		/*
		 * Método modificar contraseña
		 */
		modificarContrasena.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Modificar_contrasena modCont=new Modificar_contrasena();
				modCont.salir.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						setContent(new Ajustes(usu,1));
					}
				});
				modCont.modificar.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						if(modCont.contrasenaAntigua.getValue().equals(usu.getContrasena())) {
							if(modCont.contrasenaNueva.getValue().equals(modCont.contrasenaNueva2.getValue())) {
								icu.modificarContrasena(usu.getORMID(), modCont.contrasenaNueva.getValue());
								setContent(new Ajustes(iuno.iniciarSesion(usu.getEmail(), modCont.contrasenaNueva.getValue()),1));
							}
							else Notification.show("Sus contraseñas nuevas no coinciden","",Notification.TYPE_ERROR_MESSAGE);
						}
						else Notification.show("Su contraseña antigua es incorrecta","",Notification.TYPE_ERROR_MESSAGE);
					}
				});
				modCont.salir.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						datosPerfil.setVisible(true);
						main2.removeComponent(modCont);
					}
				});
				main2.addComponent(modCont);	
				datosPerfil.setVisible(false);
			}
		});
		
		/*
		 * Método modificar perfil
		 */
		modificarPerfil.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Modificar_perfil mp=new Modificar_perfil();
				
				//Relleno los parámatros para que sea más claro
				if(!usu.getDescripcion().isEmpty())mp.descripcion.setValue(usu.getDescripcion());
				mp.nombreCompleto.setValue(usu.getNombre_completo());
				
				mp.modificar.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						if(mp.descripcion.getValue().isEmpty()||mp.nombreCompleto.getValue().isEmpty()) Notification.show("Faltan datos por añadir","",Notification.TYPE_ERROR_MESSAGE);
						else if(mp.descripcion.getValue().contentEquals(usu.getDescripcion())&&mp.nombreCompleto.getValue().equals(usu.getNombre_completo())) Notification.show("No hay datos para cambiar","",Notification.TYPE_ERROR_MESSAGE);
						else if(!mp.descripcion.getValue().equals(usu.getDescripcion())&&!mp.nombreCompleto.getValue().equals(usu.getNombre_completo())) icu.modificarPerfil(usu.getORMID(), mp.nombreCompleto.getValue(), mp.descripcion.getValue());
						else if(!mp.descripcion.getValue().equals(usu.getDescripcion())) icu.modificarPerfil(usu.getORMID(), null, mp.descripcion.getValue());
						else icu.modificarPerfil(usu.getORMID(), mp.nombreCompleto.getValue(), null);	
						setContent(new Ajustes(iuno.iniciarSesion(usu.getEmail(), usu.getContrasena()),1));
					}
				});
				mp.salir.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						datosPerfil.setVisible(true);
						main2.removeComponent(mp);
					}
				});
				main2.addComponent(mp);
				datosPerfil.setVisible(false);
			}
		});
		
		
		email.setValue(usu.getEmail());
	}
	public void listaUsuarios() {
		datosPerfil.setVisible(false);
		usuariosB.setEnabled(false);
		movimientoPaginas.setVisible(true);
		
		pagAct=1;
		cargarUsuarios(1);
	}
	public void amigos() {
		datosPerfil.setVisible(false);
		amigos.setEnabled(false);
		movimientoPaginas.setVisible(true);
		
		pagAct=1;
		cargarUsuarios(2);
	}
	public void usuariosReportados(){
		datosPerfil.setVisible(false);
		usuariosReportados.setEnabled(false);
		movimientoPaginas.setVisible(true);
		
		pagAct=1;
		cargarUsuarios(3);
	}
	public void usuariosBaneados(){
		datosPerfil.setVisible(false);
		usuariosBaneados.setEnabled(false);
		movimientoPaginas.setVisible(true);
		
		pagAct=1;
		cargarUsuarios(4);
	}
	
	public void pagAde() {
		pagAct++;
		pagAntUsu.setVisible(true);
		if(pagAct==maxPag) pagAdeUsu.setVisible(false);
	}
	
	public void pagAtr() {
		pagAct--;
		pagAdeUsu.setVisible(true);
		if(pagAct==1) pagAntUsu.setVisible(false);
	}
	
	public void cargarUsuarios(int a) {
		tipoLista=a;
		switch(a) {
		case 1:
			usuarios=iadm.cargarUsuarios(usu.getORMID());
			break;
		case 2:
			usuarios=iadm.cargarAmigos(usu.getORMID());
			break;
		case 3:
			usuarios=iadm.cargarUsuariosReportados();
			break;
		case 4:
			usuarios=iadm.cargarUsuariosBaneados();
			break;
		}
		
		if(usuarios==null) {
			
		}else if(usuarios.length>10) {
			maxPag=usuarios.length/10;
			numEleUltPos=usuarios.length%10;
			pagAdeUsu.setVisible(true);
		}else {
			maxPag=1;
			numEleUltPos=usuarios.length;
		}
		cargarPagina();
	}
	
	public void cargarPagina() {
		int numV=0;
		int posI=0;
		
		listaUsuarios.removeAllComponents();
		if(maxPag==pagAct) {
			numV=numEleUltPos;
			posI=10*(pagAct-1);
		}else {
			numV=10;
			posI=10*(pagAct-1);
		}
		
		switch(tipoLista) {
		case 1:
			listaUsuarios.addComponent(new UsuariosReg(usu, numV, posI, usuarios));
			break;
		case 2:
			listaUsuarios.addComponent(new Amigos(usu, numV, posI, usuarios));
			break;
		case 3:
			listaUsuarios.addComponent(new Usuarios_Para_Revision(usu, numV, posI, usuarios));
			break;
		case 4:
			listaUsuarios.addComponent(new UsuariosAdm(usu, numV, posI, usuarios));
			break;
		}
	}
	
	
	
}