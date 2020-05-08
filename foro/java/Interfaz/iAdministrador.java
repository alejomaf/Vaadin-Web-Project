package Interfaz;

public interface iAdministrador extends iUsuario_Registrado, iComun_privilegiados, iComun_registrados {

	public void Conceder_privilegios(int aID);

	public void Retirar_privilegios(int aID);

	public void Privatizar_tema(int aID);

	public void Banear(int aID);

	public void Desbanear(int aID);

	public void cargarSecciones();

	public void cargarNotificaciones();

	public void cargarMensajes();

	public void cargarAmigos();

	public void cargarUsuariosReportados();
}