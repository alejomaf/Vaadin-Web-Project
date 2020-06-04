/**
 * Licensee: Alejo Martín Arias Filippo(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteCUData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.mds.database.CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Notificaciones lcommdsdatabaseNotificaciones = com.mds.database.NotificacionesDAO.loadNotificacionesByQuery(null, null);
			// Delete the persistent object
			com.mds.database.NotificacionesDAO.delete(lcommdsdatabaseNotificaciones);
			com.mds.database.Usuario lcommdsdatabaseUsuario = com.mds.database.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			com.mds.database.UsuarioDAO.delete(lcommdsdatabaseUsuario);
			com.mds.database.Moderador lcommdsdatabaseModerador = com.mds.database.ModeradorDAO.loadModeradorByQuery(null, null);
			// Delete the persistent object
			com.mds.database.ModeradorDAO.delete(lcommdsdatabaseModerador);
			com.mds.database.Administrador lcommdsdatabaseAdministrador = com.mds.database.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			com.mds.database.AdministradorDAO.delete(lcommdsdatabaseAdministrador);
			com.mds.database.Temas lcommdsdatabaseTemas = com.mds.database.TemasDAO.loadTemasByQuery(null, null);
			// Delete the persistent object
			com.mds.database.TemasDAO.delete(lcommdsdatabaseTemas);
			com.mds.database.Mensaje lcommdsdatabaseMensaje = com.mds.database.MensajeDAO.loadMensajeByQuery(null, null);
			// Delete the persistent object
			com.mds.database.MensajeDAO.delete(lcommdsdatabaseMensaje);
			com.mds.database.Media lcommdsdatabaseMedia = com.mds.database.MediaDAO.loadMediaByQuery(null, null);
			// Delete the persistent object
			com.mds.database.MediaDAO.delete(lcommdsdatabaseMedia);
			com.mds.database.Video lcommdsdatabaseVideo = com.mds.database.VideoDAO.loadVideoByQuery(null, null);
			// Delete the persistent object
			com.mds.database.VideoDAO.delete(lcommdsdatabaseVideo);
			com.mds.database.Secciones lcommdsdatabaseSecciones = com.mds.database.SeccionesDAO.loadSeccionesByQuery(null, null);
			// Delete the persistent object
			com.mds.database.SeccionesDAO.delete(lcommdsdatabaseSecciones);
			com.mds.database.Foto lcommdsdatabaseFoto = com.mds.database.FotoDAO.loadFotoByQuery(null, null);
			// Delete the persistent object
			com.mds.database.FotoDAO.delete(lcommdsdatabaseFoto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteCUData deleteCUData = new DeleteCUData();
			try {
				deleteCUData.deleteTestData();
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
