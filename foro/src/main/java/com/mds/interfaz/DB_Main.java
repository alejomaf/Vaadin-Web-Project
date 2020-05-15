package com.mds.interfaz;

public class DB_Main implements iCorreo, iAdministrador, iUsuario_Registrado, iComun_usuarios, iUsuario_No_Registrado, iUsuario_propietario_mensaje, iModerador, iComun_privilegiados, iComun_registrados {

	public boolean modificarContrasena(int aID) {
		throw new UnsupportedOperationException();
	}

	public void modificarPerfil(String aNombreCompleto, String aDescripcion, String aImagen) {
		throw new UnsupportedOperationException();
	}

	public void Enviar_solicitud_amistad(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_amigos(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_notificacion(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Dar_me_gusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_mensaje(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearMensaje(int aID, String aMensaje) {
		throw new UnsupportedOperationException();
	}

	public void Dar_me_gusta_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Eliminar_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Crear_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Conceder_privilegios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Retirar_privilegios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Privatizar_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Banear(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Desbanear(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cargarSecciones() {
		throw new UnsupportedOperationException();
	}

	public void cargarNotificaciones() {
		throw new UnsupportedOperationException();
	}

	public void cargarMensajes() {
		throw new UnsupportedOperationException();
	}

	public void cargarAmigos() {
		throw new UnsupportedOperationException();
	}

	public void cargarUsuariosReportados() {
		throw new UnsupportedOperationException();
	}

	public void buscarSeccion(String aBusqueda) {
		throw new UnsupportedOperationException();
	}

	public void registrarse() {
		throw new UnsupportedOperationException();
	}

	public void iniciarSesion(String aUsuario, String aContrasena) {
		throw new UnsupportedOperationException();
	}

	public void Desmarcar(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Marcar(int aID) {
		throw new UnsupportedOperationException();
	}
}