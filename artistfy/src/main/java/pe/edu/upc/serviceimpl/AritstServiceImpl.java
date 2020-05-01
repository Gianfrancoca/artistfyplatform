package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IartistDao;
import pe.edu.upc.entity.Artist;
import pe.edu.upc.serviceinterface.IartistService;

@Named
@RequestScoped
public class AritstServiceImpl implements IartistService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IartistDao iD;

	@Override
	public void insert(Artist artist) {
		// TODO Auto-generated method stub
		try {
			iD.insert(artist);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el service al insertar un artista");
		}
	}

	@Override
	public List<Artist> list() {
		return iD.list();
	}
	

}
