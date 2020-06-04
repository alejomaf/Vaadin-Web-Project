package com.mds.interfaz;

import com.mds.database.Secciones;
import com.mds.database.Usuario;

public interface iComun_privilegiados {

	public void Eliminar_mensaje(int aID);

	public void Eliminar_tema(int aID);

	public void Crear_tema(String titulo, String contenido, Usuario usu, Secciones sec);
}