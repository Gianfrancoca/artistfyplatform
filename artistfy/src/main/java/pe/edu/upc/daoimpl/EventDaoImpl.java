package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IeventDao;
import pe.edu.upc.entity.Event;

public class EventDaoImpl implements IeventDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "artistfy")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Event event) {
		try {
			em.persist(event);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error insert DAOImpl");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> list() {
		
		List<Event> lista = new ArrayList<Event>();
		try {
			Query q = em.createQuery("from Event e");
			lista = (List<Event>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar DAOImpl");
		}
		
		return lista;
	}

}
