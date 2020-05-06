package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IcontractDao;
import pe.edu.upc.entity.Contract;

public class ContractDaoImpl implements IcontractDao, Serializable{


	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "artistfy")
	private EntityManager em;
	
	
	@Transactional
	@Override
	public void insert(Contract contract) {
		// TODO Auto-generated method stub
		try {
			em.persist(contract);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en DAO insert");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> list() {
		// TODO Auto-generated method stub
		List<Contract> lista = new ArrayList<Contract>();
		
		try {
			Query q = em.createQuery("from Contract c");
			lista=(List<Contract>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en DAO list");
		}
				
		return lista;
	}

	@Transactional
	@Override
	public void delete(int IdContract) {
		// TODO Auto-generated method stub
		Contract co = new Contract();
		
		try {
			co=em.getReference(Contract.class, IdContract);
			em.remove(co);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar");
		}
		
	}

	@Transactional
	@Override
	public void update(Contract co) {
		// TODO Auto-generated method stub
		try {
			em.merge(co);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modificar");
		}
		
	}

}
