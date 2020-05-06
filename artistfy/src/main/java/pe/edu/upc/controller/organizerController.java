package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.entity.Organizer;
import pe.edu.upc.serviceinterface.IorganizerService;

@Named
@RequestScoped
public class organizerController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//variables
	@Inject
	private IorganizerService iService;

	private Organizer i;
	List<Organizer> listaOrganizer;
	
	//constructor
	@PostConstruct
	public void init() {
		this.listaOrganizer = new ArrayList<Organizer>();
		this.i=new Organizer();
		this.list();
	}
	
	//metodos
	public String newOrganizer() {
		this.setI(new Organizer());
		return "organizer.xhtml";
	}
	
	public void insert() {
		try {
			iService.insert(i);
			cleanOrganizer();
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void list() {
		try {
			listaOrganizer=iService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void delete (Organizer or) {
		try {
			iService.delete(or.getIdOrganizer());
			list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void update() {
		try {
			iService.update(this.i);
			cleanOrganizer();
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public String Modifpre(Organizer or) {
		this.setI(or);
		return ("organizerMod.xhtml");
	}
	
		
	public void cleanOrganizer() {
		this.init();
	}

	//Getter y setters
	
	public Organizer getI() {
		return i;
	}

	public void setI(Organizer i) {
		this.i = i;
	}
	
	
	public List<Organizer> getListaOrganizer() {
		return listaOrganizer;
	}

	public void setListaOrganizer(List<Organizer> listaOrganizer) {
		this.listaOrganizer = listaOrganizer;
	}	
	
	
	
}
