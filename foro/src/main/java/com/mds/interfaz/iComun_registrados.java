package com.mds.interfaz;

public interface iComun_registrados {

	public void Dar_me_gusta(int aID, int aIDU);

	public void Eliminar_mensaje(int aID);

	public void crearMensaje(int aID, int idR, int idT, String aMensaje);

	public void Dar_me_gusta_tema(int aID, int aIDU);
	
	public boolean leGustaTema (int aID, int aIDU );
	
	public boolean leGustaMensaje (int aID, int aIDU);
}