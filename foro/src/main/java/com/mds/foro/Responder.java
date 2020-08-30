package com.mds.foro;

import com.mds.interfaz.DB_Main;
import com.mds.interfaz.iComun_registrados;

public class Responder {

	static iComun_registrados icr = new DB_Main();
	
	public static void responder(int usu, int idRes, int idTem, String respuesta, String foto, String video) {
		icr.crearMensaje(usu, idRes, idTem, respuesta, foto, video);
	}
}
