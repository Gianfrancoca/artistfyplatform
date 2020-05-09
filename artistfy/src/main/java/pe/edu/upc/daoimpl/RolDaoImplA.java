package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.daointerface.IrolDaoA;
import pe.edu.upc.entity.RolA;
import pe.edu.upc.entity.UserA;
import pe.edu.upc.entity.UserRolA;

@Named
public class RolDaoImplA implements IrolDaoA, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "artistfy")
	private EntityManager em;

	public Integer insert(RolA t) throws Exception {
		em.persist(t);
		return t.getIdA();
	}

	public Integer update(RolA t) throws Exception {
		em.merge(t);
		return t.getIdA();
	}

	public Integer delete(RolA t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<RolA> findAllA() throws Exception {
		List<RolA> rolesA = new ArrayList<RolA>();

		Query q = em.createQuery("SELECT r FROM RolA r");
		rolesA = (List<RolA>) q.getResultList();
		return rolesA;
	}

	@SuppressWarnings("unchecked")
	public Optional<RolA> findByIdA(RolA t) throws Exception {

		RolA rolA = new RolA();
		List<RolA> rolesA = new ArrayList<RolA>();
		Query query = em.createQuery("FROM RolA r where r.idA = ?1");
		query.setParameter(1, t.getIdA());

		rolesA = (List<RolA>) query.getResultList();

		if (rolesA != null && !rolesA.isEmpty()) {
			rolA = rolesA.get(0);
		}

		return Optional.of(rolA);
	}

	public Integer insertUserRoleA(List<UserRolA> userRolesA) throws Exception {
		try {

			final int[] iarr = { 0 };
			userRolesA.forEach(r -> {
				em.persist(r);
				if (iarr[0] % 100 == 0) {
					em.flush();
					em.clear();
				}
				iarr[0]++;
			});
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<UserRolA> findUserRolesByUserA(UserA userA) throws Exception {
		List<UserRolA> userRolesA = new ArrayList<UserRolA>();

		try {
			Query query = em.createQuery("FROM UserRolA ur where ur.userA.artist.idA =?1");
			query.setParameter(1, userA.getArtist().getIdArtist());

			userRolesA = (List<UserRolA>) query.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return userRolesA;
	}


}
