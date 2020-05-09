package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.RolA;
import pe.edu.upc.entity.UserA;
import pe.edu.upc.entity.UserRolA;

public interface IrolServiceA {
	Integer insert(RolA rolA) throws Exception;

	Integer update(RolA rolA) throws Exception;

	Integer delete(RolA rolA) throws Exception;

	List<RolA> getAllA() throws Exception;

	Optional<RolA> getOneA(RolA rolA) throws Exception;

	Integer assignRolesToUserA(UserA userA, List<RolA> rolesA) throws Exception;

	List<UserRolA> findUserRolesByUserA(UserA userA) throws Exception;

}
