package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Contract;

public interface IcontractService {
	
	public void insert(Contract contract);
	
	public List<Contract> list();
	
	public void delete (int idContract);
	
	public void update (Contract co);

}
