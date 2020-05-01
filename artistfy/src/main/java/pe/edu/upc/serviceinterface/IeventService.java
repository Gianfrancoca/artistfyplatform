package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Event;

public interface IeventService {

		public void insert(Event event);
		public List<Event> list();
}
