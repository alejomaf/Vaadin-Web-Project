/**
 * Licensee: Alejo Martín Arias Filippo(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateCUData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.mds.database.CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Notificaciones lcommdsdatabaseNotificaciones = com.mds.database.NotificacionesDAO.loadNotificacionesByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.NotificacionesDAO.save(lcommdsdatabaseNotificaciones);
			com.mds.database.Usuario lcommdsdatabaseUsuario = com.mds.database.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.UsuarioDAO.save(lcommdsdatabaseUsuario);
			com.mds.database.Moderador lcommdsdatabaseModerador = com.mds.database.ModeradorDAO.loadModeradorByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.ModeradorDAO.save(lcommdsdatabaseModerador);
			com.mds.database.Administrador lcommdsdatabaseAdministrador = com.mds.database.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.AdministradorDAO.save(lcommdsdatabaseAdministrador);
			com.mds.database.Temas lcommdsdatabaseTemas = com.mds.database.TemasDAO.loadTemasByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.TemasDAO.save(lcommdsdatabaseTemas);
			com.mds.database.Mensaje lcommdsdatabaseMensaje = com.mds.database.MensajeDAO.loadMensajeByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.MensajeDAO.save(lcommdsdatabaseMensaje);
			com.mds.database.Media lcommdsdatabaseMedia = com.mds.database.MediaDAO.loadMediaByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.MediaDAO.save(lcommdsdatabaseMedia);
			com.mds.database.Video lcommdsdatabaseVideo = com.mds.database.VideoDAO.loadVideoByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.VideoDAO.save(lcommdsdatabaseVideo);
			com.mds.database.Secciones lcommdsdatabaseSecciones = com.mds.database.SeccionesDAO.loadSeccionesByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.SeccionesDAO.save(lcommdsdatabaseSecciones);
			com.mds.database.Foto lcommdsdatabaseFoto = com.mds.database.FotoDAO.loadFotoByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.FotoDAO.save(lcommdsdatabaseFoto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Notificaciones by NotificacionesCriteria");
		com.mds.database.NotificacionesCriteria lcommdsdatabaseNotificacionesCriteria = new com.mds.database.NotificacionesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseNotificacionesCriteria.id_notificaciones.eq();
		System.out.println(lcommdsdatabaseNotificacionesCriteria.uniqueNotificaciones());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		com.mds.database.UsuarioCriteria lcommdsdatabaseUsuarioCriteria = new com.mds.database.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseUsuarioCriteria.id_usuario.eq();
		System.out.println(lcommdsdatabaseUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Moderador by ModeradorCriteria");
		com.mds.database.ModeradorCriteria lcommdsdatabaseModeradorCriteria = new com.mds.database.ModeradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseModeradorCriteria.id_usuario.eq();
		System.out.println(lcommdsdatabaseModeradorCriteria.uniqueModerador());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		com.mds.database.AdministradorCriteria lcommdsdatabaseAdministradorCriteria = new com.mds.database.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseAdministradorCriteria.id_usuario.eq();
		System.out.println(lcommdsdatabaseAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Temas by TemasCriteria");
		com.mds.database.TemasCriteria lcommdsdatabaseTemasCriteria = new com.mds.database.TemasCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseTemasCriteria.id_tema.eq();
		System.out.println(lcommdsdatabaseTemasCriteria.uniqueTemas());
		
		System.out.println("Retrieving Mensaje by MensajeCriteria");
		com.mds.database.MensajeCriteria lcommdsdatabaseMensajeCriteria = new com.mds.database.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseMensajeCriteria.id_mensaje.eq();
		System.out.println(lcommdsdatabaseMensajeCriteria.uniqueMensaje());
		
		System.out.println("Retrieving Media by MediaCriteria");
		com.mds.database.MediaCriteria lcommdsdatabaseMediaCriteria = new com.mds.database.MediaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseMediaCriteria.id_media.eq();
		System.out.println(lcommdsdatabaseMediaCriteria.uniqueMedia());
		
		System.out.println("Retrieving Video by VideoCriteria");
		com.mds.database.VideoCriteria lcommdsdatabaseVideoCriteria = new com.mds.database.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseVideoCriteria.id_media.eq();
		System.out.println(lcommdsdatabaseVideoCriteria.uniqueVideo());
		
		System.out.println("Retrieving Secciones by SeccionesCriteria");
		com.mds.database.SeccionesCriteria lcommdsdatabaseSeccionesCriteria = new com.mds.database.SeccionesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseSeccionesCriteria.id_secciones.eq();
		System.out.println(lcommdsdatabaseSeccionesCriteria.uniqueSecciones());
		
		System.out.println("Retrieving Foto by FotoCriteria");
		com.mds.database.FotoCriteria lcommdsdatabaseFotoCriteria = new com.mds.database.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsdatabaseFotoCriteria.id_media.eq();
		System.out.println(lcommdsdatabaseFotoCriteria.uniqueFoto());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateCUData retrieveAndUpdateCUData = new RetrieveAndUpdateCUData();
			try {
				retrieveAndUpdateCUData.retrieveAndUpdateTestData();
				//retrieveAndUpdateCUData.retrieveByCriteria();
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
