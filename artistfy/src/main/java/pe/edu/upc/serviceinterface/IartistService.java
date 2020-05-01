package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Artist;

public interface IartistService {
	
	public void insert(Artist artist);
	
	public List<Artist> list();

}
