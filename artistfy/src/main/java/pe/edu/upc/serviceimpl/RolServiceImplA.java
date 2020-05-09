package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;


import pe.edu.upc.daointerface.IrolDaoA;
import pe.edu.upc.entity.RolA;
import pe.edu.upc.entity.UserA;
import pe.edu.upc.entity.UserRolA;
import pe.edu.upc.serviceinterface.IrolServiceA;

@Named
public class RolServiceImplA implements IrolServiceA, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IrolDaoA rD;

	@Transactional
	@Override
	public Integer insert(RolA t) throws Exception {
		return rD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(RolA t) throws Exception {
		return rD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(RolA t) throws Exception {
		return rD.delete(t);
	}

	@Override
	public List<RolA> getAllA() throws Exception {
		return rD.findAllA();
	}

	@Override
	public Optional<RolA> getOneA(RolA t) throws Exception {
		return rD.findByIdA(t);
	}

	@Transactional
	@Override
	public Integer assignRolesToUserA(UserA userA, List<RolA> rolesA) throws Exception {
		List<UserRolA> userRolesA = new ArrayList<>();

		rolesA.forEach(rolA -> {
			UserRolA userRolA = new UserRolA();
			userRolA.setUserA(userA);
			userRolA.setRolA(rolA);
			userRolesA.add(userRolA);
		});

		rD.insertUserRoleA(userRolesA);

		return 1;
	}

	@Override
	public List<UserRolA> findUserRolesByUserA(UserA userA) throws Exception {
		return rD.findUserRolesByUserA(userA);
	}


}
