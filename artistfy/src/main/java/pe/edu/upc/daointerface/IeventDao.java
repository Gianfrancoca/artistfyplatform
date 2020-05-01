package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Event;

public interface IeventDao {

	public void insert(Event event);
	public List<Event> list();
}
