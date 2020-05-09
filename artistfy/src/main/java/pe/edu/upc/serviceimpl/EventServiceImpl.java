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
			System.out.println("Error en el service al insertar un evento");
		}
	}

	@Override
	public List<Event> list() {
		// TODO Auto-generated method stub
		return iD.list();
	}

	@Override
	public void delete(int idEvent) {
		// TODO Auto-generated method stub
		iD.delete(idEvent);
	}

	@Override
	public void update(Event ev) {
		// TODO Auto-generated method stub
		iD.update(ev);
	}

	@Override
	public List<Event> findByName(Event ev) {
		// TODO Auto-generated method stub
		return iD.findByName(ev);
	}

}
