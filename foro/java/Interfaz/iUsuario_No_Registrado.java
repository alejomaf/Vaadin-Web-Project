package Interfaz;

public interface iUsuario_No_Registrado extends iComun_usuarios {

	public void buscarSeccion(String aBusqueda);

	public void registrarse();

	public void iniciarSesion(String aUsuario, String aContrasena);
}