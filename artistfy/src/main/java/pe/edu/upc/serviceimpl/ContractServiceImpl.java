package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IcontractDao;
import pe.edu.upc.entity.Contract;
import pe.edu.upc.serviceinterface.IcontractService;

@Named
@RequestScoped
public class ContractServiceImpl implements IcontractService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IcontractDao iD;

	@Override
	public void insert(Contract contract) {
		// TODO Auto-generated method stub
		try {
			iD.insert(contract);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el service al insertar un contrato");
		}
	}

	@Override
	public List<Contract> list() {
		// TODO Auto-generated method stub
		return iD.list();
	}

	@Override
	public void delete(int idContract) {
		// TODO Auto-generated method stub
		iD.delete(idContract);
	}

	@Override
	public void update(Contract co) {
		// TODO Auto-generated method stub
		iD.update(co);
	}

}
