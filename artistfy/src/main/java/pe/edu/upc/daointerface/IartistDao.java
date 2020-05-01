package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Artist;

public interface IartistDao {

	public void insert(Artist artist);
	public List<Artist> list();
}
