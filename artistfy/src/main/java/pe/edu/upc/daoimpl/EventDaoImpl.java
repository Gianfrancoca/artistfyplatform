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
	
	@Transactional
	@Override
	public void delete(int IdEvent) {
		// TODO Auto-generated method stub
		Event ev = new Event();
		try {
			ev=em.getReference(Event.class, IdEvent);
			em.remove(ev);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar");
		}
	}
	
	@Transactional
	@Override
	public void update(Event ev) {
		// TODO Auto-generated method stub
		try {
			em.merge(ev);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modificar");
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findByName(Event ev) {
		// TODO Auto-generated method stub
		List<Event> lista=new ArrayList<Event>();
		try {
			Query q = em.createQuery("from Event e where e.name like ?1");
			q.setParameter(1, "%" + ev.getName() + "%");
			lista=(List<Event>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		
		return lista;
	}

}
