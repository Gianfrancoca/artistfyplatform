package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.RolA;
import pe.edu.upc.entity.UserA;
import pe.edu.upc.entity.UserRolA;


public interface IRolDaoA {
	Integer insert(RolA rolA) throws Exception;

	Integer update(RolA rolA) throws Exception;

	Integer delete(RolA rolA) throws Exception;

	List<RolA> findAllA() throws Exception;

	Optional<RolA> findByIdA(RolA rolA) throws Exception;

	Integer insertUserRoleA(List<UserRolA> userRolesA) throws Exception;

	List<UserRolA> findUserRolesByUserA(UserA userA) throws Exception;
}
