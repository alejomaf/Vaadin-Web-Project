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
			com.mds.database.Notificaciones lcommdsforoNotificaciones = com.mds.database.NotificacionesDAO.loadNotificacionesByQuery(null, null);
			// Delete the persistent object
			com.mds.database.NotificacionesDAO.delete(lcommdsforoNotificaciones);
			com.mds.database.Usuario lcommdsforoUsuario = com.mds.database.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			com.mds.database.UsuarioDAO.delete(lcommdsforoUsuario);
			com.mds.database.Moderador lcommdsforoModerador = com.mds.database.ModeradorDAO.loadModeradorByQuery(null, null);
			// Delete the persistent object
			com.mds.database.ModeradorDAO.delete(lcommdsforoModerador);
			com.mds.database.Administrador lcommdsforoAdministrador = com.mds.database.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			com.mds.database.AdministradorDAO.delete(lcommdsforoAdministrador);
			com.mds.database.Temas lcommdsforoTemas = com.mds.database.TemasDAO.loadTemasByQuery(null, null);
			// Delete the persistent object
			com.mds.database.TemasDAO.delete(lcommdsforoTemas);
			com.mds.database.Mensaje lcommdsforoMensaje = com.mds.database.MensajeDAO.loadMensajeByQuery(null, null);
			// Delete the persistent object
			com.mds.database.MensajeDAO.delete(lcommdsforoMensaje);
			com.mds.database.Media lcommdsforoMedia = com.mds.database.MediaDAO.loadMediaByQuery(null, null);
			// Delete the persistent object
			com.mds.database.MediaDAO.delete(lcommdsforoMedia);
			com.mds.database.Video lcommdsforoVideo = com.mds.database.VideoDAO.loadVideoByQuery(null, null);
			// Delete the persistent object
			com.mds.database.VideoDAO.delete(lcommdsforoVideo);
			com.mds.database.Secciones lcommdsforoSecciones = com.mds.database.SeccionesDAO.loadSeccionesByQuery(null, null);
			// Delete the persistent object
			com.mds.database.SeccionesDAO.delete(lcommdsforoSecciones);
			com.mds.database.Foto lcommdsforoFoto = com.mds.database.FotoDAO.loadFotoByQuery(null, null);
			// Delete the persistent object
			com.mds.database.FotoDAO.delete(lcommdsforoFoto);
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
