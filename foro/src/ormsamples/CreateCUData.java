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
			com.mds.database.Notificaciones lcommdsforoNotificaciones = com.mds.database.NotificacionesDAO.createNotificaciones();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : de
			com.mds.database.NotificacionesDAO.save(lcommdsforoNotificaciones);
			com.mds.database.Usuario lcommdsforoUsuario = com.mds.database.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : gustaT, es_reportado_por, gustaM, eliminado_por, es_amigo_de, tiene, reporta_a, escribe, creaT, reportado, moderador, amigo_de
			com.mds.database.UsuarioDAO.save(lcommdsforoUsuario);
			com.mds.database.Moderador lcommdsforoModerador = com.mds.database.ModeradorDAO.createModerador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : eliminaMod
			com.mds.database.ModeradorDAO.save(lcommdsforoModerador);
			com.mds.database.Administrador lcommdsforoAdministrador = com.mds.database.AdministradorDAO.createAdministrador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : elimina, creaS
			com.mds.database.AdministradorDAO.save(lcommdsforoAdministrador);
			com.mds.database.Temas lcommdsforoTemas = com.mds.database.TemasDAO.createTemas();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ocultos, privados, publico, tiene, creado_por, num__likes, temas, pertenece_a, son, es, es_gustado
			com.mds.database.TemasDAO.save(lcommdsforoTemas);
			com.mds.database.Mensaje lcommdsforoMensaje = com.mds.database.MensajeDAO.createMensaje();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contiene, pertenece_a, tiene, privado, num_likes, son_de, es_gustado, respuesta_de, eliminado_por
			com.mds.database.MensajeDAO.save(lcommdsforoMensaje);
			com.mds.database.Media lcommdsforoMedia = com.mds.database.MediaDAO.createMedia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : es_de
			com.mds.database.MediaDAO.save(lcommdsforoMedia);
			com.mds.database.Video lcommdsforoVideo = com.mds.database.VideoDAO.createVideo();
			// Initialize the properties of the persistent object here
			com.mds.database.VideoDAO.save(lcommdsforoVideo);
			com.mds.database.Secciones lcommdsforoSecciones = com.mds.database.SeccionesDAO.createSecciones();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tiene, es_creada_por
			com.mds.database.SeccionesDAO.save(lcommdsforoSecciones);
			com.mds.database.Foto lcommdsforoFoto = com.mds.database.FotoDAO.createFoto();
			// Initialize the properties of the persistent object here
			com.mds.database.FotoDAO.save(lcommdsforoFoto);
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
