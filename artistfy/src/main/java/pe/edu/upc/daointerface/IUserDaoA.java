package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.UserA;

public interface IUserDaoA {
	Integer insert(UserA userA) throws Exception;

	Integer update(UserA userA) throws Exception;

	Integer delete(UserA userA) throws Exception;

	List<UserA> findAllA() throws Exception;

	Optional<UserA> findByIdA(UserA userA) throws Exception;

	String getPassworHashedByUserNameA(String usernameA) throws Exception;

	Optional<UserA> findUserByUsernameA(UserA userA) throws Exception;
}
