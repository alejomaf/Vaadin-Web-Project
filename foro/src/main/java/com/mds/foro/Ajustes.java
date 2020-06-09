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
	public int pagActNot=1;
	com.mds.database.Notificaciones[] notis;
	int primeraNotificacion;
	public int maxPagNot;
	public int secUltNot;
	
	
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
				cargaNotificaciones();
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
		notificacionAdelante.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAdelanteNot();
			}
		});
		
		notificacionAtras.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				pagAtrasNot();
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
	
	public void cargaNotificaciones() {
		notis=iadm.cargarNotificaciones(usu.getORMID());
		if(listaNotificaciones.isVisible()) {
			listaNotificaciones.setVisible(false);
		}else {
			if(notis==null) return;
			listaNotificaciones.setVisible(true);
			cargarListaNotificaciones();
		}
	}
	public void cargarListaNotificaciones() {
		configuracionNot();
		cargarPagNot();
	}
	
	public void cargarPartesNotificaciones(int num) {
		notificacion1.setVisible(false);
		notificacion2.setVisible(false);
		notificacion3.setVisible(false);
		switch(num) {
		case 0: 
			break;
		case 1:
			notificacion1.setVisible(true);
			break;
		case 2:
			notificacion1.setVisible(true);
			notificacion2.setVisible(true);
			break;
		case 3:
			notificacion1.setVisible(true);
			notificacion2.setVisible(true);
			notificacion3.setVisible(true);
			break;
		}
	}
	
	public void configuracionNot() {
		if(notis==null||notis.length<=3) {
			maxPagNot=1;
			if(notis==null) secUltNot=0;
			else secUltNot=notis.length;
		}
		else if(notis.length%3==0) {
			maxPagNot=(notis.length/3);
			secUltNot=3;
		}else {
			maxPagNot=((notis.length/3)+1);
			secUltNot=notis.length%3;
		}
	}
	
	public void cargarPagNot() {
		if(pagActNot==maxPagNot) {
			cargarPartesNotificaciones(secUltNot);
			escrituraNot(pagActNot, secUltNot);
			notificacionAdelante.setVisible(false);
			if (pagActNot!=1) notificacionAtras.setVisible(true);
		}
		else {
			if(pagActNot!=1) notificacionAtras.setVisible(true);
			else notificacionAtras.setVisible(false);
			notificacionAdelante.setVisible(true);
			cargarPartesNotificaciones(3);
			escrituraNot(pagActNot, 3);
		}
	}
	
	public void escrituraNot(int pag, int num){
		//Formula optimizada para calcular la posicion de la seccion
		primeraNotificacion=3*(pag-1);
		
		if(num<3) {
			if(num==2) {
				asignarValoresNotificaciones(tituloNotificacion, eliminarNotificacion, aceptarNotificacion, visualizarNotificacion, notificacion1);		
				primeraNotificacion++;
				asignarValoresNotificaciones(tituloNotificacion1, eliminarNotificacion1, aceptarNotificacion1, visualizarNotificacion1, notificacion2);	
			}	
			else asignarValoresNotificaciones(tituloNotificacion, eliminarNotificacion, aceptarNotificacion, visualizarNotificacion, notificacion1);	
		}
		else {
			asignarValoresNotificaciones(tituloNotificacion, eliminarNotificacion, aceptarNotificacion, visualizarNotificacion, notificacion1);		
			primeraNotificacion++;
			asignarValoresNotificaciones(tituloNotificacion1, eliminarNotificacion1, aceptarNotificacion1, visualizarNotificacion1, notificacion2);
			primeraNotificacion++;
			asignarValoresNotificaciones(tituloNotificacion2, eliminarNotificacion2, aceptarNotificacion2, visualizarNotificacion2, notificacion3);		
		}
		
	}
	
	public void pagAdelanteNot() {
		pagActNot++;
		cargarPagNot();
	}
	
	public void pagAtrasNot() {
		pagActNot--;
		cargarPagNot();
	}
	
	public void asignarValoresNotificaciones(Label tituloN, Button elimN, Button acepN, Button visuN, HorizontalLayout barra) {
		com.mds.database.Notificaciones not=notis[primeraNotificacion];
		barra.setVisible(true);
		
		String[] descom=not.getTitulo().split(",");
		
		if(not.getEnlace().equals("amistad")) {
			tituloN.setValue(descom[0]);
			elimN.setVisible(true);
			elimN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					iadm.borrarNotificacion(not.getORMID());
					cargaNotificaciones();
				}
			});
			acepN.setVisible(true);
			acepN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					iadm.aceptarSolicitud(usu.getORMID(), Integer.parseInt(descom[1]));
					cargaNotificaciones();
				}
			});
		}else {
			tituloN.setValue(descom[0]+" en: "+iadm.cargarTema(Integer.parseInt(descom[1])).getNombre());
			elimN.setVisible(true);
			elimN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					iadm.borrarNotificacion(not.getORMID());
					cargarListaNotificaciones();
				}
			});
			visuN.setVisible(true);
			visuN.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					setContent(new Tema(usu, iadm.cargarTema(Integer.parseInt(descom[1])).getPertenece_a() , iadm.cargarTema(Integer.parseInt(descom[1]))));
					iadm.borrarNotificacion(not.getORMID());
				}
			});
		}
		
	}
	
}