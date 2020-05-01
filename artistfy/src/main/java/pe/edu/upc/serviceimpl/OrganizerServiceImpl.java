package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IorganizerDao;
import pe.edu.upc.entity.Organizer;
import pe.edu.upc.serviceinterface.IorganizerService;

@Named
@RequestScoped
public class OrganizerServiceImpl implements IorganizerService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IorganizerDao iD;

	@Override
	public void insert(Organizer organizer) {
		// TODO Auto-generated method stub
		try {
			
			iD.insert(organizer);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el service al insertar un organizador");
		}
	}

	@Override
	public List<Organizer> list() {
		// TODO Auto-generated method stub
		return iD.list();
	}

}
