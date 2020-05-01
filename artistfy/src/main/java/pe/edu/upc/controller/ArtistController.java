package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Artist;
import pe.edu.upc.serviceinterface.IartistService;

@Named
@RequestScoped
public class ArtistController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IartistService iService;
	
	private Artist i;
	List<Artist> listaArtist;
	
	@PostConstruct
	public void init() {
		this.listaArtist = new ArrayList<Artist>();
		this.i=new Artist();
		this.list();
	}
	
	public String newArtist() {
		this.setI(new Artist());
		return "artist.xhtml";
	}
	
	public void insert() {
		try {
			iService.insert(i);
			cleanArtist();
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void list() {
		try {
			listaArtist = iService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void cleanArtist() {
		this.init();
	}
	private void setI(Artist i) {
		// TODO Auto-generated method stub
		this.i = i;
	}
	
	public Artist getI() {
		return i;
	}
	
	public List<Artist> getListaArtist() {
		return listaArtist;
	}

	public void setListaArtist(List<Artist> listaArtist) {
		this.listaArtist = listaArtist;
	}

	
}
