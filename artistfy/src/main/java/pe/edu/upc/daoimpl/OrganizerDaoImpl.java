package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IorganizerDao;
import pe.edu.upc.entity.Organizer;

public class OrganizerDaoImpl implements IorganizerDao, Serializable {


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "artistfy")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Organizer organizer) {
		// TODO Auto-generated method stub
		try {
			
			em.persist(organizer);

		} catch (Exception e) {
			System.out.println("Error insert DAOImpl");
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Organizer> list() {
		
		List<Organizer> lista=new ArrayList<Organizer>();
		
		try {
			Query q = em.createQuery("from Organizer i");
			lista= (List<Organizer>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar DAOImpl");
		}
		
		
		return lista;
	}

	@Transactional
	@Override
	public void delete(int IdOrganizer) {
		// TODO Auto-generated method stub
		Organizer or = new Organizer();
		try {
			or=em.getReference(Organizer.class, IdOrganizer);
			em.remove(or);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar");	
		}
		
	}

	@Transactional
	@Override
	public void update(Organizer or) {
		// TODO Auto-generated method stub
		try {
			em.merge(or);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modificar");
		}
		
	}

}
