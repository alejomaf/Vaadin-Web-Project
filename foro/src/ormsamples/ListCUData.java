/**
 * Licensee: Alejo Martín Arias Filippo(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListCUData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Notificaciones...");
		com.mds.database.Notificaciones[] commdsforoNotificacioneses = com.mds.database.NotificacionesDAO.listNotificacionesByQuery(null, null);
		int length = Math.min(commdsforoNotificacioneses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoNotificacioneses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario...");
		com.mds.database.Usuario[] commdsforoUsuarios = com.mds.database.UsuarioDAO.listUsuarioByQuery(null, null);
		length = Math.min(commdsforoUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Moderador...");
		com.mds.database.Moderador[] commdsforoModeradors = com.mds.database.ModeradorDAO.listModeradorByQuery(null, null);
		length = Math.min(commdsforoModeradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoModeradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		com.mds.database.Administrador[] commdsforoAdministradors = com.mds.database.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(commdsforoAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Temas...");
		com.mds.database.Temas[] commdsforoTemases = com.mds.database.TemasDAO.listTemasByQuery(null, null);
		length = Math.min(commdsforoTemases.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoTemases[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Mensaje...");
		com.mds.database.Mensaje[] commdsforoMensajes = com.mds.database.MensajeDAO.listMensajeByQuery(null, null);
		length = Math.min(commdsforoMensajes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoMensajes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Media...");
		com.mds.database.Media[] commdsforoMedias = com.mds.database.MediaDAO.listMediaByQuery(null, null);
		length = Math.min(commdsforoMedias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoMedias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Video...");
		com.mds.database.Video[] commdsforoVideos = com.mds.database.VideoDAO.listVideoByQuery(null, null);
		length = Math.min(commdsforoVideos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoVideos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Secciones...");
		com.mds.database.Secciones[] commdsforoSeccioneses = com.mds.database.SeccionesDAO.listSeccionesByQuery(null, null);
		length = Math.min(commdsforoSeccioneses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoSeccioneses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Foto...");
		com.mds.database.Foto[] commdsforoFotos = com.mds.database.FotoDAO.listFotoByQuery(null, null);
		length = Math.min(commdsforoFotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsforoFotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Notificaciones by Criteria...");
		com.mds.database.NotificacionesCriteria lcommdsforoNotificacionesCriteria = new com.mds.database.NotificacionesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoNotificacionesCriteria.id_notificaciones.eq();
		lcommdsforoNotificacionesCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Notificaciones[] commdsforoNotificacioneses = lcommdsforoNotificacionesCriteria.listNotificaciones();
		int length =commdsforoNotificacioneses== null ? 0 : Math.min(commdsforoNotificacioneses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoNotificacioneses[i]);
		}
		System.out.println(length + " Notificaciones record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		com.mds.database.UsuarioCriteria lcommdsforoUsuarioCriteria = new com.mds.database.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoUsuarioCriteria.id_usuario.eq();
		lcommdsforoUsuarioCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Usuario[] commdsforoUsuarios = lcommdsforoUsuarioCriteria.listUsuario();
		length =commdsforoUsuarios== null ? 0 : Math.min(commdsforoUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Moderador by Criteria...");
		com.mds.database.ModeradorCriteria lcommdsforoModeradorCriteria = new com.mds.database.ModeradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoModeradorCriteria.id_usuario.eq();
		lcommdsforoModeradorCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Moderador[] commdsforoModeradors = lcommdsforoModeradorCriteria.listModerador();
		length =commdsforoModeradors== null ? 0 : Math.min(commdsforoModeradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoModeradors[i]);
		}
		System.out.println(length + " Moderador record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		com.mds.database.AdministradorCriteria lcommdsforoAdministradorCriteria = new com.mds.database.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoAdministradorCriteria.id_usuario.eq();
		lcommdsforoAdministradorCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Administrador[] commdsforoAdministradors = lcommdsforoAdministradorCriteria.listAdministrador();
		length =commdsforoAdministradors== null ? 0 : Math.min(commdsforoAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Temas by Criteria...");
		com.mds.database.TemasCriteria lcommdsforoTemasCriteria = new com.mds.database.TemasCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoTemasCriteria.id_tema.eq();
		lcommdsforoTemasCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Temas[] commdsforoTemases = lcommdsforoTemasCriteria.listTemas();
		length =commdsforoTemases== null ? 0 : Math.min(commdsforoTemases.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoTemases[i]);
		}
		System.out.println(length + " Temas record(s) retrieved."); 
		
		System.out.println("Listing Mensaje by Criteria...");
		com.mds.database.MensajeCriteria lcommdsforoMensajeCriteria = new com.mds.database.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoMensajeCriteria.id_mensaje.eq();
		lcommdsforoMensajeCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Mensaje[] commdsforoMensajes = lcommdsforoMensajeCriteria.listMensaje();
		length =commdsforoMensajes== null ? 0 : Math.min(commdsforoMensajes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoMensajes[i]);
		}
		System.out.println(length + " Mensaje record(s) retrieved."); 
		
		System.out.println("Listing Media by Criteria...");
		com.mds.database.MediaCriteria lcommdsforoMediaCriteria = new com.mds.database.MediaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoMediaCriteria.id_media.eq();
		lcommdsforoMediaCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Media[] commdsforoMedias = lcommdsforoMediaCriteria.listMedia();
		length =commdsforoMedias== null ? 0 : Math.min(commdsforoMedias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoMedias[i]);
		}
		System.out.println(length + " Media record(s) retrieved."); 
		
		System.out.println("Listing Video by Criteria...");
		com.mds.database.VideoCriteria lcommdsforoVideoCriteria = new com.mds.database.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoVideoCriteria.id_media.eq();
		lcommdsforoVideoCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Video[] commdsforoVideos = lcommdsforoVideoCriteria.listVideo();
		length =commdsforoVideos== null ? 0 : Math.min(commdsforoVideos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoVideos[i]);
		}
		System.out.println(length + " Video record(s) retrieved."); 
		
		System.out.println("Listing Secciones by Criteria...");
		com.mds.database.SeccionesCriteria lcommdsforoSeccionesCriteria = new com.mds.database.SeccionesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoSeccionesCriteria.id_secciones.eq();
		lcommdsforoSeccionesCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Secciones[] commdsforoSeccioneses = lcommdsforoSeccionesCriteria.listSecciones();
		length =commdsforoSeccioneses== null ? 0 : Math.min(commdsforoSeccioneses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoSeccioneses[i]);
		}
		System.out.println(length + " Secciones record(s) retrieved."); 
		
		System.out.println("Listing Foto by Criteria...");
		com.mds.database.FotoCriteria lcommdsforoFotoCriteria = new com.mds.database.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsforoFotoCriteria.id_media.eq();
		lcommdsforoFotoCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Foto[] commdsforoFotos = lcommdsforoFotoCriteria.listFoto();
		length =commdsforoFotos== null ? 0 : Math.min(commdsforoFotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsforoFotos[i]);
		}
		System.out.println(length + " Foto record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListCUData listCUData = new ListCUData();
			try {
				listCUData.listTestData();
				//listCUData.listByCriteria();
			}
			finally {
				com.mds.database.CUPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
