package com.mds.foro;

import javax.servlet.annotation.WebServlet;

import com.mds.database.Temas;
import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iAdministrador;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	static iAdministrador iadm = new DB_Main();
	public static Navigator navigator;
	public static com.mds.database.Usuario sesionUsuario = null;
	protected static final String MAINVIEW = "main";

	@Override
	protected void init(VaadinRequest vaadinRequest) {

//        Comun_registrados creg=new Comun_registrados(null);
//        setContent(creg);
		// Create a navigator to control the views
		navigator = new Navigator(this, this);

		// Create and register the views
		navigator.addView("", new Comun_usuarios());
		navigator.addView(MAINVIEW, new Comun_usuarios());
		navigator.addView("login", new Iniciar_Sesion());
		navigator.addView("register", new Registrarse());
		navigator.addView("recordarContrasena", new Recordar_contrasena());
		
		cargarPaginas();
	}

	public static void cargarPaginas() {
		
		com.mds.database.Secciones[] sec=iadm.cargarSecciones();
		
		if(sec!=null) {
			for(com.mds.database.Secciones secAux: sec) {
				navigator.addView("seccion/"+secAux.getORMID(), new com.mds.foro.Temas(secAux));
				Temas[] tem=iadm.cargarTodosLosTemas(secAux.getORMID());
				if(tem!=null) {
					for (com.mds.database.Temas temAux: tem) {
						navigator.addView("seccion/"+secAux.getORMID()+"/tema/"+temAux.getORMID(), new com.mds.foro.Mensajes(secAux, temAux));
					}
				}
			}
		}
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
