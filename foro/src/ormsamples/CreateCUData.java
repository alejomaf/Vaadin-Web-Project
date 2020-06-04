/**
 * Licensee: Alejo Martín Arias Filippo(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateCUData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.mds.database.CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Notificaciones lcommdsdatabaseNotificaciones = com.mds.database.NotificacionesDAO.createNotificaciones();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : de
			com.mds.database.NotificacionesDAO.save(lcommdsdatabaseNotificaciones);
			com.mds.database.Usuario lcommdsdatabaseUsuario = com.mds.database.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : gustaT, gustaM, es_amigo_de, tiene, escribe, creaT, eliminado, reportado, moderador, amigo_de
			com.mds.database.UsuarioDAO.save(lcommdsdatabaseUsuario);
			com.mds.database.Moderador lcommdsdatabaseModerador = com.mds.database.ModeradorDAO.createModerador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : eliminaMod
			com.mds.database.ModeradorDAO.save(lcommdsdatabaseModerador);
			com.mds.database.Administrador lcommdsdatabaseAdministrador = com.mds.database.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			com.mds.database.AdministradorDAO.save(lcommdsdatabaseAdministrador);
			com.mds.database.Temas lcommdsdatabaseTemas = com.mds.database.TemasDAO.createTemas();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tiene, creado_por, publico, num__likes, pertenece_a, es_gustado
			com.mds.database.TemasDAO.save(lcommdsdatabaseTemas);
			com.mds.database.Mensaje lcommdsdatabaseMensaje = com.mds.database.MensajeDAO.createMensaje();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contiene, pertenece_a, tiene, privado, num_likes, son_de, es_gustado, respuesta_de, eliminado_por
			com.mds.database.MensajeDAO.save(lcommdsdatabaseMensaje);
			com.mds.database.Media lcommdsdatabaseMedia = com.mds.database.MediaDAO.createMedia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : es_de
			com.mds.database.MediaDAO.save(lcommdsdatabaseMedia);
			com.mds.database.Video lcommdsdatabaseVideo = com.mds.database.VideoDAO.createVideo();
			// Initialize the properties of the persistent object here
			com.mds.database.VideoDAO.save(lcommdsdatabaseVideo);
			com.mds.database.Secciones lcommdsdatabaseSecciones = com.mds.database.SeccionesDAO.createSecciones();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tiene
			com.mds.database.SeccionesDAO.save(lcommdsdatabaseSecciones);
			com.mds.database.Foto lcommdsdatabaseFoto = com.mds.database.FotoDAO.createFoto();
			// Initialize the properties of the persistent object here
			com.mds.database.FotoDAO.save(lcommdsdatabaseFoto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateCUData createCUData = new CreateCUData();
			try {
				createCUData.createTestData();
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
