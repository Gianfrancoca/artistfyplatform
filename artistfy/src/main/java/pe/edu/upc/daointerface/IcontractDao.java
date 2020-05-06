package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Contract;

public interface IcontractDao {

	public void insert(Contract contract);
	
	public List<Contract> list();
	
	public void delete (int IdContract);
	
	public void update (Contract co);
	
}
