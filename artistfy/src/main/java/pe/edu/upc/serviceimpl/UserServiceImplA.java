package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.daointerface.IuserDaoA;
import pe.edu.upc.entity.UserA;
import pe.edu.upc.serviceinterface.IuserServiceA;

@Named
public class UserServiceImplA implements IuserServiceA, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IuserDaoA uD;

	@Transactional
	@Override
	public Integer insert(UserA t) throws Exception {
		return uD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(UserA t) throws Exception {
		return uD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(UserA t) throws Exception {
		return uD.delete(t);
	}

	@Override
	public List<UserA> getAllA() throws Exception {
		return uD.findAllA();
	}

	@Override
	public Optional<UserA> getOneA(UserA t) throws Exception {
		return uD.findByIdA(t);
	}

	@Override
	public Optional<UserA> authenticationA(UserA userA) throws Exception {
		String password = userA.getPasswordA();

		String passwordHash = uD.getPassworHashedByUserNameA(userA.getUsernameA());

		if (BCrypt.checkpw(password, passwordHash)) {
			userA.setPasswordA(passwordHash);
			return uD.findUserByUsernameA(userA);
		}

		return Optional.of(new UserA());
	}

}
