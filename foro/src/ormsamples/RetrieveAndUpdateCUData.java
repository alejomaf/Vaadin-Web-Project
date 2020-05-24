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
			com.mds.database.Notificaciones lcommdsforoNotificaciones = com.mds.database.NotificacionesDAO.loadNotificacionesByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.NotificacionesDAO.save(lcommdsforoNotificaciones);
			com.mds.database.Usuario lcommdsforoUsuario = com.mds.database.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.UsuarioDAO.save(lcommdsforoUsuario);
			com.mds.database.Moderador lcommdsforoModerador = com.mds.database.ModeradorDAO.loadModeradorByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.ModeradorDAO.save(lcommdsforoModerador);
			com.mds.database.Administrador lcommdsforoAdministrador = com.mds.database.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.AdministradorDAO.save(lcommdsforoAdministrador);
			com.mds.database.Temas lcommdsforoTemas = com.mds.database.TemasDAO.loadTemasByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.TemasDAO.save(lcommdsforoTemas);
			com.mds.database.Mensaje lcommdsforoMensaje = com.mds.database.MensajeDAO.loadMensajeByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.MensajeDAO.save(lcommdsforoMensaje);
			com.mds.database.Media lcommdsforoMedia = com.mds.database.MediaDAO.loadMediaByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.MediaDAO.save(lcommdsforoMedia);
			com.mds.database.Video lcommdsforoVideo = com.mds.database.VideoDAO.loadVideoByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.VideoDAO.save(lcommdsforoVideo);
			com.mds.database.Secciones lcommdsforoSecciones = com.mds.database.SeccionesDAO.loadSeccionesByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.SeccionesDAO.save(lcommdsforoSecciones);
			com.mds.database.Foto lcommdsforoFoto = com.mds.database.FotoDAO.loadFotoByQuery(null, null);
			// Update the properties of the persistent object
			com.mds.database.FotoDAO.save(lcommdsforoFoto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Notificaciones by NotificacionesCriteria");
		com.mds.database.NotificacionesCriteria lcommdsforoNotificacionesCriteria = new com.mds.database.NotificacionesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoNotificacionesCriteria.id_notificaciones.eq();
		System.out.println(lcommdsforoNotificacionesCriteria.uniqueNotificaciones());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		com.mds.database.UsuarioCriteria lcommdsforoUsuarioCriteria = new com.mds.database.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoUsuarioCriteria.id_usuario.eq();
		System.out.println(lcommdsforoUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Moderador by ModeradorCriteria");
		com.mds.database.ModeradorCriteria lcommdsforoModeradorCriteria = new com.mds.database.ModeradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoModeradorCriteria.id_usuario.eq();
		System.out.println(lcommdsforoModeradorCriteria.uniqueModerador());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		com.mds.database.AdministradorCriteria lcommdsforoAdministradorCriteria = new com.mds.database.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoAdministradorCriteria.id_usuario.eq();
		System.out.println(lcommdsforoAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Temas by TemasCriteria");
		com.mds.database.TemasCriteria lcommdsforoTemasCriteria = new com.mds.database.TemasCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoTemasCriteria.id_tema.eq();
		System.out.println(lcommdsforoTemasCriteria.uniqueTemas());
		
		System.out.println("Retrieving Mensaje by MensajeCriteria");
		com.mds.database.MensajeCriteria lcommdsforoMensajeCriteria = new com.mds.database.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoMensajeCriteria.id_mensaje.eq();
		System.out.println(lcommdsforoMensajeCriteria.uniqueMensaje());
		
		System.out.println("Retrieving Media by MediaCriteria");
		com.mds.database.MediaCriteria lcommdsforoMediaCriteria = new com.mds.database.MediaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoMediaCriteria.id_media.eq();
		System.out.println(lcommdsforoMediaCriteria.uniqueMedia());
		
		System.out.println("Retrieving Video by VideoCriteria");
		com.mds.database.VideoCriteria lcommdsforoVideoCriteria = new com.mds.database.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoVideoCriteria.id_media.eq();
		System.out.println(lcommdsforoVideoCriteria.uniqueVideo());
		
		System.out.println("Retrieving Secciones by SeccionesCriteria");
		com.mds.database.SeccionesCriteria lcommdsforoSeccionesCriteria = new com.mds.database.SeccionesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoSeccionesCriteria.id_secciones.eq();
		System.out.println(lcommdsforoSeccionesCriteria.uniqueSecciones());
		
		System.out.println("Retrieving Foto by FotoCriteria");
		com.mds.database.FotoCriteria lcommdsforoFotoCriteria = new com.mds.database.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommdsforoFotoCriteria.id_media.eq();
		System.out.println(lcommdsforoFotoCriteria.uniqueFoto());
		
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
