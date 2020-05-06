package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Organizer;

public interface IorganizerDao {
	public void insert(Organizer organizer);
	public List<Organizer> list();
	public void delete (int IdOrganizer);
	public void update (Organizer or);
}
