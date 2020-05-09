package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Organizer;

public interface IorganizerService {

	public void insert (Organizer organizer);
	
	public List<Organizer> list();
	public void delete (Organizer or);
}
