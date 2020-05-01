package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IeventDao;
import pe.edu.upc.entity.Event;
import pe.edu.upc.serviceinterface.IeventService;

@Named
@RequestScoped
public class EventServiceImpl implements IeventService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IeventDao iD;
	
	@Override
	public void insert(Event event) {
		// TODO Auto-generated method stub
		try {
			iD.insert(event);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el service al insertar un eventi");
		}
	}

	@Override
	public List<Event> list() {
		// TODO Auto-generated method stub
		return iD.list();
	}

}
