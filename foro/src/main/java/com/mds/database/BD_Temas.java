package com.mds.database;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mds.database.Temas;

public class BD_Temas {
	public BD_Pincipal _bD_Pincipal;
	public Vector<Temas> _unnamed_Temas_ = new Vector<Temas>();

	public void Eliminar_tema(int aID) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem = TemasDAO.loadTemasByORMID(aID);
			
			TemasDAO.delete(tem);
			
			t.commit();
			
		}catch (Exception e) {
			t.rollback();
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
			tem.setCreado_por(usu);
			tem.setPertenece_a(sec);

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
			tem = TemasDAO.listTemasByQuery("id_secciones = \'"+sec.getId_secciones()+"\'", null);
			if(tem.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return tem;
	}
}