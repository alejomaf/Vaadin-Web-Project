package com.mds.interfaz;

public interface iModerador extends iUsuario_Registrado, iComun_privilegiados, iComun_registrados {

	public void Desmarcar(int aID);

	public void Marcar(int aID);
}