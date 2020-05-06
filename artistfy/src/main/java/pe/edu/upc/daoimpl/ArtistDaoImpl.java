package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IartistDao;
import pe.edu.upc.entity.Artist;

public class ArtistDaoImpl implements IartistDao, Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "artistfy")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Artist artist) {
		try {
			em.persist(artist);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error insert DAOimpl");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> list() {
		// TODO Auto-generated method stub
		List<Artist> lista = new ArrayList<Artist>();
		try {
			Query q = em.createQuery("from Artist a");
			lista=(List<Artist>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar DAOimpl");
		}
		return lista;
	}	

	@Transactional
	@Override
	public void delete(int IdArtist) {
		// TODO Auto-generated method stub
		Artist ar = new Artist();
		try {
			ar=em.getReference(Artist.class, IdArtist);
			em.remove(ar);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar");
		}
		
	}

	@Transactional
	@Override
	public void update(Artist ar) {
		// TODO Auto-generated method stub
		try {
			em.merge(ar);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modificar");
		}
	}

}
