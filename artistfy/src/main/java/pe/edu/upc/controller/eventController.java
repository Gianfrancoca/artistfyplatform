package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Event;
import pe.edu.upc.entity.Organizer;
import pe.edu.upc.serviceinterface.IeventService;
import pe.edu.upc.serviceinterface.IorganizerService;

@Named
@RequestScoped
public class eventController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IeventService iService;
	
	@Inject
	private IorganizerService oService;
	
	private Event e;
	private Organizer o;
	
	private String mensaje;
	private String mensajeUp;
	
	List<Event> listaEvent;
	List<Organizer> listaOrganizer;
	
	//constructor
	@PostConstruct
	public void init() {
		this.listaEvent=new ArrayList<Event>();
		this.listaOrganizer=new ArrayList<Organizer>();
		this.e=new Event();
		this.o=new Organizer();
		this.list();
		this.listO();
	}
	
	//Metodos
	
	public String newEvent() {
		this.setE(new Event());
		return "event.xhtml";
	}
	
	public String newEventO() {
		this.setE(new Event());
		return "eventO.xhtml";
	}
	public void insert() {
		try {
			iService.insert(e);
			cleanEvent();
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void list() {
		try {
			listaEvent=iService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void listO() {
		try {
			listaOrganizer=oService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void delete(Event ev) {
		try {
			iService.delete(ev.getIdEvent());
			list();
			mensaje="Event has been deleted";
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void update() {
		try {
			iService.update(this.e);
			cleanEvent();
			this.list();
			mensaje = "Event has been updated";
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void findByName() {
		try {
			if(e.getName().isEmpty()) {
				this.list();
			} else {
				listaEvent = this.iService.findByName(this.getE());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Event ev) {
		this.setE(ev);
		return "eventMod.xhtml";
	}
	
	public void cleanEvent() {
		this.init();
	}
	
	public Event getE() {
		return e;
	}

	public void setE(Event e) {
		this.e = e;
	}

	public List<Event> getListaEvent() {
		return listaEvent;
	}

	public void setListaEvent(List<Event> listaEvent) {
		this.listaEvent = listaEvent;
	}

	public Organizer getO() {
		return o;
	}

	public void setO(Organizer o) {
		this.o = o;
	}

	public List<Organizer> getListaOrganizer() {
		return listaOrganizer;
	}

	public void setListaOrganizer(List<Organizer> listaOrganizer) {
		this.listaOrganizer = listaOrganizer;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeUp() {
		return mensajeUp;
	}

	public void setMensajeUp(String mensajeUp) {
		this.mensajeUp = mensajeUp;
	}
	
	

}
