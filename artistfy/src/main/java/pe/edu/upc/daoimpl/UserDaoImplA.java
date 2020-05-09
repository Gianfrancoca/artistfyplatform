package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.daointerface.IuserDaoA;
import pe.edu.upc.entity.UserA;

@Named
public class UserDaoImplA implements IuserDaoA, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "artistfy")
	private EntityManager em;

	@Override
	public Integer insert(UserA t) throws Exception {
		em.persist(t);
		return t.getArtist().getIdArtist();
	}

	@Override
	public Integer update(UserA t) throws Exception {
		em.merge(t);
		return t.getArtist().getIdArtist();
	}

	@Override
	public Integer delete(UserA t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserA> findAllA() throws Exception {
		List<UserA> usersA = new ArrayList<>();

		Query query = em.createQuery("SELECT c FROM UserA c");
		usersA = (List<UserA>) query.getResultList();

		return usersA;
	}

	@Override
	public Optional<UserA> findByIdA(UserA t) throws Exception {

		UserA userA;
		TypedQuery<UserA> query = em.createQuery("SELECT u FROM UserA u WHERE u.idA = ?1", UserA.class);
		query.setParameter(1, t.getArtist().getIdArtist());

		userA = query.getSingleResult();

		return Optional.of(userA);
	}

	@Override
	public String getPassworHashedByUserNameA(String usernameA) throws Exception {
		UserA userA = new UserA();

		try {

			Query query = em.createQuery("FROM UserA u WHERE u.usernameA = ?1");
			query.setParameter(1, usernameA);
			@SuppressWarnings("unchecked")
			List<UserA> lista = query.getResultList();
			if (!lista.isEmpty()) {
				userA = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return userA != null ? userA.getPasswordA() : "";
	}

	@Override
	public Optional<UserA> findUserByUsernameA(UserA userA) throws Exception {
		
		UserA userFound;
		TypedQuery<UserA> query = em.createQuery("FROM UserA u WHERE u.usernameA = ?1 and u.passwordA = ?2", UserA.class);
		query.setParameter(1, userA.getUsernameA());
		query.setParameter(2, userA.getPasswordA());

		userFound = query.getSingleResult();

		return Optional.of(userFound);
	}

}
