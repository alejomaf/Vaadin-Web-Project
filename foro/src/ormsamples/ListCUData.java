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
		com.mds.database.Notificaciones[] commdsdatabaseNotificacioneses = com.mds.database.NotificacionesDAO.listNotificacionesByQuery(null, null);
		int length = Math.min(commdsdatabaseNotificacioneses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseNotificacioneses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario...");
		com.mds.database.Usuario[] commdsdatabaseUsuarios = com.mds.database.UsuarioDAO.listUsuarioByQuery(null, null);
		length = Math.min(commdsdatabaseUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Moderador...");
		com.mds.database.Moderador[] commdsdatabaseModeradors = com.mds.database.ModeradorDAO.listModeradorByQuery(null, null);
		length = Math.min(commdsdatabaseModeradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseModeradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		com.mds.database.Administrador[] commdsdatabaseAdministradors = com.mds.database.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(commdsdatabaseAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Temas...");
		com.mds.database.Temas[] commdsdatabaseTemases = com.mds.database.TemasDAO.listTemasByQuery(null, null);
		length = Math.min(commdsdatabaseTemases.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseTemases[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Mensaje...");
		com.mds.database.Mensaje[] commdsdatabaseMensajes = com.mds.database.MensajeDAO.listMensajeByQuery(null, null);
		length = Math.min(commdsdatabaseMensajes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseMensajes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Media...");
		com.mds.database.Media[] commdsdatabaseMedias = com.mds.database.MediaDAO.listMediaByQuery(null, null);
		length = Math.min(commdsdatabaseMedias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseMedias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Video...");
		com.mds.database.Video[] commdsdatabaseVideos = com.mds.database.VideoDAO.listVideoByQuery(null, null);
		length = Math.min(commdsdatabaseVideos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseVideos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Secciones...");
		com.mds.database.Secciones[] commdsdatabaseSeccioneses = com.mds.database.SeccionesDAO.listSeccionesByQuery(null, null);
		length = Math.min(commdsdatabaseSeccioneses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseSeccioneses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Foto...");
		com.mds.database.Foto[] commdsdatabaseFotos = com.mds.database.FotoDAO.listFotoByQuery(null, null);
		length = Math.min(commdsdatabaseFotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commdsdatabaseFotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Notificaciones by Criteria...");
		com.mds.database.NotificacionesCriteria lcommdsdatabaseNotificacionesCriteria = new com.mds.database.NotificacionesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseNotificacionesCriteria.id_notificaciones.eq();
		lcommdsdatabaseNotificacionesCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Notificaciones[] commdsdatabaseNotificacioneses = lcommdsdatabaseNotificacionesCriteria.listNotificaciones();
		int length =commdsdatabaseNotificacioneses== null ? 0 : Math.min(commdsdatabaseNotificacioneses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseNotificacioneses[i]);
		}
		System.out.println(length + " Notificaciones record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		com.mds.database.UsuarioCriteria lcommdsdatabaseUsuarioCriteria = new com.mds.database.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseUsuarioCriteria.id_usuario.eq();
		lcommdsdatabaseUsuarioCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Usuario[] commdsdatabaseUsuarios = lcommdsdatabaseUsuarioCriteria.listUsuario();
		length =commdsdatabaseUsuarios== null ? 0 : Math.min(commdsdatabaseUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Moderador by Criteria...");
		com.mds.database.ModeradorCriteria lcommdsdatabaseModeradorCriteria = new com.mds.database.ModeradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseModeradorCriteria.id_usuario.eq();
		lcommdsdatabaseModeradorCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Moderador[] commdsdatabaseModeradors = lcommdsdatabaseModeradorCriteria.listModerador();
		length =commdsdatabaseModeradors== null ? 0 : Math.min(commdsdatabaseModeradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseModeradors[i]);
		}
		System.out.println(length + " Moderador record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		com.mds.database.AdministradorCriteria lcommdsdatabaseAdministradorCriteria = new com.mds.database.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseAdministradorCriteria.id_usuario.eq();
		lcommdsdatabaseAdministradorCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Administrador[] commdsdatabaseAdministradors = lcommdsdatabaseAdministradorCriteria.listAdministrador();
		length =commdsdatabaseAdministradors== null ? 0 : Math.min(commdsdatabaseAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Temas by Criteria...");
		com.mds.database.TemasCriteria lcommdsdatabaseTemasCriteria = new com.mds.database.TemasCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseTemasCriteria.id_tema.eq();
		lcommdsdatabaseTemasCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Temas[] commdsdatabaseTemases = lcommdsdatabaseTemasCriteria.listTemas();
		length =commdsdatabaseTemases== null ? 0 : Math.min(commdsdatabaseTemases.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseTemases[i]);
		}
		System.out.println(length + " Temas record(s) retrieved."); 
		
		System.out.println("Listing Mensaje by Criteria...");
		com.mds.database.MensajeCriteria lcommdsdatabaseMensajeCriteria = new com.mds.database.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseMensajeCriteria.id_mensaje.eq();
		lcommdsdatabaseMensajeCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Mensaje[] commdsdatabaseMensajes = lcommdsdatabaseMensajeCriteria.listMensaje();
		length =commdsdatabaseMensajes== null ? 0 : Math.min(commdsdatabaseMensajes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseMensajes[i]);
		}
		System.out.println(length + " Mensaje record(s) retrieved."); 
		
		System.out.println("Listing Media by Criteria...");
		com.mds.database.MediaCriteria lcommdsdatabaseMediaCriteria = new com.mds.database.MediaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseMediaCriteria.id_media.eq();
		lcommdsdatabaseMediaCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Media[] commdsdatabaseMedias = lcommdsdatabaseMediaCriteria.listMedia();
		length =commdsdatabaseMedias== null ? 0 : Math.min(commdsdatabaseMedias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseMedias[i]);
		}
		System.out.println(length + " Media record(s) retrieved."); 
		
		System.out.println("Listing Video by Criteria...");
		com.mds.database.VideoCriteria lcommdsdatabaseVideoCriteria = new com.mds.database.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseVideoCriteria.id_media.eq();
		lcommdsdatabaseVideoCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Video[] commdsdatabaseVideos = lcommdsdatabaseVideoCriteria.listVideo();
		length =commdsdatabaseVideos== null ? 0 : Math.min(commdsdatabaseVideos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseVideos[i]);
		}
		System.out.println(length + " Video record(s) retrieved."); 
		
		System.out.println("Listing Secciones by Criteria...");
		com.mds.database.SeccionesCriteria lcommdsdatabaseSeccionesCriteria = new com.mds.database.SeccionesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseSeccionesCriteria.id_secciones.eq();
		lcommdsdatabaseSeccionesCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Secciones[] commdsdatabaseSeccioneses = lcommdsdatabaseSeccionesCriteria.listSecciones();
		length =commdsdatabaseSeccioneses== null ? 0 : Math.min(commdsdatabaseSeccioneses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseSeccioneses[i]);
		}
		System.out.println(length + " Secciones record(s) retrieved."); 
		
		System.out.println("Listing Foto by Criteria...");
		com.mds.database.FotoCriteria lcommdsdatabaseFotoCriteria = new com.mds.database.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommdsdatabaseFotoCriteria.id_media.eq();
		lcommdsdatabaseFotoCriteria.setMaxResults(ROW_COUNT);
		com.mds.database.Foto[] commdsdatabaseFotos = lcommdsdatabaseFotoCriteria.listFoto();
		length =commdsdatabaseFotos== null ? 0 : Math.min(commdsdatabaseFotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commdsdatabaseFotos[i]);
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
