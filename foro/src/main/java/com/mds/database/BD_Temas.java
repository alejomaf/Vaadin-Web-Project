package com.mds.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mds.database.Temas;

public class BD_Temas implements Serializable {
	public BD_Pincipal _bD_Pincipal;
	public Vector<Temas> _unnamed_Temas_ = new Vector<Temas>();

	public void Eliminar_tema(int aID) throws PersistentException{
				PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
				try {
					com.mds.database.Mensaje[] men= MensajeDAO.listMensajeByQuery("TemasId_tema = \'"+aID+"\'", null);
					if(men!=null) for(Mensaje menAux: men) MensajeDAO.delete(menAux);
					t.commit();
					
				}catch (Exception e) {
					t.rollback();
				}

				PersistentTransaction t2= CUPersistentManager.instance().getSession().beginTransaction();
				try {	
					
				TemasDAO.delete(TemasDAO.loadTemasByORMID(aID));

				t2.commit();
				
				}catch (Exception e) {
					t2.rollback();
				}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Privatizar_tema(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Dar_me_gusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void Crear_tema(String titulo, String contenido, Usuario usu, Secciones sec) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem = TemasDAO.createTemas();
			tem.setNombre(titulo);
			tem.setNum__likes(0);
			tem.setCreado_por(UsuarioDAO.loadUsuarioByORMID(usu.getORMID()));
			tem.setContenido(contenido);
			tem.setPertenece_a(SeccionesDAO.loadSeccionesByORMID(sec.getORMID()));
			tem.setPublico(true);
			tem.setFechaTema(new Date(0));
			
			TemasDAO.save(tem);
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
	
	public com.mds.database.Temas[] cargarTema(Secciones sec) throws PersistentException{
		com.mds.database.Temas[] tem=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			tem = TemasDAO.listTemasByQuery("SeccionesId_secciones = \'"+sec.getId_secciones()+"\'", null);
			if(tem.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return tem;
	}

	public Temas cargarUnTema(int aID) throws PersistentException {
		com.mds.database.Temas tem=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			tem= TemasDAO.loadTemasByORMID(aID);
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return tem;
	}
}