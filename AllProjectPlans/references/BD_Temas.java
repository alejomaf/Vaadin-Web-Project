package com.mds.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
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

	public void Privatizar_tema(int aID) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem=TemasDAO.loadTemasByORMID(aID);
			tem.setPublico(false);
			TemasDAO.save(tem);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void Dar_me_gusta(int aID, int aIDU) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem = TemasDAO.loadTemasByORMID(aID);
			com.mds.database.Usuario usu=UsuarioDAO.loadUsuarioByORMID(aIDU);
			usu.gustaT.add(tem);
			tem.setNum__likes(tem.getNum__likes()+1);
			TemasDAO.save(tem);
			UsuarioDAO.save(usu);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
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
			tem.setFechaTema(new java.util.Date());
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
			tem = TemasDAO.listTemasByQuery("SeccionesId_secciones = \'"+sec.getId_secciones()+"\' AND Publico = \'"+1+"\'", null);
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

	public boolean leGustaTema(int aID, int aIDU) throws PersistentException {
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem= TemasDAO.loadTemasByORMID(aID);
			if(tem.leGustaTema.contains(UsuarioDAO.loadUsuarioByORMID(aIDU))) return true;
		}catch (Exception e) {
			t.rollback();
			return false;
		}
		CUPersistentManager.instance().disposePersistentManager();
		return false;
	}

	public Temas[] cargarTemasRecientes() throws PersistentException{
		com.mds.database.Temas[] tem=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			tem = TemasDAO.listTemasByQuery("Publico = \'"+1+"\'", null);
			if(tem.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		if(tem.length>3) return Arrays.copyOfRange(tem, 0, 2);
		return tem;
	}

	public Temas[] cargarTodosLosTema(int aID) throws PersistentException{
		com.mds.database.Temas[] tem=null;
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			tem = TemasDAO.listTemasByQuery("SeccionesId_secciones = \'"+aID+"\'", null);
			if(tem.length==0) { CUPersistentManager.instance().disposePersistentManager(); return null;}
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
		return tem;
	}

	public void mostrarTema(Temas tema) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem=TemasDAO.loadTemasByORMID(tema.getORMID());
			tem.setPublico(true);
			TemasDAO.save(tem);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}

	public void ocultarTema(Temas tema) throws PersistentException{
		PersistentTransaction t= CUPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mds.database.Temas tem=TemasDAO.loadTemasByORMID(tema.getORMID());
			tem.setPublico(false);
			TemasDAO.save(tem);
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		CUPersistentManager.instance().disposePersistentManager();
	}
}