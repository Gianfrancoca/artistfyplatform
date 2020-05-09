package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Event;

public interface IeventDao {

	public void insert(Event event);
	public List<Event> list();
	public void delete(int IdEvent);
	public void update(Event ev);
	public List<Event> findByName(Event ev);
}
