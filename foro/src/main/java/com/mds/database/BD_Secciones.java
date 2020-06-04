package com.mds.database;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mds.database.Secciones;

public class BD_Secciones {
	public BD_Pincipal _bD_Pincipal;
	public Vector<Secciones> _unnamed_Secciones_ = new Vector<Secciones>();

	public void buscarSeccion(String aBusqueda) {
		throw new UnsupportedOperationException();
	}

	public com.mds.database.Secciones[] cargarSecciones() throws PersistentException {
		com.mds.database.Secciones[] sec=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			sec = SeccionesDAO.listSeccionesByQuery(null, null);
			if(sec.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return sec;
	}
	
	public void crearSeccion(String titulo) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Secciones sec = SeccionesDAO.createSecciones();
			sec.setNombre(titulo);
			
			SeccionesDAO.save(sec);
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
	
	public void borrarSecion(int aID) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Secciones sec = SeccionesDAO.loadSeccionesByORMID(aID);
			
			SeccionesDAO.delete(sec);
			
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
}