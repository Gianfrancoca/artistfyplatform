package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.UserA;

public interface IuserServiceA {
	Integer insert(UserA userA) throws Exception;

	Integer update(UserA userA) throws Exception;

	Integer delete(UserA userA) throws Exception;

	List<UserA> getAllA() throws Exception;

	Optional<UserA> getOneA(UserA userA) throws Exception;

	Optional<UserA> authenticationA(UserA usA) throws Exception;
}